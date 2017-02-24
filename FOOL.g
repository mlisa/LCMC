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
		private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
		
		private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>(); 
		
		private HashMap<String,String> superType = new HashMap<String,String>(); 
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
prog  returns [Node ast]
  :       e=exp SEMIC  
            {$ast = new ProgNode($e.ast);}
        | LET {
              nestingLevel++;
              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
              symTable.add(hm);
              FOOLlib.putSuperType(superType);
          }  
          c=cllist 
          d=declist IN e=exp SEMIC {
            symTable.remove(nestingLevel--);
            $ast = new ProgLetInNode($d.astlist,$e.ast);
          } 
  ;
  
//Dichiarazioni di classi in LET
cllist returns [ArrayList<Node> astlist] : {        
	   $astlist = new ArrayList<Node>();
	   //Lista dei campi
	   ArrayList<Node> fieldList = new ArrayList<Node>();
	   //Lista dei metodi
	   ArrayList<Node> methodList = new ArrayList<Node>();
  } 
  //----------------------------------------------------------INIZIO DELLE CLASSI
  (CLASS classId=ID { 
      //Nuova entry per la class table
      CTentry ctEntry = new CTentry(); 
      CTentry superClassEntry = new CTentry();
      
      //Prendo la Symbol table del livello corrente
      HashMap<String, STentry> hm = symTable.get(nestingLevel);
     
     //Controllo che la classe non sia già stata dichiarata, altrimenti la aggiungo
      if(hm.put($classId.text, new STentry(nestingLevel, null, 777)) != null){
          System.out.println("ERROR : Class " + $classId.text + "has been already declared!");
          System.exit(1);
      }          
  } 
  (EXTENDS superClass=ID {
	    //Se la classe estende un'altra classe
		  if(classTable.get($superClass.text) != null) {
		    //Se esiste la superclasse utilizzo il costruttore che prende in input una CTentry
		    superClassEntry =  new CTentry(classTable.get($superClass.text));
		    ctEntry = superClassEntry;
		    //Aggiungo la relazione fra le classi alla SuperType map
		    superType.put($classId.text, $superClass.text);
		  } else { 
		    //Non esiste la superclasse - errore
		    System.out.println("Class of name "+$superClass.text + "does not exist.");
		    System.exit(0);
		  } 
  })? {
      //Aggiungo la ctentry all'interno della class table
      classTable.put($classId.text, ctEntry);
      //Aggiungo alla Symbol Table di questo livello la virtual table della CTentry
      symTable.add(ctEntry.getVTable());
      //Creo il ClassNode e lo aggiungo alla lista
      $astlist.add(new ClassNode($classId.text, fieldList, methodList, ctEntry, superClassEntry));
        
  } 
  //----------------------------------------------------------INIZIO DEI CAMPI
  LPAR ( fieldId=ID COLON b=basic {  
    //Primo campo:
    //Aggiungo il campo alla CTentry (i controlli sono effettuati all'interno del metodo)
    ctEntry.addField($fieldId.text, $b.ast);     
    //Aggiungo il campo alla fieldList 
    fieldList.add(new FieldNode($fieldId.text, $b.ast));
  } 
  (COMMA fieldId=ID COLON b=basic { 
    //Campi successivi al primo 
    ctEntry.addField($fieldId.text, $b.ast);
    fieldList.add(new FieldNode($fieldId.text, $b.ast));
    
  })*)? 
  RPAR
      //----------------------------------------------------------INIZIO CORPO DELLA CLASSE
      CLPAR
         //----------------------------------------------------------INIZIO METODI         
         ( FUN funId=ID COLON retType=basic { 
            //Creo la Symbol Table per il metodo
            HashMap<String, STentry> methodSymTable = new HashMap<>();
            //Creo la lista per i tipi dei parametri
            ArrayList<Node> parTypes = new ArrayList<>();
            //Setto gli offset di partenza per i parametri
            int parOffset = 1; // qui c'è il primo parametro
            int offset = -2; // qui c'è la prima variabile, in mezzo c'è l'AL/FP/SL(0) e RA/CL/DL(-1)
            //Aumento il nesting level per creare una nuova symbol table per lo scope del metodo
            nestingLevel++;
            //La aggiungo alla lista di symbol table
            symTable.add(methodSymTable);
            //Creo un method node 
            MethodNode mNode = new MethodNode($funId.text, $retType.ast);
            //Lo aggiungo alla methodList
            methodList.add(mNode);
            //Lo aggiungo alla alla virtual table
            ctEntry.addMethod($funId.text, mNode);         
         } 
         //----------------------------------------------------------INIZIO DEI PARAMETRI 
         LPAR (parId=ID COLON t=type {
            //Creo la STEntry per il parametro e imposto 
            STentry STentry = new STentry(nestingLevel, $t.ast, parOffset++);      //HO TOLTO DA QUI IL SET AS METHOD PERCHE ERA SBAGLIATO
            //Aggiungo il parametro al method node
            mNode.addPar(new ParNode($parId.text, $t.ast));
            //Aggiungo il tipo alla partypes
            parTypes.add($t.ast);
            //Aggiungo alla symbol table del metodo il 
            methodSymTable.put($parId.text, STentry);
            // qui non controllo che il parametro esista già, perchè è il primo 
         } (COMMA parId=ID COLON t=type { 
             //parametri successivi al primo; li aggiungo e controllo che non siano già stati dichiarati
            mNode.addPar(new ParNode($parId.text, $t.ast));
            if (methodSymTable.put($parId.text, new STentry(nestingLevel, $t.ast, parOffset++)) != null) {
                System.out.println("PAR id "+$parId.text+" at line "+$parId.line+" already declared");
                System.exit(0);
            } 
         }
         )* )? RPAR
         //----------------------------------------------------------INIZIO DICHIARAZIONI METODO
               (LET (VAR varId=ID COLON varType=basic ASS varExp=exp SEMIC {
                   //Aggiungo la variabile al metodo
                  mNode.addVar(new VarNode($varId.text, $varType.ast, $varExp.ast));
                  //Controllo che la variabile non sia già stata dichiarata
                  if (methodSymTable.put($parId.text, new STentry(nestingLevel, $varType.ast, offset--)) != null) {
                    System.out.println("VAR id "+$parId.text+" at line "+$parId.line+" already declared");
                    System.exit(0);
                  }
                 }
               )*
               IN)? 
               //----------------------------------------------------------INIZIO CORPO METODO
               body=exp {
                 //Aggiungo il corpo
                 mNode.addBody($body.ast);
                 //Aggiungo il tipo della symbol table
                 mNode.addSymType(new ArrowTypeNode(parTypes, retType));
                 //Rimuovo la symbol table perchè non mi serve in più (la dichiarazione è finita)
                 symTable.remove(nestingLevel--); 
               }
           SEMIC
         )*                
      CRPAR
      
  )*
