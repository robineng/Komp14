package mjc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by suicidal on 3/18/14.
 */
public class JVMMain {
    public static void main(String[] args) {
        try {
            javagrammarLexer lexer = new javagrammarLexer(new ANTLRInputStream(new FileInputStream(args[0])));
            lexer.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(@NotNull Recognizer<?, ?> recognizer, @Nullable Object o, int i, int i2, @NotNull String s, @Nullable RecognitionException e) {
                    System.err.println("Syntax error!");
                    System.err.println(s);
                    System.exit(1);
                }

                @Override
                public void reportAmbiguity(@NotNull Parser parser, @NotNull DFA dfa, int i, int i2, boolean b, @Nullable BitSet bitSet, @NotNull ATNConfigSet atnConfigs) {
                    System.err.println(String.format("ambiguity at: %d %d\n", i, i2));
                    System.exit(1);
                }

                @Override
                public void reportAttemptingFullContext(@NotNull Parser parser, @NotNull DFA dfa, int i, int i2, @Nullable BitSet bitSet, @NotNull ATNConfigSet atnConfigs) {

                }

                @Override
                public void reportContextSensitivity(@NotNull Parser parser, @NotNull DFA dfa, int i, int i2, int i3, @NotNull ATNConfigSet atnConfigs) {

                }
            });
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
