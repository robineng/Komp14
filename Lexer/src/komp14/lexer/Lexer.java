package komp14.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

	private boolean EOF;
	private Pattern pattern;
	private Scanner fileReader;
	
	private LinkedList<Token> comingTokens;

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
		comingTokens = new LinkedList<Token>();
		this.fileReader = new Scanner(new File(fileName));
		EOF = false;
		this.findNextLinesTokens();
	}

	/**
	 * Gets the next token in the file.
	 * Returns null if no token can be found.
	 */
	public Token getNextToken() {
		Token t = comingTokens.pop();
		while(comingTokens.isEmpty() && !EOF) {
			findNextLinesTokens();
		}
		return t;
	}

	/**
	 * Skips the next Token in the file.
	 */
	public void skipToken() {
		comingTokens.pop();
		while(comingTokens.isEmpty() && !EOF) {
			findNextLinesTokens();
		}
	}

	/**
	 * Peeks at the next token in the file.
	 * Returns null if no token has been found.
	 */
	public Token peek() {
		return comingTokens.peek();
	}
	
	private void findNextLinesTokens() {
		if(fileReader.hasNextLine()) {
			Matcher matcher = pattern.matcher(fileReader.nextLine());
			while(matcher.find()) {
				for(TokenType t : TokenType.values()) {
					if(matcher.group(t.name()) != null) {
						comingTokens.add(new Token(t, matcher.group(t.name())));
					}
				}
			}
		}
		else {EOF = true;}
	}

	/**
	 * Check wheter there are still tokens left in the file.
	 * @return true if there are tokens left, otherwise false.
	 */
	public boolean hasNext() {
		return !comingTokens.isEmpty();
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

