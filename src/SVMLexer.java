// $ANTLR 3.5.2 D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g 2017-03-01 07:58:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMLexer extends Lexer {
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

	int lexicalErrors=0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SVMLexer() {} 
	public SVMLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g"; }

	// $ANTLR start "PUSH"
	public final void mPUSH() throws RecognitionException {
		try {
			int _type = PUSH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:69:9: ( 'push' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:69:11: 'push'
			{
			match("push"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUSH"

	// $ANTLR start "POP"
	public final void mPOP() throws RecognitionException {
		try {
			int _type = POP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:70:6: ( 'pop' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:70:8: 'pop'
			{
			match("pop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POP"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:71:6: ( 'add' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:71:8: 'add'
			{
			match("add"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:72:6: ( 'sub' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:72:8: 'sub'
			{
			match("sub"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:73:7: ( 'mult' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:73:9: 'mult'
			{
			match("mult"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:74:6: ( 'div' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:74:8: 'div'
			{
			match("div"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:75:6: ( 'and' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:75:8: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:76:5: ( 'or' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:76:7: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:77:6: ( 'not' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:77:8: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "STOREW"
	public final void mSTOREW() throws RecognitionException {
		try {
			int _type = STOREW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:78:9: ( 'sw' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:78:11: 'sw'
			{
			match("sw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREW"

	// $ANTLR start "LOADW"
	public final void mLOADW() throws RecognitionException {
		try {
			int _type = LOADW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:79:8: ( 'lw' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:79:10: 'lw'
			{
			match("lw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADW"

	// $ANTLR start "BRANCH"
	public final void mBRANCH() throws RecognitionException {
		try {
			int _type = BRANCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:80:9: ( 'b' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:80:11: 'b'
			{
			match('b'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCH"

	// $ANTLR start "BRANCHEQ"
	public final void mBRANCHEQ() throws RecognitionException {
		try {
			int _type = BRANCHEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:81:10: ( 'beq' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:81:12: 'beq'
			{
			match("beq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHEQ"

	// $ANTLR start "BRANCHLESSEQ"
	public final void mBRANCHLESSEQ() throws RecognitionException {
		try {
			int _type = BRANCHLESSEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:82:13: ( 'bleq' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:82:14: 'bleq'
			{
			match("bleq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHLESSEQ"

	// $ANTLR start "BRANCHGEQ"
	public final void mBRANCHGEQ() throws RecognitionException {
		try {
			int _type = BRANCHGEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:83:10: ( 'bgeq' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:83:11: 'bgeq'
			{
			match("bgeq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHGEQ"

	// $ANTLR start "JS"
	public final void mJS() throws RecognitionException {
		try {
			int _type = JS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:84:5: ( 'js' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:84:7: 'js'
			{
			match("js"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JS"

	// $ANTLR start "LOADRA"
	public final void mLOADRA() throws RecognitionException {
		try {
			int _type = LOADRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:85:9: ( 'lra' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:85:11: 'lra'
			{
			match("lra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRA"

	// $ANTLR start "STORERA"
	public final void mSTORERA() throws RecognitionException {
		try {
			int _type = STORERA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:86:10: ( 'sra' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:86:12: 'sra'
			{
			match("sra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERA"

	// $ANTLR start "LOADRV"
	public final void mLOADRV() throws RecognitionException {
		try {
			int _type = LOADRV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:87:9: ( 'lrv' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:87:11: 'lrv'
			{
			match("lrv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRV"

	// $ANTLR start "STORERV"
	public final void mSTORERV() throws RecognitionException {
		try {
			int _type = STORERV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:88:10: ( 'srv' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:88:12: 'srv'
			{
			match("srv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERV"

	// $ANTLR start "LOADFP"
	public final void mLOADFP() throws RecognitionException {
		try {
			int _type = LOADFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:89:9: ( 'lfp' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:89:11: 'lfp'
			{
			match("lfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADFP"

	// $ANTLR start "STOREFP"
	public final void mSTOREFP() throws RecognitionException {
		try {
			int _type = STOREFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:90:10: ( 'sfp' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:90:12: 'sfp'
			{
			match("sfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREFP"

	// $ANTLR start "COPYFP"
	public final void mCOPYFP() throws RecognitionException {
		try {
			int _type = COPYFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:91:10: ( 'cfp' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:91:12: 'cfp'
			{
			match("cfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COPYFP"

	// $ANTLR start "LOADHP"
	public final void mLOADHP() throws RecognitionException {
		try {
			int _type = LOADHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:92:9: ( 'lhp' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:92:11: 'lhp'
			{
			match("lhp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADHP"

	// $ANTLR start "STOREHP"
	public final void mSTOREHP() throws RecognitionException {
		try {
			int _type = STOREHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:93:10: ( 'shp' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:93:12: 'shp'
			{
			match("shp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREHP"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:94:8: ( 'print' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:94:10: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "HALT"
	public final void mHALT() throws RecognitionException {
		try {
			int _type = HALT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:95:7: ( 'halt' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:95:9: 'halt'
			{
			match("halt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HALT"

	// $ANTLR start "COL"
	public final void mCOL() throws RecognitionException {
		try {
			int _type = COL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:97:6: ( ':' )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:97:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COL"

	// $ANTLR start "LABEL"
	public final void mLABEL() throws RecognitionException {
		try {
			int _type = LABEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:98:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:98:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:98:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LABEL"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:9: ( '0' | ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='0') ) {
				alt4=1;
			}
			else if ( (LA4_0=='-'||(LA4_0 >= '1' && LA4_0 <= '9')) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:11: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:17: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:17: ( '-' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='-') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:18: '-'
							{
							match('-'); 
							}
							break;

					}

					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:23: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:24: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:99:34: ( '0' .. '9' )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop3;
						}
					}

					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:101:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:101:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:101:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESP"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:103:9: ( . )
			// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:103:11: .
			{
			matchAny(); 
			 System.err.println("Invalid char: "+getText()); lexicalErrors++; _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERR"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:8: ( PUSH | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESSEQ | BRANCHGEQ | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | ERR )
		int alt6=32;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:10: PUSH
				{
				mPUSH(); 

				}
				break;
			case 2 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:15: POP
				{
				mPOP(); 

				}
				break;
			case 3 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:19: ADD
				{
				mADD(); 

				}
				break;
			case 4 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:23: SUB
				{
				mSUB(); 

				}
				break;
			case 5 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:27: MULT
				{
				mMULT(); 

				}
				break;
			case 6 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:32: DIV
				{
				mDIV(); 

				}
				break;
			case 7 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:36: AND
				{
				mAND(); 

				}
				break;
			case 8 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:40: OR
				{
				mOR(); 

				}
				break;
			case 9 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:43: NOT
				{
				mNOT(); 

				}
				break;
			case 10 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:47: STOREW
				{
				mSTOREW(); 

				}
				break;
			case 11 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:54: LOADW
				{
				mLOADW(); 

				}
				break;
			case 12 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:60: BRANCH
				{
				mBRANCH(); 

				}
				break;
			case 13 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:67: BRANCHEQ
				{
				mBRANCHEQ(); 

				}
				break;
			case 14 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:76: BRANCHLESSEQ
				{
				mBRANCHLESSEQ(); 

				}
				break;
			case 15 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:89: BRANCHGEQ
				{
				mBRANCHGEQ(); 

				}
				break;
			case 16 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:99: JS
				{
				mJS(); 

				}
				break;
			case 17 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:102: LOADRA
				{
				mLOADRA(); 

				}
				break;
			case 18 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:109: STORERA
				{
				mSTORERA(); 

				}
				break;
			case 19 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:117: LOADRV
				{
				mLOADRV(); 

				}
				break;
			case 20 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:124: STORERV
				{
				mSTORERV(); 

				}
				break;
			case 21 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:132: LOADFP
				{
				mLOADFP(); 

				}
				break;
			case 22 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:139: STOREFP
				{
				mSTOREFP(); 

				}
				break;
			case 23 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:147: COPYFP
				{
				mCOPYFP(); 

				}
				break;
			case 24 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:154: LOADHP
				{
				mLOADHP(); 

				}
				break;
			case 25 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:161: STOREHP
				{
				mSTOREHP(); 

				}
				break;
			case 26 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:169: PRINT
				{
				mPRINT(); 

				}
				break;
			case 27 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:175: HALT
				{
				mHALT(); 

				}
				break;
			case 28 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:180: COL
				{
				mCOL(); 

				}
				break;
			case 29 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:184: LABEL
				{
				mLABEL(); 

				}
				break;
			case 30 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:190: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 31 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:197: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 32 :
				// D:\\Xander_C\\Documents\\Projects\\FoolProject\\SVM.g:1:205: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\10\27\1\52\3\27\3\uffff\1\23\3\uffff\3\27\1\uffff\3\27\1\67\5"+
		"\27\1\76\1\27\1\100\6\27\1\uffff\1\110\2\27\3\uffff\1\27\1\114\1\27\1"+
		"\116\1\117\1\120\1\uffff\1\121\1\122\1\123\1\124\1\27\1\126\1\uffff\1"+
		"\127\1\uffff\1\130\1\131\1\132\1\133\1\134\2\27\1\uffff\1\137\1\27\1\141"+
		"\1\uffff\1\27\7\uffff\1\143\7\uffff\1\144\1\145\1\uffff\1\146\1\uffff"+
		"\1\147\5\uffff";
	static final String DFA6_eofS =
		"\150\uffff";
	static final String DFA6_minS =
		"\1\0\1\157\1\144\1\146\1\165\1\151\1\162\1\157\1\146\1\60\1\163\1\146"+
		"\1\141\3\uffff\1\61\3\uffff\1\163\1\160\1\151\1\uffff\2\144\1\142\1\60"+
		"\1\141\2\160\1\154\1\166\1\60\1\164\1\60\1\141\2\160\1\161\2\145\1\uffff"+
		"\1\60\1\160\1\154\3\uffff\1\150\1\60\1\156\3\60\1\uffff\4\60\1\164\1\60"+
		"\1\uffff\1\60\1\uffff\5\60\2\161\1\uffff\1\60\1\164\1\60\1\uffff\1\164"+
		"\7\uffff\1\60\7\uffff\2\60\1\uffff\1\60\1\uffff\1\60\5\uffff";
	static final String DFA6_maxS =
		"\1\uffff\1\165\1\156\1\167\1\165\1\151\1\162\1\157\1\167\1\172\1\163\1"+
		"\146\1\141\3\uffff\1\71\3\uffff\1\163\1\160\1\151\1\uffff\2\144\1\142"+
		"\1\172\1\166\2\160\1\154\1\166\1\172\1\164\1\172\1\166\2\160\1\161\2\145"+
		"\1\uffff\1\172\1\160\1\154\3\uffff\1\150\1\172\1\156\3\172\1\uffff\4\172"+
		"\1\164\1\172\1\uffff\1\172\1\uffff\5\172\2\161\1\uffff\1\172\1\164\1\172"+
		"\1\uffff\1\164\7\uffff\1\172\7\uffff\2\172\1\uffff\1\172\1\uffff\1\172"+
		"\5\uffff";
	static final String DFA6_acceptS =
		"\15\uffff\1\34\1\35\1\36\1\uffff\1\36\1\37\1\40\3\uffff\1\35\22\uffff"+
		"\1\14\3\uffff\1\34\1\36\1\37\6\uffff\1\12\6\uffff\1\10\1\uffff\1\13\7"+
		"\uffff\1\20\3\uffff\1\2\1\uffff\1\3\1\7\1\4\1\22\1\24\1\26\1\31\1\uffff"+
		"\1\6\1\11\1\21\1\23\1\25\1\30\1\15\2\uffff\1\27\1\uffff\1\1\1\uffff\1"+
		"\5\1\16\1\17\1\33\1\32";
	static final String DFA6_specialS =
		"\1\0\147\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\23\2\22\2\23\1\22\22\23\1\22\14\23\1\20\2\23\1\17\11\21\1\15\6\23"+
			"\32\16\6\23\1\2\1\11\1\13\1\5\3\16\1\14\1\16\1\12\1\16\1\10\1\4\1\7\1"+
			"\6\1\1\2\16\1\3\7\16\uff85\23",
			"\1\25\2\uffff\1\26\2\uffff\1\24",
			"\1\30\11\uffff\1\31",
			"\1\35\1\uffff\1\36\11\uffff\1\34\2\uffff\1\32\1\uffff\1\33",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\45\1\uffff\1\46\11\uffff\1\44\4\uffff\1\43",
			"\12\27\7\uffff\32\27\6\uffff\4\27\1\47\1\27\1\51\4\27\1\50\16\27",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"",
			"",
			"\11\57",
			"",
			"",
			"",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"\1\64",
			"\1\65",
			"\1\66",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\70\24\uffff\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\77",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\101\24\uffff\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\111",
			"\1\112",
			"",
			"",
			"",
			"\1\113",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\115",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\125",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\135",
			"\1\136",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\140",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\1\142",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PUSH | POP | ADD | SUB | MULT | DIV | AND | OR | NOT | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESSEQ | BRANCHGEQ | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='p') ) {s = 1;}
						else if ( (LA6_0=='a') ) {s = 2;}
						else if ( (LA6_0=='s') ) {s = 3;}
						else if ( (LA6_0=='m') ) {s = 4;}
						else if ( (LA6_0=='d') ) {s = 5;}
						else if ( (LA6_0=='o') ) {s = 6;}
						else if ( (LA6_0=='n') ) {s = 7;}
						else if ( (LA6_0=='l') ) {s = 8;}
						else if ( (LA6_0=='b') ) {s = 9;}
						else if ( (LA6_0=='j') ) {s = 10;}
						else if ( (LA6_0=='c') ) {s = 11;}
						else if ( (LA6_0=='h') ) {s = 12;}
						else if ( (LA6_0==':') ) {s = 13;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'e' && LA6_0 <= 'g')||LA6_0=='i'||LA6_0=='k'||(LA6_0 >= 'q' && LA6_0 <= 'r')||(LA6_0 >= 't' && LA6_0 <= 'z')) ) {s = 14;}
						else if ( (LA6_0=='0') ) {s = 15;}
						else if ( (LA6_0=='-') ) {s = 16;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 17;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 18;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= ',')||(LA6_0 >= '.' && LA6_0 <= '/')||(LA6_0 >= ';' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||(LA6_0 >= '{' && LA6_0 <= '\uFFFF')) ) {s = 19;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 6, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
