// $ANTLR 3.5.2 D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g 2017-02-25 12:41:48

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
	@Override public String getGrammarFileName() { return "D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g"; }


			private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
			private int nestingLevel = -1;
			//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
			//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
			
			private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>(); 
			
			private HashMap<String,String> superType = new HashMap<String,String>(); 



	// $ANTLR start "prog"
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:28:1: prog returns [Node ast] : (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> c =null;
		ArrayList<Node> d =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:28:25: (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC )
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:29:6: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog42);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog44); 

						        ast = new ProgNode(e);
						    
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:33:6: LET c= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog62); 

								nestingLevel++;
								HashMap<String,STentry> hm = new HashMap<String,STentry> ();
								symTable.add(hm);
								FOOLlib.putSuperType(superType);
								
						    
					pushFollow(FOLLOW_cllist_in_prog79);
					c=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog83);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog91); 
					pushFollow(FOLLOW_exp_in_prog95);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog97); 

						    
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:51:1: cllist returns [ArrayList<Node> astlist] : ( CLASS classID= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )? RPAR CLPAR ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token classID=null;
		Token superClass=null;
		Token fieldID=null;
		Token funID=null;
		Token mparfID=null;
		Token mparnID=null;
		Token varID=null;
		Node fieldType =null;
		Node retType =null;
		Node mparfType =null;
		Node mparnType =null;
		Node varType =null;
		Node varExp =null;
		Node body =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:51:42: ( ( CLASS classID= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )? RPAR CLPAR ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:51:44: ( CLASS classID= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )? RPAR CLPAR ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			{

				        
						astlist = new ArrayList<Node>();
					   
				    
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:55:8: ( CLASS classID= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )? RPAR CLPAR ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:56:10: CLASS classID= ID ( EXTENDS superClass= ID )? LPAR (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )? RPAR CLPAR ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist133); 
					classID=(Token)match(input,ID,FOLLOW_ID_in_cllist153); 
					 
							        //Nuova entry per la class table
							        CTentry ctEntry = new CTentry(); 
							        CTentry superClassEntry = new CTentry();
							 
							        //Prendo la Symbol table del livello corrente
							        HashMap<String, STentry> hm = symTable.get(nestingLevel);
							
									//Controllo che la classe non sia già stata dichiarata, altrimenti la aggiungo
									if(hm.put((classID!=null?classID.getText():null), new STentry(nestingLevel, null, 777)) != null){
									    System.out.println("ERROR : Class " + (classID!=null?classID.getText():null) + "has been already declared!");
									    System.exit(1);
									}          
							    
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:71:9: ( EXTENDS superClass= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:72:11: EXTENDS superClass= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist170); 
							superClass=(Token)match(input,ID,FOLLOW_ID_in_cllist187); 

											    //Se la classe estende un'altra classe
											    superClassEntry = classTable.get((superClass!=null?superClass.getText():null));
												if(superClassEntry != null) {
													//Se esiste la superclasse utilizzo il costruttore che prende in input una CTentry
													ctEntry = new CTentry(superClassEntry);
													//Aggiungo la relazione fra le classi alla SuperType map
													superType.put((classID!=null?classID.getText():null), (superClass!=null?superClass.getText():null));
												} else { 
													//Non esiste la superclasse - errore
													System.out.println("Class of name "+(superClass!=null?superClass.getText():null) + "does not exist.");
													System.exit(0);
												}
											
							}
							break;

					}


								    //Lista dei campi
						            ArrayList<Node> fieldList = new ArrayList<Node>();
						            //Lista dei metodi
						            ArrayList<Node> methodList = new ArrayList<Node>();
						            
						            //Creo il ClassNode e lo aggiungo alla lista
					                astlist.add(new ClassNode(new ClassTypeNode((classID!=null?classID.getText():null)), fieldList, methodList, ctEntry, superClassEntry));
									
									//Aggiungo la ctentry all'interno della class table
									classTable.put((classID!=null?classID.getText():null), ctEntry);
									
									// Sempre il bomber qui aumenta il Nesting Level di inserire nella SymTable
					                nestingLevel++;
					                //Aggiungo alla Symbol Table di questo livello la virtual table della CTentry
					                symTable.add(ctEntry.getVTable());
					                
								
					match(input,LPAR,FOLLOW_LPAR_in_cllist200); 
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:104:11: (fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:105:8: fieldID= ID COLON fieldType= basic ( COMMA fieldID= ID COLON fieldType= basic )*
							{
							fieldID=(Token)match(input,ID,FOLLOW_ID_in_cllist216); 
							match(input,COLON,FOLLOW_COLON_in_cllist218); 
							pushFollow(FOLLOW_basic_in_cllist224);
							fieldType=basic();
							state._fsp--;


										    
												//Primo campo:
												//Aggiungo il campo alla CTentry (i controlli sono effettuati all'interno del metodo)
												ctEntry.addField((fieldID!=null?fieldID.getText():null), fieldType);     
												//Aggiungo il campo alla fieldList
												fieldList.add(new FieldNode((fieldID!=null?fieldID.getText():null), fieldType));
												
											
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:113:7: ( COMMA fieldID= ID COLON fieldType= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:113:8: COMMA fieldID= ID COLON fieldType= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist229); 
									fieldID=(Token)match(input,ID,FOLLOW_ID_in_cllist235); 
									match(input,COLON,FOLLOW_COLON_in_cllist237); 
									pushFollow(FOLLOW_basic_in_cllist243);
									fieldType=basic();
									state._fsp--;


													
													    //Campi successivi al primo 
													    ctEntry.addField((fieldID!=null?fieldID.getText():null), fieldType);
													    fieldList.add(new FieldNode((fieldID!=null?fieldID.getText():null), fieldType));
													    
													
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist260); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist280); 
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:124:10: ( FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:125:8: FUN funID= ID COLON retType= basic LPAR (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )? RPAR ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )? body= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist291); 
							funID=(Token)match(input,ID,FOLLOW_ID_in_cllist297); 
							match(input,COLON,FOLLOW_COLON_in_cllist299); 
							pushFollow(FOLLOW_basic_in_cllist305);
							retType=basic();
							state._fsp--;

							 
										        //Creo un method node 
							                    MethodNode mNode = new MethodNode((funID!=null?funID.getText():null), retType);
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
										        //Lo aggiungo alla methodList
										        methodList.add(mNode);
										        
										    
							match(input,LPAR,FOLLOW_LPAR_in_cllist309); 
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:143:15: (mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:144:12: mparfID= ID COLON mparfType= type ( COMMA mparnID= ID COLON mparnType= type )*
									{
									mparfID=(Token)match(input,ID,FOLLOW_ID_in_cllist329); 
									match(input,COLON,FOLLOW_COLON_in_cllist331); 
									pushFollow(FOLLOW_type_in_cllist337);
									mparfType=type();
									state._fsp--;

									 
															
															//Aggiungo il parametro al method node
															mNode.addPar(new ParNode((mparfID!=null?mparfID.getText():null), mparfType));
															//Aggiungo il tipo alla partypes
															parTypes.add(mparfType);
															//Aggiungo alla symbol table del metodo la relativa entry
															methodSymTable.put((mparfID!=null?mparfID.getText():null), new STentry(nestingLevel, mparfType, parOffset++));
															// qui non controllo che il parametro esista già, perchè è il primo
															
													    
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:154:11: ( COMMA mparnID= ID COLON mparnType= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:154:12: COMMA mparnID= ID COLON mparnType= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist342); 
											mparnID=(Token)match(input,ID,FOLLOW_ID_in_cllist348); 
											match(input,COLON,FOLLOW_COLON_in_cllist350); 
											pushFollow(FOLLOW_type_in_cllist356);
											mparnType=type();
											state._fsp--;


															        
															        //parametri successivi al primo; li aggiungo e controllo che non siano già stati dichiarati
															        mNode.addPar(new ParNode((mparnID!=null?mparnID.getText():null), mparnType));
															        //Aggiungo il tipo alla partypes
											                        parTypes.add(mparnType);
											                        
											                        //Occorre creare anche qui una STEntry???
											                        //Aggiungo alla symbol table del metodo la relativa entry
											                        methodSymTable.put((mparnID!=null?mparnID.getText():null), new STentry(nestingLevel, mparnType, parOffset++));
											                        
															        if (methodSymTable.put((mparnID!=null?mparnID.getText():null), new STentry(nestingLevel, mparnType, parOffset++)) != null) {
															            System.out.println("PAR id "+(mparnID!=null?mparnID.getText():null)+" at line "+(mparnID!=null?mparnID.getLine():0)+" already declared");
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

							match(input,RPAR,FOLLOW_RPAR_in_cllist377); 
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:171:13: ( LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:172:9: LET ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist389); 
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:172:13: ( VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:173:13: VAR varID= ID COLON varType= basic ASS varExp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist406); 
											varID=(Token)match(input,ID,FOLLOW_ID_in_cllist412); 
											match(input,COLON,FOLLOW_COLON_in_cllist414); 
											pushFollow(FOLLOW_basic_in_cllist420);
											varType=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist422); 
											pushFollow(FOLLOW_exp_in_cllist428);
											varExp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist430); 

																		//Aggiungo la variabile al metodo
																		mNode.addVar(new VarNode((varID!=null?varID.getText():null), varType, varExp));
																		
																		//Controllo che la variabile non sia già stata dichiarata
																		if (methodSymTable.put((varID!=null?varID.getText():null), new STentry(nestingLevel, varType, offset--)) != null) {
																			System.out.println("VAR id "+(varID!=null?varID.getText():null)+" at line "+(varID!=null?varID.getLine():0)+" already declared");
																			System.exit(0);
																		}
																	
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist443); 
									}
									break;

							}


											    //Lo aggiungo alla alla virtual table
							                    ctEntry.addMethod((funID!=null?funID.getText():null), mNode);
							                    //Aggiungo il tipo della symbol table
							                    mNode.addSymType(new ArrowTypeNode(parTypes, retType));
							                    
											
							pushFollow(FOLLOW_exp_in_cllist463);
							body=exp();
							state._fsp--;


												//Aggiungo il corpo
												mNode.addBody(body);
																	
										    
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist467); 

										        //Rimuovo la symbol table del metodo poichè non mi serve in più (la dichiarazione è finita)
							                    symTable.remove(nestingLevel--);
										    
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist481); 

								    //Rimuovo la symbol table della Classe perch� non mi serve più (la dichiarazione è finita)
					                symTable.remove(nestingLevel--);
								
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:208:1: declist returns [ArrayList<Node> astlist] : ( ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token varID=null;
		Token funID=null;
		Token parfID=null;
		Token parnID=null;
		Node varType =null;
		Node varExp =null;
		Node funType =null;
		Node parfType =null;
		Node parnType =null;
		ArrayList<Node> d =null;
		Node e =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:208:43: ( ( ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:208:45: ( ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{

					    //Lista delle cose dichiarate  
					    astlist = new ArrayList<Node>() ;
					    
					    // Global AR -> RetAddr (RA) at -1
					    // Layout AR -> AccLink (AL) at 0 && RA at -1
					    int offset=-2; 
				    
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:215:8: ( ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:216:10: ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:216:10: ( VAR varID= ID COLON varType= type ASS varExp= exp | FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:218:8: VAR varID= ID COLON varType= type ASS varExp= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist552); 
							varID=(Token)match(input,ID,FOLLOW_ID_in_declist558); 
							match(input,COLON,FOLLOW_COLON_in_declist560); 
							pushFollow(FOLLOW_type_in_declist566);
							varType=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist568); 
							pushFollow(FOLLOW_exp_in_declist574);
							varExp=exp();
							state._fsp--;


										    
										        //Dichiara e Aggiungo una varibile alle lista delle dichiarazioni
										        astlist.add(new VarNode((varID!=null?varID.getText():null), varType, varExp));
										        //Controllo che non sia già dichiarata
										        HashMap<String,STentry> hm = symTable.get(nestingLevel);
										        
										        if (hm.put((varID!=null?varID.getText():null), new STentry(nestingLevel, varType, offset--)) != null) {
													System.out.println("Var id "+(varID!=null?varID.getText():null)+" at line "+(varID!=null?varID.getLine():0)+" already declared");
													System.exit(0);
										        }
										    
							}
							break;
						case 2 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:231:8: FUN funID= ID COLON funType= type LPAR (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist596); 
							funID=(Token)match(input,ID,FOLLOW_ID_in_declist614); 
							match(input,COLON,FOLLOW_COLON_in_declist616); 
							pushFollow(FOLLOW_type_in_declist622);
							funType=type();
							state._fsp--;


										    
													//Dichiaro una funzione - inserimento di ID nella symtable 
													FunNode f = new FunNode((funID!=null?funID.getText():null), funType);
													// QUI LO AGGIUNGE ALLA LISTA DI COSE DICHIARATE 
													astlist.add(f);
													//Prendo la symbol table attuale
													HashMap<String,STentry> hm = symTable.get(nestingLevel);
													//Creo una nuova entry
													STentry entry = new STentry(nestingLevel,offset--); //separo introducendo "entry"
													
													offset = -2; // ???
													
													//Controllo che non sia già dichiarata una funzione con lo stesso nome 
													if (hm.put((funID!=null?funID.getText():null),entry) != null){ 
														System.out.println("Fun id "+(funID!=null?funID.getText():null)+" at line "+(funID!=null?funID.getLine():0)+" already declared");
														System.exit(0);
													}
													
													//creare una nuova hashmap per la symTable relativa alla funzione appena dichiarata
													nestingLevel++;
													HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
													symTable.add(hmn);
													
													//Lista di parametri della funzione
							                        ArrayList<Node> parTypes = new ArrayList<Node>();
							                        int paroffset = 1;
													
												
							match(input,LPAR,FOLLOW_LPAR_in_declist626); 
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:260:13: (parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:261:10: parfID= ID COLON parfType= type ( COMMA parnID= ID COLON parnType= type )*
									{
									parfID=(Token)match(input,ID,FOLLOW_ID_in_declist643); 
									match(input,COLON,FOLLOW_COLON_in_declist645); 
									pushFollow(FOLLOW_type_in_declist651);
									parfType=type();
									state._fsp--;

									 
														
																//Aggiungo il primo parametro
																parTypes.add(parfType); 
																f.addPar(new ParNode((parfID!=null?parfID.getText():null),parfType));
																
																f.addSymType(parfType);
																
																// Occorre controllare che il tipo della funzione sia ArrowTypeNode 
									                            // poichè il tal caso devo riservare 2 spazi!
																paroffset = parfType instanceof ArrowTypeNode ? paroffset++ : paroffset;
																if (hmn.put((parfID!=null?parfID.getText():null), new STentry(nestingLevel, parfType, paroffset++)) != null){
																    System.out.println("Parameter id "+(parfID!=null?parfID.getText():null)+" at line "+(parfID!=null?parfID.getLine():0)+" already declared");
																    System.exit(0);
																}
																
															
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:277:9: ( COMMA parnID= ID COLON parnType= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:277:10: COMMA parnID= ID COLON parnType= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist656); 
											parnID=(Token)match(input,ID,FOLLOW_ID_in_declist662); 
											match(input,COLON,FOLLOW_COLON_in_declist664); 
											pushFollow(FOLLOW_type_in_declist670);
											parnType=type();
											state._fsp--;


																	
																		//Aggiungo il primo parametro
											                            parTypes.add(parnType);
											                            f.addPar(new ParNode((parnID!=null?parnID.getText():null), parnType));
											                            
											                            f.addSymType(parnType); // Perchè non lo mettiamo ???
											                            
											                            // Occorre controllare che il tipo della funzione sia ArrowTypeNode 
											                            // poichè il tal caso devo riservare 2 spazi!
											                            paroffset = parnType instanceof ArrowTypeNode ? paroffset++ : paroffset;
											                            if (hmn.put((parnID!=null?parnID.getText():null), new STentry(nestingLevel, parnType, paroffset++)) != null){
											                                System.out.println("Parameter id "+(parnID!=null?parnID.getText():null)+" at line "+(parnID!=null?parnID.getLine():0)+" already declared");
											                                System.exit(0);
											                            }
																		
																	
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist693); 

												
													entry.addType(new ArrowTypeNode(parTypes, funType));
													f.addSymType(new ArrowTypeNode(parTypes, funType));
													
												
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:300:8: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:300:9: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist698); 
									pushFollow(FOLLOW_declist_in_declist704);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist706); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist714);
							e=exp();
							state._fsp--;


													//chiudere scope
													symTable.remove(nestingLevel--);
													f.addDecBody(d, e);
													
											    
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist727); 
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:310:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node b =null;
		Node a =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:310:25: (b= basic |a= arrow )
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:311:9: b= basic
					{
					pushFollow(FOLLOW_basic_in_type768);
					b=basic();
					state._fsp--;


					            ast = b;
					        
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:313:13: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type778);
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:318:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:318:26: ( INT | BOOL |i= ID )
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:319:9: INT
					{
					match(input,INT,FOLLOW_INT_in_basic810); 

					            ast = new IntTypeNode();
					        
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:323:9: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic833); 

					            ast = new BoolTypeNode();
					        
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:327:9: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic860); 

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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:332:1: arrow returns [Node ast] : LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node ty =null;
		Node r =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:332:26: ( LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:333:9: LPAR (t= type ( COMMA ty= type )* )? RPAR ARROW r= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow891); 

			            ArrayList<Node> typeList = new ArrayList<>(); 
			        
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:335:11: (t= type ( COMMA ty= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:335:12: t= type ( COMMA ty= type )*
					{
					pushFollow(FOLLOW_type_in_arrow900);
					t=type();
					state._fsp--;

					 
					            //aggiungo il primo
					            typeList.add(t);
					        
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:338:11: ( COMMA ty= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:338:13: COMMA ty= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow906); 
							pushFollow(FOLLOW_type_in_arrow912);
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

			match(input,RPAR,FOLLOW_RPAR_in_arrow922); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow924); 
			pushFollow(FOLLOW_basic_in_arrow930);
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:346:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:346:24: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:347:9: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp971);
			f=term();
			state._fsp--;


			            ast = f;    
			        
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:349:11: ( PLUS l= term | MINUS l= term | OR l= term )*
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:351:10: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp995); 
					pushFollow(FOLLOW_term_in_exp1001);
					l=term();
					state._fsp--;


						            ast = new PlusNode (ast,l);
						        
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:355:10: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1027); 
					pushFollow(FOLLOW_term_in_exp1033);
					l=term();
					state._fsp--;


						            ast = new MinusNode (ast,l);
						        
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:359:10: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1058); 
					pushFollow(FOLLOW_term_in_exp1064);
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:365:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:365:26: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:366:9: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1107);
			f=factor();
			state._fsp--;


			            ast = f;
			        
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:368:11: ( TIMES l= factor | DIV l= factor | AND l= factor )*
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:370:10: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1131); 
					pushFollow(FOLLOW_factor_in_term1137);
					l=factor();
					state._fsp--;


						            ast = new MultNode (ast,l);
						        
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:374:10: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1162); 
					pushFollow(FOLLOW_factor_in_term1168);
					l=factor();
					state._fsp--;


						            ast = new DivNode (ast,l);
						        
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:378:10: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1193); 
					pushFollow(FOLLOW_factor_in_term1199);
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:384:1: factor returns [Node ast] : f= value ( EQ l= value | LE l= value | GE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:384:28: (f= value ( EQ l= value | LE l= value | GE l= value )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:385:9: f= value ( EQ l= value | LE l= value | GE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1245);
			f=value();
			state._fsp--;


			            ast = f;
			        
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:387:11: ( EQ l= value | LE l= value | GE l= value )*
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:389:13: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1272); 
					pushFollow(FOLLOW_value_in_factor1278);
					l=value();
					state._fsp--;


					                ast = new EqualNode (ast,l);
					            
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:393:13: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1309); 
					pushFollow(FOLLOW_value_in_factor1315);
					l=value();
					state._fsp--;


					                ast = new LessEqualNode (ast,l);
					            
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:397:13: GE l= value
					{
					match(input,GE,FOLLOW_GE_in_factor1346); 
					pushFollow(FOLLOW_value_in_factor1352);
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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:403:1: value returns [Node ast] : (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (newfExpr= exp ( COMMA newnExpr= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodID= ID LPAR (callfExp= exp ( COMMA callnExpr= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Token methodID=null;
		Node newfExpr =null;
		Node newnExpr =null;
		Node e =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node t =null;
		Node fa =null;
		Node a =null;
		Node callfExp =null;
		Node callnExpr =null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:403:26: (n= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (newfExpr= exp ( COMMA newnExpr= exp )* )? RPAR | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR t= term RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodID= ID LPAR (callfExp= exp ( COMMA callnExpr= exp )* )? RPAR )? )
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
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:404:9: n= INTEGER
					{
					n=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1400); 

					            ast = new IntNode(Integer.parseInt((n!=null?n.getText():null)));
					        
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:408:9: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1424); 

					            ast = new BoolNode(true);
					        
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:412:9: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1448); 

					            ast = new BoolNode(false);
					        
					}
					break;
				case 4 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:416:9: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1472); 

					            ast = new EmptyNode();
					        
					}
					break;
				case 5 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:420:9: NEW i= ID LPAR (newfExpr= exp ( COMMA newnExpr= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1496); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1509); 

						       
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
							    
							    
					match(input,LPAR,FOLLOW_LPAR_in_value1513); 
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:437:14: (newfExpr= exp ( COMMA newnExpr= exp )* )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==FALSE||(LA24_0 >= ID && LA24_0 <= IF)||LA24_0==INTEGER||LA24_0==LPAR||(LA24_0 >= NEW && LA24_0 <= NULL)||LA24_0==PRINT||LA24_0==TRUE) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:438:11: newfExpr= exp ( COMMA newnExpr= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1531);
							newfExpr=exp();
							state._fsp--;


									            //Aggiungo i parametri
									            fieldList.add(newfExpr);
									        
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:441:13: ( COMMA newnExpr= exp )*
							loop23:
							while (true) {
								int alt23=2;
								int LA23_0 = input.LA(1);
								if ( (LA23_0==COMMA) ) {
									alt23=1;
								}

								switch (alt23) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:441:14: COMMA newnExpr= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1536); 
									pushFollow(FOLLOW_exp_in_value1542);
									newnExpr=exp();
									state._fsp--;


											            //Aggiungo i parametri
											            fieldList.add(newnExpr);
											        
									}
									break;

								default :
									break loop23;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_value1558); 
					}
					break;
				case 6 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:447:3: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1567); 
					pushFollow(FOLLOW_exp_in_value1573);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1575); 

							    ast = e;
							
					}
					break;
				case 7 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:451:3: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1587); 
					pushFollow(FOLLOW_exp_in_value1593);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value1595); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1597); 
					pushFollow(FOLLOW_exp_in_value1603);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1605); 
					match(input,ELSE,FOLLOW_ELSE_in_value1607); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1609); 
					pushFollow(FOLLOW_exp_in_value1615);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1617); 

							    ast = new IfNode(x,y,z);
							
					}
					break;
				case 8 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:455:3: NOT LPAR t= term RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1630); 
					match(input,LPAR,FOLLOW_LPAR_in_value1632); 
					pushFollow(FOLLOW_term_in_value1638);
					t=term();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1640); 

							    ast = new NotNode(t);
							
					}
					break;
				case 9 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:459:3: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1652); 
					match(input,LPAR,FOLLOW_LPAR_in_value1654); 
					pushFollow(FOLLOW_exp_in_value1660);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1662); 

							    ast = new PrintNode(e);
							
					}
					break;
				case 10 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:463:3: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodID= ID LPAR (callfExp= exp ( COMMA callnExpr= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1678); 

								
								//cercare la dichiarazione
							    int j = nestingLevel;
							    System.out.println("Nestinglevel " + nestingLevel);
							    STentry entry = null; 
							    
							    while (j >= 0 && entry == null) {
									entry=(symTable.get(j--)).get((i!=null?i.getText():null));
									System.out.println(entry);
							    }
							    
							    if (entry == null) {
									System.out.println("ID "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
									System.exit(0);
							    }
							                   
							    ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
							
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:481:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT methodID= ID LPAR (callfExp= exp ( COMMA callnExpr= exp )* )? RPAR )?
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
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:482:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1691); 

									        ArrayList<Node> argList = new ArrayList<Node>();
									    
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:484:8: (fa= exp ( COMMA a= exp )* )?
							int alt26=2;
							int LA26_0 = input.LA(1);
							if ( (LA26_0==FALSE||(LA26_0 >= ID && LA26_0 <= IF)||LA26_0==INTEGER||LA26_0==LPAR||(LA26_0 >= NEW && LA26_0 <= NULL)||LA26_0==PRINT||LA26_0==TRUE) ) {
								alt26=1;
							}
							switch (alt26) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:485:11: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1710);
									fa=exp();
									state._fsp--;


											            argList.add(fa);
											        
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:487:12: ( COMMA a= exp )*
									loop25:
									while (true) {
										int alt25=2;
										int LA25_0 = input.LA(1);
										if ( (LA25_0==COMMA) ) {
											alt25=1;
										}

										switch (alt25) {
										case 1 :
											// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:487:13: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1714); 
											pushFollow(FOLLOW_exp_in_value1720);
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

							match(input,RPAR,FOLLOW_RPAR_in_value1743); 

									        ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
									    
							}
							break;
						case 2 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:495:7: DOT methodID= ID LPAR (callfExp= exp ( COMMA callnExpr= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1759); 
							methodID=(Token)match(input,ID,FOLLOW_ID_in_value1765); 

									    
									        CTentry classCTEntry = classTable.get((methodID!=null?methodID.getText():null));
									        ArrayList<Node> methodParlist = new ArrayList<>();
									        
									        if(classCTEntry == null){
												System.out.println("Class id "+ (i!=null?i.getText():null) +" at line "+(i!=null?i.getLine():0)+" not declared");
												System.exit(0);
									        }
									        
									        //Prendo dalla ctentry la virtual table da cui poi risalgo al metodo
									        STentry methodSTEntry = classCTEntry.getVTable().get((methodID!=null?methodID.getText():null));
									        
									        STentry classSTEntry = symTable.get(0).get((i!=null?i.getText():null));
									        
									        //Controllo che il metodo esista 
									        if(methodSTEntry == null) {
												System.out.println("Method id "+(methodID!=null?methodID.getText():null)+" at line "+(methodID!=null?methodID.getLine():0)+" not declared");
												System.exit(0); 
									        }
									             
									    
							match(input,LPAR,FOLLOW_LPAR_in_value1769); 
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:516:14: (callfExp= exp ( COMMA callnExpr= exp )* )?
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( (LA28_0==FALSE||(LA28_0 >= ID && LA28_0 <= IF)||LA28_0==INTEGER||LA28_0==LPAR||(LA28_0 >= NEW && LA28_0 <= NULL)||LA28_0==PRINT||LA28_0==TRUE) ) {
								alt28=1;
							}
							switch (alt28) {
								case 1 :
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:517:11: callfExp= exp ( COMMA callnExpr= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1787);
									callfExp=exp();
									state._fsp--;


											            //Aggiungo il primo parametro
											            methodParlist.add(callfExp);
											        
									// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:520:13: ( COMMA callnExpr= exp )*
									loop27:
									while (true) {
										int alt27=2;
										int LA27_0 = input.LA(1);
										if ( (LA27_0==COMMA) ) {
											alt27=1;
										}

										switch (alt27) {
										case 1 :
											// D:\\Xander_C\\Documents\\Projects\\FoolProject\\FOOL.g:520:14: COMMA callnExpr= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1792); 
											pushFollow(FOLLOW_exp_in_value1798);
											callnExpr=exp();
											state._fsp--;


													            //Aggiungo i parametri successivi
													            methodParlist.add(callnExpr);
													        
											}
											break;

										default :
											break loop27;
										}
									}

									}
									break;

							}

							 
									        ast = new ClassCallNode((i!=null?i.getText():null), (methodID!=null?methodID.getText():null), classSTEntry, methodSTEntry, methodParlist, nestingLevel); 
									    
							match(input,RPAR,FOLLOW_RPAR_in_value1816); 
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



	public static final BitSet FOLLOW_exp_in_prog42 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog62 = new BitSet(new long[]{0x0000080000200100L});
	public static final BitSet FOLLOW_cllist_in_prog79 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_prog83 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_prog91 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_prog95 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist133 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist153 = new BitSet(new long[]{0x0000000040080000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist170 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist187 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist200 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist216 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist218 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist224 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist229 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist235 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist237 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist243 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist260 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist280 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_FUN_in_cllist291 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist297 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist299 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist305 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist309 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist329 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist331 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist337 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist342 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist348 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist350 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_cllist356 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist377 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_cllist389 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_VAR_in_cllist406 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist412 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist414 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist420 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist422 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist428 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist430 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_IN_in_cllist443 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_cllist463 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist467 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist481 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist552 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist558 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist560 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist566 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist568 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist574 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist596 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist614 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist616 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist622 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist626 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_declist643 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist645 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist651 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist656 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist662 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist664 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_declist670 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist693 = new BitSet(new long[]{0x0000042769900000L});
	public static final BitSet FOLLOW_LET_in_declist698 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_declist704 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_declist706 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_declist714 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist727 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_basic_in_type768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow891 = new BitSet(new long[]{0x0000004044800080L});
	public static final BitSet FOLLOW_type_in_arrow900 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow906 = new BitSet(new long[]{0x0000000044800080L});
	public static final BitSet FOLLOW_type_in_arrow912 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow922 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow924 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_arrow930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp971 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_PLUS_in_exp995 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1001 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1027 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1033 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_OR_in_exp1058 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_exp1064 = new BitSet(new long[]{0x0000001880000002L});
	public static final BitSet FOLLOW_factor_in_term1107 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_TIMES_in_term1131 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1137 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_DIV_in_term1162 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1168 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_AND_in_term1193 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_factor_in_term1199 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_value_in_factor1245 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_EQ_in_factor1272 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1278 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_LE_in_factor1309 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1315 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_GE_in_factor1346 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_value_in_factor1352 = new BitSet(new long[]{0x0000000010420002L});
	public static final BitSet FOLLOW_INTEGER_in_value1400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1496 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1509 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1513 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1531 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1536 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1542 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1567 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1573 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1587 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1593 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1595 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1597 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1603 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1605 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_value1607 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1609 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1615 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value1617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1630 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1632 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_term_in_value1638 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1652 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1654 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1660 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1678 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_LPAR_in_value1691 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1710 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1714 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1720 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1759 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1765 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1769 = new BitSet(new long[]{0x0000046749900000L});
	public static final BitSet FOLLOW_exp_in_value1787 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1792 = new BitSet(new long[]{0x0000042749900000L});
	public static final BitSet FOLLOW_exp_in_value1798 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1816 = new BitSet(new long[]{0x0000000000000002L});
}
