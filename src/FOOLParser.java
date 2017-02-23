// $ANTLR 3.5.2 /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g 2017-02-23 18:46:17

		import java.util.ArrayList;
		import java.util.HashMap;
		import ast.*;
		import lib.FOOLlib;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARROW", "ASS", "BOOL", 
		"CLASS", "CLPAR", "COLON", "COMMA", "COMMENT", "CRPAR", "DIV", "DOT", 
		"ELSE", "EQ", "ERR", "EXTENDS", "FALSE", "FUN", "GE", "ID", "IF", "IN", 
		"INT", "INTEGER", "LE", "LET", "LPAR", "MINUS", "NEW", "NOT", "NULL", 
		"OR", "PLUS", "PRINT", "RPAR", "SEMIC", "THEN", "TIMES", "TRUE", "VAR", 
		"WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOL=7;
	public static final int CLASS=8;
	public static final int CLPAR=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int COMMENT=12;
	public static final int CRPAR=13;
	public static final int DIV=14;
	public static final int DOT=15;
	public static final int ELSE=16;
	public static final int EQ=17;
	public static final int ERR=18;
	public static final int EXTENDS=19;
	public static final int FALSE=20;
	public static final int FUN=21;
	public static final int GE=22;
	public static final int ID=23;
	public static final int IF=24;
	public static final int IN=25;
	public static final int INT=26;
	public static final int INTEGER=27;
	public static final int LE=28;
	public static final int LET=29;
	public static final int LPAR=30;
	public static final int MINUS=31;
	public static final int NEW=32;
	public static final int NOT=33;
	public static final int NULL=34;
	public static final int OR=35;
	public static final int PLUS=36;
	public static final int PRINT=37;
	public static final int RPAR=38;
	public static final int SEMIC=39;
	public static final int THEN=40;
	public static final int TIMES=41;
	public static final int TRUE=42;
	public static final int VAR=43;
	public static final int WHITESP=44;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FOOLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FOOLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g"; }


			private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
			private int nestingLevel = -1;
			//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
			//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
			
			private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>(); 
			
			private HashMap<String,String> superType = new HashMap<String,String>(); 



	// $ANTLR start "prog"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:28:1: prog returns [Node ast] : (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> c =null;
		ArrayList<Node> d =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:29:3: (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==INTEGER||LA1_0==LPAR||(LA1_0 >= NEW && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
				alt1=1;
			}
			else if ( (LA1_0==LET) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:29:11: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog48);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog50); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:31:11: LET c= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog78); 

					              nestingLevel++;
					              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					              symTable.add(hm);
					              FOOLlib.putSuperType(superType);
					          
					pushFollow(FOLLOW_cllist_in_prog96);
					c=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog111);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog113); 
					pushFollow(FOLLOW_exp_in_prog117);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog119); 

					            symTable.remove(nestingLevel--);
					            ast = new ProgLetInNode(d,e);
					          
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "cllist"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:1: cllist returns [ArrayList<Node> astlist] : ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token classId=null;
		Token superClass=null;
		Token fieldID=null;
		Token fieldId=null;
		Token funId=null;
		Token parId=null;
		Token varId=null;
		Node b =null;
		Node retType =null;
		Node t =null;
		Node varType =null;
		Node varExp =null;
		Node body =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:42: ( ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:44: ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			{
			        
				     astlist = new ArrayList<Node>();
				     //Lista dei campi
				     ArrayList<Node> fieldList = new ArrayList<Node>();
				     //Lista dei metodi
				     ArrayList<Node> methodList = new ArrayList<Node>();
			    
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:53:3: ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:53:4: CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist149); 
					classId=(Token)match(input,ID,FOLLOW_ID_in_cllist153); 
					 
					      //Nuova entry per la class table
					      CTentry ctEntry = new CTentry(); 
					      //Aggiungo alla Symbol Table di questo livello la virtual table della CTentry
					      symTable.add(ctEntry.getVTable());
					      //Prendo la Symbol table del livello corrente
					      HashMap<String, STentry> hm = symTable.get(nestingLevel);
					     
					     //Controllo che la classe non sia già stata dichiarata, altrimenti la aggiungo
					      if(hm.put((classId!=null?classId.getText():null), new STentry(nestingLevel, null, 777)) != null){
					          System.out.println("ERROR : Class " + (classId!=null?classId.getText():null) + "has been already declared!");
					          System.exit(1);
					      }          
					  
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:67:3: ( EXTENDS superClass= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:67:4: EXTENDS superClass= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist161); 
							superClass=(Token)match(input,ID,FOLLOW_ID_in_cllist165); 

							    //Se la classe estende un'altra classe
								  if(classTable.get(superClass) != null) {
								    //Se esiste la superclasse utilizzo il costruttore che prende in input una CTentry
								    ctEntry = new CTentry(classTable.get(superClass));
								    //Aggiungo la relazione fra le classi alla SuperType map
								    superType.put((classId!=null?classId.getText():null), (superClass!=null?superClass.getText():null));
								  } else { 
								    //Non esiste la superclasse - errore
								    System.out.println("Class of name "+(superClass!=null?superClass.getText():null) + "does not exist.");
								    System.exit(0);
								  } 
							  
							}
							break;

					}

					match(input,LPAR,FOLLOW_LPAR_in_cllist183); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:81:11: (fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:81:13: fieldID= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )*
							{
							fieldID=(Token)match(input,ID,FOLLOW_ID_in_cllist189); 
							match(input,COLON,FOLLOW_COLON_in_cllist191); 
							pushFollow(FOLLOW_basic_in_cllist195);
							b=basic();
							state._fsp--;

							  
							       //Primo campo:
							       //Aggiungo il campo alla CTentry (i controlli sono effettuati all'interno del metodo)
							       ctEntry.addField((fieldId!=null?fieldId.getText():null), b);      
							       //Aggiungo il campo alla fieldList 
							       fieldList.add(new FieldNode((fieldId!=null?fieldId.getText():null), b));
							     
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:88:6: ( COMMA fieldId= ID COLON b= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:88:7: COMMA fieldId= ID COLON b= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist206); 
									fieldId=(Token)match(input,ID,FOLLOW_ID_in_cllist210); 
									match(input,COLON,FOLLOW_COLON_in_cllist212); 
									pushFollow(FOLLOW_basic_in_cllist216);
									b=basic();
									state._fsp--;

									 
									       //Campi successivi al primo 
									       ctEntry.addField((fieldId!=null?fieldId.getText():null), b);
									       fieldList.add(new FieldNode((fieldId!=null?fieldId.getText():null), b));
									       
									     
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist236); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist257); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:99:13: ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:99:15: FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist286); 
							funId=(Token)match(input,ID,FOLLOW_ID_in_cllist290); 
							match(input,COLON,FOLLOW_COLON_in_cllist292); 
							pushFollow(FOLLOW_basic_in_cllist296);
							retType=basic();
							state._fsp--;

							 
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
							               MethodNode mNode = new MethodNode((funId!=null?funId.getText():null), retType);
							               //Lo aggiungo alla methodList
							               methodList.add(mNode);
							               //Lo aggiungo alla alla virtual table
							               ctEntry.addMethod((funId!=null?funId.getText():null), mNode);         
							            
							match(input,LPAR,FOLLOW_LPAR_in_cllist326); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:119:18: (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:119:19: parId= ID COLON t= type ( COMMA parId= ID COLON t= type )*
									{
									parId=(Token)match(input,ID,FOLLOW_ID_in_cllist331); 
									match(input,COLON,FOLLOW_COLON_in_cllist333); 
									pushFollow(FOLLOW_type_in_cllist337);
									t=type();
									state._fsp--;


									               //Creo la STEntry per il parametro e imposto 
									               STentry STentry = new STentry(nestingLevel, t, parOffset++);      //HO TOLTO DA QUI IL SET AS METHOD PERCHE ERA SBAGLIATO
									               //Aggiungo il parametro al method node
									               mNode.addPar(new ParNode((parId!=null?parId.getText():null), t));
									               //Aggiungo il tipo alla partypes
									               parTypes.add(t);
									               //Aggiungo alla symbol table del metodo il 
									               methodSymTable.put((parId!=null?parId.getText():null), STentry);
									               // qui non controllo che il parametro esista già, perchè è il primo 
									            
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:129:15: ( COMMA parId= ID COLON t= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:129:16: COMMA parId= ID COLON t= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist342); 
											parId=(Token)match(input,ID,FOLLOW_ID_in_cllist346); 
											match(input,COLON,FOLLOW_COLON_in_cllist348); 
											pushFollow(FOLLOW_type_in_cllist352);
											t=type();
											state._fsp--;

											 
											                //parametri successivi al primo; li aggiungo e controllo che non siano già stati dichiarati
											               mNode.addPar(new ParNode((parId!=null?parId.getText():null), t));
											               if (methodSymTable.put((parId!=null?parId.getText():null), new STentry(nestingLevel, t, parOffset++)) != null) {
											                   System.out.println("PAR id "+(parId!=null?parId.getText():null)+" at line "+(parId!=null?parId.getLine():0)+" already declared");
											                   System.exit(0);
											               } 
											            
											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist374); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:139:19: ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:139:20: LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist408); 
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:139:24: ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:139:25: VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist411); 
											varId=(Token)match(input,ID,FOLLOW_ID_in_cllist415); 
											match(input,COLON,FOLLOW_COLON_in_cllist417); 
											pushFollow(FOLLOW_basic_in_cllist421);
											varType=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist423); 
											pushFollow(FOLLOW_exp_in_cllist427);
											varExp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist429); 

											                      //Aggiungo la variabile al metodo
												                    mNode.addVar(new VarNode((varId!=null?varId.getText():null), varType, varExp));
												                    //Controllo che la variabile non sia già stata dichiarata
												                    if (methodSymTable.put((parId!=null?parId.getText():null), new STentry(nestingLevel, varType, offset--)) != null) {
												                      System.out.println("VAR id "+(parId!=null?parId.getText():null)+" at line "+(parId!=null?parId.getLine():0)+" already declared");
												                      System.exit(0);
												                    }
											                    
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist472); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist516);
							body=exp();
							state._fsp--;


							                    //Aggiungo il corpo
							                    mNode.addBody(body);
							                    //Aggiungo il tipo della symbol table
							                    mNode.addSymType(new ArrowTypeNode(parTypes, retType));
							                    //Rimuovo la symbol table perchè non mi serve in più (la dichiarazione è finita)
							                    symTable.remove(nestingLevel--); 
							                  
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist534); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist576); 

					      //Aggiungo la ctentry all'interno della class table
					      classTable.put((classId!=null?classId.getText():null), ctEntry);
					      //Creo il ClassNode e lo aggiungo alla lista
					      astlist.add(new ClassNode((classId!=null?classId.getText():null), fieldList, methodList));
					     
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astlist;
	}
	// $ANTLR end "cllist"



	// $ANTLR start "declist"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:171:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token i=null;
		Token fid=null;
		Token id=null;
		Node t =null;
		Node e =null;
		Node fty =null;
		Node ty =null;
		ArrayList<Node> d =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:172:3: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:172:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{
			 //Lista delle cose dichiarate 
			      astlist = new ArrayList<Node>() ;
			     int offset=-2;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:175:9: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==FUN||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:175:11: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:175:11: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==VAR) ) {
						alt14=1;
					}
					else if ( (LA14_0==FUN) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:176:13: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist637); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist641); 
							match(input,COLON,FOLLOW_COLON_in_declist643); 
							pushFollow(FOLLOW_type_in_declist647);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist649); 
							pushFollow(FOLLOW_exp_in_declist653);
							e=exp();
							state._fsp--;

							 //Dichiara una variabile
							               VarNode v = new VarNode((i!=null?i.getText():null),t,e); 
							               // Aggiungo la varibile alle cose dichiarate
							               astlist.add(v);
							               //Controllo che non sia già dichiarata
							               HashMap<String,STentry> hm = symTable.get(nestingLevel); 
							               if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  ) {
							                 System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							                  System.exit(0);
							                }  
							              
							}
							break;
						case 2 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:189:13: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist698); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist702); 
							match(input,COLON,FOLLOW_COLON_in_declist704); 
							pushFollow(FOLLOW_type_in_declist708);
							t=type();
							state._fsp--;


							               //Dichiaro una funzione - inserimento di ID nella symtable 
							               FunNode f = new FunNode((i!=null?i.getText():null),t);
							               // QUI LO AGGIUNGE ALLA LISTA DI COSE DICHIARATE 
							               astlist.add(f);
							               //Prendo la symbol table attuale
							               HashMap<String,STentry> hm = symTable.get(nestingLevel);
							               //Creo una nuova entry
							               STentry entry = new STentry(nestingLevel,offset--); //separo introducendo "entry"
							               
							               //Controllo che non sia già dichiarata una funzione con lo stesso nome 
							               if ( hm.put((i!=null?i.getText():null),entry) != null ){ 
							                  System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							                  System.exit(0);
							               }
							               //creare una nuova hashmap per la symTable relativa alla funzione appena dichiarata
							               nestingLevel++;
							               HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							               symTable.add(hmn);
							              
							match(input,LPAR,FOLLOW_LPAR_in_declist726); 

							                    //Lista di parametri della funzione
							                    ArrayList<Node> parTypes = new ArrayList<Node>();
							                    int paroffset=1;
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:213:17: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:213:18: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist750); 
									match(input,COLON,FOLLOW_COLON_in_declist752); 
									pushFollow(FOLLOW_type_in_declist756);
									fty=type();
									state._fsp--;

									 
									                  //Aggiungo il primo parametro
									                  parTypes.add(fty); 
									                  ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
									                  f.addPar(fpar);
									                  f.addSymType(fty);              
									                  if ( hmn.put((fid!=null?fid.getText():null),new STentry(nestingLevel, fty, paroffset++)) != null  )
									                    {System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
									                     System.exit(0);}
									                  
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:223:19: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:223:20: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist779); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist783); 
											match(input,COLON,FOLLOW_COLON_in_declist785); 
											pushFollow(FOLLOW_type_in_declist789);
											ty=type();
											state._fsp--;


											                    parTypes.add(ty); //
											                    ParNode par = new ParNode((id!=null?id.getText():null),ty);
											                    f.addPar(par);
											                    if ( hmn.put((id!=null?id.getText():null),new STentry(nestingLevel,ty,paroffset++)) != null  )
											                      {System.out.println("Parameter id "+(id!=null?id.getText():null)+" at line "+(id!=null?id.getLine():0)+" already declared");
											                       System.exit(0);}
											                    
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist848); 

							                entry.addType(new ArrowTypeNode(parTypes, t));
							                f.addSymType(new ArrowTypeNode(parTypes, t));
							              
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:237:15: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:237:16: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist868); 
									pushFollow(FOLLOW_declist_in_declist872);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist874); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist880);
							e=exp();
							state._fsp--;


							              //chiudere scope
							              symTable.remove(nestingLevel--);
							              f.addDecBody(d,e);
							              
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist896); 
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astlist;
	}
	// $ANTLR end "declist"



	// $ANTLR start "type"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:246:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node b =null;
		Node a =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:247:9: (b= basic |a= arrow )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BOOL||LA16_0==ID||LA16_0==INT) ) {
				alt16=1;
			}
			else if ( (LA16_0==LPAR) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:247:11: b= basic
					{
					pushFollow(FOLLOW_basic_in_type947);
					b=basic();
					state._fsp--;

					ast = b;
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:248:11: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type963);
					a=arrow();
					state._fsp--;

					ast = a;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"



	// $ANTLR start "basic"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:251:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:252:3: ( INT | BOOL |i= ID )
			int alt17=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt17=1;
				}
				break;
			case BOOL:
				{
				alt17=2;
				}
				break;
			case ID:
				{
				alt17=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:252:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic999); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:253:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic1014); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:254:11: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic1031); 
					ast = new ClassTypeNode((i!=null?i.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "basic"



	// $ANTLR start "arrow"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:257:1: arrow returns [Node ast] : LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node ty =null;
		Node r =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:258:3: ( LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:258:3: LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow1053); 

			        ArrayList<Node> typeList = new ArrayList<>(); 
			        
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:262:9: (t= type ( COMMA ty= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:262:10: t= type ( COMMA ty= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1077);
					t=type();
					state._fsp--;

					 //aggiungo il primo
					           typeList.add(t);
					        
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:266:9: ( COMMA ty= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:266:10: COMMA ty= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1101); 
							pushFollow(FOLLOW_type_in_arrow1105);
							ty=type();
							state._fsp--;


							        //aggiungo gli altri
							        typeList.add(t);
							        
							}
							break;

						default :
							break loop18;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow1147); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1149); 
			pushFollow(FOLLOW_basic_in_arrow1153);
			r=basic();
			state._fsp--;


			         
			         
			         ast = new ArrowTypeNode(typeList, r);
			         
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "arrow"



	// $ANTLR start "exp"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:281:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:282:3: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:282:5: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1194);
			f=term();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:283:7: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop20:
			while (true) {
				int alt20=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt20=1;
					}
					break;
				case MINUS:
					{
					alt20=2;
					}
					break;
				case OR:
					{
					alt20=3;
					}
					break;
				}
				switch (alt20) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:283:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1205); 
					pushFollow(FOLLOW_term_in_exp1209);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:286:9: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1240); 
					pushFollow(FOLLOW_term_in_exp1244);
					l=term();
					state._fsp--;

					ast = new MinusNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:289:9: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1274); 
					pushFollow(FOLLOW_term_in_exp1278);
					l=term();
					state._fsp--;

					ast = new OrNode (ast,l);
					}
					break;

				default :
					break loop20;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:294:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:295:3: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:295:5: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1319);
			f=factor();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:296:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
			loop21:
			while (true) {
				int alt21=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt21=1;
					}
					break;
				case DIV:
					{
					alt21=2;
					}
					break;
				case AND:
					{
					alt21=3;
					}
					break;
				}
				switch (alt21) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:296:8: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1330); 
					pushFollow(FOLLOW_factor_in_term1334);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:299:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1364); 
					pushFollow(FOLLOW_factor_in_term1368);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:302:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1399); 
					pushFollow(FOLLOW_factor_in_term1403);
					l=factor();
					state._fsp--;

					ast = new AndNode (ast,l);
					}
					break;

				default :
					break loop21;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:307:1: factor returns [Node ast] : f= value ( EQ l= value | LE l= value | GE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:308:3: (f= value ( EQ l= value | LE l= value | GE l= value )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:308:5: f= value ( EQ l= value | LE l= value | GE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1445);
			f=value();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:309:7: ( EQ l= value | LE l= value | GE l= value )*
			loop22:
			while (true) {
				int alt22=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt22=1;
					}
					break;
				case LE:
					{
					alt22=2;
					}
					break;
				case GE:
					{
					alt22=3;
					}
					break;
				}
				switch (alt22) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:309:8: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1456); 
					pushFollow(FOLLOW_value_in_factor1460);
					l=value();
					state._fsp--;

					ast = new EqualNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:312:8: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1489); 
					pushFollow(FOLLOW_value_in_factor1493);
					l=value();
					state._fsp--;

					ast = new LessEqualNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:315:8: GE l= value
					{
					match(input,GE,FOLLOW_GE_in_factor1521); 
					pushFollow(FOLLOW_value_in_factor1525);
					l=value();
					state._fsp--;

					ast = new GreaterEqualNode (ast,l);
					}
					break;

				default :
					break loop22;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "factor"



	// $ANTLR start "value"
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:320:1: value returns [Node ast] : (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT id= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Token id=null;
		Node e =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node t =null;
		Node fa =null;
		Node a =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:321:3: (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT id= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR )? )
			int alt30=10;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt30=1;
				}
				break;
			case TRUE:
				{
				alt30=2;
				}
				break;
			case FALSE:
				{
				alt30=3;
				}
				break;
			case NULL:
				{
				alt30=4;
				}
				break;
			case NEW:
				{
				alt30=5;
				}
				break;
			case LPAR:
				{
				alt30=6;
				}
				break;
			case IF:
				{
				alt30=7;
				}
				break;
			case NOT:
				{
				alt30=8;
				}
				break;
			case PRINT:
				{
				alt30=9;
				}
				break;
			case ID:
				{
				alt30=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:321:5: n= INTEGER
					{
					n=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1568); 
					ast = new IntNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:323:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1585); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:325:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1600); 
					}
					break;
				case 4 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:326:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1608); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:328:5: NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1625); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1629); 

					    ArrayList<Node> fieldList = new ArrayList<Node>();
					    NewNode newNode = new NewNode((i!=null?i.getText():null), fieldList);
					    
					match(input,LPAR,FOLLOW_LPAR_in_value1635); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:332:8: (e= exp ( COMMA e= exp )* )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==FALSE||(LA24_0 >= ID && LA24_0 <= IF)||LA24_0==INTEGER||LA24_0==LPAR||(LA24_0 >= NEW && LA24_0 <= NULL)||LA24_0==PRINT||LA24_0==TRUE) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:332:9: e= exp ( COMMA e= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1640);
							e=exp();
							state._fsp--;


							    fieldList.add(e);
							  
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:335:3: ( COMMA e= exp )*
							loop23:
							while (true) {
								int alt23=2;
								int LA23_0 = input.LA(1);
								if ( (LA23_0==COMMA) ) {
									alt23=1;
								}

								switch (alt23) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:335:4: COMMA e= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1647); 
									pushFollow(FOLLOW_exp_in_value1651);
									e=exp();
									state._fsp--;


									    fieldList.add(e);
									  
									}
									break;

								default :
									break loop23;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_value1662); 
					ast = new BoolNode(false);
					}
					break;
				case 6 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:340:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1681); 
					pushFollow(FOLLOW_exp_in_value1685);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1687); 
					ast = e;
					}
					break;
				case 7 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:342:5: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1701); 
					pushFollow(FOLLOW_exp_in_value1705);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value1707); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1709); 
					pushFollow(FOLLOW_exp_in_value1713);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1715); 
					match(input,ELSE,FOLLOW_ELSE_in_value1725); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1727); 
					pushFollow(FOLLOW_exp_in_value1731);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1733); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:345:6: NOT LPAR t= term RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1749); 
					match(input,LPAR,FOLLOW_LPAR_in_value1751); 
					pushFollow(FOLLOW_term_in_value1755);
					t=term();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1757); 
					ast = new NotNode(t);
					}
					break;
				case 9 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:347:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1774); 
					match(input,LPAR,FOLLOW_LPAR_in_value1776); 
					pushFollow(FOLLOW_exp_in_value1780);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1782); 
					ast = new PrintNode(e);
					}
					break;
				case 10 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:349:5: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT id= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1797); 
					//cercare la dichiarazione
						    int j=nestingLevel;
						    STentry entry=null; 
						    while (j>=0 && entry==null) {
						      entry=(symTable.get(j--)).get((i!=null?i.getText():null));
						    }
						    if (entry==null) {
						      System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
						      System.exit(0);
						    }               
						    ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					    
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:361:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT id= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR )?
					int alt29=3;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==LPAR) ) {
						alt29=1;
					}
					else if ( (LA29_0==DOT) ) {
						alt29=2;
					}
					switch (alt29) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:361:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1807); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:362:7: (fa= exp ( COMMA a= exp )* )?
							int alt26=2;
							int LA26_0 = input.LA(1);
							if ( (LA26_0==FALSE||(LA26_0 >= ID && LA26_0 <= IF)||LA26_0==INTEGER||LA26_0==LPAR||(LA26_0 >= NEW && LA26_0 <= NULL)||LA26_0==PRINT||LA26_0==TRUE) ) {
								alt26=1;
							}
							switch (alt26) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:362:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1821);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:363:9: ( COMMA a= exp )*
									loop25:
									while (true) {
										int alt25=2;
										int LA25_0 = input.LA(1);
										if ( (LA25_0==COMMA) ) {
											alt25=1;
										}

										switch (alt25) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:364:11: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1845); 
											pushFollow(FOLLOW_exp_in_value1849);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop25;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1880); 
							ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
							}
							break;
						case 2 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:368:9: DOT id= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1892); 
							id=(Token)match(input,ID,FOLLOW_ID_in_value1896); 
							match(input,LPAR,FOLLOW_LPAR_in_value1898); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:368:24: (e= exp ( COMMA e= exp )* )?
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( (LA28_0==FALSE||(LA28_0 >= ID && LA28_0 <= IF)||LA28_0==INTEGER||LA28_0==LPAR||(LA28_0 >= NEW && LA28_0 <= NULL)||LA28_0==PRINT||LA28_0==TRUE) ) {
								alt28=1;
							}
							switch (alt28) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:368:25: e= exp ( COMMA e= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1903);
									e=exp();
									state._fsp--;

									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:368:31: ( COMMA e= exp )*
									loop27:
									while (true) {
										int alt27=2;
										int LA27_0 = input.LA(1);
										if ( (LA27_0==COMMA) ) {
											alt27=1;
										}

										switch (alt27) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:368:32: COMMA e= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1906); 
											pushFollow(FOLLOW_exp_in_value1910);
											e=exp();
											state._fsp--;

											}
											break;

										default :
											break loop27;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1917); 
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog48 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog78 = new BitSet(new long[]{0x0000080000200100L});
	public static final BitSet FOLLOW_cllist_in_prog96 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_prog111 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_prog113 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_prog117 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist149 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist153 = new BitSet(new long[]{0x0000000040080000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist161 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist165 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist183 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist189 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist191 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist195 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist206 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist210 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist212 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist216 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist236 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist257 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_FUN_in_cllist286 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist290 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist292 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist296 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist326 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist331 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist333 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist337 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist342 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist346 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist348 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist352 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist374 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_cllist408 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_VAR_in_cllist411 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist415 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist417 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist421 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist423 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist427 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist429 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_IN_in_cllist472 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist516 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist534 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist576 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist637 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist641 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist643 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist647 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist649 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist653 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist698 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist702 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist704 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist708 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist726 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_declist750 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist752 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist756 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist779 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist783 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist785 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist789 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist848 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_declist868 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_declist872 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_declist874 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist880 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist896 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_basic_in_type947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic1031 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow1053 = new BitSet(new long[]{0x0000004044800080L});
	public static final BitSet FOLLOW_type_in_arrow1077 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow1101 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_arrow1105 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow1147 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1149 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_arrow1153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp1194 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1205 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1209 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1240 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1244 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_OR_in_exp1274 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1278 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_factor_in_term1319 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_TIMES_in_term1330 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1334 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_DIV_in_term1364 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1368 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_AND_in_term1399 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1403 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_value_in_factor1445 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_EQ_in_factor1456 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1460 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_LE_in_factor1489 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1493 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_GE_in_factor1521 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1525 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_INTEGER_in_value1568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1625 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1629 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1635 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1640 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1647 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1651 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1681 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1685 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1701 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1705 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1707 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1709 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1713 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1715 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_value1725 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1727 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1731 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1749 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1751 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_value1755 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1774 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1776 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1780 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1797 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_LPAR_in_value1807 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1821 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1845 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1849 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1892 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1896 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1898 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1903 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1906 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1910 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1917 = new BitSet(new long[]{0x0000000000000002L});
}
