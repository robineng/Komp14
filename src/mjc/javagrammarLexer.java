// Generated from javagrammar.g4 by ANTLR 4.2

    package mjc;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class javagrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, COMMENT1=3, COMMENT2=4, COMMENT3=5, CLASS=6, PUBLIC=7, STATIC=8, 
		VOID=9, IF=10, ELSE=11, WHILE=12, NEW=13, RETURN=14, THIS=15, SYSO=16, 
		LENGTH=17, BOOLEAN=18, INT=19, STRING=20, LONG=21, LEFTBRACKET=22, RIGHTBRACKET=23, 
		LEFTPAREN=24, RIGHTPAREN=25, LEFTBRACE=26, RIGHTBRACE=27, DOT=28, COMMA=29, 
		COLON=30, SEMICOLON=31, PLUS=32, MINUS=33, MULT=34, ASSIGNMENT=35, NOT=36, 
		AND=37, OR=38, LESSTHAN=39, MORETHAN=40, LEQ=41, MEQ=42, EQ=43, NEQ=44, 
		TRUE=45, FALSE=46, INT_LIT=47, LONG_LIT=48, ID=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'main'", "WS", "COMMENT1", "COMMENT2", "COMMENT3", "'class'", "'public'", 
		"'static'", "'void'", "'if'", "'else'", "'while'", "'new'", "'return'", 
		"'this'", "'System.out.println'", "'length'", "'boolean'", "'int'", "'String'", 
		"'long'", "'['", "']'", "'('", "')'", "'{'", "'}'", "'.'", "','", "':'", 
		"';'", "'+'", "'-'", "'*'", "'='", "'!'", "'&&'", "'||'", "'<'", "'>'", 
		"'<='", "'>='", "'=='", "'!='", "'true'", "'false'", "INT_LIT", "LONG_LIT", 
		"ID"
	};
	public static final String[] ruleNames = {
		"T__0", "WS", "COMMENT1", "COMMENT2", "COMMENT3", "CLASS", "PUBLIC", "STATIC", 
		"VOID", "IF", "ELSE", "WHILE", "NEW", "RETURN", "THIS", "SYSO", "LENGTH", 
		"BOOLEAN", "INT", "STRING", "LONG", "LEFTBRACKET", "RIGHTBRACKET", "LEFTPAREN", 
		"RIGHTPAREN", "LEFTBRACE", "RIGHTBRACE", "DOT", "COMMA", "COLON", "SEMICOLON", 
		"PLUS", "MINUS", "MULT", "ASSIGNMENT", "NOT", "AND", "OR", "LESSTHAN", 
		"MORETHAN", "LEQ", "MEQ", "EQ", "NEQ", "TRUE", "FALSE", "INT_LIT", "LONG_LIT", 
		"ID"
	};


	public javagrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "javagrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u0161\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\6\3l\n\3\r\3\16\3m\3\3\3\3\3\4\3\4\3\4\3\4\7\4v\n\4\f\4\16"+
		"\4y\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u0083\n\5\f\5\16\5\u0086"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6\u0092\n\6\f\6\16\6\u0095"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+"+
		"\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\7\60"+
		"\u0148\n\60\f\60\16\60\u014b\13\60\5\60\u014d\n\60\3\61\3\61\3\61\3\61"+
		"\7\61\u0153\n\61\f\61\16\61\u0156\13\61\3\61\5\61\u0159\n\61\3\62\3\62"+
		"\7\62\u015d\n\62\f\62\16\62\u0160\13\62\5w\u0084\u0093\2\63\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\7\5\2\13\f\17\17\"\"\3"+
		"\2\f\f\4\2NNnn\5\2C\\aac|\6\2\62;C\\aac|\u0169\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2"+
		"\2\2\5k\3\2\2\2\7q\3\2\2\2\t~\3\2\2\2\13\u008c\3\2\2\2\r\u009c\3\2\2\2"+
		"\17\u00a2\3\2\2\2\21\u00a9\3\2\2\2\23\u00b0\3\2\2\2\25\u00b5\3\2\2\2\27"+
		"\u00b8\3\2\2\2\31\u00bd\3\2\2\2\33\u00c3\3\2\2\2\35\u00c7\3\2\2\2\37\u00ce"+
		"\3\2\2\2!\u00d3\3\2\2\2#\u00e6\3\2\2\2%\u00ed\3\2\2\2\'\u00f5\3\2\2\2"+
		")\u00f9\3\2\2\2+\u0100\3\2\2\2-\u0105\3\2\2\2/\u0107\3\2\2\2\61\u0109"+
		"\3\2\2\2\63\u010b\3\2\2\2\65\u010d\3\2\2\2\67\u010f\3\2\2\29\u0111\3\2"+
		"\2\2;\u0113\3\2\2\2=\u0115\3\2\2\2?\u0117\3\2\2\2A\u0119\3\2\2\2C\u011b"+
		"\3\2\2\2E\u011d\3\2\2\2G\u011f\3\2\2\2I\u0121\3\2\2\2K\u0123\3\2\2\2M"+
		"\u0126\3\2\2\2O\u0129\3\2\2\2Q\u012b\3\2\2\2S\u012d\3\2\2\2U\u0130\3\2"+
		"\2\2W\u0133\3\2\2\2Y\u0136\3\2\2\2[\u0139\3\2\2\2]\u013e\3\2\2\2_\u014c"+
		"\3\2\2\2a\u0158\3\2\2\2c\u015a\3\2\2\2ef\7o\2\2fg\7c\2\2gh\7k\2\2hi\7"+
		"p\2\2i\4\3\2\2\2jl\t\2\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3"+
		"\2\2\2op\b\3\2\2p\6\3\2\2\2qr\7\61\2\2rs\7\61\2\2sw\3\2\2\2tv\13\2\2\2"+
		"ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\t\3\2\2"+
		"{|\3\2\2\2|}\b\4\2\2}\b\3\2\2\2~\177\7\61\2\2\177\u0080\7,\2\2\u0080\u0084"+
		"\3\2\2\2\u0081\u0083\13\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u0088\7,\2\2\u0088\u0089\7\61\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\b\5\2\2\u008b\n\3\2\2\2\u008c\u008d\7\61\2\2\u008d\u008e\7,\2\2"+
		"\u008e\u008f\7,\2\2\u008f\u0093\3\2\2\2\u0090\u0092\13\2\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7,\2\2\u0097\u0098\7,\2"+
		"\2\u0098\u0099\7\61\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\6\2\2\u009b"+
		"\f\3\2\2\2\u009c\u009d\7e\2\2\u009d\u009e\7n\2\2\u009e\u009f\7c\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7u\2\2\u00a1\16\3\2\2\2\u00a2\u00a3\7r\2\2\u00a3"+
		"\u00a4\7w\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7k\2\2"+
		"\u00a7\u00a8\7e\2\2\u00a8\20\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7"+
		"v\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7e\2\2\u00af\22\3\2\2\2\u00b0\u00b1\7x\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3"+
		"\7k\2\2\u00b3\u00b4\7f\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7"+
		"\7h\2\2\u00b7\26\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb"+
		"\7u\2\2\u00bb\u00bc\7g\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7y\2\2\u00be\u00bf"+
		"\7j\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7g\2\2\u00c2"+
		"\32\3\2\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7y\2\2\u00c6"+
		"\34\3\2\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		"\u00cb\7w\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7p\2\2\u00cd\36\3\2\2\2\u00ce"+
		"\u00cf\7v\2\2\u00cf\u00d0\7j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7u\2\2"+
		"\u00d2 \3\2\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d5\7{\2\2\u00d5\u00d6\7u\2"+
		"\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7o\2\2\u00d9\u00da"+
		"\7\60\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7w\2\2\u00dc\u00dd\7v\2\2\u00dd"+
		"\u00de\7\60\2\2\u00de\u00df\7r\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7k\2"+
		"\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5"+
		"\7p\2\2\u00e5\"\3\2\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9"+
		"\7p\2\2\u00e9\u00ea\7i\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7j\2\2\u00ec"+
		"$\3\2\2\2\u00ed\u00ee\7d\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7q\2\2\u00f0"+
		"\u00f1\7n\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7p\2\2"+
		"\u00f4&\3\2\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7v\2"+
		"\2\u00f8(\3\2\2\2\u00f9\u00fa\7U\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7"+
		"t\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7i\2\2\u00ff*"+
		"\3\2\2\2\u0100\u0101\7n\2\2\u0101\u0102\7q\2\2\u0102\u0103\7p\2\2\u0103"+
		"\u0104\7i\2\2\u0104,\3\2\2\2\u0105\u0106\7]\2\2\u0106.\3\2\2\2\u0107\u0108"+
		"\7_\2\2\u0108\60\3\2\2\2\u0109\u010a\7*\2\2\u010a\62\3\2\2\2\u010b\u010c"+
		"\7+\2\2\u010c\64\3\2\2\2\u010d\u010e\7}\2\2\u010e\66\3\2\2\2\u010f\u0110"+
		"\7\177\2\2\u01108\3\2\2\2\u0111\u0112\7\60\2\2\u0112:\3\2\2\2\u0113\u0114"+
		"\7.\2\2\u0114<\3\2\2\2\u0115\u0116\7<\2\2\u0116>\3\2\2\2\u0117\u0118\7"+
		"=\2\2\u0118@\3\2\2\2\u0119\u011a\7-\2\2\u011aB\3\2\2\2\u011b\u011c\7/"+
		"\2\2\u011cD\3\2\2\2\u011d\u011e\7,\2\2\u011eF\3\2\2\2\u011f\u0120\7?\2"+
		"\2\u0120H\3\2\2\2\u0121\u0122\7#\2\2\u0122J\3\2\2\2\u0123\u0124\7(\2\2"+
		"\u0124\u0125\7(\2\2\u0125L\3\2\2\2\u0126\u0127\7~\2\2\u0127\u0128\7~\2"+
		"\2\u0128N\3\2\2\2\u0129\u012a\7>\2\2\u012aP\3\2\2\2\u012b\u012c\7@\2\2"+
		"\u012cR\3\2\2\2\u012d\u012e\7>\2\2\u012e\u012f\7?\2\2\u012fT\3\2\2\2\u0130"+
		"\u0131\7@\2\2\u0131\u0132\7?\2\2\u0132V\3\2\2\2\u0133\u0134\7?\2\2\u0134"+
		"\u0135\7?\2\2\u0135X\3\2\2\2\u0136\u0137\7#\2\2\u0137\u0138\7?\2\2\u0138"+
		"Z\3\2\2\2\u0139\u013a\7v\2\2\u013a\u013b\7t\2\2\u013b\u013c\7w\2\2\u013c"+
		"\u013d\7g\2\2\u013d\\\3\2\2\2\u013e\u013f\7h\2\2\u013f\u0140\7c\2\2\u0140"+
		"\u0141\7n\2\2\u0141\u0142\7u\2\2\u0142\u0143\7g\2\2\u0143^\3\2\2\2\u0144"+
		"\u014d\7\62\2\2\u0145\u0149\4\63;\2\u0146\u0148\4\62;\2\u0147\u0146\3"+
		"\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0144\3\2\2\2\u014c\u0145\3\2"+
		"\2\2\u014d`\3\2\2\2\u014e\u014f\7\62\2\2\u014f\u0159\t\4\2\2\u0150\u0154"+
		"\4\63;\2\u0151\u0153\4\62;\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0157\u0159\t\4\2\2\u0158\u014e\3\2\2\2\u0158\u0150\3\2\2\2\u0159"+
		"b\3\2\2\2\u015a\u015e\t\5\2\2\u015b\u015d\t\6\2\2\u015c\u015b\3\2\2\2"+
		"\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015fd\3"+
		"\2\2\2\u0160\u015e\3\2\2\2\f\2mw\u0084\u0093\u0149\u014c\u0154\u0158\u015e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}