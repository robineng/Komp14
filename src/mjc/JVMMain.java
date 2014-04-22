package mjc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

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

            if(parser.getNumberOfSyntaxErrors() == 0) {
              ParseTreeWalker walker = new ParseTreeWalker();

              SymbolRecorder rec = new SymbolRecorder();
              walker.walk(rec, context);

              HashMap<String, ClassSymbol> classes = rec.getClasses();

              StatementValidator valid = new StatementValidator(classes);
              walker.walk(valid, context);


              //javagrammarSymbolListener listener = new javagrammarSymbolListener();
              //walker.walk(listener, context);

              JasminTranslator translator = new JasminTranslator();
              walker.walk(translator, context);
            } else {
                System.err.println("Syntax errors!");
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
