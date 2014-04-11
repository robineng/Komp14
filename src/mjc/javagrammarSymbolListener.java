package mjc;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;

public class javagrammarSymbolListener extends javagrammarBaseListener{

    //Used to keep track of difference between class variables and
    //variables that are only available within a method
    private HashMap <String, String> classVariables;
    private  HashMap<String, String> methodVariables;
    private javagrammarParser.MainclassContext mainclass;
    private HashMap<String, javagrammarParser.ClassdeclContext> classes;
    private javagrammarParser.ClassdeclContext currClass = null;

    public javagrammarSymbolListener(){
        super();
        classes = new HashMap<String, javagrammarParser.ClassdeclContext>();
        classVariables = new HashMap<String, String>();
        methodVariables = new HashMap<String, String>();
    }


    @Override public void enterProgram(@NotNull javagrammarParser.ProgramContext ctx) {
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
        //Make sure that we have a hashmap to store variables in
        classVariables.clear();
    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        //Remove all mainclasses variables
        classVariables.clear();
    }

    @Override public void enterVardecl(@NotNull javagrammarParser.VardeclContext ctx) {
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
        if(ctx.IF() != null || ctx.WHILE() != null) {
           if(!getTypeFromExp(ctx.exp(0)).equals("boolean")) {
              System.err.println("If must have a boolean exp");
              System.exit(1);
           }
        }
        if(ctx.ASSIGNMENT() != null) {
            //If assigment to index of array
            if(ctx.exp().size() == 2){
                if(ctx.exp(0).INT_LIT() == null && !getTypeFromExp(ctx.exp(0)).equals("int")){
                    System.err.println("Invalid index of array at line " + ctx.ID().getSymbol().getLine());
                    System.exit(1);
                }
                String arrayType = getTypeFromArrayId(ctx.ID());
                if(!arrayType.equals(getTypeFromExp(ctx.exp(1)))){
                    System.err.println("Cannot assign " + getTypeFromExp(ctx.exp(1)) + " to " + arrayType +
                            " array on line " + ctx.ID().getSymbol().getLine());
                    System.exit(1);
                }
            }

            else if(!getTypeFromId(ctx.ID()).equals(getTypeFromExp(ctx.exp(0)))) {
                System.err.println("Cannot assign " + getTypeFromExp(ctx.exp(0)) + " to " + getTypeFromId(ctx.ID()) +
                        " variable on line " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }

    }


    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        currClass = ctx;
        classVariables.clear();
    }

    @Override public void exitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx) {
        currClass = null;
        classVariables.clear();
    }

