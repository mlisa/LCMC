grammar FOOL;

@header{
		import java.util.ArrayList;
		import java.util.HashMap;
		import ast.*;
		import lib.FOOLlib;
}

@lexer::members {
    int lexicalErrors=0;
}

@members{
    //La symbol table è implementata come lista di hashmap (ogni hashmap corrisponde a uno scope) 
		private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
		
		private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>(); 
		
		private HashMap<String,String> superType = new HashMap<String,String>(); 
}

/*------------------------------------------------------------------
 * PARSER RULES
 *  
 *  Qui è definita la grammatica libera dal contesto usata dal parser di ANTLR 
 *  (linguaggi liberi, controlla la sintassi e genera l'AST)
 *   generato per controllare la sintassi dei token creati dal lexer. 
 *------------------------------------------------------------------*/

prog returns [Node ast] :
	    e = exp SEMIC {
	        $ast = new ProgNode($e.ast);
	    } | 
	    
	    LET {
			nestingLevel++;  //Parte da -1, quindi lo setto a 0
			HashMap<String,STentry> hm = new HashMap<String,STentry> ();
			symTable.add(hm);
			// Setto la mappa delle coppie sottoclasse-superclasse
			FOOLlib.putSuperType(superType);
			
	    }
	    // Posso avere una lista di classi o di dichiarazioni (func o var) 
	    c = cllist 
	    d = declist 
	    IN e = exp SEMIC {
	      //Ho terminato le dichiarazioni, torno al nestinglevel precedente (-1) e rimuovo l'ultima hashmap 
		    symTable.remove(nestingLevel--);
		    $ast = new ProgLetInNode($c.astlist, $d.astlist, $e.ast);
		    
	    }
    ;
  