; 
 
declist returns [ArrayList<Node> astlist]
  : { //Lista delle cose dichiarate 
      $astlist= new ArrayList<Node>() ;
     int offset=-2;}
        ( (
            VAR i=ID COLON t=type ASS e=exp
              { //Dichiara una variabile
               VarNode v = new VarNode($i.text,$t.ast,$e.ast); 
               // Aggiungo la varibile alle cose dichiarate
               $astlist.add(v);
               //Controllo che non sia già dichiarata
               HashMap<String,STentry> hm = symTable.get(nestingLevel); 
               if ( hm.put($i.text,new STentry(nestingLevel,$t.ast,offset--)) != null  ) {
                 System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
                  System.exit(0);
                }  
              }  
          | 
            FUN i=ID COLON t=type {
               //Dichiaro una funzione - inserimento di ID nella symtable 
               FunNode f = new FunNode($i.text,$t.ast);
               // QUI LO AGGIUNGE ALLA LISTA DI COSE DICHIARATE 
               $astlist.add(f);
               //Prendo la symbol table attuale
               HashMap<String,STentry> hm = symTable.get(nestingLevel);
               //Creo una nuova entry
               STentry entry = new STentry(nestingLevel,offset--); //separo introducendo "entry"
               
               //Controllo che non sia già dichiarata una funzione con lo stesso nome 
               if ( hm.put($i.text,entry) != null ){ 
                  System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
                  System.exit(0);
               }
               //creare una nuova hashmap per la symTable relativa alla funzione appena dichiarata
               nestingLevel++;
               HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
               symTable.add(hmn);
              }
              LPAR {
                    //Lista di parametri della funzione
                    ArrayList<Node> parTypes = new ArrayList<Node>();
                    int paroffset=1;} //
                (fid=ID COLON fty=type { 
                  //Aggiungo il primo parametro
                  parTypes.add($fty.ast); 
                  ParNode fpar = new ParNode($fid.text,$fty.ast);
                  f.addPar(fpar);
                  f.addSymType($fty.ast);              
                  if ( hmn.put($fid.text,new STentry(nestingLevel, $fty.ast, paroffset++)) != null  )
                    {System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
                     System.exit(0);}
                  }
                  (COMMA id=ID COLON ty=type {
                    parTypes.add($ty.ast); //
                    ParNode par = new ParNode($id.text,$ty.ast);
                    f.addPar(par);
                    if ( hmn.put($id.text,new STentry(nestingLevel,$ty.ast,paroffset++)) != null  )
                      {System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
                       System.exit(0);}
                    }
                  )*
                )? 
              RPAR {
                entry.addType(new ArrowTypeNode(parTypes, $t.ast));
                f.addSymType(new ArrowTypeNode(parTypes, $t.ast));
              } //
              (LET d=declist IN)? e=exp {
              //chiudere scope
              symTable.remove(nestingLevel--);
              f.addDecBody($d.astlist,$e.ast);
              }
          ) SEMIC
        )+          
  ;
  
