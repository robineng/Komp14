package komp14.lexer;

import java.io.FileNotFoundException;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Lexer lexer = new Lexer("Lexer.java");
			System.out.println(lexer.getNextToken());
			while(lexer.hasNext()) {
				System.out.println(lexer.getNextToken());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