//Dichiarazioni di classi in LET
cllist returns [ArrayList<Node> astlist] : {
	        
			$astlist = new ArrayList<Node>();
		   
	    } ( // Posso dichiarare 0 o + classi ma devono sempre essere dichiarate prima di qualsiasi altra cosa!
	        CLASS 
		    //--------------------------> INIZIO DELLE CLASSI
		    classID = ID { 
		        //Nuova entry per la class table
		        CTentry ctEntry = new CTentry(); 
		        CTentry superClassEntry = new CTentry();
		 
		        //Prendo la Symbol table del livello corrente
		        HashMap<String, STentry> hm = symTable.get(nestingLevel);
		
				//Controllo che la classe non sia già stata dichiarata, altrimenti la aggiungo (l'offset è random perchè non serve nelle classi) 
				if(hm.put($classID.text, new STentry(nestingLevel, null, 777)) != null){
				    System.out.println("ERROR : Class " + $classID.text + "has been already declared!");
				    System.exit(1);
				}          
		    } ( // La Classe Estende una o nessuna Classe
		        EXTENDS 
		        superClass = ID {
				    //Se la classe estende un'altra classe
				    superClassEntry = classTable.get($superClass.text);
					if(superClassEntry != null) {
						//Se esiste la superclasse utilizzo il costruttore che prende in input una CTentry
						ctEntry = new CTentry(superClassEntry);
						//Aggiungo la relazione fra le classi alla SuperType map (sottoclasse - superclasse) 
						superType.put($classID.text, $superClass.text);
					} else { 
						//Non esiste la superclasse - errore
						System.out.println("Class of name "+$superClass.text + "does not exist.");
						System.exit(0);
					}
				} 
			)? {
			    //Lista dei campi
	            ArrayList<Node> fieldList = new ArrayList<Node>();
	            //Lista dei metodi
	            ArrayList<Node> methodList = new ArrayList<Node>();
	            
	            //Creo il ClassNode e lo aggiungo alla lista
                $astlist.add(new ClassNode(new ClassTypeNode($classID.text), fieldList, methodList, ctEntry, superClassEntry));
				
				//Aggiungo la ctentry all'interno della class table
				classTable.put($classID.text, ctEntry);
				
				// Aumento il nesting level per le dichiarazioni della classe (quindi il suo scope) 
                nestingLevel++;
                //Aggiungo alla Symbol Table di questo livello la virtual table della CTentry
                symTable.add(ctEntry.getVTable());
                
			} LPAR ( //--------------> INIZIO DEI CAMPI (0 o +)
			    fieldID = ID COLON fieldType = basic {
			    
					//Primo campo:
					//Aggiungo il campo alla CTentry (i controlli sono effettuati all'interno del metodo)
					ctEntry.addField($fieldID.text, $fieldType.ast);     
					//Aggiungo il campo alla fieldList
					fieldList.add(new FieldNode($fieldID.text, $fieldType.ast));
					
				} (COMMA fieldID = ID COLON fieldType = basic {
				
				    //Campi successivi al primo 
				    ctEntry.addField($fieldID.text, $fieldType.ast);
				    fieldList.add(new FieldNode($fieldID.text, $fieldType.ast));
				    
				} )* //chiudo la parentesi del comma 
		    )? RPAR
		    
			// ---------------------------> INIZIO CORPO DELLA CLASSE
			// -----------------------------> INIZIO METODI (0 o +)
			CLPAR (
			    FUN funID = ID COLON retType = basic { 
			        //Creo un method node 
              MethodNode mNode = new MethodNode($funID.text, $retType.ast);
			        //Creo la Symbol Table per il metodo
			        HashMap<String, STentry> methodSymTable = new HashMap<>();
			        //Creo la lista per i tipi dei parametri (mi serviranno poi per il typecheck e l'overriding del metodo)
			        ArrayList<Node> parTypes = new ArrayList<>();
			        //Setto gli offset di partenza per i parametri
			        int parOffset = 1; // qui c'è il primo parametro
			        int offset = -2; // qui c'è la prima variabile, in mezzo c'è l'AL/FP/SL(0) e RA/CL/DL(-1)
			        
			        //Aumento il nesting level per creare una nuova symbol table per lo scope del metodo
			        nestingLevel++;
			        //La aggiungo alla lista di symbol table
			        symTable.add(methodSymTable);
			        //Lo aggiungo alla methodList
			        methodList.add(mNode);
			        
			    } LPAR ( // -------------> Parametri Metodo (0 o +)
			        mparfID = ID COLON mparfType = type { 
						
						//Aggiungo il parametro al method node
						mNode.addPar(new ParNode($mparfID.text, $mparfType.ast));
						//Aggiungo il tipo alla partypes
						parTypes.add($mparfType.ast);
						//Aggiungo alla symbol table del metodo la relativa entry
						methodSymTable.put($mparfID.text, new STentry(nestingLevel, $mparfType.ast, parOffset++));
						// qui non controllo che il parametro esista già, perchè è il primo
						
				    } (COMMA mparnID = ID COLON mparnType = type {
				        
				        //parametri successivi al primo; li aggiungo e controllo che non siano già stati dichiarati
				        mNode.addPar(new ParNode($mparnID.text, $mparnType.ast));
				        //Aggiungo il tipo alla partypes
                        parTypes.add($mparnType.ast);
                        
				        if (methodSymTable.put($mparnID.text, new STentry(nestingLevel, $mparnType.ast, parOffset++)) != null) {
				            System.out.println("PAR id "+$mparnID.text+" at line "+$mparnID.line+" already declared");
				            System.exit(0);
				        }		        
					} )* // Chiudo Parentesi Comma
					
				)? RPAR (//--------------> INIZIO DICHIARAZIONI Variabili METODO (0 o +)
				    LET ( 
				        VAR varID = ID COLON varType = basic ASS varExp = exp SEMIC {
							//Aggiungo la variabile al metodo
							mNode.addVar(new VarNode($varID.text, $varType.ast, $varExp.ast));
							
							//Controllo che la variabile non sia già stata dichiarata
							if (methodSymTable.put($varID.text, new STentry(nestingLevel, $varType.ast, offset--)) != null) {
								System.out.println("VAR id "+$varID.text+" at line "+$varID.line+" already declared");
								System.exit(0);
							}
						} 
					)* IN
				)? {
				    
				      //Aggiungo il tipo della symbol table
              mNode.addSymType(new ArrowTypeNode(parTypes, $retType.ast));
              //Lo aggiungo alla virtual table
              ctEntry.addMethod($funID.text, mNode);
                    
                    
				} //-------------------> INIZIO CORPO METODO
				body = exp {
					//Aggiungo il corpo
					mNode.addBody($body.ast);
										
			    } SEMIC {
			        //Rimuovo la symbol table del metodo poichè non mi serve in più (la dichiarazione è finita)
                    symTable.remove(nestingLevel--);  //esco dallo scope del metodo
			    }
			// Chiudo il body della classe contenente le dichiarazioni delle classi
			)* CRPAR {
			    //Rimuovo la symbol table della Classe perch� non mi serve più (la dichiarazione è finita)
                symTable.remove(nestingLevel--); //esco dallo scope della classe
			}
			 
		)* // Chiudo parentesi principale -> segnala 0 o + dichiarazioni di classi
    ; 
 
