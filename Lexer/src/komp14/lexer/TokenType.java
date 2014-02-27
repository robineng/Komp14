package komp14.lexer;

import java.util.ArrayList;

public enum TokenType {
	//reserved words
	PUBLIC("public"),
	STATIC("static"),
	VOID("void"),
	CLASS("class"),
	IF("if"),
	NEW("new"),
	RETURN("return"),
	THIS("this"),
	
	//Types
	BOOLEAN("boolean"),
	INT("int"),
	STRING("String"),

	//Symbols
	DOT("\\."),
	SEMICOLON(";"),
	LEFTPAREN("\\("),
	LEFTBRACKET("\\["),
	RIGHTBRACKET("\\]"),
	LEFTBRACE("\\{"),
	RIGHTBRACE("\\}"),
	PLUS("\\+"),
	MINUS("\\-"),
	RIGHTPAREN("\\)"),
	ASSIGNMENT("="),
	NOT("!"),
	AND("&"),
	OR("\\|"),
	LESSTHAN("<"),
	ASTERISK("\\*"),

	//values
	TRUE("true"),
	FALSE("false"),
	NUM("0|[1-9][0-9]*"),
	ID("[a-zA-Z][a-zA-Z0-9]*");

	private final String lexerRegex;
	private TokenType(String regex) {
		lexerRegex = regex;
	}
	
	public String getPattern() {
		return lexerRegex;
	}
	
	public boolean equals(TokenType t) {
		if(t == null) { return false; }
		return  t == this;
	}
}
