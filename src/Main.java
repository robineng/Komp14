import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by suicidal on 3/18/14.
 */
public class Main {
    public static void main(String[] args) {
        javagrammarLexer lexer = new javagrammarLexer(new ANTLRInputStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        javagrammarParser parser = new javagrammarParser(tokens);
        javagrammarParser.ProgramContext context = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        javagrammarSymbolListener listener new javagrammarSymbolListener();
        walker.walk(listener, context);
    }
}