declist returns [ArrayList<Node> astlist] : {
		    //Lista delle cose dichiarate  
		    $astlist= new ArrayList<Node>() ;
		    
		    // Global AR -> RetAddr (RA) at -1
		    // Layout AR -> AccLink (AL) at 0 && RA at -1
		    int offset = -2; 
	    } ( // Deve esistere almeno 1 tra una funzione o una variabile dichiarate
	        (  // Nel Let posso dichiarare Variabili o Funzioni, in qualsiasi ordine
	            //----------> Variables Declaration (0 o +)
			    VAR varID = ID COLON varType = type ASS varExp = exp {
			    
			        //Dichiara e Aggiungo una varibile alle lista delle dichiarazioni
			        $astlist.add(new VarNode($varID.text, $varType.ast, $varExp.ast));
			        //Controllo che non sia già dichiarata
			        HashMap<String,STentry> hm = symTable.get(nestingLevel);
			        
			        if (hm.put($varID.text, new STentry(nestingLevel, $varType.ast, offset--)) != null) {
						System.out.println("Var id "+$varID.text+" at line "+$varID.line+" already declared");
						System.exit(0);
			        }
			    } | 
			    //------------> Function Definitions (0 o +)
			    FUN 
			        funID = ID COLON funRetType = type {
			    
						//Dichiaro una funzione - inserimento di ID nella symtable 
						FunNode f = new FunNode($funID.text, $funRetType.ast);
						// QUI LO AGGIUNGE ALLA LISTA DI COSE DICHIARATE
						$astlist.add(f);
						//Prendo la symbol table attuale
						HashMap<String,STentry> hm = symTable.get(nestingLevel);
						//Creo una nuova entry
						
						STentry entry = new STentry(nestingLevel, offset); //separo introducendo "entry"
						
						offset -= 2; // Mi sposto in basso di un'altro posto poichè fun occupa 2 posti (indirizzo del padre sintattico - indirizzo del codice) 
						
						//Controllo che non sia già dichiarata una funzione con lo stesso nome 
						if (hm.put($funID.text,entry) != null){ 
							System.out.println("Fun id "+$funID.text+" at line "+$funID.line+" already declared");
							System.exit(0);
						}
						
						//creare una nuova hashmap per la symTable relativa alla funzione appena dichiarata
						nestingLevel++; //Entro nello scope della funzione 
						HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
						symTable.add(hmn);
						
						//Lista di parametri della funzione
                        ArrayList<Node> parTypes = new ArrayList<Node>();
                        int paroffset = 1;  //perchè i parametri vengono inseriti dal chiamante nel suo spazio di memoria
						
					} LPAR (
					    parfID = ID COLON parfType = type { 
					
							//Aggiungo il primo parametro
							parTypes.add($parfType.ast); 
							f.addPar(new ParNode($parfID.text, $parfType.ast));
							
							// Occorre controllare che il tipo della funzione sia ArrowTypeNode (high-order)
                            // poichè il tal caso devo riservare 2 spazi! 
							paroffset += $parfType.ast instanceof ArrowTypeNode ? 1 : 0;
							if (hmn.put($parfID.text, new STentry(nestingLevel, $parfType.ast, paroffset++)) != null){
							    System.out.println("Parameter id "+$parfID.text+" at line "+$parfID.line+" already declared");
							    System.exit(0);
							}
							
						} (COMMA parnID = ID COLON parnType = type {
						
							//Aggiungo il primo parametro
                            parTypes.add($parnType.ast);
                            f.addPar(new ParNode($parnID.text, $parnType.ast));
                            
                            //f.addSymType($parnType.ast); // Perchè non lo mettiamo ???
                            
                            // Occorre controllare che il tipo della funzione sia ArrowTypeNode 
                            // poichè il tal caso devo riservare 2 spazi!
                            paroffset = $parnType.ast instanceof ArrowTypeNode ? paroffset+1 : paroffset;
                            
                            if (hmn.put($parnID.text, new STentry(nestingLevel, $parnType.ast, paroffset++)) != null){
                                System.out.println("Parameter id "+$parnID.text+" at line "+$parnID.line+" already declared");
                                System.exit(0);
                            }
							
						} )* //chiudo parentesi comma
						
					)? RPAR {
					  ArrowTypeNode arrowTypeNode =  new ArrowTypeNode(parTypes, $funRetType.ast);
						entry.addType(arrowTypeNode);
						f.addSymType(arrowTypeNode);
						
					} (LET d = declist IN)? e = exp {
							//chiudere scope
							symTable.remove(nestingLevel--);
							f.addDecBody($d.astlist, $e.ast);
						
				    } 
		    ) SEMIC 
	    )+
    ;
  
