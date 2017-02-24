// $ANTLR 3.5.2 /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g 2017-02-24 16:16:17

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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:1: cllist returns [ArrayList<Node> astlist] : ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token classId=null;
		Token superClass=null;
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
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:42: ( ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:45:44: ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			{
			        
				   astlist = new ArrayList<Node>();
				   //Lista dei campi
				   ArrayList<Node> fieldList = new ArrayList<Node>();
				   //Lista dei metodi
				   ArrayList<Node> methodList = new ArrayList<Node>();
			  
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:53:3: ( CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:53:4: CLASS classId= ID ( EXTENDS superClass= ID )? LPAR (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )? RPAR CLPAR ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist149); 
					classId=(Token)match(input,ID,FOLLOW_ID_in_cllist153); 
					 
					      //Nuova entry per la class table
					      CTentry ctEntry = new CTentry(); 
					      CTentry superClassEntry = new CTentry();
					      
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
									  if(classTable.get((superClass!=null?superClass.getText():null)) != null) {
									    //Se esiste la superclasse utilizzo il costruttore che prende in input una CTentry
									    superClassEntry =  new CTentry(classTable.get((superClass!=null?superClass.getText():null)));
									    ctEntry = superClassEntry;
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


					      //Aggiungo la ctentry all'interno della class table
					      classTable.put((classId!=null?classId.getText():null), ctEntry);
					      //Aggiungo alla Symbol Table di questo livello la virtual table della CTentry
					      symTable.add(ctEntry.getVTable());
					      //Creo il ClassNode e lo aggiungo alla lista
					      astlist.add(new ClassNode((classId!=null?classId.getText():null), fieldList, methodList, ctEntry, superClassEntry));
					        
					  
					match(input,LPAR,FOLLOW_LPAR_in_cllist179); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:90:8: (fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:90:10: fieldId= ID COLON b= basic ( COMMA fieldId= ID COLON b= basic )*
							{
							fieldId=(Token)match(input,ID,FOLLOW_ID_in_cllist185); 
							match(input,COLON,FOLLOW_COLON_in_cllist187); 
							pushFollow(FOLLOW_basic_in_cllist191);
							b=basic();
							state._fsp--;

							  
							    //Primo campo:
							    //Aggiungo il campo alla CTentry (i controlli sono effettuati all'interno del metodo)
							    ctEntry.addField((fieldId!=null?fieldId.getText():null), b);     
							    //Aggiungo il campo alla fieldList 
							    fieldList.add(new FieldNode((fieldId!=null?fieldId.getText():null), b));
							  
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:97:3: ( COMMA fieldId= ID COLON b= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:97:4: COMMA fieldId= ID COLON b= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist199); 
									fieldId=(Token)match(input,ID,FOLLOW_ID_in_cllist203); 
									match(input,COLON,FOLLOW_COLON_in_cllist205); 
									pushFollow(FOLLOW_basic_in_cllist209);
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

					match(input,RPAR,FOLLOW_RPAR_in_cllist220); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist235); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:107:10: ( FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:107:12: FUN funId= ID COLON retType= basic LPAR (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )? RPAR ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist258); 
							funId=(Token)match(input,ID,FOLLOW_ID_in_cllist262); 
							match(input,COLON,FOLLOW_COLON_in_cllist264); 
							pushFollow(FOLLOW_basic_in_cllist268);
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
							         
							match(input,LPAR,FOLLOW_LPAR_in_cllist292); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:127:15: (parId= ID COLON t= type ( COMMA parId= ID COLON t= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:127:16: parId= ID COLON t= type ( COMMA parId= ID COLON t= type )*
									{
									parId=(Token)match(input,ID,FOLLOW_ID_in_cllist297); 
									match(input,COLON,FOLLOW_COLON_in_cllist299); 
									pushFollow(FOLLOW_type_in_cllist303);
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
									         
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:137:12: ( COMMA parId= ID COLON t= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:137:13: COMMA parId= ID COLON t= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist308); 
											parId=(Token)match(input,ID,FOLLOW_ID_in_cllist312); 
											match(input,COLON,FOLLOW_COLON_in_cllist314); 
											pushFollow(FOLLOW_type_in_cllist318);
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

							match(input,RPAR,FOLLOW_RPAR_in_cllist337); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:147:16: ( LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:147:17: LET ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist365); 
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:147:21: ( VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:147:22: VAR varId= ID COLON varType= basic ASS varExp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist368); 
											varId=(Token)match(input,ID,FOLLOW_ID_in_cllist372); 
											match(input,COLON,FOLLOW_COLON_in_cllist374); 
											pushFollow(FOLLOW_basic_in_cllist378);
											varType=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist380); 
											pushFollow(FOLLOW_exp_in_cllist384);
											varExp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist386); 

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

									match(input,IN,FOLLOW_IN_in_cllist423); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist461);
							body=exp();
							state._fsp--;


							                 //Aggiungo il corpo
							                 mNode.addBody(body);
							                 //Aggiungo il tipo della symbol table
							                 mNode.addSymType(new ArrowTypeNode(parTypes, retType));
							                 //Rimuovo la symbol table perchè non mi serve in più (la dichiarazione è finita)
							                 symTable.remove(nestingLevel--); 
							               
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist476); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist512); 
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:174:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
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
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:175:3: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:175:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{
			 //Lista delle cose dichiarate 
			      astlist = new ArrayList<Node>() ;
			     int offset=-2;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:178:9: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:178:11: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:178:11: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:179:13: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist567); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist571); 
							match(input,COLON,FOLLOW_COLON_in_declist573); 
							pushFollow(FOLLOW_type_in_declist577);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist579); 
							pushFollow(FOLLOW_exp_in_declist583);
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
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:192:13: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist628); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist632); 
							match(input,COLON,FOLLOW_COLON_in_declist634); 
							pushFollow(FOLLOW_type_in_declist638);
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
							              
							match(input,LPAR,FOLLOW_LPAR_in_declist656); 

							                    //Lista di parametri della funzione
							                    ArrayList<Node> parTypes = new ArrayList<Node>();
							                    int paroffset=1;
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:216:17: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:216:18: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist680); 
									match(input,COLON,FOLLOW_COLON_in_declist682); 
									pushFollow(FOLLOW_type_in_declist686);
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
									                  
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:226:19: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:226:20: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist709); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist713); 
											match(input,COLON,FOLLOW_COLON_in_declist715); 
											pushFollow(FOLLOW_type_in_declist719);
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

							match(input,RPAR,FOLLOW_RPAR_in_declist778); 

							                entry.addType(new ArrowTypeNode(parTypes, t));
							                f.addSymType(new ArrowTypeNode(parTypes, t));
							              
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:240:15: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:240:16: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist798); 
									pushFollow(FOLLOW_declist_in_declist802);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist804); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist810);
							e=exp();
							state._fsp--;


							              //chiudere scope
							              symTable.remove(nestingLevel--);
							              f.addDecBody(d,e);
							              
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist826); 
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:249:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node b =null;
		Node a =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:250:9: (b= basic |a= arrow )
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:250:11: b= basic
					{
					pushFollow(FOLLOW_basic_in_type877);
					b=basic();
					state._fsp--;

					ast = b;
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:251:11: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type893);
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:254:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:255:3: ( INT | BOOL |i= ID )
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:255:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic929); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:256:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic944); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:257:11: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic961); 
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:260:1: arrow returns [Node ast] : LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node ty =null;
		Node r =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:261:3: ( LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:261:3: LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow983); 

			        ArrayList<Node> typeList = new ArrayList<>(); 
			        
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:265:9: (t= type ( COMMA ty= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:265:10: t= type ( COMMA ty= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1007);
					t=type();
					state._fsp--;

					 //aggiungo il primo
					           typeList.add(t);
					        
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:269:9: ( COMMA ty= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:269:10: COMMA ty= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1031); 
							pushFollow(FOLLOW_type_in_arrow1035);
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

			match(input,RPAR,FOLLOW_RPAR_in_arrow1077); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1079); 
			pushFollow(FOLLOW_basic_in_arrow1083);
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:284:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:285:3: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:285:5: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1124);
			f=term();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:286:7: ( PLUS l= term | MINUS l= term | OR l= term )*
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:286:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1135); 
					pushFollow(FOLLOW_term_in_exp1139);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:289:9: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1170); 
					pushFollow(FOLLOW_term_in_exp1174);
					l=term();
					state._fsp--;

					ast = new MinusNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:292:9: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1204); 
					pushFollow(FOLLOW_term_in_exp1208);
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:297:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:298:3: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:298:5: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1249);
			f=factor();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:299:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:299:8: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1260); 
					pushFollow(FOLLOW_factor_in_term1264);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:302:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1294); 
					pushFollow(FOLLOW_factor_in_term1298);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:305:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1329); 
					pushFollow(FOLLOW_factor_in_term1333);
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:310:1: factor returns [Node ast] : f= value ( EQ l= value | LE l= value | GE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:311:3: (f= value ( EQ l= value | LE l= value | GE l= value )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:311:5: f= value ( EQ l= value | LE l= value | GE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1375);
			f=value();
			state._fsp--;

			ast = f;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:312:7: ( EQ l= value | LE l= value | GE l= value )*
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:312:8: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1386); 
					pushFollow(FOLLOW_value_in_factor1390);
					l=value();
					state._fsp--;

					ast = new EqualNode (ast,l);
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:315:8: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1419); 
					pushFollow(FOLLOW_value_in_factor1423);
					l=value();
					state._fsp--;

					ast = new LessEqualNode (ast,l);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:318:8: GE l= value
					{
					match(input,GE,FOLLOW_GE_in_factor1451); 
					pushFollow(FOLLOW_value_in_factor1455);
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
	// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:323:1: value returns [Node ast] : (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodId= ID LPAR (e= exp ( COMMA ee= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Token methodId=null;
		Node e =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node t =null;
		Node fa =null;
		Node a =null;
		Node ee =null;

		try {
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:324:3: (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodId= ID LPAR (e= exp ( COMMA ee= exp )* )? RPAR )? )
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:324:5: n= INTEGER
					{
					n=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1498); 
					ast = new IntNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:326:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1515); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:328:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1530); 
					}
					break;
				case 4 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:329:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1538); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:331:5: NEW i= ID LPAR (e= exp ( COMMA e= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1555); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1559); 

					    //Creo la lista del parametri
					    ArrayList<Node> fieldList = new ArrayList<Node>();
					    //Prendo la CTentry dalla class table
					    CTentry classEntry = classTable.get((i!=null?i.getText():null));
					    //Controllo l'esistenza della classe 
					    if(classEntry == null){
					          System.out.println("Class id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
					          System.exit(0);
					        }
					        //Creo il NewNode con l'id, la lista dei parametri e la ctentry 
					    NewNode newNode = new NewNode((i!=null?i.getText():null), fieldList, classEntry);
					    
					match(input,LPAR,FOLLOW_LPAR_in_value1565); 
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:344:8: (e= exp ( COMMA e= exp )* )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==FALSE||(LA24_0 >= ID && LA24_0 <= IF)||LA24_0==INTEGER||LA24_0==LPAR||(LA24_0 >= NEW && LA24_0 <= NULL)||LA24_0==PRINT||LA24_0==TRUE) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:344:9: e= exp ( COMMA e= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1570);
							e=exp();
							state._fsp--;


							    //Aggiungo i parametri
							    fieldList.add(e);
							  
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:348:3: ( COMMA e= exp )*
							loop23:
							while (true) {
								int alt23=2;
								int LA23_0 = input.LA(1);
								if ( (LA23_0==COMMA) ) {
									alt23=1;
								}

								switch (alt23) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:348:4: COMMA e= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1577); 
									pushFollow(FOLLOW_exp_in_value1581);
									e=exp();
									state._fsp--;


									    //Aggiungo i parametri
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

					match(input,RPAR,FOLLOW_RPAR_in_value1592); 
					ast = new BoolNode(false);
					}
					break;
				case 6 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:354:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1611); 
					pushFollow(FOLLOW_exp_in_value1615);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1617); 
					ast = e;
					}
					break;
				case 7 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:356:5: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1631); 
					pushFollow(FOLLOW_exp_in_value1635);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value1637); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1639); 
					pushFollow(FOLLOW_exp_in_value1643);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1645); 
					match(input,ELSE,FOLLOW_ELSE_in_value1655); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1657); 
					pushFollow(FOLLOW_exp_in_value1661);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1663); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:359:6: NOT LPAR t= term RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1679); 
					match(input,LPAR,FOLLOW_LPAR_in_value1681); 
					pushFollow(FOLLOW_term_in_value1685);
					t=term();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1687); 
					ast = new NotNode(t);
					}
					break;
				case 9 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:361:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1704); 
					match(input,LPAR,FOLLOW_LPAR_in_value1706); 
					pushFollow(FOLLOW_exp_in_value1710);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1712); 
					ast = new PrintNode(e);
					}
					break;
				case 10 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:363:5: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodId= ID LPAR (e= exp ( COMMA ee= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1727); 

					      //cercare la dichiarazione
						    int j=nestingLevel;
						    System.out.println("Nestinglevel " + nestingLevel);
						    
						    STentry entry=null; 
						    while (j>=0 && entry==null) {
						      entry=(symTable.get(j--)).get((i!=null?i.getText():null));
						      System.out.println(entry);
						    }
						    if (entry==null) {
						      System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
						      System.exit(0);
						    }               
						    ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					    
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:379:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodId= ID LPAR (e= exp ( COMMA ee= exp )* )? RPAR )?
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
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:379:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1737); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:380:7: (fa= exp ( COMMA a= exp )* )?
							int alt26=2;
							int LA26_0 = input.LA(1);
							if ( (LA26_0==FALSE||(LA26_0 >= ID && LA26_0 <= IF)||LA26_0==INTEGER||LA26_0==LPAR||(LA26_0 >= NEW && LA26_0 <= NULL)||LA26_0==PRINT||LA26_0==TRUE) ) {
								alt26=1;
							}
							switch (alt26) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:380:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1751);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:381:9: ( COMMA a= exp )*
									loop25:
									while (true) {
										int alt25=2;
										int LA25_0 = input.LA(1);
										if ( (LA25_0==COMMA) ) {
											alt25=1;
										}

										switch (alt25) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:382:11: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1775); 
											pushFollow(FOLLOW_exp_in_value1779);
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

							match(input,RPAR,FOLLOW_RPAR_in_value1810); 
							ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
							}
							break;
						case 2 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:386:9: DOT methodId= ID LPAR (e= exp ( COMMA ee= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1822); 
							methodId=(Token)match(input,ID,FOLLOW_ID_in_value1826); 

							        CTentry classCTEntry = classTable.get((methodId!=null?methodId.getText():null));
							        ArrayList<Node> methodParlist = new ArrayList<>();
							        if(classCTEntry == null){
							          System.out.println("Class id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
							          System.exit(0);
							        }
							        //Prendo dalla ctentry la virtual table da cui poi risalgo al metodo
							        STentry methodSTEntry = classCTEntry.getVTable().get((methodId!=null?methodId.getText():null));
							        
							        STentry classSTEntry = symTable.get(0).get((i!=null?i.getText():null));
							        //Controllo che il metodo esista 
							        if(methodSTEntry == null) {
							          System.out.println("Method id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
							          System.exit(0); 
							        }
							        
							        
							      
							match(input,LPAR,FOLLOW_LPAR_in_value1836); 
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:405:12: (e= exp ( COMMA ee= exp )* )?
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( (LA28_0==FALSE||(LA28_0 >= ID && LA28_0 <= IF)||LA28_0==INTEGER||LA28_0==LPAR||(LA28_0 >= NEW && LA28_0 <= NULL)||LA28_0==PRINT||LA28_0==TRUE) ) {
								alt28=1;
							}
							switch (alt28) {
								case 1 :
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:405:13: e= exp ( COMMA ee= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1841);
									e=exp();
									state._fsp--;


									        //Aggiungo il primo parametro
									        methodParlist.add(e);
									      
									// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:410:7: ( COMMA ee= exp )*
									loop27:
									while (true) {
										int alt27=2;
										int LA27_0 = input.LA(1);
										if ( (LA27_0==COMMA) ) {
											alt27=1;
										}

										switch (alt27) {
										case 1 :
											// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:410:8: COMMA ee= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1859); 
											pushFollow(FOLLOW_exp_in_value1863);
											ee=exp();
											state._fsp--;


											      //Aggiungo i parametri successivi
											        methodParlist.add(ee);
											        
											      
											}
											break;

										default :
											break loop27;
										}
									}

									}
									break;

							}

							 ast = new ClassCallNode((i!=null?i.getText():null), (methodId!=null?methodId.getText():null), classSTEntry, methodSTEntry, methodParlist, nestingLevel); 
							match(input,RPAR,FOLLOW_RPAR_in_value1886); 
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
	public static final BitSet FOLLOW_LPAR_in_cllist179 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist185 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist187 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist191 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist199 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist203 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist205 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist209 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist220 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist235 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_FUN_in_cllist258 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist262 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist264 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist268 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist292 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist297 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist299 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist303 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist308 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist312 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist314 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist318 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist337 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_cllist365 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_VAR_in_cllist368 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist372 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist374 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist378 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist380 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist384 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist386 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_IN_in_cllist423 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist461 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist476 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist512 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist567 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist571 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist573 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist577 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist579 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist583 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist628 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist632 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist634 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist638 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist656 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_declist680 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist682 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist686 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist709 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist713 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist715 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist719 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist778 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_declist798 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_declist802 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_declist804 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist810 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist826 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_basic_in_type877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow983 = new BitSet(new long[]{0x0000004044800080L});
	public static final BitSet FOLLOW_type_in_arrow1007 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow1031 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_arrow1035 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow1077 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1079 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_arrow1083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp1124 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1135 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1139 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1170 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1174 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_OR_in_exp1204 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1208 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_factor_in_term1249 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_TIMES_in_term1260 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1264 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_DIV_in_term1294 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1298 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_AND_in_term1329 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1333 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_value_in_factor1375 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_EQ_in_factor1386 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1390 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_LE_in_factor1419 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1423 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_GE_in_factor1451 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1455 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_INTEGER_in_value1498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1555 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1559 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1565 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1570 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1577 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1581 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1611 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1615 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1631 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1635 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1637 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1639 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1643 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1645 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_value1655 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1657 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1661 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1679 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1681 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_value1685 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1704 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1706 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1710 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1727 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_LPAR_in_value1737 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1751 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1775 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1779 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1822 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1826 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1836 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1841 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1859 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1863 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1886 = new BitSet(new long[]{0x0000000000000002L});
}
