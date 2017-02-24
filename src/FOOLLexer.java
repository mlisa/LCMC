// $ANTLR 3.5.2 /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g 2017-02-24 16:16:17

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLLexer extends Lexer {
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

	    int lexicalErrors=0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FOOLLexer() {} 
	public FOOLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g"; }

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:425:9: ( '+' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:425:11: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:426:9: ( '-' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:426:11: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:427:10: ( '*' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:427:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:428:7: ( '/' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:428:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:429:7: ( '(' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:429:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:430:7: ( ')' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:430:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "CLPAR"
	public final void mCLPAR() throws RecognitionException {
		try {
			int _type = CLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:431:7: ( '{' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:431:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLPAR"

	// $ANTLR start "CRPAR"
	public final void mCRPAR() throws RecognitionException {
		try {
			int _type = CRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:432:7: ( '}' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:432:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CRPAR"

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:433:9: ( ';' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:433:11: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMIC"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:434:9: ( ':' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:434:11: ':'
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
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:435:7: ( ',' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:435:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:436:5: ( '.' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:436:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:437:5: ( '||' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:437:7: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:438:5: ( '&&' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:438:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:439:5: ( 'not' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:439:7: 'not'
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

	// $ANTLR start "GE"
	public final void mGE() throws RecognitionException {
		try {
			int _type = GE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:440:5: ( '>=' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:440:7: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE"

	// $ANTLR start "LE"
	public final void mLE() throws RecognitionException {
		try {
			int _type = LE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:441:5: ( '<=' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:441:7: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:442:5: ( '==' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:442:7: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:443:5: ( '=' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:443:7: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASS"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:444:7: ( 'true' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:444:9: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:445:7: ( 'false' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:445:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:446:5: ( 'if' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:446:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:447:7: ( 'then' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:447:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:448:7: ( 'else' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:448:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:449:7: ( 'print' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:449:9: 'print'
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

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:450:9: ( 'let' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:450:11: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:451:9: ( 'in' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:451:11: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:452:9: ( 'var' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:452:11: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:453:5: ( 'fun' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:453:7: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:454:7: ( 'class' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:454:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "EXTENDS"
	public final void mEXTENDS() throws RecognitionException {
		try {
			int _type = EXTENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:455:9: ( 'extends' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:455:11: 'extends'
			{
			match("extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTENDS"

	// $ANTLR start "NEW"
	public final void mNEW() throws RecognitionException {
		try {
			int _type = NEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:456:7: ( 'new' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:456:9: 'new'
			{
			match("new"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEW"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:457:9: ( 'null' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:457:11: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:458:5: ( 'int' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:458:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:459:7: ( 'bool' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:459:9: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:460:9: ( '->' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:460:11: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:9: ( '0' | ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='0') ) {
				alt3=1;
			}
			else if ( (LA3_0=='-'||(LA3_0 >= '1' && LA3_0 <= '9')) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:11: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:17: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:17: ( '-' )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='-') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:18: '-'
							{
							match('-'); 
							}
							break;

					}

					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:23: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:24: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:461:34: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:
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
							break loop2;
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
	// $ANTLR end "INTEGER"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:463:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:463:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:463:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:
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
					break loop4;
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
	// $ANTLR end "ID"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:465:9: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:465:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:465:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
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
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:
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

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:467:9: ( '/*' ( . )* '*/' )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:467:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:467:16: ( . )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='*') ) {
					int LA6_1 = input.LA(2);
					if ( (LA6_1=='/') ) {
						alt6=2;
					}
					else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
						alt6=1;
					}

				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:467:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop6;
				}
			}

			match("*/"); 

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:469:10: ( . )
			// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:469:12: .
			{
			matchAny(); 
			 System.out.println("Invalid char: "+getText()); lexicalErrors++; _channel=HIDDEN; 
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
		// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:8: ( PLUS | MINUS | TIMES | DIV | LPAR | RPAR | CLPAR | CRPAR | SEMIC | COLON | COMMA | DOT | OR | AND | NOT | GE | LE | EQ | ASS | TRUE | FALSE | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | CLASS | EXTENDS | NEW | NULL | INT | BOOL | ARROW | INTEGER | ID | WHITESP | COMMENT | ERR )
		int alt7=41;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:10: PLUS
				{
				mPLUS(); 

				}
				break;
			case 2 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:15: MINUS
				{
				mMINUS(); 

				}
				break;
			case 3 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:21: TIMES
				{
				mTIMES(); 

				}
				break;
			case 4 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:27: DIV
				{
				mDIV(); 

				}
				break;
			case 5 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:31: LPAR
				{
				mLPAR(); 

				}
				break;
			case 6 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:36: RPAR
				{
				mRPAR(); 

				}
				break;
			case 7 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:41: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 8 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:47: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 9 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:53: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 10 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:59: COLON
				{
				mCOLON(); 

				}
				break;
			case 11 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:65: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 12 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:71: DOT
				{
				mDOT(); 

				}
				break;
			case 13 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:75: OR
				{
				mOR(); 

				}
				break;
			case 14 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:78: AND
				{
				mAND(); 

				}
				break;
			case 15 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:82: NOT
				{
				mNOT(); 

				}
				break;
			case 16 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:86: GE
				{
				mGE(); 

				}
				break;
			case 17 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:89: LE
				{
				mLE(); 

				}
				break;
			case 18 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:92: EQ
				{
				mEQ(); 

				}
				break;
			case 19 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:95: ASS
				{
				mASS(); 

				}
				break;
			case 20 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:99: TRUE
				{
				mTRUE(); 

				}
				break;
			case 21 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:104: FALSE
				{
				mFALSE(); 

				}
				break;
			case 22 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:110: IF
				{
				mIF(); 

				}
				break;
			case 23 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:113: THEN
				{
				mTHEN(); 

				}
				break;
			case 24 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:118: ELSE
				{
				mELSE(); 

				}
				break;
			case 25 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:123: PRINT
				{
				mPRINT(); 

				}
				break;
			case 26 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:129: LET
				{
				mLET(); 

				}
				break;
			case 27 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:133: IN
				{
				mIN(); 

				}
				break;
			case 28 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:136: VAR
				{
				mVAR(); 

				}
				break;
			case 29 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:140: FUN
				{
				mFUN(); 

				}
				break;
			case 30 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:144: CLASS
				{
				mCLASS(); 

				}
				break;
			case 31 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:150: EXTENDS
				{
				mEXTENDS(); 

				}
				break;
			case 32 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:158: NEW
				{
				mNEW(); 

				}
				break;
			case 33 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:162: NULL
				{
				mNULL(); 

				}
				break;
			case 34 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:167: INT
				{
				mINT(); 

				}
				break;
			case 35 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:171: BOOL
				{
				mBOOL(); 

				}
				break;
			case 36 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:176: ARROW
				{
				mARROW(); 

				}
				break;
			case 37 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:182: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 38 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:190: ID
				{
				mID(); 

				}
				break;
			case 39 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:193: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 40 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:201: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 41 :
				// /Users/lisamazzini/Documents/workspace/FOOL_12_02/FOOL.g:1:209: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\2\uffff\1\43\1\uffff\1\47\10\uffff\2\40\1\65\2\40\1\71\11\65\26\uffff"+
		"\3\65\5\uffff\4\65\1\117\1\121\7\65\1\uffff\1\131\1\132\4\65\1\137\1\uffff"+
		"\1\140\1\uffff\3\65\1\144\1\145\2\65\2\uffff\1\150\1\151\1\152\1\65\2"+
		"\uffff\1\154\2\65\2\uffff\1\65\1\160\3\uffff\1\161\1\uffff\1\65\1\163"+
		"\1\164\2\uffff\1\65\2\uffff\1\166\1\uffff";
	static final String DFA7_eofS =
		"\167\uffff";
	static final String DFA7_minS =
		"\1\0\1\uffff\1\61\1\uffff\1\52\10\uffff\1\174\1\46\1\145\3\75\1\150\1"+
		"\141\1\146\1\154\1\162\1\145\1\141\1\154\1\157\26\uffff\1\164\1\167\1"+
		"\154\5\uffff\1\165\1\145\1\154\1\156\2\60\1\163\1\164\1\151\1\164\1\162"+
		"\1\141\1\157\1\uffff\2\60\1\154\1\145\1\156\1\163\1\60\1\uffff\1\60\1"+
		"\uffff\2\145\1\156\2\60\1\163\1\154\2\uffff\3\60\1\145\2\uffff\1\60\1"+
		"\156\1\164\2\uffff\1\163\1\60\3\uffff\1\60\1\uffff\1\144\2\60\2\uffff"+
		"\1\163\2\uffff\1\60\1\uffff";
	static final String DFA7_maxS =
		"\1\uffff\1\uffff\1\76\1\uffff\1\52\10\uffff\1\174\1\46\1\165\3\75\1\162"+
		"\1\165\1\156\1\170\1\162\1\145\1\141\1\154\1\157\26\uffff\1\164\1\167"+
		"\1\154\5\uffff\1\165\1\145\1\154\1\156\2\172\1\163\1\164\1\151\1\164\1"+
		"\162\1\141\1\157\1\uffff\2\172\1\154\1\145\1\156\1\163\1\172\1\uffff\1"+
		"\172\1\uffff\2\145\1\156\2\172\1\163\1\154\2\uffff\3\172\1\145\2\uffff"+
		"\1\172\1\156\1\164\2\uffff\1\163\1\172\3\uffff\1\172\1\uffff\1\144\2\172"+
		"\2\uffff\1\163\2\uffff\1\172\1\uffff";
	static final String DFA7_acceptS =
		"\1\uffff\1\1\1\uffff\1\3\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
		"\17\uffff\2\45\1\46\1\47\1\51\1\1\1\44\1\2\1\45\1\3\1\50\1\4\1\5\1\6\1"+
		"\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\3\uffff\1\46\1\20\1\21\1\22\1\23"+
		"\15\uffff\1\47\7\uffff\1\26\1\uffff\1\33\7\uffff\1\17\1\40\4\uffff\1\35"+
		"\1\42\3\uffff\1\32\1\34\2\uffff\1\41\1\24\1\27\1\uffff\1\30\3\uffff\1"+
		"\43\1\25\1\uffff\1\31\1\36\1\uffff\1\37";
	static final String DFA7_specialS =
		"\1\0\166\uffff}>";
	static final String[] DFA7_transitionS = {
			"\11\40\2\37\2\40\1\37\22\40\1\37\5\40\1\16\1\40\1\5\1\6\1\3\1\1\1\13"+
			"\1\2\1\14\1\4\1\34\11\35\1\12\1\11\1\21\1\22\1\20\2\40\32\36\6\40\1\36"+
			"\1\33\1\32\1\36\1\26\1\24\2\36\1\25\2\36\1\30\1\36\1\17\1\36\1\27\3\36"+
			"\1\23\1\36\1\31\4\36\1\7\1\15\1\10\uff82\40",
			"",
			"\11\44\4\uffff\1\42",
			"",
			"\1\46",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\60",
			"\1\61",
			"\1\63\11\uffff\1\62\5\uffff\1\64",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\73\11\uffff\1\72",
			"\1\74\23\uffff\1\75",
			"\1\76\7\uffff\1\77",
			"\1\100\13\uffff\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\110",
			"\1\111",
			"\1\112",
			"",
			"",
			"",
			"",
			"",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\23\65\1\120\6\65",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"",
			"\1\141",
			"\1\142",
			"\1\143",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\1\146",
			"\1\147",
			"",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\1\153",
			"",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\1\155",
			"\1\156",
			"",
			"",
			"\1\157",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"",
			"",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"",
			"\1\162",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			"",
			"",
			"\1\165",
			"",
			"",
			"\12\65\7\uffff\32\65\6\uffff\32\65",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PLUS | MINUS | TIMES | DIV | LPAR | RPAR | CLPAR | CRPAR | SEMIC | COLON | COMMA | DOT | OR | AND | NOT | GE | LE | EQ | ASS | TRUE | FALSE | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | CLASS | EXTENDS | NEW | NULL | INT | BOOL | ARROW | INTEGER | ID | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA7_0 = input.LA(1);
						s = -1;
						if ( (LA7_0=='+') ) {s = 1;}
						else if ( (LA7_0=='-') ) {s = 2;}
						else if ( (LA7_0=='*') ) {s = 3;}
						else if ( (LA7_0=='/') ) {s = 4;}
						else if ( (LA7_0=='(') ) {s = 5;}
						else if ( (LA7_0==')') ) {s = 6;}
						else if ( (LA7_0=='{') ) {s = 7;}
						else if ( (LA7_0=='}') ) {s = 8;}
						else if ( (LA7_0==';') ) {s = 9;}
						else if ( (LA7_0==':') ) {s = 10;}
						else if ( (LA7_0==',') ) {s = 11;}
						else if ( (LA7_0=='.') ) {s = 12;}
						else if ( (LA7_0=='|') ) {s = 13;}
						else if ( (LA7_0=='&') ) {s = 14;}
						else if ( (LA7_0=='n') ) {s = 15;}
						else if ( (LA7_0=='>') ) {s = 16;}
						else if ( (LA7_0=='<') ) {s = 17;}
						else if ( (LA7_0=='=') ) {s = 18;}
						else if ( (LA7_0=='t') ) {s = 19;}
						else if ( (LA7_0=='f') ) {s = 20;}
						else if ( (LA7_0=='i') ) {s = 21;}
						else if ( (LA7_0=='e') ) {s = 22;}
						else if ( (LA7_0=='p') ) {s = 23;}
						else if ( (LA7_0=='l') ) {s = 24;}
						else if ( (LA7_0=='v') ) {s = 25;}
						else if ( (LA7_0=='c') ) {s = 26;}
						else if ( (LA7_0=='b') ) {s = 27;}
						else if ( (LA7_0=='0') ) {s = 28;}
						else if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {s = 29;}
						else if ( ((LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='a'||LA7_0=='d'||(LA7_0 >= 'g' && LA7_0 <= 'h')||(LA7_0 >= 'j' && LA7_0 <= 'k')||LA7_0=='m'||LA7_0=='o'||(LA7_0 >= 'q' && LA7_0 <= 's')||LA7_0=='u'||(LA7_0 >= 'w' && LA7_0 <= 'z')) ) {s = 30;}
						else if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {s = 31;}
						else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\u001F')||(LA7_0 >= '!' && LA7_0 <= '%')||LA7_0=='\''||(LA7_0 >= '?' && LA7_0 <= '@')||(LA7_0 >= '[' && LA7_0 <= '`')||(LA7_0 >= '~' && LA7_0 <= '\uFFFF')) ) {s = 32;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 7, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