    @Override public void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        methodVariables.clear();
    }

    @Override public void enterFormallist(@NotNull javagrammarParser.FormallistContext ctx) {
        if(ctx.type() != null) {
            if(!idAlreadyInCurrentContext(ctx.ID())) {
                methodVariables.put(ctx.ID().getText(), ctx.type().getText());
            } else {
                System.err.println("Cannot redefine variable at line " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }
    }
    @Override public void enterFormalrest(@NotNull javagrammarParser.FormalrestContext ctx){
        if(ctx.type() != null) {
            if(!idAlreadyInCurrentContext(ctx.ID())) {
                methodVariables.put(ctx.ID().getText(), ctx.type().getText());
            } else {
                System.err.println("Cannot redefine variable at line " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }
    }

    @Override public void exitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        if(!ctx.type().getText().equals(getTypeFromExp(ctx.exp()))) {
            System.err.println("You have to return an item of the same type as the method");
            System.exit(1);
        }
        methodVariables.clear();
    }

    @Override public void enterType(@NotNull javagrammarParser.TypeContext ctx) {
        if(ctx.ID() != null && !classes.containsKey(ctx.ID().getText())) {
            System.err.println("Class " + ctx.ID().getText() + " does not exist");
            System.exit(1);
        }
    }

    /**
     * Go through an ```Exp´´´ and find what type it results in in the end.
     * Return the type.
     */
    private String getTypeFromExp(javagrammarParser.ExpContext exp) {;
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
            } else if(classes.containsKey(exp.ID().getText())) {
                return exp.ID().getText();
            } else {
                System.err.println("Cannot create instance of " + exp.ID().getText());
                System.exit(1);
            }
        } else if(exp.NOT() != null) {
            if(getTypeFromExp(exp.exp(0)).equals("boolean")) {
                return "boolean";
            } else {
                System.err.println("Cannot negate a non boolean value");
                System.exit(1);
            }
        } else if(exp.ID() != null && exp.DOT() == null) {
            return getTypeFromId(exp.ID());
        }

        /*
         * Other expressions that aren't as obvious and might need some calculations
         * to know which type to return.
         */
        else if(exp.AND() != null || exp.OR() != null) {
            if(getTypeFromExp(exp.exp(0)).equals("boolean") && getTypeFromExp(exp.exp(1)).equals("boolean")) {
                return "boolean";
            }
            else {
                System.err.println("Both sides of AND or OR must be boolean");
                System.exit(1);
            }
        }

        else if((exp.MULT() != null) || (exp.MINUS() != null) || (exp.PLUS() != null)) {
            //Could be either long or int
            String numtype = getTypeFromExp(exp.exp(0));
            if(numtype.matches("int|long") && numtype.equals(getTypeFromExp(exp.exp(1)))) {
                return numtype;
            } else {
                System.err.println("Both expression must be either long or int.");
                System.exit(1);
            }
        } else if((exp.MEQ() != null) || (exp.EQ() != null) || (exp.LEQ() != null) || (exp.LESSTHAN() != null)
                || (exp.MORETHAN() != null)) {
            String exptype = getTypeFromExp(exp.exp(0));
            String exptype2 = getTypeFromExp(exp.exp(1));
            if(exptype.matches("int|long|boolean|int\\[\\]|long\\[\\]")) {
                if(exptype.equals(exptype2)) {
                    return "boolean";
                }else if((exptype.equals("int") || exptype.equals("long")) && (exptype2.equals("int") || exptype2.equals("long"))){
                    return "boolean";
                }
            }
            //If exp(0) is a pointer, then we can compare it to any other pointer.
            //Therefore make sure that exp(1) is not a primitive type
            else if (!getTypeFromExp(exp.exp(1)).matches("int|long|boolean|int\\[\\]|long\\[\\]")) {
               return "boolean";
            }
            System.err.println("Cannot compare " + exptype + " with " + getTypeFromExp(exp.exp(1)));
            System.exit(1);
        } else if(exp.LENGTH() != null) {
            if(getTypeFromExp(exp.exp(0)).matches("int\\[]|long\\[]")) {
                return "int";
            }
            System.err.println("Can not get the length of this object");
            System.exit(1);
        } else if(exp.exp().size() == 2 && exp.LEFTBRACKET() != null){
            if(getTypeFromExp(exp.exp(1)).equals("int")){
                return getArrayTypeFromExp(exp.exp(0));
            }
            System.err.println("Invalid index of array at line: " + exp.LEFTBRACKET().getSymbol().getLine());
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

        //If an exp is within brackets (exp)
        if(exp.LEFTPAREN() != null) {
            return getTypeFromExp(exp.exp(0));
        }
        /*
         * If we reach this point, we have made a mistake.
         */
        System.err.println("Something has gone terribly wrong in getTypeFromExp");
        System.err.println("Check it out!");
        System.err.println(exp.getText());
        System.exit(1);
        return null;
    }

    /**
     * Scans available ids and returns which type it has.
     * If no matching id can be found, exit the compiler.
     */
    private String getTypeFromId(TerminalNode id) {
        if(classVariables.containsKey(id.getText())) {
            return classVariables.get(id.getText());
        }
        else if(methodVariables.containsKey(id.getText())) {
            return methodVariables.get(id.getText());
        }
        System.err.println("Cannot find id : " + id.getText() + " at line " + id.getSymbol().getLine());
        System.exit(1);
        return null;
    }

    /**
     * Gets the type of the objects an array i storing
     * @param id the id of the array
     * @return String representing the type
     */
    private String getTypeFromArrayId(TerminalNode id){
        return getTypeFromId(id).split("\\[")[0];
    }

    private String getArrayTypeFromExp(javagrammarParser.ExpContext exp){
        return getTypeFromExp(exp).split("\\[")[0];
    }

    private boolean idAlreadyInCurrentContext(TerminalNode id) {
        return methodVariables.containsKey(id.getText());
    }

    private void addNewIdToContext(TerminalNode id, String type, RuleContext rc) {
        if(rc instanceof javagrammarParser.MainclassContext || rc instanceof javagrammarParser.ClassdeclContext) {
            classVariables.put(id.getText(), type);
            return;
        }
        methodVariables.put(id.getText(), type);
    }
}