type returns [Node ast] : 
        b = basic {
            $ast = $b.ast;
        } | a = arrow {
            $ast = $a.ast;
        }
    ;  
  
basic returns [Node ast] : 
        INT {
            $ast= new IntTypeNode();
        } |
        
        BOOL {
            $ast= new BoolTypeNode();
        } |
        
        i = ID {
            $ast= new ClassTypeNode($i.text);
        }
    ;   

arrow returns [Node ast] : 
        LPAR {
            ArrayList<Node> typeList = new ArrayList<>(); 
        } (t = type { 
            //aggiungo il primo
            typeList.add($t.ast);
        } ( COMMA ty = type {
	        //aggiungo gli altri
	        typeList.add($t.ast);
        } )* )? RPAR ARROW r = basic {
            $ast = new ArrowTypeNode(typeList, $r.ast);
        }
    ;          

exp returns [Node ast] :
        left = term {
            $ast = $left.ast;    
        } (
        
	        PLUS rightP = term {
	            $ast = new PlusNode ($ast, $rightP.ast);
	        } |
	         
	        MINUS rightM = term {
	            $ast = new MinusNode ($ast, $rightM.ast);
	        } |
	        
	        OR rightO = term {
	            $ast = new OrNode ($ast, $rightO.ast);
	        }
	    )*
    ;
  
term  returns [Node ast] : 
        left = factor {
            $ast = $left.ast;
        } (
        
	        TIMES rightT = factor {
	            $ast = new MultNode ($ast, $rightT.ast);
	        } |
	        
	        DIV rightD = factor {
	            $ast = new DivNode ($ast, $rightD.ast);
	        } |
	        
	        AND rightA = factor {
	            $ast = new AndNode ($ast, $rightA.ast);
	        }
        )*
    ;
  
factor  returns [Node ast] : 
        f = value {
            $ast = $f.ast;
        } (
        
            EQ l = value {
                $ast = new EqualNode ($ast,$l.ast);
            } |
            
            LE l = value {
                $ast = new LessEqualNode ($ast,$l.ast);
            } |
            
            GE l = value {
                $ast = new GreaterEqualNode ($ast,$l.ast);
            }
        )*
    ;   
  
