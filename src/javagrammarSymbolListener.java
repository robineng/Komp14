import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by robin on 3/18/14.
 */
public class javagrammarSymbolListener extends javagrammarBaseListener{

    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        System.out.println("ENTER MAINCLASS");
        System.out.println(ctx.getText());
    }
}
