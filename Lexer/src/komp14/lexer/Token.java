package komp14.lexer;
/**
 * A class to represent a Token created by the lexer on the pass through the document.
 */
public class Token {
	final private TokenType type;
	final private String data;

	public Token(TokenType type, String data) {
		this.type = type;
		this.data = data;
	}

	public TokenType getTokenType() {
		return this.type;
	}

	public String getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return String.format("(%s \"%s\")", type, data);
	}
	
	public boolean equals (Token t) {
		if(t == null) { return false; }
		return t.data.equals(data) && t.type.equals(type);
	}
}