value returns [Node ast] : 
        n = INTEGER {
            $ast = new IntNode(Integer.parseInt($n.text));
        } | 
        
        TRUE {
            $ast = new BoolNode(true);
        } | 
        
        FALSE {
            $ast = new BoolNode(false);
        } | 
        
        NULL {
            $ast = new EmptyNode();
        } | 
        
        NEW 
	       newClassID = ID {
	       
			//Creo la lista del parametri
			ArrayList<Node> fieldList = new ArrayList<Node>();
			//Prendo la CTentry dalla class table
			CTentry classEntry = classTable.get($newClassID.text);
			
			//Controllo l'esistenza della classe 
			if(classEntry == null){
				System.out.println("Class id "+$newClassID.text+" at line "+$newClassID.line+" not declared");
				System.exit(0);
		    }
		    
		   
		    } LPAR (
		        newfExpr = exp {
		            //Aggiungo i parametri
		            fieldList.add($newfExpr.ast);
		        } (COMMA newnExpr = exp{
		            //Aggiungo i parametri
		            fieldList.add($newnExpr.ast);
		        } )* 
		    )? RPAR 
		    {
		    //Creo il NewNode con l'id, la lista dei parametri e la ctentry 
		        $ast =  new NewNode($newClassID.text, fieldList, classEntry);
		    }
		    | 
	
		LPAR e = exp RPAR {
		    $ast = $e.ast;
		} | 
		
		IF x = exp THEN CLPAR y = exp CRPAR ELSE CLPAR z = exp CRPAR {
		    $ast = new IfNode($x.ast,$y.ast,$z.ast);
		} |  
		
		NOT LPAR t = term RPAR {
		    $ast = new NotNode($t.ast);
		} | 
		
		PRINT LPAR e = exp RPAR {
		    $ast = new PrintNode($e.ast);
		} | 
		
		callID = ID {   //Chiamata di variabile ( x ), di funzione ( fun(x,y,z) ) oppure chiamata di metodo di classe (class.method(x,y) )
			
			//cercare la dichiarazione
		    int j = nestingLevel;
		    STentry calledEntry = null; 
		    
		    while (j >= 0 && calledEntry == null) {
		        calledEntry = (symTable.get(j--)).get($callID.text);
		    }
		    		    
		    if (calledEntry == null) {
				System.out.println("ID "+$callID.text+" at line "+$callID.line+" not declared");
				System.exit(0);
		    }
		                   
		    //Lo userò solo se è una variabile o riferimento di una funzione (solo il nome senza () higher-order)  altrimenti verrà sovrascritto               
		    $ast= new IdNode($callID.text, calledEntry, nestingLevel);
		} ( // Possibili usi dell'ID -> ID() o ID.ID(x1, x2, ...) (solo funzioni o chiamate di metodo) 
		    LPAR {
		        ArrayList<Node> argList = new ArrayList<Node>();
		    }(
		        farg = exp {
		            argList.add($farg.ast);
		        }(COMMA narg = exp {
		            argList.add($narg.ast);
		        } )*
		    )? 
		    RPAR {
		        $ast=new CallNode($callID.text, calledEntry, argList, nestingLevel);
		    } | 
		    // Chiamata di metodo 
		    DOT methodID = ID {
		    
		        ClassTypeNode classCallType = (ClassTypeNode)calledEntry.getType();
		        // Cerco se esiste una classe del tipo dell'oggetto che fa la call del metodo 
		        CTentry classCTEntry = classTable.get(classCallType.getClassID());
		        
		        ArrayList<Node> methodParlist = new ArrayList<>();
		        
		        // Se non esiste alcuna classe del tipo dell'oggetto dichiaro errore
		        if(classCTEntry == null){
					System.out.println("Class id "+ $callID.text +" at line "+$callID.line+" not declared");
					System.exit(0);
		        }
		        
		        //Prendo dalla ctentry la virtual table da cui poi risalgo al metodo
		        STentry methodSTEntry = classCTEntry.getVTable().get($methodID.text);
		        		        		        
		        //Controllo che il metodo esista 
		        if(methodSTEntry == null) {
					System.out.println("Method id "+$methodID.text+" at line "+$methodID.line+" not declared");
					System.exit(0); 
		        }
		             
		    } LPAR (
		        callfExp = exp {
		            //Aggiungo il primo parametro
		            methodParlist.add($callfExp.ast);
		        } (COMMA callnExpr = exp {
		            //Aggiungo i parametri successivi
		            methodParlist.add($callnExpr.ast);
		        })* 
		    )? { 
		        $ast = new ClassCallNode($callID.text, $methodID.text, calledEntry, methodSTEntry, methodParlist, nestingLevel); 
		    } RPAR 
	    )?      
    ; 

    
/*------------------------------------------------------------------
 * LEXER RULES
 *
 *  Questa parte del file .g descrive come il lexer di ANTLR deve essere generato e come deve produrre i lessemi/token 
 *  (tramite caratteri o espressioni regolari) suddividendo lo stream di caratteri in input. 
 *------------------------------------------------------------------*/
 
// TOKEN : 'LEXEM';

PLUS    : '+' ;
MINUS   : '-' ;
TIMES    : '*' ;
DIV   : '/' ;
LPAR  : '(' ;
RPAR  : ')' ;
CLPAR : '{' ;
CRPAR : '}' ;
SEMIC   : ';' ;
COLON   : ':' ; 
COMMA : ',' ;
DOT : '.' ;
OR  : '||';
AND : '&&';
NOT : 'not' ;
GE  : '>=' ;
LE  : '<=' ;
EQ  : '==' ;  
ASS : '=' ;
TRUE  : 'true' ;
FALSE : 'false' ;
IF  : 'if' ;
THEN  : 'then';
ELSE  : 'else' ;
PRINT : 'print' ;
LET     : 'let' ; 
IN      : 'in' ;  
VAR     : 'var' ;
FUN : 'fun' ; 
CLASS : 'class' ; 
EXTENDS : 'extends' ; 
NEW   : 'new' ; 
NULL    : 'null' ;    
INT : 'int' ;
BOOL  : 'bool' ;
ARROW   : '->' ;  
INTEGER : '0' | ('-')?(('1'..'9')('0'..'9')*) ; 

ID    : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;

WHITESP : ( '\t' | ' ' | '\r' | '\n' )+    { $channel=HIDDEN; } ;

COMMENT : '/*' .* '*/' { $channel=HIDDEN; } ;
 
ERR      : . { System.out.println("Invalid char: "+$text); lexicalErrors++; $channel=HIDDEN; } ; 

