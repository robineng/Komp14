import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Stack;

public class javagrammarSymbolListener extends javagrammarBaseListener{

    //Used to keep track of difference between class variables and
    //variables that are only available within a method
    private HashMap <String, String> classVariables;
    private  HashMap<String, String> methodVariables;
    private javagrammarParser.MainclassContext mainclass;
    private final HashMap<String, javagrammarParser.ClassdeclContext> classes;

    public javagrammarSymbolListener(){
        super();
        classes = new HashMap<String, javagrammarParser.ClassdeclContext>();
        classVariables = new HashMap<String, String>();
        methodVariables = new HashMap<String, String>();
    }


    @Override public void enterProgram(@NotNull javagrammarParser.ProgramContext ctx) {
        System.err.println("Entering program");
        mainclass = ctx.mainclass();
        for(javagrammarParser.ClassdeclContext currclass : ctx.classdecl()) {
            if(!classes.containsKey(currclass.ID().getText()) && !mainclass.ID(0).getText().equals(currclass.ID().getText())) {
                classes.put(currclass.ID().getText(), currclass);
            } else {
                System.err.println("Class  :" + currclass.ID().getText() + " already defined");
                System.exit(1);
            }
        }
    }

    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        System.err.println("Entering main");
        //Make sure that we have a hashmap to store variables in
        classVariables.clear();
    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        System.err.println("Exiting main");
        //Remove all mainclasses variables
        classVariables.clear();
    }

    @Override public void enterVardecl(@NotNull javagrammarParser.VardeclContext ctx) {
        System.err.println("Entering vardecl");
        if(idAlreadyInCurrentContext(ctx.ID())) {
            System.err.println("ID " + ctx.ID() + " already defined");
            System.exit(1);
        } else {
            if(ctx.type().ID() != null) {
                if(!classes.containsKey(ctx.type().ID().getText())) {
                    System.err.println("No such class exists : " + ctx.type().ID().getText());
                    System.exit(1);
                }
            }
            addNewIdToContext(ctx.ID(), ctx.type().getText(), ctx.parent);
        }
    }

    @Override public void enterStmt(@NotNull javagrammarParser.StmtContext ctx) {
        System.err.println("Entering stmt");
        if(ctx.ID() != null) {
            String type = getTypeFromId(ctx.ID());
            System.out.println(type);
        }
    }

    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        System.err.println("Entering classdecl");
        classVariables.clear();
    }

    @Override public void exitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        System.err.println("Exiting classdecl");
        classVariables.clear();
    }

    @Override public void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        System.err.println("Entering methoddecl");
        methodVariables.clear();
    }

    @Override public void exitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        System.err.println("Exiting methoddecl");
        methodVariables.clear();
    }

    @Override public void enterType(@NotNull javagrammarParser.TypeContext ctx) {
        System.err.println("Entering type");
        if(ctx.ID() != null && !classes.containsKey(ctx.ID().getText())) {
            System.err.println("Class " + ctx.ID().getText() + " does not exist");
            System.exit(1);
        }
    }

    /**
     * Go through an ```Exp´´´ and find what type it results in in the end.
     * Return the type.
     */
    private String getTypeFromExp(javagrammarParser.ExpContext exp) {
        if(exp.exp() != null) {
            return null;
        }
        if(exp.ID() != null && idAlreadyInCurrentContext(exp.ID())) {
            if(exp.NEW() != null) {
                return exp.ID().getText();
            } else {
                return getTypeFromId(exp.ID());
            }
        } else if(exp.INT_LIT() != null) {
            return "int";
        } else if(exp.TRUE() != null || exp.FALSE() != null) {
            return "boolean";
        }
        return null;
    }

    /**
     * Scans available ids and returns which type it has.
     * If no matching id can be found, exit the compiler.
     */
    private String getTypeFromId(TerminalNode id) {
        System.out.println("getting type from id :");
        System.out.println(id.getText());
        if(classVariables.containsKey(id.getText())) {
            return classVariables.get(id.getText());
        }
        else if(methodVariables.containsKey(id.getText())) {
            return methodVariables.get(id.getText());
        }
        System.out.println("Cannot find id : " + id.getText());
        System.exit(1);
        return null;
    }

    private boolean idAlreadyInCurrentContext(TerminalNode id) {
        return classVariables.containsKey(id.getText()) || methodVariables.containsKey(id.getText());
    }

    private void addNewIdToContext(TerminalNode id, String type, RuleContext rc) {
        if(rc instanceof javagrammarParser.MainclassContext || rc instanceof javagrammarParser.ClassdeclContext) {
            classVariables.put(id.getText(), type);
            return;
        }
        methodVariables.put(id.getText(), type);
    }
}
