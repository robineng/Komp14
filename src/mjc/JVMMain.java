package mjc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by suicidal on 3/18/14.
 */
public class JVMMain {
    public static void main(String[] args) {
        try {
            javagrammarLexer lexer = new javagrammarLexer(new ANTLRInputStream(new FileInputStream(args[0])));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            javagrammarParser parser = new javagrammarParser(tokens);
            javagrammarParser.ProgramContext context = parser.program();

            ParseTreeWalker walker = new ParseTreeWalker();
            javagrammarSymbolListener listener = new javagrammarSymbolListener();
            walker.walk(listener, context);
            File f = new File(args[0].substring(0, args[0].indexOf(".")) + ".j");
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
