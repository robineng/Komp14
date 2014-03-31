package mjc;// Generated from javagrammar.g4 by ANTLR 4.2
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
		T__0=1, WS=2, CLASS=3, PUBLIC=4, STATIC=5, VOID=6, IF=7, ELSE=8, WHILE=9, 
		NEW=10, RETURN=11, THIS=12, SYSO=13, LENGTH=14, BOOLEAN=15, INT=16, STRING=17, 
		LONG=18, LEFTBRACKET=19, RIGHTBRACKET=20, LEFTPAREN=21, RIGHTPAREN=22, 
		LEFTBRACE=23, RIGHTBRACE=24, DOT=25, COMMA=26, COLON=27, SEMICOLON=28, 
		PLUS=29, MINUS=30, MULT=31, ASSIGNMENT=32, NOT=33, AND=34, OR=35, LESSTHAN=36, 
		MORETHAN=37, LEQ=38, MEQ=39, EQ=40, NEQ=41, TRUE=42, FALSE=43, INT_LIT=44, 
		LONG_LIT=45, ID=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'main'", "WS", "'class'", "'public'", "'static'", "'void'", "'if'", "'else'", 
		"'while'", "'new'", "'return'", "'this'", "'System.out.println'", "'length'", 
		"'boolean'", "'int'", "'String'", "'long'", "'['", "']'", "'('", "')'", 
		"'{'", "'}'", "'.'", "','", "':'", "';'", "'+'", "'-'", "'*'", "'='", 
		"'!'", "'&&'", "'||'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'true'", 
		"'false'", "INT_LIT", "LONG_LIT", "ID"
	};
	public static final String[] ruleNames = {
		"T__0", "WS", "CLASS", "PUBLIC", "STATIC", "VOID", "IF", "ELSE", "WHILE", 
		"NEW", "RETURN", "THIS", "SYSO", "LENGTH", "BOOLEAN", "INT", "STRING", 
		"LONG", "LEFTBRACKET", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "LEFTBRACE", 
		"RIGHTBRACE", "DOT", "COMMA", "COLON", "SEMICOLON", "PLUS", "MINUS", "MULT", 
		"ASSIGNMENT", "NOT", "AND", "OR", "LESSTHAN", "MORETHAN", "LEQ", "MEQ", 
		"EQ", "NEQ", "TRUE", "FALSE", "INT_LIT", "LONG_LIT", "ID"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0130\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\3\6\3f\n\3\r\3\16\3g\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#"+
		"\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\7-\u0117\n-\f-\16-\u011a\13-\5-\u011c"+
		"\n-\3.\3.\3.\3.\7.\u0122\n.\f.\16.\u0125\13.\3.\5.\u0128\n.\3/\3/\7/\u012c"+
		"\n/\f/\16/\u012f\13/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\6"+
		"\5\2\13\f\17\17\"\"\4\2NNnn\4\2C\\c|\6\2\62;C\\aac|\u0135\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5e\3\2\2\2\7k\3\2"+
		"\2\2\tq\3\2\2\2\13x\3\2\2\2\r\177\3\2\2\2\17\u0084\3\2\2\2\21\u0087\3"+
		"\2\2\2\23\u008c\3\2\2\2\25\u0092\3\2\2\2\27\u0096\3\2\2\2\31\u009d\3\2"+
		"\2\2\33\u00a2\3\2\2\2\35\u00b5\3\2\2\2\37\u00bc\3\2\2\2!\u00c4\3\2\2\2"+
		"#\u00c8\3\2\2\2%\u00cf\3\2\2\2\'\u00d4\3\2\2\2)\u00d6\3\2\2\2+\u00d8\3"+
		"\2\2\2-\u00da\3\2\2\2/\u00dc\3\2\2\2\61\u00de\3\2\2\2\63\u00e0\3\2\2\2"+
		"\65\u00e2\3\2\2\2\67\u00e4\3\2\2\29\u00e6\3\2\2\2;\u00e8\3\2\2\2=\u00ea"+
		"\3\2\2\2?\u00ec\3\2\2\2A\u00ee\3\2\2\2C\u00f0\3\2\2\2E\u00f2\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f8\3\2\2\2K\u00fa\3\2\2\2M\u00fc\3\2\2\2O\u00ff\3\2"+
		"\2\2Q\u0102\3\2\2\2S\u0105\3\2\2\2U\u0108\3\2\2\2W\u010d\3\2\2\2Y\u011b"+
		"\3\2\2\2[\u0127\3\2\2\2]\u0129\3\2\2\2_`\7o\2\2`a\7c\2\2ab\7k\2\2bc\7"+
		"p\2\2c\4\3\2\2\2df\t\2\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3"+
		"\2\2\2ij\b\3\2\2j\6\3\2\2\2kl\7e\2\2lm\7n\2\2mn\7c\2\2no\7u\2\2op\7u\2"+
		"\2p\b\3\2\2\2qr\7r\2\2rs\7w\2\2st\7d\2\2tu\7n\2\2uv\7k\2\2vw\7e\2\2w\n"+
		"\3\2\2\2xy\7u\2\2yz\7v\2\2z{\7c\2\2{|\7v\2\2|}\7k\2\2}~\7e\2\2~\f\3\2"+
		"\2\2\177\u0080\7x\2\2\u0080\u0081\7q\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7f\2\2\u0083\16\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7h\2\2\u0086\20"+
		"\3\2\2\2\u0087\u0088\7g\2\2\u0088\u0089\7n\2\2\u0089\u008a\7u\2\2\u008a"+
		"\u008b\7g\2\2\u008b\22\3\2\2\2\u008c\u008d\7y\2\2\u008d\u008e\7j\2\2\u008e"+
		"\u008f\7k\2\2\u008f\u0090\7n\2\2\u0090\u0091\7g\2\2\u0091\24\3\2\2\2\u0092"+
		"\u0093\7p\2\2\u0093\u0094\7g\2\2\u0094\u0095\7y\2\2\u0095\26\3\2\2\2\u0096"+
		"\u0097\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099\u009a\7w\2\2"+
		"\u009a\u009b\7t\2\2\u009b\u009c\7p\2\2\u009c\30\3\2\2\2\u009d\u009e\7"+
		"v\2\2\u009e\u009f\7j\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7u\2\2\u00a1\32"+
		"\3\2\2\2\u00a2\u00a3\7U\2\2\u00a3\u00a4\7{\2\2\u00a4\u00a5\7u\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7\60\2"+
		"\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad"+
		"\7\60\2\2\u00ad\u00ae\7r\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7k\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7p\2\2"+
		"\u00b4\34\3\2\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7"+
		"p\2\2\u00b8\u00b9\7i\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7j\2\2\u00bb\36"+
		"\3\2\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7q\2\2\u00be\u00bf\7q\2\2\u00bf"+
		"\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7p\2\2"+
		"\u00c3 \3\2\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7v\2"+
		"\2\u00c7\"\3\2\2\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7"+
		"t\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7i\2\2\u00ce$"+
		"\3\2\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7p\2\2\u00d2"+
		"\u00d3\7i\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7]\2\2\u00d5(\3\2\2\2\u00d6\u00d7"+
		"\7_\2\2\u00d7*\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9,\3\2\2\2\u00da\u00db\7"+
		"+\2\2\u00db.\3\2\2\2\u00dc\u00dd\7}\2\2\u00dd\60\3\2\2\2\u00de\u00df\7"+
		"\177\2\2\u00df\62\3\2\2\2\u00e0\u00e1\7\60\2\2\u00e1\64\3\2\2\2\u00e2"+
		"\u00e3\7.\2\2\u00e3\66\3\2\2\2\u00e4\u00e5\7<\2\2\u00e58\3\2\2\2\u00e6"+
		"\u00e7\7=\2\2\u00e7:\3\2\2\2\u00e8\u00e9\7-\2\2\u00e9<\3\2\2\2\u00ea\u00eb"+
		"\7/\2\2\u00eb>\3\2\2\2\u00ec\u00ed\7,\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7"+
		"?\2\2\u00efB\3\2\2\2\u00f0\u00f1\7#\2\2\u00f1D\3\2\2\2\u00f2\u00f3\7("+
		"\2\2\u00f3\u00f4\7(\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7~\2\2\u00f6\u00f7"+
		"\7~\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7>\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7"+
		"@\2\2\u00fbL\3\2\2\2\u00fc\u00fd\7>\2\2\u00fd\u00fe\7?\2\2\u00feN\3\2"+
		"\2\2\u00ff\u0100\7@\2\2\u0100\u0101\7?\2\2\u0101P\3\2\2\2\u0102\u0103"+
		"\7?\2\2\u0103\u0104\7?\2\2\u0104R\3\2\2\2\u0105\u0106\7#\2\2\u0106\u0107"+
		"\7?\2\2\u0107T\3\2\2\2\u0108\u0109\7v\2\2\u0109\u010a\7t\2\2\u010a\u010b"+
		"\7w\2\2\u010b\u010c\7g\2\2\u010cV\3\2\2\2\u010d\u010e\7h\2\2\u010e\u010f"+
		"\7c\2\2\u010f\u0110\7n\2\2\u0110\u0111\7u\2\2\u0111\u0112\7g\2\2\u0112"+
		"X\3\2\2\2\u0113\u011c\7\62\2\2\u0114\u0118\4\63;\2\u0115\u0117\4\62;\2"+
		"\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0113\3\2\2\2\u011b"+
		"\u0114\3\2\2\2\u011cZ\3\2\2\2\u011d\u011e\7\62\2\2\u011e\u0128\t\3\2\2"+
		"\u011f\u0123\4\63;\2\u0120\u0122\4\62;\2\u0121\u0120\3\2\2\2\u0122\u0125"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0128\t\3\2\2\u0127\u011d\3\2\2\2\u0127\u011f\3\2"+
		"\2\2\u0128\\\3\2\2\2\u0129\u012d\t\4\2\2\u012a\u012c\t\5\2\2\u012b\u012a"+
		"\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"^\3\2\2\2\u012f\u012d\3\2\2\2\t\2g\u0118\u011b\u0123\u0127\u012d\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}