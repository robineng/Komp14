package komp14.parser;

import komp14.lexer.*;

public class Parser {
	private Lexer lexer;
	private ParseTree<Token> parseTree;

	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("Input valid filename");
		}
		new Parser(args[0]);

	}

	public Parser(String filename) {
		this.lexer = new Lexer(filename);
		this.parseTree = new ParseTree<Token>(null);
		
		Start();
		
	}
	
	private void Start(){
		
	}
	
	
}
