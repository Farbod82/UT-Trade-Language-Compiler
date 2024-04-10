// Generated from C:/Users/farbo/Desktop/university-s5/compiler/compiler_ca4/UTL-Phase3/UTL-Phase3-Final/UTL-Phase3/src/main/grammar/UTL.g4 by ANTLR 4.13.1
package parsers;

    import main.ast.node.*;
    import main.ast.node.declaration.*;
    import main.ast.node.statement.*;
    import main.ast.node.expression.*;
    import main.ast.node.expression.operators.*;
    import main.ast.node.expression.values.*;
    import main.ast.type.primitiveType.*;
    import main.ast.type.complexType.*;
    import main.ast.type.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UTLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SPACES=1, SEMICOLON=2, COMMA=3, COLON=4, DOT=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, LBRACK=10, RBRACK=11, PLUS=12, MINUS=13, MULT=14, DIV=15, MOD=16, 
		AND=17, OR=18, NOT=19, BIT_AND=20, BIT_OR=21, BIT_XOR=22, L_SHIFT=23, 
		R_SHIFT=24, BIT_NOT=25, LT=26, GT=27, EQ=28, NEQ=29, INC=30, DEC=31, ASSIGN=32, 
		ADD_ASSIGN=33, SUB_ASSIGN=34, MUL_ASSIGN=35, DIV_ASSIGN=36, MOD_ASSIGN=37, 
		TRY=38, THROW=39, CATCH=40, IF=41, ELSE=42, FOR=43, WHILE=44, BREAK=45, 
		CONTINUE=46, RETURN=47, MAIN=48, ONINIT=49, ONSTART=50, FLOAT=51, STRING=52, 
		BOOL=53, VOID=54, INT=55, BUY=56, SELL=57, ASK=58, BID=59, TIME=60, HIGH=61, 
		LOW=62, DIGITS=63, VOLUME=64, TYPE=65, TEXT=66, OPEN=67, CLOSE=68, TRADE=69, 
		ORDER=70, CANDLE=71, EXCEPTION=72, REFRESH_RATE=73, GET_CANDLE=74, TERMINATE=75, 
		CONNECT=76, OBSERVE=77, PRINT=78, ID=79, INT_LITERAL=80, FLOAT_LITERAL=81, 
		STRING_LITERAL=82, COMMENT=83;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SPACES", "SEMICOLON", "COMMA", "COLON", "DOT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACK", "RBRACK", "PLUS", "MINUS", "MULT", "DIV", "MOD", 
			"AND", "OR", "NOT", "BIT_AND", "BIT_OR", "BIT_XOR", "L_SHIFT", "R_SHIFT", 
			"BIT_NOT", "LT", "GT", "EQ", "NEQ", "INC", "DEC", "ASSIGN", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "TRY", "THROW", 
			"CATCH", "IF", "ELSE", "FOR", "WHILE", "BREAK", "CONTINUE", "RETURN", 
			"MAIN", "ONINIT", "ONSTART", "FLOAT", "STRING", "BOOL", "VOID", "INT", 
			"BUY", "SELL", "ASK", "BID", "TIME", "HIGH", "LOW", "DIGITS", "VOLUME", 
			"TYPE", "TEXT", "OPEN", "CLOSE", "TRADE", "ORDER", "CANDLE", "EXCEPTION", 
			"REFRESH_RATE", "GET_CANDLE", "TERMINATE", "CONNECT", "OBSERVE", "PRINT", 
			"ID", "INT_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'", "','", "':'", "'.'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'&'", 
			"'|'", "'^'", "'<<'", "'>>'", "'~'", "'<'", "'>'", "'=='", "'!='", "'++'", 
			"'--'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'try'", "'throw'", 
			"'catch'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", "'Main'", "'OnInit'", "'OnStart'", "'float'", "'string'", 
			"'bool'", "'void'", "'int'", "'BUY'", "'SELL'", "'Ask'", "'Bid'", "'Time'", 
			"'High'", "'Low'", "'Digits'", "'Volume'", "'Type'", "'Text'", "'Open'", 
			"'Close'", "'Trade'", "'Order'", "'Candle'", "'Exception'", "'RefreshRate'", 
			"'GetCandle'", "'Terminate'", "'Connect'", "'Observe'", "'Print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SPACES", "SEMICOLON", "COMMA", "COLON", "DOT", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "PLUS", "MINUS", "MULT", "DIV", 
			"MOD", "AND", "OR", "NOT", "BIT_AND", "BIT_OR", "BIT_XOR", "L_SHIFT", 
			"R_SHIFT", "BIT_NOT", "LT", "GT", "EQ", "NEQ", "INC", "DEC", "ASSIGN", 
			"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", 
			"TRY", "THROW", "CATCH", "IF", "ELSE", "FOR", "WHILE", "BREAK", "CONTINUE", 
			"RETURN", "MAIN", "ONINIT", "ONSTART", "FLOAT", "STRING", "BOOL", "VOID", 
			"INT", "BUY", "SELL", "ASK", "BID", "TIME", "HIGH", "LOW", "DIGITS", 
			"VOLUME", "TYPE", "TEXT", "OPEN", "CLOSE", "TRADE", "ORDER", "CANDLE", 
			"EXCEPTION", "REFRESH_RATE", "GET_CANDLE", "TERMINATE", "CONNECT", "OBSERVE", 
			"PRINT", "ID", "INT_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public UTLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000S\u023d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007"+
		"D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007"+
		"I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007"+
		"N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0001\u0000"+
		"\u0004\u0000\u00a9\b\u0000\u000b\u0000\f\u0000\u00aa\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u0001"+
		"4\u00014\u00015\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u0001"+
		"6\u00017\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u00018\u0001"+
		"9\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001=\u0001=\u0001"+
		"=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001A\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"N\u0001N\u0005N\u0202\bN\nN\fN\u0205\tN\u0001O\u0001O\u0005O\u0209\bO"+
		"\nO\fO\u020c\tO\u0001O\u0003O\u020f\bO\u0001P\u0005P\u0212\bP\nP\fP\u0215"+
		"\tP\u0001P\u0001P\u0004P\u0219\bP\u000bP\fP\u021a\u0001Q\u0001Q\u0005"+
		"Q\u021f\bQ\nQ\fQ\u0222\tQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0005"+
		"R\u022a\bR\nR\fR\u022d\tR\u0001R\u0001R\u0001R\u0001R\u0005R\u0233\bR"+
		"\nR\fR\u0236\tR\u0001R\u0001R\u0003R\u023a\bR\u0001R\u0001R\u0001\u0234"+
		"\u0000S\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y={>}?\u007f@\u0081"+
		"A\u0083B\u0085C\u0087D\u0089E\u008bF\u008dG\u008fH\u0091I\u0093J\u0095"+
		"K\u0097L\u0099M\u009bN\u009dO\u009fP\u00a1Q\u00a3R\u00a5S\u0001\u0000"+
		"\u0007\u0003\u0000\t\n\r\r  \u0003\u0000AZ__az\u0004\u000009AZ__az\u0001"+
		"\u000019\u0001\u000009\u0001\u0000\"\"\u0002\u0000\n\n\r\r\u0246\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"+
		"\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000"+
		"\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000"+
		"\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y"+
		"\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000"+
		"\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000"+
		"\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g"+
		"\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000"+
		"\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000"+
		"\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001\u0000\u0000\u0000\u0000u"+
		"\u0001\u0000\u0000\u0000\u0000w\u0001\u0000\u0000\u0000\u0000y\u0001\u0000"+
		"\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000"+
		"\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000"+
		"\u0000\u0083\u0001\u0000\u0000\u0000\u0000\u0085\u0001\u0000\u0000\u0000"+
		"\u0000\u0087\u0001\u0000\u0000\u0000\u0000\u0089\u0001\u0000\u0000\u0000"+
		"\u0000\u008b\u0001\u0000\u0000\u0000\u0000\u008d\u0001\u0000\u0000\u0000"+
		"\u0000\u008f\u0001\u0000\u0000\u0000\u0000\u0091\u0001\u0000\u0000\u0000"+
		"\u0000\u0093\u0001\u0000\u0000\u0000\u0000\u0095\u0001\u0000\u0000\u0000"+
		"\u0000\u0097\u0001\u0000\u0000\u0000\u0000\u0099\u0001\u0000\u0000\u0000"+
		"\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d\u0001\u0000\u0000\u0000"+
		"\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1\u0001\u0000\u0000\u0000"+
		"\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5\u0001\u0000\u0000\u0000"+
		"\u0001\u00a8\u0001\u0000\u0000\u0000\u0003\u00ae\u0001\u0000\u0000\u0000"+
		"\u0005\u00b0\u0001\u0000\u0000\u0000\u0007\u00b2\u0001\u0000\u0000\u0000"+
		"\t\u00b4\u0001\u0000\u0000\u0000\u000b\u00b6\u0001\u0000\u0000\u0000\r"+
		"\u00b8\u0001\u0000\u0000\u0000\u000f\u00ba\u0001\u0000\u0000\u0000\u0011"+
		"\u00bc\u0001\u0000\u0000\u0000\u0013\u00be\u0001\u0000\u0000\u0000\u0015"+
		"\u00c0\u0001\u0000\u0000\u0000\u0017\u00c2\u0001\u0000\u0000\u0000\u0019"+
		"\u00c4\u0001\u0000\u0000\u0000\u001b\u00c6\u0001\u0000\u0000\u0000\u001d"+
		"\u00c8\u0001\u0000\u0000\u0000\u001f\u00ca\u0001\u0000\u0000\u0000!\u00cc"+
		"\u0001\u0000\u0000\u0000#\u00cf\u0001\u0000\u0000\u0000%\u00d2\u0001\u0000"+
		"\u0000\u0000\'\u00d4\u0001\u0000\u0000\u0000)\u00d6\u0001\u0000\u0000"+
		"\u0000+\u00d8\u0001\u0000\u0000\u0000-\u00da\u0001\u0000\u0000\u0000/"+
		"\u00dd\u0001\u0000\u0000\u00001\u00e0\u0001\u0000\u0000\u00003\u00e2\u0001"+
		"\u0000\u0000\u00005\u00e4\u0001\u0000\u0000\u00007\u00e6\u0001\u0000\u0000"+
		"\u00009\u00e9\u0001\u0000\u0000\u0000;\u00ec\u0001\u0000\u0000\u0000="+
		"\u00ef\u0001\u0000\u0000\u0000?\u00f2\u0001\u0000\u0000\u0000A\u00f4\u0001"+
		"\u0000\u0000\u0000C\u00f7\u0001\u0000\u0000\u0000E\u00fa\u0001\u0000\u0000"+
		"\u0000G\u00fd\u0001\u0000\u0000\u0000I\u0100\u0001\u0000\u0000\u0000K"+
		"\u0103\u0001\u0000\u0000\u0000M\u0107\u0001\u0000\u0000\u0000O\u010d\u0001"+
		"\u0000\u0000\u0000Q\u0113\u0001\u0000\u0000\u0000S\u0116\u0001\u0000\u0000"+
		"\u0000U\u011b\u0001\u0000\u0000\u0000W\u011f\u0001\u0000\u0000\u0000Y"+
		"\u0125\u0001\u0000\u0000\u0000[\u012b\u0001\u0000\u0000\u0000]\u0134\u0001"+
		"\u0000\u0000\u0000_\u013b\u0001\u0000\u0000\u0000a\u0140\u0001\u0000\u0000"+
		"\u0000c\u0147\u0001\u0000\u0000\u0000e\u014f\u0001\u0000\u0000\u0000g"+
		"\u0155\u0001\u0000\u0000\u0000i\u015c\u0001\u0000\u0000\u0000k\u0161\u0001"+
		"\u0000\u0000\u0000m\u0166\u0001\u0000\u0000\u0000o\u016a\u0001\u0000\u0000"+
		"\u0000q\u016e\u0001\u0000\u0000\u0000s\u0173\u0001\u0000\u0000\u0000u"+
		"\u0177\u0001\u0000\u0000\u0000w\u017b\u0001\u0000\u0000\u0000y\u0180\u0001"+
		"\u0000\u0000\u0000{\u0185\u0001\u0000\u0000\u0000}\u0189\u0001\u0000\u0000"+
		"\u0000\u007f\u0190\u0001\u0000\u0000\u0000\u0081\u0197\u0001\u0000\u0000"+
		"\u0000\u0083\u019c\u0001\u0000\u0000\u0000\u0085\u01a1\u0001\u0000\u0000"+
		"\u0000\u0087\u01a6\u0001\u0000\u0000\u0000\u0089\u01ac\u0001\u0000\u0000"+
		"\u0000\u008b\u01b2\u0001\u0000\u0000\u0000\u008d\u01b8\u0001\u0000\u0000"+
		"\u0000\u008f\u01bf\u0001\u0000\u0000\u0000\u0091\u01c9\u0001\u0000\u0000"+
		"\u0000\u0093\u01d5\u0001\u0000\u0000\u0000\u0095\u01df\u0001\u0000\u0000"+
		"\u0000\u0097\u01e9\u0001\u0000\u0000\u0000\u0099\u01f1\u0001\u0000\u0000"+
		"\u0000\u009b\u01f9\u0001\u0000\u0000\u0000\u009d\u01ff\u0001\u0000\u0000"+
		"\u0000\u009f\u020e\u0001\u0000\u0000\u0000\u00a1\u0213\u0001\u0000\u0000"+
		"\u0000\u00a3\u021c\u0001\u0000\u0000\u0000\u00a5\u0239\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a9\u0007\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0006\u0000\u0000\u0000\u00ad\u0002\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0005;\u0000\u0000\u00af\u0004\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005,\u0000\u0000\u00b1\u0006\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005:\u0000\u0000\u00b3\b\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005.\u0000\u0000\u00b5\n\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"(\u0000\u0000\u00b7\f\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005)\u0000"+
		"\u0000\u00b9\u000e\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005{\u0000\u0000"+
		"\u00bb\u0010\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005}\u0000\u0000\u00bd"+
		"\u0012\u0001\u0000\u0000\u0000\u00be\u00bf\u0005[\u0000\u0000\u00bf\u0014"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005]\u0000\u0000\u00c1\u0016\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0005+\u0000\u0000\u00c3\u0018\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005-\u0000\u0000\u00c5\u001a\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005*\u0000\u0000\u00c7\u001c\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0005/\u0000\u0000\u00c9\u001e\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0005%\u0000\u0000\u00cb \u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"&\u0000\u0000\u00cd\u00ce\u0005&\u0000\u0000\u00ce\"\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0005|\u0000\u0000\u00d0\u00d1\u0005|\u0000\u0000\u00d1"+
		"$\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005!\u0000\u0000\u00d3&\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0005&\u0000\u0000\u00d5(\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0005|\u0000\u0000\u00d7*\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0005^\u0000\u0000\u00d9,\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"<\u0000\u0000\u00db\u00dc\u0005<\u0000\u0000\u00dc.\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0005>\u0000\u0000\u00de\u00df\u0005>\u0000\u0000\u00df"+
		"0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005~\u0000\u0000\u00e12\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005<\u0000\u0000\u00e34\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0005>\u0000\u0000\u00e56\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0005=\u0000\u0000\u00e7\u00e8\u0005=\u0000\u0000\u00e88\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0005!\u0000\u0000\u00ea\u00eb\u0005=\u0000"+
		"\u0000\u00eb:\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005+\u0000\u0000\u00ed"+
		"\u00ee\u0005+\u0000\u0000\u00ee<\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005"+
		"-\u0000\u0000\u00f0\u00f1\u0005-\u0000\u0000\u00f1>\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005=\u0000\u0000\u00f3@\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0005+\u0000\u0000\u00f5\u00f6\u0005=\u0000\u0000\u00f6B\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005-\u0000\u0000\u00f8\u00f9\u0005=\u0000"+
		"\u0000\u00f9D\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005*\u0000\u0000\u00fb"+
		"\u00fc\u0005=\u0000\u0000\u00fcF\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005"+
		"/\u0000\u0000\u00fe\u00ff\u0005=\u0000\u0000\u00ffH\u0001\u0000\u0000"+
		"\u0000\u0100\u0101\u0005%\u0000\u0000\u0101\u0102\u0005=\u0000\u0000\u0102"+
		"J\u0001\u0000\u0000\u0000\u0103\u0104\u0005t\u0000\u0000\u0104\u0105\u0005"+
		"r\u0000\u0000\u0105\u0106\u0005y\u0000\u0000\u0106L\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005t\u0000\u0000\u0108\u0109\u0005h\u0000\u0000\u0109"+
		"\u010a\u0005r\u0000\u0000\u010a\u010b\u0005o\u0000\u0000\u010b\u010c\u0005"+
		"w\u0000\u0000\u010cN\u0001\u0000\u0000\u0000\u010d\u010e\u0005c\u0000"+
		"\u0000\u010e\u010f\u0005a\u0000\u0000\u010f\u0110\u0005t\u0000\u0000\u0110"+
		"\u0111\u0005c\u0000\u0000\u0111\u0112\u0005h\u0000\u0000\u0112P\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0005i\u0000\u0000\u0114\u0115\u0005f\u0000"+
		"\u0000\u0115R\u0001\u0000\u0000\u0000\u0116\u0117\u0005e\u0000\u0000\u0117"+
		"\u0118\u0005l\u0000\u0000\u0118\u0119\u0005s\u0000\u0000\u0119\u011a\u0005"+
		"e\u0000\u0000\u011aT\u0001\u0000\u0000\u0000\u011b\u011c\u0005f\u0000"+
		"\u0000\u011c\u011d\u0005o\u0000\u0000\u011d\u011e\u0005r\u0000\u0000\u011e"+
		"V\u0001\u0000\u0000\u0000\u011f\u0120\u0005w\u0000\u0000\u0120\u0121\u0005"+
		"h\u0000\u0000\u0121\u0122\u0005i\u0000\u0000\u0122\u0123\u0005l\u0000"+
		"\u0000\u0123\u0124\u0005e\u0000\u0000\u0124X\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0005b\u0000\u0000\u0126\u0127\u0005r\u0000\u0000\u0127\u0128\u0005"+
		"e\u0000\u0000\u0128\u0129\u0005a\u0000\u0000\u0129\u012a\u0005k\u0000"+
		"\u0000\u012aZ\u0001\u0000\u0000\u0000\u012b\u012c\u0005c\u0000\u0000\u012c"+
		"\u012d\u0005o\u0000\u0000\u012d\u012e\u0005n\u0000\u0000\u012e\u012f\u0005"+
		"t\u0000\u0000\u012f\u0130\u0005i\u0000\u0000\u0130\u0131\u0005n\u0000"+
		"\u0000\u0131\u0132\u0005u\u0000\u0000\u0132\u0133\u0005e\u0000\u0000\u0133"+
		"\\\u0001\u0000\u0000\u0000\u0134\u0135\u0005r\u0000\u0000\u0135\u0136"+
		"\u0005e\u0000\u0000\u0136\u0137\u0005t\u0000\u0000\u0137\u0138\u0005u"+
		"\u0000\u0000\u0138\u0139\u0005r\u0000\u0000\u0139\u013a\u0005n\u0000\u0000"+
		"\u013a^\u0001\u0000\u0000\u0000\u013b\u013c\u0005M\u0000\u0000\u013c\u013d"+
		"\u0005a\u0000\u0000\u013d\u013e\u0005i\u0000\u0000\u013e\u013f\u0005n"+
		"\u0000\u0000\u013f`\u0001\u0000\u0000\u0000\u0140\u0141\u0005O\u0000\u0000"+
		"\u0141\u0142\u0005n\u0000\u0000\u0142\u0143\u0005I\u0000\u0000\u0143\u0144"+
		"\u0005n\u0000\u0000\u0144\u0145\u0005i\u0000\u0000\u0145\u0146\u0005t"+
		"\u0000\u0000\u0146b\u0001\u0000\u0000\u0000\u0147\u0148\u0005O\u0000\u0000"+
		"\u0148\u0149\u0005n\u0000\u0000\u0149\u014a\u0005S\u0000\u0000\u014a\u014b"+
		"\u0005t\u0000\u0000\u014b\u014c\u0005a\u0000\u0000\u014c\u014d\u0005r"+
		"\u0000\u0000\u014d\u014e\u0005t\u0000\u0000\u014ed\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0005f\u0000\u0000\u0150\u0151\u0005l\u0000\u0000\u0151\u0152"+
		"\u0005o\u0000\u0000\u0152\u0153\u0005a\u0000\u0000\u0153\u0154\u0005t"+
		"\u0000\u0000\u0154f\u0001\u0000\u0000\u0000\u0155\u0156\u0005s\u0000\u0000"+
		"\u0156\u0157\u0005t\u0000\u0000\u0157\u0158\u0005r\u0000\u0000\u0158\u0159"+
		"\u0005i\u0000\u0000\u0159\u015a\u0005n\u0000\u0000\u015a\u015b\u0005g"+
		"\u0000\u0000\u015bh\u0001\u0000\u0000\u0000\u015c\u015d\u0005b\u0000\u0000"+
		"\u015d\u015e\u0005o\u0000\u0000\u015e\u015f\u0005o\u0000\u0000\u015f\u0160"+
		"\u0005l\u0000\u0000\u0160j\u0001\u0000\u0000\u0000\u0161\u0162\u0005v"+
		"\u0000\u0000\u0162\u0163\u0005o\u0000\u0000\u0163\u0164\u0005i\u0000\u0000"+
		"\u0164\u0165\u0005d\u0000\u0000\u0165l\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0005i\u0000\u0000\u0167\u0168\u0005n\u0000\u0000\u0168\u0169\u0005t"+
		"\u0000\u0000\u0169n\u0001\u0000\u0000\u0000\u016a\u016b\u0005B\u0000\u0000"+
		"\u016b\u016c\u0005U\u0000\u0000\u016c\u016d\u0005Y\u0000\u0000\u016dp"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u0005S\u0000\u0000\u016f\u0170\u0005"+
		"E\u0000\u0000\u0170\u0171\u0005L\u0000\u0000\u0171\u0172\u0005L\u0000"+
		"\u0000\u0172r\u0001\u0000\u0000\u0000\u0173\u0174\u0005A\u0000\u0000\u0174"+
		"\u0175\u0005s\u0000\u0000\u0175\u0176\u0005k\u0000\u0000\u0176t\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0005B\u0000\u0000\u0178\u0179\u0005i\u0000"+
		"\u0000\u0179\u017a\u0005d\u0000\u0000\u017av\u0001\u0000\u0000\u0000\u017b"+
		"\u017c\u0005T\u0000\u0000\u017c\u017d\u0005i\u0000\u0000\u017d\u017e\u0005"+
		"m\u0000\u0000\u017e\u017f\u0005e\u0000\u0000\u017fx\u0001\u0000\u0000"+
		"\u0000\u0180\u0181\u0005H\u0000\u0000\u0181\u0182\u0005i\u0000\u0000\u0182"+
		"\u0183\u0005g\u0000\u0000\u0183\u0184\u0005h\u0000\u0000\u0184z\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0005L\u0000\u0000\u0186\u0187\u0005o\u0000"+
		"\u0000\u0187\u0188\u0005w\u0000\u0000\u0188|\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u0005D\u0000\u0000\u018a\u018b\u0005i\u0000\u0000\u018b\u018c\u0005"+
		"g\u0000\u0000\u018c\u018d\u0005i\u0000\u0000\u018d\u018e\u0005t\u0000"+
		"\u0000\u018e\u018f\u0005s\u0000\u0000\u018f~\u0001\u0000\u0000\u0000\u0190"+
		"\u0191\u0005V\u0000\u0000\u0191\u0192\u0005o\u0000\u0000\u0192\u0193\u0005"+
		"l\u0000\u0000\u0193\u0194\u0005u\u0000\u0000\u0194\u0195\u0005m\u0000"+
		"\u0000\u0195\u0196\u0005e\u0000\u0000\u0196\u0080\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0005T\u0000\u0000\u0198\u0199\u0005y\u0000\u0000\u0199\u019a"+
		"\u0005p\u0000\u0000\u019a\u019b\u0005e\u0000\u0000\u019b\u0082\u0001\u0000"+
		"\u0000\u0000\u019c\u019d\u0005T\u0000\u0000\u019d\u019e\u0005e\u0000\u0000"+
		"\u019e\u019f\u0005x\u0000\u0000\u019f\u01a0\u0005t\u0000\u0000\u01a0\u0084"+
		"\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005O\u0000\u0000\u01a2\u01a3\u0005"+
		"p\u0000\u0000\u01a3\u01a4\u0005e\u0000\u0000\u01a4\u01a5\u0005n\u0000"+
		"\u0000\u01a5\u0086\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005C\u0000\u0000"+
		"\u01a7\u01a8\u0005l\u0000\u0000\u01a8\u01a9\u0005o\u0000\u0000\u01a9\u01aa"+
		"\u0005s\u0000\u0000\u01aa\u01ab\u0005e\u0000\u0000\u01ab\u0088\u0001\u0000"+
		"\u0000\u0000\u01ac\u01ad\u0005T\u0000\u0000\u01ad\u01ae\u0005r\u0000\u0000"+
		"\u01ae\u01af\u0005a\u0000\u0000\u01af\u01b0\u0005d\u0000\u0000\u01b0\u01b1"+
		"\u0005e\u0000\u0000\u01b1\u008a\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005"+
		"O\u0000\u0000\u01b3\u01b4\u0005r\u0000\u0000\u01b4\u01b5\u0005d\u0000"+
		"\u0000\u01b5\u01b6\u0005e\u0000\u0000\u01b6\u01b7\u0005r\u0000\u0000\u01b7"+
		"\u008c\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005C\u0000\u0000\u01b9\u01ba"+
		"\u0005a\u0000\u0000\u01ba\u01bb\u0005n\u0000\u0000\u01bb\u01bc\u0005d"+
		"\u0000\u0000\u01bc\u01bd\u0005l\u0000\u0000\u01bd\u01be\u0005e\u0000\u0000"+
		"\u01be\u008e\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005E\u0000\u0000\u01c0"+
		"\u01c1\u0005x\u0000\u0000\u01c1\u01c2\u0005c\u0000\u0000\u01c2\u01c3\u0005"+
		"e\u0000\u0000\u01c3\u01c4\u0005p\u0000\u0000\u01c4\u01c5\u0005t\u0000"+
		"\u0000\u01c5\u01c6\u0005i\u0000\u0000\u01c6\u01c7\u0005o\u0000\u0000\u01c7"+
		"\u01c8\u0005n\u0000\u0000\u01c8\u0090\u0001\u0000\u0000\u0000\u01c9\u01ca"+
		"\u0005R\u0000\u0000\u01ca\u01cb\u0005e\u0000\u0000\u01cb\u01cc\u0005f"+
		"\u0000\u0000\u01cc\u01cd\u0005r\u0000\u0000\u01cd\u01ce\u0005e\u0000\u0000"+
		"\u01ce\u01cf\u0005s\u0000\u0000\u01cf\u01d0\u0005h\u0000\u0000\u01d0\u01d1"+
		"\u0005R\u0000\u0000\u01d1\u01d2\u0005a\u0000\u0000\u01d2\u01d3\u0005t"+
		"\u0000\u0000\u01d3\u01d4\u0005e\u0000\u0000\u01d4\u0092\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d6\u0005G\u0000\u0000\u01d6\u01d7\u0005e\u0000\u0000\u01d7"+
		"\u01d8\u0005t\u0000\u0000\u01d8\u01d9\u0005C\u0000\u0000\u01d9\u01da\u0005"+
		"a\u0000\u0000\u01da\u01db\u0005n\u0000\u0000\u01db\u01dc\u0005d\u0000"+
		"\u0000\u01dc\u01dd\u0005l\u0000\u0000\u01dd\u01de\u0005e\u0000\u0000\u01de"+
		"\u0094\u0001\u0000\u0000\u0000\u01df\u01e0\u0005T\u0000\u0000\u01e0\u01e1"+
		"\u0005e\u0000\u0000\u01e1\u01e2\u0005r\u0000\u0000\u01e2\u01e3\u0005m"+
		"\u0000\u0000\u01e3\u01e4\u0005i\u0000\u0000\u01e4\u01e5\u0005n\u0000\u0000"+
		"\u01e5\u01e6\u0005a\u0000\u0000\u01e6\u01e7\u0005t\u0000\u0000\u01e7\u01e8"+
		"\u0005e\u0000\u0000\u01e8\u0096\u0001\u0000\u0000\u0000\u01e9\u01ea\u0005"+
		"C\u0000\u0000\u01ea\u01eb\u0005o\u0000\u0000\u01eb\u01ec\u0005n\u0000"+
		"\u0000\u01ec\u01ed\u0005n\u0000\u0000\u01ed\u01ee\u0005e\u0000\u0000\u01ee"+
		"\u01ef\u0005c\u0000\u0000\u01ef\u01f0\u0005t\u0000\u0000\u01f0\u0098\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f2\u0005O\u0000\u0000\u01f2\u01f3\u0005b\u0000"+
		"\u0000\u01f3\u01f4\u0005s\u0000\u0000\u01f4\u01f5\u0005e\u0000\u0000\u01f5"+
		"\u01f6\u0005r\u0000\u0000\u01f6\u01f7\u0005v\u0000\u0000\u01f7\u01f8\u0005"+
		"e\u0000\u0000\u01f8\u009a\u0001\u0000\u0000\u0000\u01f9\u01fa\u0005P\u0000"+
		"\u0000\u01fa\u01fb\u0005r\u0000\u0000\u01fb\u01fc\u0005i\u0000\u0000\u01fc"+
		"\u01fd\u0005n\u0000\u0000\u01fd\u01fe\u0005t\u0000\u0000\u01fe\u009c\u0001"+
		"\u0000\u0000\u0000\u01ff\u0203\u0007\u0001\u0000\u0000\u0200\u0202\u0007"+
		"\u0002\u0000\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202\u0205\u0001"+
		"\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0203\u0204\u0001"+
		"\u0000\u0000\u0000\u0204\u009e\u0001\u0000\u0000\u0000\u0205\u0203\u0001"+
		"\u0000\u0000\u0000\u0206\u020a\u0007\u0003\u0000\u0000\u0207\u0209\u0007"+
		"\u0004\u0000\u0000\u0208\u0207\u0001\u0000\u0000\u0000\u0209\u020c\u0001"+
		"\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020a\u020b\u0001"+
		"\u0000\u0000\u0000\u020b\u020f\u0001\u0000\u0000\u0000\u020c\u020a\u0001"+
		"\u0000\u0000\u0000\u020d\u020f\u00050\u0000\u0000\u020e\u0206\u0001\u0000"+
		"\u0000\u0000\u020e\u020d\u0001\u0000\u0000\u0000\u020f\u00a0\u0001\u0000"+
		"\u0000\u0000\u0210\u0212\u0007\u0004\u0000\u0000\u0211\u0210\u0001\u0000"+
		"\u0000\u0000\u0212\u0215\u0001\u0000\u0000\u0000\u0213\u0211\u0001\u0000"+
		"\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u0216\u0001\u0000"+
		"\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0216\u0218\u0005.\u0000"+
		"\u0000\u0217\u0219\u0007\u0004\u0000\u0000\u0218\u0217\u0001\u0000\u0000"+
		"\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u0218\u0001\u0000\u0000"+
		"\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u00a2\u0001\u0000\u0000"+
		"\u0000\u021c\u0220\u0005\"\u0000\u0000\u021d\u021f\b\u0005\u0000\u0000"+
		"\u021e\u021d\u0001\u0000\u0000\u0000\u021f\u0222\u0001\u0000\u0000\u0000"+
		"\u0220\u021e\u0001\u0000\u0000\u0000\u0220\u0221\u0001\u0000\u0000\u0000"+
		"\u0221\u0223\u0001\u0000\u0000\u0000\u0222\u0220\u0001\u0000\u0000\u0000"+
		"\u0223\u0224\u0005\"\u0000\u0000\u0224\u00a4\u0001\u0000\u0000\u0000\u0225"+
		"\u0226\u0005/\u0000\u0000\u0226\u0227\u0005/\u0000\u0000\u0227\u022b\u0001"+
		"\u0000\u0000\u0000\u0228\u022a\b\u0006\u0000\u0000\u0229\u0228\u0001\u0000"+
		"\u0000\u0000\u022a\u022d\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000"+
		"\u0000\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u023a\u0001\u0000"+
		"\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u022f\u0005/\u0000"+
		"\u0000\u022f\u0230\u0005*\u0000\u0000\u0230\u0234\u0001\u0000\u0000\u0000"+
		"\u0231\u0233\t\u0000\u0000\u0000\u0232\u0231\u0001\u0000\u0000\u0000\u0233"+
		"\u0236\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000\u0000\u0000\u0234"+
		"\u0232\u0001\u0000\u0000\u0000\u0235\u0237\u0001\u0000\u0000\u0000\u0236"+
		"\u0234\u0001\u0000\u0000\u0000\u0237\u0238\u0005*\u0000\u0000\u0238\u023a"+
		"\u0005/\u0000\u0000\u0239\u0225\u0001\u0000\u0000\u0000\u0239\u022e\u0001"+
		"\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023c\u0006"+
		"R\u0000\u0000\u023c\u00a6\u0001\u0000\u0000\u0000\u000b\u0000\u00aa\u0203"+
		"\u020a\u020e\u0213\u021a\u0220\u022b\u0234\u0239\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}