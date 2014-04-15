// Generated from javagrammar.g4 by ANTLR 4.2

    package mjc;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class javagrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT1=2, COMMENT2=3, COMMENT3=4, CLASS=5, PUBLIC=6, STATIC=7, 
		VOID=8, IF=9, ELSE=10, WHILE=11, NEW=12, RETURN=13, THIS=14, SYSO=15, 
		LENGTH=16, BOOLEAN=17, INT=18, STRING=19, LONG=20, LEFTBRACKET=21, RIGHTBRACKET=22, 
		LEFTPAREN=23, RIGHTPAREN=24, LEFTBRACE=25, RIGHTBRACE=26, DOT=27, COMMA=28, 
		COLON=29, SEMICOLON=30, PLUS=31, MINUS=32, MULT=33, ASSIGNMENT=34, NOT=35, 
		AND=36, OR=37, LESSTHAN=38, MORETHAN=39, LEQ=40, MEQ=41, EQ=42, NEQ=43, 
		TRUE=44, FALSE=45, INT_LIT=46, LONG_LIT=47, ID=48;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENT1", "COMMENT2", "COMMENT3", "'class'", "'public'", 
		"'static'", "'void'", "'if'", "'else'", "'while'", "'new'", "'return'", 
		"'this'", "'System.out.println'", "'length'", "'boolean'", "'int'", "'String'", 
		"'long'", "'['", "']'", "'('", "')'", "'{'", "'}'", "'.'", "','", "':'", 
		"';'", "'+'", "'-'", "'*'", "'='", "'!'", "'&&'", "'||'", "'<'", "'>'", 
		"'<='", "'>='", "'=='", "'!='", "'true'", "'false'", "INT_LIT", "LONG_LIT", 
		"ID"
	};
	public static final int
		RULE_program = 0, RULE_mainclass = 1, RULE_classdecl = 2, RULE_vardecl = 3, 
		RULE_methoddecl = 4, RULE_formallist = 5, RULE_formalrest = 6, RULE_type = 7, 
		RULE_stmt = 8, RULE_exp = 9, RULE_explist = 10, RULE_exprest = 11;
	public static final String[] ruleNames = {
		"program", "mainclass", "classdecl", "vardecl", "methoddecl", "formallist", 
		"formalrest", "type", "stmt", "exp", "explist", "exprest"
	};

	@Override
	public String getGrammarFileName() { return "javagrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public javagrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ClassdeclContext classdecl(int i) {
			return getRuleContext(ClassdeclContext.class,i);
		}
		public MainclassContext mainclass() {
			return getRuleContext(MainclassContext.class,0);
		}
		public List<ClassdeclContext> classdecl() {
			return getRuleContexts(ClassdeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); mainclass();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(25); classdecl();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainclassContext extends ParserRuleContext {
		public TerminalNode RIGHTBRACKET() { return getToken(javagrammarParser.RIGHTBRACKET, 0); }
		public List<TerminalNode> RIGHTBRACE() { return getTokens(javagrammarParser.RIGHTBRACE); }
		public List<TerminalNode> ID() { return getTokens(javagrammarParser.ID); }
		public TerminalNode VOID() { return getToken(javagrammarParser.VOID, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public List<TerminalNode> LEFTBRACE() { return getTokens(javagrammarParser.LEFTBRACE); }
		public TerminalNode RIGHTBRACE(int i) {
			return getToken(javagrammarParser.RIGHTBRACE, i);
		}
		public TerminalNode CLASS() { return getToken(javagrammarParser.CLASS, 0); }
		public TerminalNode PUBLIC() { return getToken(javagrammarParser.PUBLIC, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(javagrammarParser.LEFTBRACKET, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode RIGHTPAREN() { return getToken(javagrammarParser.RIGHTPAREN, 0); }
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public TerminalNode STATIC() { return getToken(javagrammarParser.STATIC, 0); }
		public TerminalNode LEFTPAREN() { return getToken(javagrammarParser.LEFTPAREN, 0); }
		public TerminalNode LEFTBRACE(int i) {
			return getToken(javagrammarParser.LEFTBRACE, i);
		}
		public TerminalNode STRING() { return getToken(javagrammarParser.STRING, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(javagrammarParser.ID, i);
		}
		public MainclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterMainclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitMainclass(this);
		}
	}

	public final MainclassContext mainclass() throws RecognitionException {
		MainclassContext _localctx = new MainclassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainclass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(CLASS);
			setState(32); match(ID);
			setState(33); match(LEFTBRACE);
			setState(34); match(PUBLIC);
			setState(35); match(STATIC);
			setState(36); match(VOID);
			setState(37);
			if (!(_input.LT(1).getText().matches("main"))) throw new FailedPredicateException(this, "_input.LT(1).getText().matches(\"main\")");
			setState(38); match(ID);
			setState(39); match(LEFTPAREN);
			setState(40); match(STRING);
			setState(41); match(LEFTBRACKET);
			setState(42); match(RIGHTBRACKET);
			setState(43); match(ID);
			setState(44); match(RIGHTPAREN);
			setState(45); match(LEFTBRACE);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(46); vardecl();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(52); stmt();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(RIGHTBRACE);
			setState(59); match(RIGHTBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdeclContext extends ParserRuleContext {
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public MethoddeclContext methoddecl(int i) {
			return getRuleContext(MethoddeclContext.class,i);
		}
		public List<MethoddeclContext> methoddecl() {
			return getRuleContexts(MethoddeclContext.class);
		}
		public TerminalNode RIGHTBRACE() { return getToken(javagrammarParser.RIGHTBRACE, 0); }
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public TerminalNode LEFTBRACE() { return getToken(javagrammarParser.LEFTBRACE, 0); }
		public TerminalNode CLASS() { return getToken(javagrammarParser.CLASS, 0); }
		public ClassdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterClassdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitClassdecl(this);
		}
	}

	public final ClassdeclContext classdecl() throws RecognitionException {
		ClassdeclContext _localctx = new ClassdeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(CLASS);
			setState(62); match(ID);
			setState(63); match(LEFTBRACE);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << ID))) != 0)) {
				{
				{
				setState(64); vardecl();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(70); methoddecl();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76); match(RIGHTBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(javagrammarParser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitVardecl(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); type();
			setState(79); match(ID);
			setState(80); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethoddeclContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(javagrammarParser.SEMICOLON, 0); }
		public FormallistContext formallist() {
			return getRuleContext(FormallistContext.class,0);
		}
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RIGHTBRACE() { return getToken(javagrammarParser.RIGHTBRACE, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public TerminalNode LEFTBRACE() { return getToken(javagrammarParser.LEFTBRACE, 0); }
		public TerminalNode PUBLIC() { return getToken(javagrammarParser.PUBLIC, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode RIGHTPAREN() { return getToken(javagrammarParser.RIGHTPAREN, 0); }
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(javagrammarParser.RETURN, 0); }
		public TerminalNode LEFTPAREN() { return getToken(javagrammarParser.LEFTPAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public MethoddeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methoddecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterMethoddecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitMethoddecl(this);
		}
	}

	public final MethoddeclContext methoddecl() throws RecognitionException {
		MethoddeclContext _localctx = new MethoddeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methoddecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(PUBLIC);
			setState(83); type();
			setState(84); match(ID);
			setState(85); match(LEFTPAREN);
			setState(86); formallist();
			setState(87); match(RIGHTPAREN);
			setState(88); match(LEFTBRACE);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(89); vardecl();
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(95); stmt();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(RETURN);
			setState(102); exp(0);
			setState(103); match(SEMICOLON);
			setState(104); match(RIGHTBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormallistContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public FormalrestContext formalrest(int i) {
			return getRuleContext(FormalrestContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FormalrestContext> formalrest() {
			return getRuleContexts(FormalrestContext.class);
		}
		public FormallistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formallist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterFormallist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitFormallist(this);
		}
	}

	public final FormallistContext formallist() throws RecognitionException {
		FormallistContext _localctx = new FormallistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formallist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << ID))) != 0)) {
				{
				setState(106); type();
				setState(107); match(ID);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(108); formalrest();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalrestContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(javagrammarParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalrest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterFormalrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitFormalrest(this);
		}
	}

	public final FormalrestContext formalrest() throws RecognitionException {
		FormalrestContext _localctx = new FormalrestContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalrest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(COMMA);
			setState(117); type();
			setState(118); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode LEFTBRACKET() { return getToken(javagrammarParser.LEFTBRACKET, 0); }
		public TerminalNode BOOLEAN() { return getToken(javagrammarParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(javagrammarParser.INT, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(javagrammarParser.RIGHTBRACKET, 0); }
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public TerminalNode LONG() { return getToken(javagrammarParser.LONG, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120); match(INT);
				setState(121); match(LEFTBRACKET);
				setState(122); match(RIGHTBRACKET);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); match(BOOLEAN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); match(INT);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125); match(LONG);
				setState(126); match(LEFTBRACKET);
				setState(127); match(RIGHTBRACKET);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(128); match(LONG);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(javagrammarParser.SEMICOLON, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(javagrammarParser.RIGHTBRACKET, 0); }
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public TerminalNode RIGHTBRACE() { return getToken(javagrammarParser.RIGHTBRACE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ASSIGNMENT() { return getToken(javagrammarParser.ASSIGNMENT, 0); }
		public TerminalNode LEFTBRACE() { return getToken(javagrammarParser.LEFTBRACE, 0); }
		public TerminalNode WHILE() { return getToken(javagrammarParser.WHILE, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(javagrammarParser.LEFTBRACKET, 0); }
		public TerminalNode IF() { return getToken(javagrammarParser.IF, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode RIGHTPAREN() { return getToken(javagrammarParser.RIGHTPAREN, 0); }
		public TerminalNode ELSE() { return getToken(javagrammarParser.ELSE, 0); }
		public TerminalNode SYSO() { return getToken(javagrammarParser.SYSO, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LEFTPAREN() { return getToken(javagrammarParser.LEFTPAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		int _la;
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); match(LEFTBRACE);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(133); stmt();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139); match(RIGHTBRACE);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); match(IF);
				setState(141); match(LEFTPAREN);
				setState(142); exp(0);
				setState(143); match(RIGHTPAREN);
				setState(144); stmt();
				setState(147);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(145); match(ELSE);
					setState(146); stmt();
					}
					break;
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149); match(WHILE);
				setState(150); match(LEFTPAREN);
				setState(151); exp(0);
				setState(152); match(RIGHTPAREN);
				setState(153); stmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155); match(SYSO);
				setState(156); match(LEFTPAREN);
				setState(157); exp(0);
				setState(158); match(RIGHTPAREN);
				setState(159); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161); match(ID);
				setState(162); match(ASSIGNMENT);
				setState(163); exp(0);
				setState(164); match(SEMICOLON);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(166); match(ID);
				setState(167); match(LEFTBRACKET);
				setState(168); exp(0);
				setState(169); match(RIGHTBRACKET);
				setState(170); match(ASSIGNMENT);
				setState(171); exp(0);
				setState(172); match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode MORETHAN() { return getToken(javagrammarParser.MORETHAN, 0); }
		public TerminalNode INT() { return getToken(javagrammarParser.INT, 0); }
		public TerminalNode TRUE() { return getToken(javagrammarParser.TRUE, 0); }
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode RIGHTBRACKET() { return getToken(javagrammarParser.RIGHTBRACKET, 0); }
		public TerminalNode AND() { return getToken(javagrammarParser.AND, 0); }
		public TerminalNode LONG_LIT() { return getToken(javagrammarParser.LONG_LIT, 0); }
		public TerminalNode EQ() { return getToken(javagrammarParser.EQ, 0); }
		public TerminalNode LEFTPAREN() { return getToken(javagrammarParser.LEFTPAREN, 0); }
		public TerminalNode PLUS() { return getToken(javagrammarParser.PLUS, 0); }
		public TerminalNode INT_LIT() { return getToken(javagrammarParser.INT_LIT, 0); }
		public TerminalNode MEQ() { return getToken(javagrammarParser.MEQ, 0); }
		public TerminalNode OR() { return getToken(javagrammarParser.OR, 0); }
		public TerminalNode ID() { return getToken(javagrammarParser.ID, 0); }
		public TerminalNode LONG() { return getToken(javagrammarParser.LONG, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode MINUS() { return getToken(javagrammarParser.MINUS, 0); }
		public TerminalNode NEQ() { return getToken(javagrammarParser.NEQ, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(javagrammarParser.LEFTBRACKET, 0); }
		public TerminalNode LESSTHAN() { return getToken(javagrammarParser.LESSTHAN, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(javagrammarParser.RIGHTPAREN, 0); }
		public TerminalNode NEW() { return getToken(javagrammarParser.NEW, 0); }
		public TerminalNode DOT() { return getToken(javagrammarParser.DOT, 0); }
		public TerminalNode MULT() { return getToken(javagrammarParser.MULT, 0); }
		public TerminalNode NOT() { return getToken(javagrammarParser.NOT, 0); }
		public TerminalNode LEQ() { return getToken(javagrammarParser.LEQ, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LENGTH() { return getToken(javagrammarParser.LENGTH, 0); }
		public TerminalNode FALSE() { return getToken(javagrammarParser.FALSE, 0); }
		public TerminalNode THIS() { return getToken(javagrammarParser.THIS, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(177); match(NOT);
				setState(178); exp(11);
				}
				break;

			case 2:
				{
				setState(179); match(NEW);
				setState(180); match(INT);
				setState(181); match(LEFTBRACKET);
				setState(182); exp(0);
				setState(183); match(RIGHTBRACKET);
				}
				break;

			case 3:
				{
				setState(185); match(NEW);
				setState(186); match(LONG);
				setState(187); match(LEFTBRACKET);
				setState(188); exp(0);
				setState(189); match(RIGHTBRACKET);
				}
				break;

			case 4:
				{
				setState(191); match(NEW);
				setState(192); match(ID);
				setState(193); match(LEFTPAREN);
				setState(194); match(RIGHTPAREN);
				}
				break;

			case 5:
				{
				setState(195); match(LEFTPAREN);
				setState(196); exp(0);
				setState(197); match(RIGHTPAREN);
				}
				break;

			case 6:
				{
				setState(199); match(INT_LIT);
				}
				break;

			case 7:
				{
				setState(200); match(LONG_LIT);
				}
				break;

			case 8:
				{
				setState(201); match(TRUE);
				}
				break;

			case 9:
				{
				setState(202); match(FALSE);
				}
				break;

			case 10:
				{
				setState(203); match(ID);
				}
				break;

			case 11:
				{
				setState(204); match(THIS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(207);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(208); match(MULT);
						setState(209); exp(14);
						}
						break;

					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(210);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(211);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(212); exp(13);
						}
						break;

					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(213);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(214);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESSTHAN) | (1L << MORETHAN) | (1L << LEQ) | (1L << MEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(215); exp(11);
						}
						break;

					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(216);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(217);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(218); exp(10);
						}
						break;

					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(219);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(220); match(AND);
						setState(221); exp(9);
						}
						break;

					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(222);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(223); match(OR);
						setState(224); exp(8);
						}
						break;

					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(225);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(226); match(DOT);
						setState(227); match(LENGTH);
						}
						break;

					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(228);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(229); match(DOT);
						setState(230); match(ID);
						setState(231); match(LEFTPAREN);
						setState(232); explist();
						setState(233); match(RIGHTPAREN);
						}
						break;

					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(235);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(236); match(LEFTBRACKET);
						setState(237); exp(0);
						setState(238); match(RIGHTBRACKET);
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExplistContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<ExprestContext> exprest() {
			return getRuleContexts(ExprestContext.class);
		}
		public ExprestContext exprest(int i) {
			return getRuleContext(ExprestContext.class,i);
		}
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterExplist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitExplist(this);
		}
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_explist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << LEFTPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LIT) | (1L << LONG_LIT) | (1L << ID))) != 0)) {
				{
				setState(245); exp(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(246); exprest();
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprestContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(javagrammarParser.COMMA, 0); }
		public ExprestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).enterExprest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof javagrammarListener ) ((javagrammarListener)listener).exitExprest(this);
		}
	}

	public final ExprestContext exprest() throws RecognitionException {
		ExprestContext _localctx = new ExprestContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(COMMA);
			setState(255); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return mainclass_sempred((MainclassContext)_localctx, predIndex);

		case 9: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 13);

		case 2: return precpred(_ctx, 12);

		case 3: return precpred(_ctx, 10);

		case 4: return precpred(_ctx, 9);

		case 5: return precpred(_ctx, 8);

		case 6: return precpred(_ctx, 7);

		case 7: return precpred(_ctx, 17);

		case 8: return precpred(_ctx, 16);

		case 9: return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean mainclass_sempred(MainclassContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return _input.LT(1).getText().matches("main");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0104\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3"+
		"\65\13\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4D"+
		"\n\4\f\4\16\4G\13\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6]\n\6\f\6\16\6`\13\6\3\6\7\6c\n"+
		"\6\f\6\16\6f\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7p\n\7\f\7\16\7s\13"+
		"\7\5\7u\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0085\n\t\3\n\3\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u0096\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b1"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00d0\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00f3\n\13\f\13"+
		"\16\13\u00f6\13\13\3\f\3\f\7\f\u00fa\n\f\f\f\16\f\u00fd\13\f\5\f\u00ff"+
		"\n\f\3\r\3\r\3\r\3\r\2\3\24\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\3\2!"+
		"\"\3\2(+\3\2,-\u0121\2\32\3\2\2\2\4!\3\2\2\2\6?\3\2\2\2\bP\3\2\2\2\nT"+
		"\3\2\2\2\ft\3\2\2\2\16v\3\2\2\2\20\u0084\3\2\2\2\22\u00b0\3\2\2\2\24\u00cf"+
		"\3\2\2\2\26\u00fe\3\2\2\2\30\u0100\3\2\2\2\32\36\5\4\3\2\33\35\5\6\4\2"+
		"\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 \36"+
		"\3\2\2\2!\"\7\7\2\2\"#\7\62\2\2#$\7\33\2\2$%\7\b\2\2%&\7\t\2\2&\'\7\n"+
		"\2\2\'(\6\3\2\2()\7\62\2\2)*\7\31\2\2*+\7\25\2\2+,\7\27\2\2,-\7\30\2\2"+
		"-.\7\62\2\2./\7\32\2\2/\63\7\33\2\2\60\62\5\b\5\2\61\60\3\2\2\2\62\65"+
		"\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\649\3\2\2\2\65\63\3\2\2\2\668\5\22"+
		"\n\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2"+
		"<=\7\34\2\2=>\7\34\2\2>\5\3\2\2\2?@\7\7\2\2@A\7\62\2\2AE\7\33\2\2BD\5"+
		"\b\5\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FK\3\2\2\2GE\3\2\2\2HJ\5"+
		"\n\6\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7"+
		"\34\2\2O\7\3\2\2\2PQ\5\20\t\2QR\7\62\2\2RS\7 \2\2S\t\3\2\2\2TU\7\b\2\2"+
		"UV\5\20\t\2VW\7\62\2\2WX\7\31\2\2XY\5\f\7\2YZ\7\32\2\2Z^\7\33\2\2[]\5"+
		"\b\5\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_d\3\2\2\2`^\3\2\2\2a"+
		"c\5\22\n\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2"+
		"gh\7\17\2\2hi\5\24\13\2ij\7 \2\2jk\7\34\2\2k\13\3\2\2\2lm\5\20\t\2mq\7"+
		"\62\2\2np\5\16\b\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2s"+
		"q\3\2\2\2tl\3\2\2\2tu\3\2\2\2u\r\3\2\2\2vw\7\36\2\2wx\5\20\t\2xy\7\62"+
		"\2\2y\17\3\2\2\2z{\7\24\2\2{|\7\27\2\2|\u0085\7\30\2\2}\u0085\7\23\2\2"+
		"~\u0085\7\24\2\2\177\u0080\7\26\2\2\u0080\u0081\7\27\2\2\u0081\u0085\7"+
		"\30\2\2\u0082\u0085\7\26\2\2\u0083\u0085\7\62\2\2\u0084z\3\2\2\2\u0084"+
		"}\3\2\2\2\u0084~\3\2\2\2\u0084\177\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\21\3\2\2\2\u0086\u008a\7\33\2\2\u0087\u0089\5\22\n\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u00b1\7\34\2\2\u008e"+
		"\u008f\7\13\2\2\u008f\u0090\7\31\2\2\u0090\u0091\5\24\13\2\u0091\u0092"+
		"\7\32\2\2\u0092\u0095\5\22\n\2\u0093\u0094\7\f\2\2\u0094\u0096\5\22\n"+
		"\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u00b1\3\2\2\2\u0097\u0098"+
		"\7\r\2\2\u0098\u0099\7\31\2\2\u0099\u009a\5\24\13\2\u009a\u009b\7\32\2"+
		"\2\u009b\u009c\5\22\n\2\u009c\u00b1\3\2\2\2\u009d\u009e\7\21\2\2\u009e"+
		"\u009f\7\31\2\2\u009f\u00a0\5\24\13\2\u00a0\u00a1\7\32\2\2\u00a1\u00a2"+
		"\7 \2\2\u00a2\u00b1\3\2\2\2\u00a3\u00a4\7\62\2\2\u00a4\u00a5\7$\2\2\u00a5"+
		"\u00a6\5\24\13\2\u00a6\u00a7\7 \2\2\u00a7\u00b1\3\2\2\2\u00a8\u00a9\7"+
		"\62\2\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\5\24\13\2\u00ab\u00ac\7\30\2"+
		"\2\u00ac\u00ad\7$\2\2\u00ad\u00ae\5\24\13\2\u00ae\u00af\7 \2\2\u00af\u00b1"+
		"\3\2\2\2\u00b0\u0086\3\2\2\2\u00b0\u008e\3\2\2\2\u00b0\u0097\3\2\2\2\u00b0"+
		"\u009d\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b1\23\3\2\2"+
		"\2\u00b2\u00b3\b\13\1\2\u00b3\u00b4\7%\2\2\u00b4\u00d0\5\24\13\r\u00b5"+
		"\u00b6\7\16\2\2\u00b6\u00b7\7\24\2\2\u00b7\u00b8\7\27\2\2\u00b8\u00b9"+
		"\5\24\13\2\u00b9\u00ba\7\30\2\2\u00ba\u00d0\3\2\2\2\u00bb\u00bc\7\16\2"+
		"\2\u00bc\u00bd\7\26\2\2\u00bd\u00be\7\27\2\2\u00be\u00bf\5\24\13\2\u00bf"+
		"\u00c0\7\30\2\2\u00c0\u00d0\3\2\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c3\7"+
		"\62\2\2\u00c3\u00c4\7\31\2\2\u00c4\u00d0\7\32\2\2\u00c5\u00c6\7\31\2\2"+
		"\u00c6\u00c7\5\24\13\2\u00c7\u00c8\7\32\2\2\u00c8\u00d0\3\2\2\2\u00c9"+
		"\u00d0\7\60\2\2\u00ca\u00d0\7\61\2\2\u00cb\u00d0\7.\2\2\u00cc\u00d0\7"+
		"/\2\2\u00cd\u00d0\7\62\2\2\u00ce\u00d0\7\20\2\2\u00cf\u00b2\3\2\2\2\u00cf"+
		"\u00b5\3\2\2\2\u00cf\u00bb\3\2\2\2\u00cf\u00c1\3\2\2\2\u00cf\u00c5\3\2"+
		"\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf"+
		"\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00f4\3\2"+
		"\2\2\u00d1\u00d2\f\17\2\2\u00d2\u00d3\7#\2\2\u00d3\u00f3\5\24\13\20\u00d4"+
		"\u00d5\f\16\2\2\u00d5\u00d6\t\2\2\2\u00d6\u00f3\5\24\13\17\u00d7\u00d8"+
		"\f\f\2\2\u00d8\u00d9\t\3\2\2\u00d9\u00f3\5\24\13\r\u00da\u00db\f\13\2"+
		"\2\u00db\u00dc\t\4\2\2\u00dc\u00f3\5\24\13\f\u00dd\u00de\f\n\2\2\u00de"+
		"\u00df\7&\2\2\u00df\u00f3\5\24\13\13\u00e0\u00e1\f\t\2\2\u00e1\u00e2\7"+
		"\'\2\2\u00e2\u00f3\5\24\13\n\u00e3\u00e4\f\23\2\2\u00e4\u00e5\7\35\2\2"+
		"\u00e5\u00f3\7\22\2\2\u00e6\u00e7\f\22\2\2\u00e7\u00e8\7\35\2\2\u00e8"+
		"\u00e9\7\62\2\2\u00e9\u00ea\7\31\2\2\u00ea\u00eb\5\26\f\2\u00eb\u00ec"+
		"\7\32\2\2\u00ec\u00f3\3\2\2\2\u00ed\u00ee\f\21\2\2\u00ee\u00ef\7\27\2"+
		"\2\u00ef\u00f0\5\24\13\2\u00f0\u00f1\7\30\2\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00d1\3\2\2\2\u00f2\u00d4\3\2\2\2\u00f2\u00d7\3\2\2\2\u00f2\u00da\3\2"+
		"\2\2\u00f2\u00dd\3\2\2\2\u00f2\u00e0\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2"+
		"\u00e6\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\25\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00fb"+
		"\5\24\13\2\u00f8\u00fa\5\30\r\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2"+
		"\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fe\u00f7\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\27\3\2\2\2\u0100"+
		"\u0101\7\36\2\2\u0101\u0102\5\24\13\2\u0102\31\3\2\2\2\24\36\639EK^dq"+
		"t\u0084\u008a\u0095\u00b0\u00cf\u00f2\u00f4\u00fb\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}