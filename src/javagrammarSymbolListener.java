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
    private javagrammarParser.ClassdeclContext currClass = null;

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
        if(ctx.exp() != null) {
            getTypeFromExp(ctx.exp(0));
        }
        if(ctx.ID() != null) {
            String type = getTypeFromId(ctx.ID());
            System.out.println(type);
        }
    }

    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        System.err.println("Entering classdecl");
        currClass = ctx;
        classVariables.clear();
    }

    @Override public void exitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        System.err.println("Exiting classdecl");
        currClass = null;
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
        System.err.println(exp.getText());
        /*
         * Every expression that makes it immediately obvious what type it is.
         */
        if(exp.INT_LIT() != null) {
            return "int";
        } else if (exp.LONG_LIT() != null) {
            return "long";
        } else if(exp.TRUE() != null || exp.FALSE() != null) {
            return "boolean";
        } else if(exp.THIS() != null) {
            if(currClass == null) {
                return mainclass.ID(0).getText();
            } else {
                return currClass.ID().getText();
            }
        } else if(exp.NEW() != null) {
            if(exp.INT() != null && getTypeFromExp(exp.exp(0)).equals("int")) {
                return "int[]";
            } else if(classes.containsKey(exp.ID())) {
                return exp.ID().getText();
            } else {
                System.err.println("Cannot create instance of " + exp.ID().getText());
                System.exit(1);
            }
        } else if(exp.NOT() != null) {
            if(getTypeFromId(exp.exp(0).ID()).equals("boolean")) {
                return "boolean";
            } else {
                System.err.println("Cannot negate a non boolean value");
                System.exit(1);
            }
        }
        //Just an ID, nothing else
        else if(exp.ID().getText().equals(exp.getText())) {
            return getTypeFromId(exp.ID());
        }

        /*
         * Other expressions that aren't as obvious and might need some calculations
         * to know which type to return.
         */

        else if((exp.MULT() != null) || (exp.MINUS() != null) || (exp.PLUS() != null)) {
            //Could be either long or int
            String numtype = getTypeFromExp(exp.exp(0));
            if(numtype.matches("int|long") && numtype.equals(getTypeFromExp(exp.exp(1)))) {
                return numtype;
            } else {
                System.err.println("Both expression must be either long or int.");
                System.exit(1);
            }
        } else if((exp.MEQ() != null) || (exp.EQ() != null) || (exp.LEQ() != null)) {
            String exptype = getTypeFromExp(exp.exp(0));
            if(exptype.matches("int|long|boolean|int\\[\\]|long\\[\\]")) {
                if(exptype.equals(getTypeFromExp(exp.exp(1)))) {
                    return "boolean";
                }
            } else if (!getTypeFromExp(exp.exp(1)).matches("int|long|boolean|int\\[\\]|long\\[\\]")) {
               return "boolean";
            }
            System.err.println("Cannot compare these types");
            System.exit(1);
        } else if(exp.LENGTH() != null) {
            if(getTypeFromExp(exp.exp(0)).matches("int\\[\\]|long\\[\\]")) {
                return "int";
            }
            System.err.println("Can not get the length of this object");
            System.exit(1);
        }
        //There should now ONLY be exp.id left.
        //Else something has gone wrong
        else if(exp.ID() != null) {
            //This will be a class name if the writer of the program did it right
            String type = getTypeFromExp(exp.exp(0));
            //Mainclass can't hold any methods so we'll just check other classes
            javagrammarParser.ClassdeclContext expclass = classes.get(type);
            for(javagrammarParser.MethoddeclContext method : expclass.methoddecl()) {
                //Found the method
                if(method.ID().getText().equals(exp.ID().getText())) {
                    return method.type().getText();
                }
            }
            System.err.println("Can't find the method");
            System.exit(1);
        }

        /*
         * If we reach this point, we have made a mistake.
         */
        System.err.println("Something has gone terribly wrong in getTypeFromExp");
        System.err.println("Check it out!");
        System.exit(1);
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
