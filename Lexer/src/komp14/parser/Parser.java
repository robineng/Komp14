package komp14.parser;

import java.io.FileNotFoundException;

import komp14.lexer.*;

public class Parser {
	private Lexer lexer;
	private ParseTree<Token> parseTree;

	public static void main(String args[]) {
		/*if (args.length != 1) {
			System.err.println("Input valid filename");
		}*/
		//new Parser(args[0]);
		new Parser("test.java");

	}
	
	private void eatToken(TokenType type) throws InvalidTokenException {
		Token t = lexer.peek();
		if(t == null) {
			throw new InvalidTokenException("No more tokens!, Expected: " + type);
		}
		else if(type.equals(t.getTokenType())) {
			lexer.getNextToken();
			return;
		}
		else {
			throw new InvalidTokenException(t.getTokenType(), type);
		}
	}
	
	private void eatToken(TokenType type, String expectedData) throws InvalidTokenException {
		Token t = lexer.peek();
		if(t == null) {
			throw new InvalidTokenException("No more tokens!, Expected: " + expectedData);
		}
		else if(t.equals(new Token(type,expectedData))) {
			lexer.getNextToken();
			return;
		}
		else {
			throw new InvalidTokenException(t, new Token(type, expectedData));
		}
	}

	public Parser(String filename) {
		try {
			lexer = new Lexer(filename);
			program();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (InvalidTokenException e) {
			e.printStackTrace();
		}
	}
	
	private void program() throws InvalidTokenException{
		mainClass();
	}
	
	private void mainClass() throws InvalidTokenException {
		eatToken(TokenType.CLASS);
		eatToken(TokenType.ID);
		eatToken(TokenType.LEFTBRACE);
		eatToken(TokenType.PUBLIC);
		eatToken(TokenType.STATIC);
		eatToken(TokenType.VOID);
		eatToken(TokenType.ID, "main");
		eatToken(TokenType.LEFTPAREN);
		eatToken(TokenType.STRING);
		eatToken(TokenType.LEFTBRACKET);
		eatToken(TokenType.RIGHTBRACKET);
		eatToken(TokenType.ID);
		eatToken(TokenType.RIGHTPAREN);
		eatToken(TokenType.LEFTBRACE);
		/* VarDecl* */
		while(true) {
			try {
				varDecl();
			} catch(InvalidTokenException e) {
				break;
			}
		}
		/* Stmt* */
		eatToken(TokenType.RIGHTBRACE);
		eatToken(TokenType.RIGHTBRACE);
	}

	public void varDecl() throws InvalidTokenException {
		type();
		eatToken(TokenType.ID);
		eatToken(TokenType.SEMICOLON);
	}
	
	public void stmt() {
		
	}
	
	private void type() throws InvalidTokenException {
		TokenType t = lexer.peek().getTokenType();
		switch(t) {
		case BOOLEAN: eatToken(TokenType.BOOLEAN); break;
		case INT: eatToken(TokenType.INT);
				if(lexer.peek().getTokenType().equals(TokenType.LEFTBRACKET)) {
					eatToken(TokenType.LEFTBRACKET);
					eatToken(TokenType.RIGHTBRACKET);
				}
				break;
		case ID: eatToken(TokenType.ID);
		default: throw new InvalidTokenException();
		}
	}
}
