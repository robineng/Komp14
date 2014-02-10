package komp14.lexer;

import java.util.ArrayList;

public enum TokenType {
	//reserved words
	PUBLIC("public"),
	STATIC("static"),
	VOID("void"),
	CLASS("class"),
	STRING("String"),
	PACKAGE("package"),
	NEW("new"),

	//Symbols
	DOT("\\."),
	SEMICOLON(";"),
	LEFTPAREN("\\("),
	LEFTBRACKET("\\["),
	RIGHTBRACKET("\\]"),
	LEFTBRACE("\\{"),
	RIGHTBRACE("\\}"),
	PLUS("\\+"),
	RIGHTPAREN("\\)"),
	ASSIGNMENT("="),

	//words that can have different length
	NUM("0|[1-9][0-9]*"),
	ID("[a-zA-Z][a-zA-Z0-9]*");

	private final String lexerRegex;
	private TokenType(String regex) {
		lexerRegex = regex;
	}
	
	public String getPattern() {
		return lexerRegex;
	}
}
