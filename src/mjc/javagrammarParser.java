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
		WS=1, LINE_COMMENT=2, COMMENT2=3, CLASS=4, PUBLIC=5, STATIC=6, VOID=7, 
		IF=8, ELSE=9, WHILE=10, NEW=11, RETURN=12, THIS=13, SYSO=14, LENGTH=15, 
		BOOLEAN=16, INT=17, STRING=18, LONG=19, LEFTBRACKET=20, RIGHTBRACKET=21, 
		LEFTPAREN=22, RIGHTPAREN=23, LEFTBRACE=24, RIGHTBRACE=25, DOT=26, COMMA=27, 
		COLON=28, SEMICOLON=29, PLUS=30, MINUS=31, MULT=32, ASSIGNMENT=33, NOT=34, 
		AND=35, OR=36, LESSTHAN=37, MORETHAN=38, LEQ=39, MEQ=40, EQ=41, NEQ=42, 
		TRUE=43, FALSE=44, INT_LIT=45, LONG_LIT=46, ID=47;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "LINE_COMMENT", "COMMENT2", "'class'", "'public'", 
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
		public TerminalNode EOF() { return getToken(javagrammarParser.EOF, 0); }
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
			setState(31); match(EOF);
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
			setState(33); match(CLASS);
			setState(34); match(ID);
			setState(35); match(LEFTBRACE);
			setState(36); match(PUBLIC);
			setState(37); match(STATIC);
			setState(38); match(VOID);
			setState(39);
			if (!(_input.LT(1).getText().matches("main"))) throw new FailedPredicateException(this, "_input.LT(1).getText().matches(\"main\")");
			setState(40); match(ID);
			setState(41); match(LEFTPAREN);
			setState(42); match(STRING);
			setState(43); match(LEFTBRACKET);
			setState(44); match(RIGHTBRACKET);
			setState(45); match(ID);
			setState(46); match(RIGHTPAREN);
			setState(47); match(LEFTBRACE);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(48); vardecl();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(54); stmt();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60); match(RIGHTBRACE);
			setState(61); match(RIGHTBRACE);
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
			setState(63); match(CLASS);
			setState(64); match(ID);
			setState(65); match(LEFTBRACE);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << ID))) != 0)) {
				{
				{
				setState(66); vardecl();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(72); methoddecl();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78); match(RIGHTBRACE);
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
			setState(80); type();
			setState(81); match(ID);
			setState(82); match(SEMICOLON);
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
			setState(84); match(PUBLIC);
			setState(85); type();
			setState(86); match(ID);
			setState(87); match(LEFTPAREN);
			setState(88); formallist();
			setState(89); match(RIGHTPAREN);
			setState(90); match(LEFTBRACE);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(91); vardecl();
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(97); stmt();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103); match(RETURN);
			setState(104); exp(0);
			setState(105); match(SEMICOLON);
			setState(106); match(RIGHTBRACE);
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
			setState(116);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << ID))) != 0)) {
				{
				setState(108); type();
				setState(109); match(ID);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(110); formalrest();
					}
					}
					setState(115);
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
			setState(118); match(COMMA);
			setState(119); type();
			setState(120); match(ID);
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
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); match(INT);
				setState(123); match(LEFTBRACKET);
				setState(124); match(RIGHTBRACKET);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); match(BOOLEAN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126); match(INT);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127); match(LONG);
				setState(128); match(LEFTBRACKET);
				setState(129); match(RIGHTBRACKET);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(130); match(LONG);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(131); match(ID);
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
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); match(LEFTBRACE);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SYSO) | (1L << LEFTBRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(135); stmt();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141); match(RIGHTBRACE);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); match(IF);
				setState(143); match(LEFTPAREN);
				setState(144); exp(0);
				setState(145); match(RIGHTPAREN);
				setState(146); stmt();
				setState(149);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(147); match(ELSE);
					setState(148); stmt();
					}
					break;
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151); match(WHILE);
				setState(152); match(LEFTPAREN);
				setState(153); exp(0);
				setState(154); match(RIGHTPAREN);
				setState(155); stmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157); match(SYSO);
				setState(158); match(LEFTPAREN);
				setState(159); exp(0);
				setState(160); match(RIGHTPAREN);
				setState(161); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163); match(ID);
				setState(164); match(ASSIGNMENT);
				setState(165); exp(0);
				setState(166); match(SEMICOLON);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168); match(ID);
				setState(169); match(LEFTBRACKET);
				setState(170); exp(0);
				setState(171); match(RIGHTBRACKET);
				setState(172); match(ASSIGNMENT);
				setState(173); exp(0);
				setState(174); match(SEMICOLON);
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
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(179); match(NOT);
				setState(180); exp(11);
				}
				break;

			case 2:
				{
				setState(181); match(NEW);
				setState(182); match(INT);
				setState(183); match(LEFTBRACKET);
				setState(184); exp(0);
				setState(185); match(RIGHTBRACKET);
				}
				break;

			case 3:
				{
				setState(187); match(NEW);
				setState(188); match(LONG);
				setState(189); match(LEFTBRACKET);
				setState(190); exp(0);
				setState(191); match(RIGHTBRACKET);
				}
				break;

			case 4:
				{
				setState(193); match(NEW);
				setState(194); match(ID);
				setState(195); match(LEFTPAREN);
				setState(196); match(RIGHTPAREN);
				}
				break;

			case 5:
				{
				setState(197); match(LEFTPAREN);
				setState(198); exp(0);
				setState(199); match(RIGHTPAREN);
				}
				break;

			case 6:
				{
				setState(201); match(INT_LIT);
				}
				break;

			case 7:
				{
				setState(202); match(LONG_LIT);
				}
				break;

			case 8:
				{
				setState(203); match(TRUE);
				}
				break;

			case 9:
				{
				setState(204); match(FALSE);
				}
				break;

			case 10:
				{
				setState(205); match(ID);
				}
				break;

			case 11:
				{
				setState(206); match(THIS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(242);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(209);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(210); match(MULT);
						setState(211); exp(14);
						}
						break;

					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(212);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(213);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(214); exp(13);
						}
						break;

					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(215);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(216);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESSTHAN) | (1L << MORETHAN) | (1L << LEQ) | (1L << MEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(217); exp(11);
						}
						break;

					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(218);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(219);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(220); exp(10);
						}
						break;

					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(221);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(222); match(AND);
						setState(223); exp(9);
						}
						break;

					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(224);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(225); match(OR);
						setState(226); exp(8);
						}
						break;

					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(227);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(228); match(DOT);
						setState(229); match(LENGTH);
						}
						break;

					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(230);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(231); match(DOT);
						setState(232); match(ID);
						setState(233); match(LEFTPAREN);
						setState(234); explist();
						setState(235); match(RIGHTPAREN);
						}
						break;

					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(237);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(238); match(LEFTBRACKET);
						setState(239); exp(0);
						setState(240); match(RIGHTBRACKET);
						}
						break;
					}
					} 
				}
				setState(246);
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
			setState(254);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << LEFTPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LIT) | (1L << LONG_LIT) | (1L << ID))) != 0)) {
				{
				setState(247); exp(0);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(248); exprest();
					}
					}
					setState(253);
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
			setState(256); match(COMMA);
			setState(257); exp(0);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u0106\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64\n\3"+
		"\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6\3\6"+
		"\7\6e\n\6\f\6\16\6h\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7r\n\7\f\7"+
		"\16\7u\13\7\5\7w\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0087\n\t\3\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u00b3\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00d2\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00f5"+
		"\n\13\f\13\16\13\u00f8\13\13\3\f\3\f\7\f\u00fc\n\f\f\f\16\f\u00ff\13\f"+
		"\5\f\u0101\n\f\3\r\3\r\3\r\3\r\2\3\24\16\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\2\5\3\2 !\3\2\'*\3\2+,\u0123\2\32\3\2\2\2\4#\3\2\2\2\6A\3\2\2\2\bR\3"+
		"\2\2\2\nV\3\2\2\2\fv\3\2\2\2\16x\3\2\2\2\20\u0086\3\2\2\2\22\u00b2\3\2"+
		"\2\2\24\u00d1\3\2\2\2\26\u0100\3\2\2\2\30\u0102\3\2\2\2\32\36\5\4\3\2"+
		"\33\35\5\6\4\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37"+
		"!\3\2\2\2 \36\3\2\2\2!\"\7\2\2\3\"\3\3\2\2\2#$\7\6\2\2$%\7\61\2\2%&\7"+
		"\32\2\2&\'\7\7\2\2\'(\7\b\2\2()\7\t\2\2)*\6\3\2\2*+\7\61\2\2+,\7\30\2"+
		"\2,-\7\24\2\2-.\7\26\2\2./\7\27\2\2/\60\7\61\2\2\60\61\7\31\2\2\61\65"+
		"\7\32\2\2\62\64\5\b\5\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5\22\n\298\3\2\2\2:=\3\2\2\2;9\3"+
		"\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\33\2\2?@\7\33\2\2@\5\3\2\2\2"+
		"AB\7\6\2\2BC\7\61\2\2CG\7\32\2\2DF\5\b\5\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2"+
		"\2GH\3\2\2\2HM\3\2\2\2IG\3\2\2\2JL\5\n\6\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2"+
		"\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\33\2\2Q\7\3\2\2\2RS\5\20\t\2ST\7"+
		"\61\2\2TU\7\37\2\2U\t\3\2\2\2VW\7\7\2\2WX\5\20\t\2XY\7\61\2\2YZ\7\30\2"+
		"\2Z[\5\f\7\2[\\\7\31\2\2\\`\7\32\2\2]_\5\b\5\2^]\3\2\2\2_b\3\2\2\2`^\3"+
		"\2\2\2`a\3\2\2\2af\3\2\2\2b`\3\2\2\2ce\5\22\n\2dc\3\2\2\2eh\3\2\2\2fd"+
		"\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\16\2\2jk\5\24\13\2kl\7\37\2"+
		"\2lm\7\33\2\2m\13\3\2\2\2no\5\20\t\2os\7\61\2\2pr\5\16\b\2qp\3\2\2\2r"+
		"u\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2\2vn\3\2\2\2vw\3\2\2\2"+
		"w\r\3\2\2\2xy\7\35\2\2yz\5\20\t\2z{\7\61\2\2{\17\3\2\2\2|}\7\23\2\2}~"+
		"\7\26\2\2~\u0087\7\27\2\2\177\u0087\7\22\2\2\u0080\u0087\7\23\2\2\u0081"+
		"\u0082\7\25\2\2\u0082\u0083\7\26\2\2\u0083\u0087\7\27\2\2\u0084\u0087"+
		"\7\25\2\2\u0085\u0087\7\61\2\2\u0086|\3\2\2\2\u0086\177\3\2\2\2\u0086"+
		"\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2"+
		"\2\2\u0087\21\3\2\2\2\u0088\u008c\7\32\2\2\u0089\u008b\5\22\n\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u00b3\7\33\2\2\u0090"+
		"\u0091\7\n\2\2\u0091\u0092\7\30\2\2\u0092\u0093\5\24\13\2\u0093\u0094"+
		"\7\31\2\2\u0094\u0097\5\22\n\2\u0095\u0096\7\13\2\2\u0096\u0098\5\22\n"+
		"\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00b3\3\2\2\2\u0099\u009a"+
		"\7\f\2\2\u009a\u009b\7\30\2\2\u009b\u009c\5\24\13\2\u009c\u009d\7\31\2"+
		"\2\u009d\u009e\5\22\n\2\u009e\u00b3\3\2\2\2\u009f\u00a0\7\20\2\2\u00a0"+
		"\u00a1\7\30\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a3\7\31\2\2\u00a3\u00a4"+
		"\7\37\2\2\u00a4\u00b3\3\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\7#\2\2"+
		"\u00a7\u00a8\5\24\13\2\u00a8\u00a9\7\37\2\2\u00a9\u00b3\3\2\2\2\u00aa"+
		"\u00ab\7\61\2\2\u00ab\u00ac\7\26\2\2\u00ac\u00ad\5\24\13\2\u00ad\u00ae"+
		"\7\27\2\2\u00ae\u00af\7#\2\2\u00af\u00b0\5\24\13\2\u00b0\u00b1\7\37\2"+
		"\2\u00b1\u00b3\3\2\2\2\u00b2\u0088\3\2\2\2\u00b2\u0090\3\2\2\2\u00b2\u0099"+
		"\3\2\2\2\u00b2\u009f\3\2\2\2\u00b2\u00a5\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b3"+
		"\23\3\2\2\2\u00b4\u00b5\b\13\1\2\u00b5\u00b6\7$\2\2\u00b6\u00d2\5\24\13"+
		"\r\u00b7\u00b8\7\r\2\2\u00b8\u00b9\7\23\2\2\u00b9\u00ba\7\26\2\2\u00ba"+
		"\u00bb\5\24\13\2\u00bb\u00bc\7\27\2\2\u00bc\u00d2\3\2\2\2\u00bd\u00be"+
		"\7\r\2\2\u00be\u00bf\7\25\2\2\u00bf\u00c0\7\26\2\2\u00c0\u00c1\5\24\13"+
		"\2\u00c1\u00c2\7\27\2\2\u00c2\u00d2\3\2\2\2\u00c3\u00c4\7\r\2\2\u00c4"+
		"\u00c5\7\61\2\2\u00c5\u00c6\7\30\2\2\u00c6\u00d2\7\31\2\2\u00c7\u00c8"+
		"\7\30\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00ca\7\31\2\2\u00ca\u00d2\3\2\2"+
		"\2\u00cb\u00d2\7/\2\2\u00cc\u00d2\7\60\2\2\u00cd\u00d2\7-\2\2\u00ce\u00d2"+
		"\7.\2\2\u00cf\u00d2\7\61\2\2\u00d0\u00d2\7\17\2\2\u00d1\u00b4\3\2\2\2"+
		"\u00d1\u00b7\3\2\2\2\u00d1\u00bd\3\2\2\2\u00d1\u00c3\3\2\2\2\u00d1\u00c7"+
		"\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00cc\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1"+
		"\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00f6\3\2"+
		"\2\2\u00d3\u00d4\f\17\2\2\u00d4\u00d5\7\"\2\2\u00d5\u00f5\5\24\13\20\u00d6"+
		"\u00d7\f\16\2\2\u00d7\u00d8\t\2\2\2\u00d8\u00f5\5\24\13\17\u00d9\u00da"+
		"\f\f\2\2\u00da\u00db\t\3\2\2\u00db\u00f5\5\24\13\r\u00dc\u00dd\f\13\2"+
		"\2\u00dd\u00de\t\4\2\2\u00de\u00f5\5\24\13\f\u00df\u00e0\f\n\2\2\u00e0"+
		"\u00e1\7%\2\2\u00e1\u00f5\5\24\13\13\u00e2\u00e3\f\t\2\2\u00e3\u00e4\7"+
		"&\2\2\u00e4\u00f5\5\24\13\n\u00e5\u00e6\f\23\2\2\u00e6\u00e7\7\34\2\2"+
		"\u00e7\u00f5\7\21\2\2\u00e8\u00e9\f\22\2\2\u00e9\u00ea\7\34\2\2\u00ea"+
		"\u00eb\7\61\2\2\u00eb\u00ec\7\30\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee"+
		"\7\31\2\2\u00ee\u00f5\3\2\2\2\u00ef\u00f0\f\21\2\2\u00f0\u00f1\7\26\2"+
		"\2\u00f1\u00f2\5\24\13\2\u00f2\u00f3\7\27\2\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00d3\3\2\2\2\u00f4\u00d6\3\2\2\2\u00f4\u00d9\3\2\2\2\u00f4\u00dc\3\2"+
		"\2\2\u00f4\u00df\3\2\2\2\u00f4\u00e2\3\2\2\2\u00f4\u00e5\3\2\2\2\u00f4"+
		"\u00e8\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\25\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fd"+
		"\5\24\13\2\u00fa\u00fc\5\30\r\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2"+
		"\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u0100\u00f9\3\2\2\2\u0100\u0101\3\2\2\2\u0101\27\3\2\2\2\u0102"+
		"\u0103\7\35\2\2\u0103\u0104\5\24\13\2\u0104\31\3\2\2\2\24\36\65;GM`fs"+
		"v\u0086\u008c\u0097\u00b2\u00d1\u00f4\u00f6\u00fd\u0100";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}