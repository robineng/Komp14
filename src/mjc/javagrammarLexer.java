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
		WS=1, LINE_COMMENT=2, COMMENT2=3, CLASS=4, PUBLIC=5, STATIC=6, VOID=7, 
		IF=8, ELSE=9, WHILE=10, NEW=11, RETURN=12, THIS=13, SYSO=14, LENGTH=15, 
		BOOLEAN=16, INT=17, STRING=18, LONG=19, LEFTBRACKET=20, RIGHTBRACKET=21, 
		LEFTPAREN=22, RIGHTPAREN=23, LEFTBRACE=24, RIGHTBRACE=25, DOT=26, COMMA=27, 
		COLON=28, SEMICOLON=29, PLUS=30, MINUS=31, MULT=32, ASSIGNMENT=33, NOT=34, 
		AND=35, OR=36, LESSTHAN=37, MORETHAN=38, LEQ=39, MEQ=40, EQ=41, NEQ=42, 
		TRUE=43, FALSE=44, INT_LIT=45, LONG_LIT=46, ID=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WS", "LINE_COMMENT", "COMMENT2", "'class'", "'public'", "'static'", "'void'", 
		"'if'", "'else'", "'while'", "'new'", "'return'", "'this'", "'System.out.println'", 
		"'length'", "'boolean'", "'int'", "'String'", "'long'", "'['", "']'", 
		"'('", "')'", "'{'", "'}'", "'.'", "','", "':'", "';'", "'+'", "'-'", 
		"'*'", "'='", "'!'", "'&&'", "'||'", "'<'", "'>'", "'<='", "'>='", "'=='", 
		"'!='", "'true'", "'false'", "INT_LIT", "LONG_LIT", "ID"
	};
	public static final String[] ruleNames = {
		"WS", "LINE_COMMENT", "COMMENT2", "CLASS", "PUBLIC", "STATIC", "VOID", 
		"IF", "ELSE", "WHILE", "NEW", "RETURN", "THIS", "SYSO", "LENGTH", "BOOLEAN", 
		"INT", "STRING", "LONG", "LEFTBRACKET", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", 
		"LEFTBRACE", "RIGHTBRACE", "DOT", "COMMA", "COLON", "SEMICOLON", "PLUS", 
		"MINUS", "MULT", "ASSIGNMENT", "NOT", "AND", "OR", "LESSTHAN", "MORETHAN", 
		"LEQ", "MEQ", "EQ", "NEQ", "TRUE", "FALSE", "INT_LIT", "LONG_LIT", "ID"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  skip();  break;

		case 1:  skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0156\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\6\2c\n\2\r\2\16\2d\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\3\3\3\3\5\3u\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3|\n\3\f\3\16\3\177\13\3\3\3\5\3\u0082\n\3\3\4\3\4\3\4\3\4"+
		"\7\4\u0088\n\4\f\4\16\4\u008b\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3"+
		"-\3-\3.\3.\3.\7.\u013d\n.\f.\16.\u0140\13.\5.\u0142\n.\3/\3/\3/\3/\7/"+
		"\u0148\n/\f/\16/\u014b\13/\3/\5/\u014e\n/\3\60\3\60\7\60\u0152\n\60\f"+
		"\60\16\60\u0155\13\60\3\u0089\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61\3\2\7\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2NNnn\5\2C\\aac|\6"+
		"\2\62;C\\aac|\u0160\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\3b\3\2\2\2\5\u0081\3\2\2\2\7\u0083\3\2\2\2\t\u0091\3\2"+
		"\2\2\13\u0097\3\2\2\2\r\u009e\3\2\2\2\17\u00a5\3\2\2\2\21\u00aa\3\2\2"+
		"\2\23\u00ad\3\2\2\2\25\u00b2\3\2\2\2\27\u00b8\3\2\2\2\31\u00bc\3\2\2\2"+
		"\33\u00c3\3\2\2\2\35\u00c8\3\2\2\2\37\u00db\3\2\2\2!\u00e2\3\2\2\2#\u00ea"+
		"\3\2\2\2%\u00ee\3\2\2\2\'\u00f5\3\2\2\2)\u00fa\3\2\2\2+\u00fc\3\2\2\2"+
		"-\u00fe\3\2\2\2/\u0100\3\2\2\2\61\u0102\3\2\2\2\63\u0104\3\2\2\2\65\u0106"+
		"\3\2\2\2\67\u0108\3\2\2\29\u010a\3\2\2\2;\u010c\3\2\2\2=\u010e\3\2\2\2"+
		"?\u0110\3\2\2\2A\u0112\3\2\2\2C\u0114\3\2\2\2E\u0116\3\2\2\2G\u0118\3"+
		"\2\2\2I\u011b\3\2\2\2K\u011e\3\2\2\2M\u0120\3\2\2\2O\u0122\3\2\2\2Q\u0125"+
		"\3\2\2\2S\u0128\3\2\2\2U\u012b\3\2\2\2W\u012e\3\2\2\2Y\u0133\3\2\2\2["+
		"\u0141\3\2\2\2]\u014d\3\2\2\2_\u014f\3\2\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2"+
		"\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\2\2\2g\4\3\2\2\2hi\7\61\2\2ij\7"+
		"\61\2\2jn\3\2\2\2km\n\3\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2ot"+
		"\3\2\2\2pn\3\2\2\2qr\7\17\2\2ru\7\f\2\2su\t\3\2\2tq\3\2\2\2ts\3\2\2\2"+
		"uv\3\2\2\2v\u0082\b\3\3\2wx\7\61\2\2xy\7\61\2\2y}\3\2\2\2z|\n\3\2\2{z"+
		"\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2"+
		"\u0080\u0082\b\3\4\2\u0081h\3\2\2\2\u0081w\3\2\2\2\u0082\6\3\2\2\2\u0083"+
		"\u0084\7\61\2\2\u0084\u0085\7,\2\2\u0085\u0089\3\2\2\2\u0086\u0088\13"+
		"\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u008a\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7,"+
		"\2\2\u008d\u008e\7\61\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\4\2\2\u0090"+
		"\b\3\2\2\2\u0091\u0092\7e\2\2\u0092\u0093\7n\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7u\2\2\u0095\u0096\7u\2\2\u0096\n\3\2\2\2\u0097\u0098\7r\2\2\u0098"+
		"\u0099\7w\2\2\u0099\u009a\7d\2\2\u009a\u009b\7n\2\2\u009b\u009c\7k\2\2"+
		"\u009c\u009d\7e\2\2\u009d\f\3\2\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7v"+
		"\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4"+
		"\7e\2\2\u00a4\16\3\2\2\2\u00a5\u00a6\7x\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8"+
		"\7k\2\2\u00a8\u00a9\7f\2\2\u00a9\20\3\2\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac"+
		"\7h\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7n\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0\u00b1\7g\2\2\u00b1\24\3\2\2\2\u00b2\u00b3\7y\2\2\u00b3\u00b4"+
		"\7j\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7g\2\2\u00b7"+
		"\26\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7y\2\2\u00bb"+
		"\30\3\2\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7v\2\2\u00bf"+
		"\u00c0\7w\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7p\2\2\u00c2\32\3\2\2\2\u00c3"+
		"\u00c4\7v\2\2\u00c4\u00c5\7j\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7u\2\2"+
		"\u00c7\34\3\2\2\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7{\2\2\u00ca\u00cb\7"+
		"u\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf"+
		"\7\60\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\7v\2\2\u00d2"+
		"\u00d3\7\60\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7k\2"+
		"\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7n\2\2\u00d9\u00da"+
		"\7p\2\2\u00da\36\3\2\2\2\u00db\u00dc\7n\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de"+
		"\7p\2\2\u00de\u00df\7i\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7j\2\2\u00e1"+
		" \3\2\2\2\u00e2\u00e3\7d\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7q\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7p\2\2"+
		"\u00e9\"\3\2\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7v"+
		"\2\2\u00ed$\3\2\2\2\u00ee\u00ef\7U\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1"+
		"\7t\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7i\2\2\u00f4"+
		"&\3\2\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7p\2\2\u00f8"+
		"\u00f9\7i\2\2\u00f9(\3\2\2\2\u00fa\u00fb\7]\2\2\u00fb*\3\2\2\2\u00fc\u00fd"+
		"\7_\2\2\u00fd,\3\2\2\2\u00fe\u00ff\7*\2\2\u00ff.\3\2\2\2\u0100\u0101\7"+
		"+\2\2\u0101\60\3\2\2\2\u0102\u0103\7}\2\2\u0103\62\3\2\2\2\u0104\u0105"+
		"\7\177\2\2\u0105\64\3\2\2\2\u0106\u0107\7\60\2\2\u0107\66\3\2\2\2\u0108"+
		"\u0109\7.\2\2\u01098\3\2\2\2\u010a\u010b\7<\2\2\u010b:\3\2\2\2\u010c\u010d"+
		"\7=\2\2\u010d<\3\2\2\2\u010e\u010f\7-\2\2\u010f>\3\2\2\2\u0110\u0111\7"+
		"/\2\2\u0111@\3\2\2\2\u0112\u0113\7,\2\2\u0113B\3\2\2\2\u0114\u0115\7?"+
		"\2\2\u0115D\3\2\2\2\u0116\u0117\7#\2\2\u0117F\3\2\2\2\u0118\u0119\7(\2"+
		"\2\u0119\u011a\7(\2\2\u011aH\3\2\2\2\u011b\u011c\7~\2\2\u011c\u011d\7"+
		"~\2\2\u011dJ\3\2\2\2\u011e\u011f\7>\2\2\u011fL\3\2\2\2\u0120\u0121\7@"+
		"\2\2\u0121N\3\2\2\2\u0122\u0123\7>\2\2\u0123\u0124\7?\2\2\u0124P\3\2\2"+
		"\2\u0125\u0126\7@\2\2\u0126\u0127\7?\2\2\u0127R\3\2\2\2\u0128\u0129\7"+
		"?\2\2\u0129\u012a\7?\2\2\u012aT\3\2\2\2\u012b\u012c\7#\2\2\u012c\u012d"+
		"\7?\2\2\u012dV\3\2\2\2\u012e\u012f\7v\2\2\u012f\u0130\7t\2\2\u0130\u0131"+
		"\7w\2\2\u0131\u0132\7g\2\2\u0132X\3\2\2\2\u0133\u0134\7h\2\2\u0134\u0135"+
		"\7c\2\2\u0135\u0136\7n\2\2\u0136\u0137\7u\2\2\u0137\u0138\7g\2\2\u0138"+
		"Z\3\2\2\2\u0139\u0142\7\62\2\2\u013a\u013e\4\63;\2\u013b\u013d\4\62;\2"+
		"\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0139\3\2\2\2\u0141"+
		"\u013a\3\2\2\2\u0142\\\3\2\2\2\u0143\u0144\7\62\2\2\u0144\u014e\t\4\2"+
		"\2\u0145\u0149\4\63;\2\u0146\u0148\4\62;\2\u0147\u0146\3\2\2\2\u0148\u014b"+
		"\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014e\t\4\2\2\u014d\u0143\3\2\2\2\u014d\u0145\3\2"+
		"\2\2\u014e^\3\2\2\2\u014f\u0153\t\5\2\2\u0150\u0152\t\6\2\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"`\3\2\2\2\u0155\u0153\3\2\2\2\16\2dnt}\u0081\u0089\u013e\u0141\u0149\u014d"+
		"\u0153\5\b\2\2\3\3\2\3\3\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}