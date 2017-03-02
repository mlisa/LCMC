// $ANTLR 3.5.2 D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g 2017-03-02 11:57:33

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
	// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:24:1: assembly : ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token n=null;
		Token l=null;

		try {
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:24:9: ( ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:5: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:5: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESSEQ l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=26;
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
				case STOREW:
					{
					alt1=8;
					}
					break;
				case LOADW:
					{
					alt1=9;
					}
					break;
				case LABEL:
					{
					alt1=10;
					}
					break;
				case BRANCH:
					{
					alt1=11;
					}
					break;
				case BRANCHEQ:
					{
					alt1=12;
					}
					break;
				case BRANCHLESSEQ:
					{
					alt1=13;
					}
					break;
				case JS:
					{
					alt1=14;
					}
					break;
				case LOADRA:
					{
					alt1=15;
					}
					break;
				case STORERA:
					{
					alt1=16;
					}
					break;
				case LOADRV:
					{
					alt1=17;
					}
					break;
				case STORERV:
					{
					alt1=18;
					}
					break;
				case LOADFP:
					{
					alt1=19;
					}
					break;
				case STOREFP:
					{
					alt1=20;
					}
					break;
				case COPYFP:
					{
					alt1=21;
					}
					break;
				case LOADHP:
					{
					alt1=22;
					}
					break;
				case STOREHP:
					{
					alt1=23;
					}
					break;
				case PRINT:
					{
					alt1=24;
					}
					break;
				case HALT:
					{
					alt1=25;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:25:7: PUSH n= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly42); 
					n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly48); 

					                code[i++] = PUSH; 
					                code[i++] = Integer.parseInt((n!=null?n.getText():null));
					            
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:29:6: PUSH l= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly59); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly65); 

						            code[i++] = PUSH; //
						            labelRef.put(i++,(l!=null?l.getText():null));
					            
					}
					break;
				case 3 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:33:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly85); 
					code[i++] = POP;
					}
					break;
				case 4 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:34:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly100); 
					code[i++] = ADD;
					}
					break;
				case 5 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:35:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly114); 
					code[i++] = SUB;
					}
					break;
				case 6 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:36:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly128); 
					code[i++] = MULT;
					}
					break;
				case 7 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:37:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly141); 
					code[i++] = DIV;
					}
					break;
				case 8 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:38:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly155); 
					code[i++] = STOREW;
					}
					break;
				case 9 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:39:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly167); 
					code[i++] = LOADW;
					}
					break;
				case 10 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:40:6: l= LABEL COL
					{
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly189); 
					match(input,COL,FOLLOW_COL_in_assembly191); 
					labelAdd.put((l!=null?l.getText():null),i);
					}
					break;
				case 11 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:41:6: BRANCH l= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly204); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly208); 

						            code[i++] = BRANCH;
						            labelRef.put(i++, (l!=null?l.getText():null));
						        
					}
					break;
				case 12 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:45:6: BRANCHEQ l= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly218); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly222); 

						            code[i++] = BRANCHEQ; //
					                labelRef.put(i++, (l!=null?l.getText():null));
					            
					}
					break;
				case 13 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:49:6: BRANCHLESSEQ l= LABEL
					{
					match(input,BRANCHLESSEQ,FOLLOW_BRANCHLESSEQ_in_assembly231); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly235); 

						            code[i++] = BRANCHLESSEQ;
					                labelRef.put(i++, (l!=null?l.getText():null));
					            
					}
					break;
				case 14 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:53:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly244); 
					code[i++] = JS;
					}
					break;
				case 15 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:54:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly273); 
					code[i++] = LOADRA;
					}
					break;
				case 16 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:55:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly295); 
					code[i++] = STORERA;
					}
					break;
				case 17 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:56:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly315); 
					code[i++] = LOADRV;
					}
					break;
				case 18 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:57:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly336); 
					code[i++] = STORERV;
					}
					break;
				case 19 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:58:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly357); 
					code[i++] = LOADFP;
					}
					break;
				case 20 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:59:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly378); 
					code[i++] = STOREFP;
					}
					break;
				case 21 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:60:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly398); 
					code[i++] = COPYFP;
					}
					break;
				case 22 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:61:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly419); 
					code[i++] = LOADHP;
					}
					break;
				case 23 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:62:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly440); 
					code[i++] = STOREHP;
					}
					break;
				case 24 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:63:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly460); 
					code[i++] = PRINT;
					}
					break;
				case 25 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:64:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly479); 
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
	public static final BitSet FOLLOW_NUMBER_in_assembly48 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_PUSH_in_assembly59 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly65 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_POP_in_assembly85 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_ADD_in_assembly100 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_SUB_in_assembly114 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_MULT_in_assembly128 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_DIV_in_assembly141 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_STOREW_in_assembly155 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LOADW_in_assembly167 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LABEL_in_assembly189 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_assembly191 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_BRANCH_in_assembly204 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly208 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly218 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly222 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_BRANCHLESSEQ_in_assembly231 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LABEL_in_assembly235 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_JS_in_assembly244 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LOADRA_in_assembly273 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_STORERA_in_assembly295 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LOADRV_in_assembly315 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_STORERV_in_assembly336 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LOADFP_in_assembly357 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_STOREFP_in_assembly378 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_COPYFP_in_assembly398 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_LOADHP_in_assembly419 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_STOREHP_in_assembly440 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_PRINT_in_assembly460 = new BitSet(new long[]{0x00000007FC7FDAD2L});
	public static final BitSet FOLLOW_HALT_in_assembly479 = new BitSet(new long[]{0x00000007FC7FDAD2L});
}
