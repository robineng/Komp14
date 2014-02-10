package komp14.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

	private Pattern pattern;
	private Scanner fileReader;
	private Token nextToken;

	/**
	 * Creates a lexer that reads from the file named 'fileName'
	 * and returns Tokens based on TokenType.
	 * @param fileName The file to read input from.
	 * @throws FileNotFoundException 
	 */
	public Lexer (final String fileName) throws FileNotFoundException {
		StringBuilder patternBuilder = new StringBuilder();
		for(TokenType t:TokenType.values()) {
			patternBuilder.append(String.format("|(?<%s>%s)", t.name(), t.getPattern()));
		}
		pattern = Pattern.compile(patternBuilder.substring(1));
		this.fileReader = new Scanner(new File(fileName));
		//Split on whitespace and all characters can can be close together in Java
		fileReader.useDelimiter(
				//whitespace
				"\\s+|" +
				//newlines
				"\n|" +
				//left parenthesis "("
				"(?=\\()|" +
				//right parenthesis ")"
				"(?=\\))|" +
				//left brace "{"
				"(?=\\{)|" +
				//right brace "}
				"(?=\\})|" +
				//left bracket "["
				"(?=\\[)|" +
				//right bracker "]"
				"(?=\\])|" +
				//semi colon ";"
				"(?=;)");

		//Find the first token to initialize it
		if(fileReader.hasNextLine()) {
			Matcher matcher = pattern.matcher(fileReader.next());
			if(matcher.find()) {
				for(TokenType t : TokenType.values()) {
					if(matcher.group(t.name()) != null) {
						nextToken = new Token(t, matcher.group(t.name()));
						break;
					}
				}
			}
			else { nextToken = null; }
		}
		else { nextToken = null; }
		System.err.println("Lexer created");
	}

	/**
	 * Gets the next token in the file.
	 * Returns null if no token can be found.
	 */
	public Token getNextToken() {
		Token currToken = nextToken;
		if(fileReader.hasNext()) {
			Matcher matcher = pattern.matcher(fileReader.next());
			if(matcher.find()) {
				for(TokenType t : TokenType.values()) {
					if(matcher.group(t.name()) != null) {
						nextToken = new Token(t, matcher.group(t.name()));
						break;
					}
				}
			}
			else { nextToken = null; }
		}
		else { nextToken = null; }
		return currToken;
	}

	/**
	 * Skips the next Token in the file.
	 */
	public void skipToken() {
		Matcher matcher = pattern.matcher(fileReader.next());
		if(matcher.find()) {
			for(TokenType t : TokenType.values()) {
				if(matcher.group(t.name()) != null) {
					nextToken = new Token(t, matcher.group(t.name()));
					break;
				}
			}
		}
		else { nextToken = null; }
	}

	/**
	 * Peeks at the next token in the file.
	 * Returns null if no token has been found.
	 */
	public Token peek() {
		return nextToken;
	}

	/**
	 * Check wheter there are still tokens left in the file.
	 * @return true if there are tokens left, otherwise false.
	 */
	public boolean hasNext() {
		return (nextToken != null);
	}
}
/**
 * A class to represent a Token created by the lexer on the pass through the document.
 */
class Token {
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
}

