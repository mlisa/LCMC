// $ANTLR 3.5.2 D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g 2017-03-01 07:58:11

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "AND", "BRANCH", "BRANCHEQ", 
		"BRANCHGEQ", "BRANCHLESSEQ", "COL", "COPYFP", "DIV", "ERR", "HALT", "JS", 
		"LABEL", "LOADFP", "LOADHP", "LOADRA", "LOADRV", "LOADW", "MULT", "NOT", 
		"NUMBER", "OR", "POP", "PRINT", "PUSH", "STOREFP", "STOREHP", "STORERA", 
		"STORERV", "STOREW", "SUB", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int AND=5;
	public static final int BRANCH=6;
	public static final int BRANCHEQ=7;
	public static final int BRANCHGEQ=8;
	public static final int BRANCHLESSEQ=9;
	public static final int COL=10;
	public static final int COPYFP=11;
	public static final int DIV=12;
	public static final int ERR=13;
	public static final int HALT=14;
	public static final int JS=15;
	public static final int LABEL=16;
	public static final int LOADFP=17;
	public static final int LOADHP=18;
	public static final int LOADRA=19;
	public static final int LOADRV=20;
	public static final int LOADW=21;
	public static final int MULT=22;
	public static final int NOT=23;
	public static final int NUMBER=24;
	public static final int OR=25;
	public static final int POP=26;
	public static final int PRINT=27;
	public static final int PUSH=28;
	public static final int STOREFP=29;
	public static final int STOREHP=30;
	public static final int STORERA=31;
	public static final int STORERV=32;
	public static final int STOREW=33;
	public static final int SUB=34;
	public static final int WHITESP=35;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SVMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SVMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g"; }


	      
	    int[] code = new int[ExecuteVM.CODESIZE];    
	    private int i = 0;
	    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
	        



	// $ANTLR start "assembly"
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:24:1: assembly : ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | BRANCHGEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token n=null;
		Token l=null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:24:9: ( ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | BRANCHGEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:5: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | BRANCHGEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:5: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | BRANCHGEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=30;
				switch ( input.LA(1) ) {
				case PUSH:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==NUMBER) ) {
						alt1=1;
					}
					else if ( (LA1_2==LABEL) ) {
						alt1=2;
					}

					}
					break;
				case POP:
					{
					alt1=3;
					}
					break;
				case ADD:
					{
					alt1=4;
					}
					break;
				case SUB:
					{
					alt1=5;
					}
					break;
				case MULT:
					{
					alt1=6;
					}
					break;
				case DIV:
					{
					alt1=7;
					}
					break;
				case AND:
					{
					alt1=8;
					}
					break;
				case OR:
					{
					alt1=9;
					}
					break;
				case NOT:
					{
					alt1=10;
					}
					break;
				case STOREW:
					{
					alt1=11;
					}
					break;
				case LOADW:
					{
					alt1=12;
					}
					break;
				case LABEL:
					{
					alt1=13;
					}
					break;
				case BRANCH:
					{
					alt1=14;
					}
					break;
				case BRANCHEQ:
					{
					alt1=15;
					}
					break;
				case BRANCHLESSEQ:
					{
					alt1=16;
					}
					break;
				case BRANCHGEQ:
					{
					alt1=17;
					}
					break;
				case JS:
					{
					alt1=18;
					}
					break;
				case LOADRA:
					{
					alt1=19;
					}
					break;
				case STORERA:
					{
					alt1=20;
					}
					break;
				case LOADRV:
					{
					alt1=21;
					}
					break;
				case STORERV:
					{
					alt1=22;
					}
					break;
				case LOADFP:
					{
					alt1=23;
					}
					break;
				case STOREFP:
					{
					alt1=24;
					}
					break;
				case COPYFP:
					{
					alt1=25;
					}
					break;
				case LOADHP:
					{
					alt1=26;
					}
					break;
				case STOREHP:
					{
					alt1=27;
					}
					break;
				case PRINT:
					{
					alt1=28;
					}
					break;
				case HALT:
					{
					alt1=29;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:7: PUSH n= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly42); 
					n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly46); 
					code[i++] = PUSH; 
								                 code[i++] = Integer.parseInt((n!=null?n.getText():null));
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:27:6: PUSH l= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly57); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly61); 
					code[i++] = PUSH; //
						    		             labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:29:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly81); 
					code[i++] = POP;
					}
					break;
				case 4 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:30:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly96); 
					code[i++] = ADD;
					}
					break;
				case 5 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:31:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly110); 
					code[i++] = SUB;
					}
					break;
				case 6 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:32:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly124); 
					code[i++] = MULT;
					}
					break;
				case 7 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:33:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly137); 
					code[i++] = DIV;
					}
					break;
				case 8 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:34:7: AND
					{
					match(input,AND,FOLLOW_AND_in_assembly152); 
					code[i++] = AND;
					}
					break;
				case 9 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:35:7: OR
					{
					match(input,OR,FOLLOW_OR_in_assembly168); 
					code[i++] = OR;
					}
					break;
				case 10 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:36:7: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_assembly184); 
					code[i++] = NOT;
					}
					break;
				case 11 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:37:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly199); 
					code[i++] = STOREW;
					}
					break;
				case 12 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:38:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly211); 
					code[i++] = LOADW;
					}
					break;
				case 13 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:39:6: l= LABEL COL
					{
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly233); 
					match(input,COL,FOLLOW_COL_in_assembly235); 
					labelAdd.put((l!=null?l.getText():null),i);
					}
					break;
				case 14 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:40:6: BRANCH l= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly248); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly252); 
					code[i++] = BRANCH;
					                       labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 15 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:42:6: BRANCHEQ l= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly262); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly266); 
					code[i++] = BRANCHEQ; //
					                        labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 16 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:44:6: BRANCHLESSEQ l= LABEL
					{
					match(input,BRANCHLESSEQ,FOLLOW_BRANCHLESSEQ_in_assembly275); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly279); 
					code[i++] = BRANCHLESSEQ;
					                          labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 17 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:46:7: BRANCHGEQ l= LABEL
					{
					match(input,BRANCHGEQ,FOLLOW_BRANCHGEQ_in_assembly289); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly293); 
					code[i++] = BRANCHGEQ;
					                      labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 18 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:48:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly302); 
					code[i++] = JS;
					}
					break;
				case 19 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:49:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly331); 
					code[i++] = LOADRA;
					}
					break;
				case 20 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:50:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly353); 
					code[i++] = STORERA;
					}
					break;
				case 21 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:51:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly373); 
					code[i++] = LOADRV;
					}
					break;
				case 22 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:52:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly394); 
					code[i++] = STORERV;
					}
					break;
				case 23 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:53:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly415); 
					code[i++] = LOADFP;
					}
					break;
				case 24 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:54:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly436); 
					code[i++] = STOREFP;
					}
					break;
				case 25 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:55:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly456); 
					code[i++] = COPYFP;
					}
					break;
				case 26 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:56:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly477); 
					code[i++] = LOADHP;
					}
					break;
				case 27 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:57:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly498); 
					code[i++] = STOREHP;
					}
					break;
				case 28 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:58:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly518); 
					code[i++] = PRINT;
					}
					break;
				case 29 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:59:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly537); 
					code[i++] = HALT;
					}
					break;

				default :
					break loop1;
				}
			}

			 for (Integer refAdd: labelRef.keySet()) {
				              code[refAdd]=labelAdd.get(labelRef.get(refAdd));
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
	}
	// $ANTLR end "assembly"

	// Delegated rules



	public static final BitSet FOLLOW_PUSH_in_assembly42 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_NUMBER_in_assembly46 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_PUSH_in_assembly57 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly61 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_POP_in_assembly81 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_ADD_in_assembly96 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_SUB_in_assembly110 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_MULT_in_assembly124 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_DIV_in_assembly137 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_AND_in_assembly152 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_OR_in_assembly168 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_NOT_in_assembly184 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_STOREW_in_assembly199 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LOADW_in_assembly211 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LABEL_in_assembly233 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_assembly235 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_BRANCH_in_assembly248 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly252 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly262 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly266 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_BRANCHLESSEQ_in_assembly275 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly279 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_BRANCHGEQ_in_assembly289 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly293 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_JS_in_assembly302 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LOADRA_in_assembly331 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_STORERA_in_assembly353 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LOADRV_in_assembly373 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_STORERV_in_assembly394 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LOADFP_in_assembly415 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_STOREFP_in_assembly436 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_COPYFP_in_assembly456 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_LOADHP_in_assembly477 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_STOREHP_in_assembly498 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_PRINT_in_assembly518 = new BitSet(new long[]{0x00000007FEFFDBF2L});
	public static final BitSet FOLLOW_HALT_in_assembly537 = new BitSet(new long[]{0x00000007FEFFDBF2L});
}