type    returns [Node ast]
        : b=basic {$ast = $b.ast;}
        | a=arrow {$ast = $a.ast;}
        ;  
  
basic  returns [Node ast]
  :       INT  {$ast= new IntTypeNode();}
        | BOOL {$ast= new BoolTypeNode();} 
        | i=ID   {$ast= new ClassTypeNode($i.text);}
  ; 

arrow   returns [Node ast]
: LPAR 
        {
        ArrayList<Node> typeList = new ArrayList<>(); 
        }
        (t=type  
        { //aggiungo il primo
           typeList.add($t.ast);
        } 
        (COMMA ty=type
        {
        //aggiungo gli altri
        typeList.add($t.ast);
        }
        
      
        )* )? RPAR ARROW r=basic
        {
         
         
         $ast = new ArrowTypeNode(typeList, r);
         } ;          

   
exp returns [Node ast]
  : f=term {$ast= $f.ast;}
      (PLUS l=term
        {$ast= new PlusNode ($ast,$l.ast);}
        | 
        MINUS l=term
        {$ast= new MinusNode ($ast,$l.ast);}
        |
        OR l=term
        {$ast= new OrNode ($ast,$l.ast);}
      )*
  ;
  
term  returns [Node ast]
  : f=factor {$ast= $f.ast;}
      (TIMES l=factor
        {$ast= new MultNode ($ast,$l.ast);}
        |
        DIV l=factor 
        {$ast= new DivNode ($ast,$l.ast);}
        |
        AND l=factor 
        {$ast= new AndNode ($ast,$l.ast);}
      )*
  ;
  
