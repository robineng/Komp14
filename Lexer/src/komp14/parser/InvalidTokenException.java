package komp14.parser;

import komp14.lexer.Token;
import komp14.lexer.TokenType;

public class InvalidTokenException extends Exception {
	public InvalidTokenException(TokenType actualToken, TokenType expectedToken) {
		super(String.format("Expected: %s, got: %s", expectedToken, actualToken));
	}
	
	public InvalidTokenException(Token actualToken, Token expectedToken) {
		super(String.format("Expected: %s, got: %s", expectedToken, actualToken));
	}
	
	public InvalidTokenException() {
		super("");
	}
	
	public InvalidTokenException(String errorMsg) {
		super(errorMsg);
	}
}
