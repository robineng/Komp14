import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by robin on 3/18/14.
 */
public class javagrammarSymbolListener extends javagrammarBaseListener{
    private final ArrayList<HashMap<TerminalNode, String>> stateList;

    public javagrammarSymbolListener(){
        super();
        stateList = new ArrayList<HashMap<TerminalNode, String>>();
    }


    /**
     * On enter program initialize state 0
     * and add all class ids to state
     *
     * @param ctx
     */
    @Override public void enterProgram(@NotNull javagrammarParser.ProgramContext ctx) {

        HashMap<TerminalNode, String> classes = new HashMap<TerminalNode, String>();
        classes.put(ctx.mainclass().ID(0), "class");
        for(javagrammarParser.ClassdeclContext classdecl : ctx.classdecl()){
            classes.put(classdecl.ID(), "class");
        }

        stateList.add(0, classes);


       }

    /**
     * On enter mainclass, create state 1 and add
     * all variable declarations as well as param to
     * the state.
     * @param ctx
     */
    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        System.out.println("ENTER MAINCLASS");
        HashMap<TerminalNode, String> vars = new HashMap<TerminalNode, String>();
        vars.put(ctx.ID(1), "String[]");
        for(javagrammarParser.VardeclContext var : ctx.vardecl()){
            vars.put(var.ID(), var.type().getText());
        }
        for(javagrammarParser.StmtContext stmt : ctx.stmt()){
            
        }

    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        stateList.remove(1);
        System.out.println("EXIT MAINCLASS");
    }

    @Override public void enterType(@NotNull javagrammarParser.TypeContext ctx) {
        System.out.println("Ny variabel: " + ctx.getText());
    }
}