factor  returns [Node ast]
  : f=value {$ast= $f.ast;}
      (EQ l=value 
        {$ast= new EqualNode ($ast,$l.ast);}
       |
       LE l=value 
       {$ast= new LessEqualNode ($ast,$l.ast);}
       |
       GE l=value 
       {$ast= new GreaterEqualNode ($ast,$l.ast);}
      )*
  ;   
  
value returns [Node ast]
  : n=INTEGER   
    {$ast= new IntNode(Integer.parseInt($n.text));}  
  | TRUE 
    {$ast= new BoolNode(true);}  
  | FALSE  
  | NULL  
    {$ast = new EmptyNode();}   
  | NEW i=ID {
    //Creo la lista del parametri
    ArrayList<Node> fieldList = new ArrayList<Node>();
    //Prendo la CTentry dalla class table
    CTentry classEntry = classTable.get($i.text);
    //Controllo l'esistenza della classe 
    if(classEntry == null){
          System.out.println("Class id "+$i.text+" at line "+$i.line+" not declared");
          System.exit(0);
        }
        //Creo il NewNode con l'id, la lista dei parametri e la ctentry 
    NewNode newNode = new NewNode($i.text, fieldList, classEntry);
    }
  LPAR (e=exp {
    //Aggiungo i parametri
    fieldList.add($e.ast);
  }
  (COMMA e=exp{
    //Aggiungo i parametri
    fieldList.add($e.ast);
  }
  )* )? RPAR     
    {$ast= new BoolNode(false);}  
  | LPAR e=exp RPAR
    {$ast= $e.ast;}  
  | IF x=exp THEN CLPAR y=exp CRPAR 
       ELSE CLPAR z=exp CRPAR 
    {$ast= new IfNode($x.ast,$y.ast,$z.ast);}  
  |  NOT LPAR t=term RPAR 
      {$ast= new NotNode($t.ast);}  
  | PRINT LPAR e=exp RPAR 
    {$ast= new PrintNode($e.ast);}
  | i=ID {
      //cercare la dichiarazione
	    int j=nestingLevel;
	    System.out.println("Nestinglevel " + nestingLevel);
	    
	    STentry entry=null; 
	    while (j>=0 && entry==null) {
	      entry=(symTable.get(j--)).get($i.text);
	      System.out.println(entry);
	    }
	    if (entry==null) {
	      System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
	      System.exit(0);
	    }               
	    $ast= new IdNode($i.text,entry,nestingLevel);
    }
    ( LPAR {ArrayList<Node> argList = new ArrayList<Node>();} 
      (fa=exp {argList.add($fa.ast);}
        (
          COMMA a=exp {argList.add($a.ast);}
        )* 
      )?
      RPAR {$ast=new CallNode($i.text,entry,argList,nestingLevel);}
      | DOT methodId=ID {
        CTentry classCTEntry = classTable.get($methodId.text);
        ArrayList<Node> methodParlist = new ArrayList<>();
        if(classCTEntry == null){
          System.out.println("Class id "+$i.text+" at line "+$i.line+" not declared");
          System.exit(0);
        }
        //Prendo dalla ctentry la virtual table da cui poi risalgo al metodo
        STentry methodSTEntry = classCTEntry.getVTable().get($methodId.text);
        
        STentry classSTEntry = symTable.get(0).get($i.text);
        //Controllo che il metodo esista 
        if(methodSTEntry == null) {
          System.out.println("Method id "+$i.text+" at line "+$i.line+" not declared");
          System.exit(0); 
        }
        
        
      }
      LPAR (e=exp {
        //Aggiungo il primo parametro
        methodParlist.add($e.ast);
      }
      
      (COMMA ee=exp{
      //Aggiungo i parametri successivi
        methodParlist.add($ee.ast);
        
      })* )?
      { $ast = new ClassCallNode($i.text, $methodId.text, classSTEntry, methodSTEntry, methodParlist, nestingLevel); }
       RPAR 
    )?      
  ; 

    
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

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

