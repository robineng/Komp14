package mjc;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by robin on 4/15/14.
 */
public class StatementValidator extends javagrammarBaseListener{

    HashMap<String, ClassSymbol> classes;
    ClassSymbol currClass;
    MethodSymbol currMethod;

    public StatementValidator(HashMap<String, ClassSymbol> classes){
        this.classes = classes;
    }

    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        this.currClass = classes.get(ctx.ID(0).getText());
        this.currMethod = currClass.getMethod("main");
    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        this.currClass = null;
        this.currMethod = null;
    }

    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx){
        this.currClass = classes.get(ctx.ID().getText());
    }

    @Override public void exitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx){
        this.currClass = null;
    }

    @Override public void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = this.currClass.getMethod(ctx.ID().getText());
        if(!getTypeFromExp(ctx.exp()).equals(this.currMethod.getType())){
            System.err.println("Method must return a " + this.currMethod.getType() + " on line: " + ctx.RETURN().getSymbol().getLine());
            System.exit(1);
        }
    }

    @Override public void exitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = null;
    }

    @Override public void enterStmt(@NotNull javagrammarParser.StmtContext ctx){
        if(ctx.IF() != null || ctx.WHILE() != null){
            if(!getTypeFromExp(ctx.exp(0)).equals("boolean")){
                System.err.println("Expression not boolean at line: " + ctx.LEFTPAREN().getSymbol().getLine());
                System.exit(1);
            }
        }else if(ctx.SYSO() != null){
            if(!getTypeFromExp(ctx.exp(0)).matches("int|long|boolean")){
                System.err.println("Can not print a " + getTypeFromExp(ctx.exp(0)) + " on line: " + ctx.SYSO().getSymbol().getLine());
            }
        }else if(ctx.ASSIGNMENT() != null){
            if(ctx.LEFTBRACKET() == null){
                VariableSymbol var = getVarFromId(ctx.ID());
                String idType = getTypeFromId(ctx.ID());
                String expType = getTypeFromExp(ctx.exp(0));
                if(!idType.equals(expType) && !(idType.equals("long") && expType.equals("int"))){
                    System.err.println("Can not assign " + expType + " to " + idType + " on line: " + ctx.ASSIGNMENT().getSymbol().getLine());
                }
                var.setInitiated(true);
            }else{
                VariableSymbol arr = getVarFromId(ctx.ID());
                String expType = getTypeFromExp(ctx.exp(1));
                /*if(!arr.isInitiated()){
                    System.err.println("Variable isn't initiated on line: " + ctx.ASSIGNMENT().getSymbol().getLine());
                    System.exit(1);
                }*/
                if(!expType.equals(arr.getArrayElementType())){
                    System.err.println("Can not assign " + expType + " to " + arr.getArrayElementType() + " array on line: " + ctx.ASSIGNMENT().getSymbol().getLine());
                    System.exit(1);
                }

            }

        }
    }

    public String getTypeFromExp(javagrammarParser.ExpContext exp){
        //Basic values
        if(exp.INT_LIT() != null){
            return "int";
        }
        if(exp.LONG_LIT() != null){
            return "long";
        }
        if(exp.TRUE() != null || exp.FALSE() != null){
            return "boolean";
        }
        if(exp.THIS() != null){
            return this.currClass.getId();
        }
        if(exp.NEW() != null){
            if(exp.ID() != null){
                if(!classes.containsKey(exp.ID().getText())){
                    System.err.println("Class " + exp.ID().getText() + " not found on line: " + exp.ID().getSymbol().getLine());
                    System.exit(1);
                }else{
                    return exp.ID().getText();
                }
            }
            if(!getTypeFromExp(exp.exp(0)).equals("int")) {
                System.err.println("Must have an integer that specifices length on line: " + exp.NEW().getSymbol().getLine());
            }
            if(exp.INT() != null){
                return "int[]";
            }
            if(exp.LONG() != null){
                return "long[]";
            }
        }
        if(exp.LENGTH() != null){
            if(!getTypeFromExp(exp.exp(0)).matches("int\\[\\]|long\\[\\]")){
                System.err.println("Must take length off arrays on line: " + exp.LENGTH().getSymbol().getLine());
                System.exit(1);
            }else{
                return "int";
            }
        }
        if(exp.DOT() != null){
            String cl = getTypeFromExp(exp.exp(0));
            if(!classes.containsKey(cl)){
                System.err.println("Class " + cl + " not found on line: " + exp.DOT().getSymbol().getLine());
                System.exit(1);
            }
            ClassSymbol cs = classes.get(cl);
            if(!cs.methodExists(exp.ID().getText())){
                System.err.println("Method " + exp.ID().getText() + " not found on line: " + exp.DOT().getSymbol().getLine());
                System.exit(1);
            }
            MethodSymbol meth = cs.getMethod(exp.ID().getText());
            if(!checkMethodParams(meth, exp.explist())){
                System.err.println("Parameter failure on line: " + exp.DOT().getSymbol().getLine());
                System.exit(1);
            }
            return meth.getType();
        }

        if(exp.LEFTBRACKET() != null){
            if(!getTypeFromExp(exp.exp(1)).equals("int")){
                System.err.println("Index need to be integer on line: " + exp.LEFTBRACKET().getSymbol().getLine());
                System.exit(1);
            }
            String type = getTypeFromExp(exp.exp(0));
            if(!type.matches("int\\[\\]|long\\[\\]")){
                System.err.println("Must be int or long array on line: " + exp.LEFTBRACKET().getSymbol().getLine());
                System.exit(1);
            }
            return type.split("\\[")[0];
        }

        if(exp.AND() != null || exp.OR() != null){
            if(!getTypeFromExp(exp.exp(0)).equals("boolean") || !getTypeFromExp(exp.exp(1)).equals("boolean")){
                System.err.println("Both sides must be boolean: " + exp.getText());
                System.exit(1);
            }
            return "boolean";
        }

        if(exp.LEQ() != null || exp.MEQ() != null || exp.LESSTHAN() != null || exp.MORETHAN() != null){
            if(!getTypeFromExp(exp.exp(0)).matches("int|long") || !getTypeFromExp(exp.exp(1)).matches("int|long")) {
                System.err.println("Both sides must be numbers: " +  exp.getText());
                System.exit(1);
            }
            return "boolean";
        }
        if(exp.PLUS() != null || exp.MINUS() != null || exp.MULT() != null){
            if(!getTypeFromExp(exp.exp(0)).matches("int|long") || !getTypeFromExp(exp.exp(1)).matches("int|long")) {
                System.err.println("Both sides must be numbers: " +  exp.getText());
                System.exit(1);
            } if(getTypeFromExp(exp.exp(0)).equals("long") || getTypeFromExp(exp.exp(1)).equals("long")){
                return "long";
            } else{
                return "int";
            }
        }
        if(exp.EQ() != null || exp.NEQ() != null){
            String e1 = getTypeFromExp(exp.exp(0));
            String e2 = getTypeFromExp(exp.exp(1));
            if(e1.matches("int|long")){
                if(!e2.matches("int|long")){
                    System.err.println("Can not match " + e1 + " with " + e2);
                    System.exit(1);
                }else{
                    return "boolean";
                }
            } else{
                if(!e1.equals(e2)){
                    System.err.println("Can not match " + e1 + " with " + e2);
                    System.exit(1);
                }else{
                    return "boolean";
                }
            }
        }
        if(exp.NOT() != null){
            if(!getTypeFromExp(exp.exp(0)).equals("boolean")){
                System.err.println("Need boolean value for NOT on line: " + exp.NOT().getSymbol().getLine());
                System.exit(1);
            } else{
                return "boolean";
            }
        }

        if(exp.LEFTPAREN() != null){
            return getTypeFromExp(exp.exp(0));
        }

        //Bara ID kvar
        return getTypeFromId(exp.ID());
    }

    public boolean checkMethodParams(MethodSymbol method, javagrammarParser.ExplistContext eList){
        int nrOfExp = 0;
        ArrayList<String> typeList = new ArrayList<String>();
        if(eList.exp() != null){
            nrOfExp++;
            typeList.add(getTypeFromExp(eList.exp()));
            for(javagrammarParser.ExprestContext rest : eList.exprest()){
                nrOfExp++;
                typeList.add(getTypeFromExp(rest.exp()));
            }
            ArrayList<VariableSymbol> params = method.getParams();
            if(params.size() != nrOfExp){
                return false;
            }
            for(int i = 0; i<nrOfExp; i++){
                if(!typeList.get(i).equals(params.get(i).getType())){
                    return false;
                }
            }

        } else{
            if(method.getParams().size() != 0){
                return false;
            }
        }
        return true;

    }

    public String getTypeFromId(TerminalNode id){
        //System.out.println(id.getText());
        if(currMethod.varExists(id.getText())){
            return currMethod.getVar(id.getText()).getType();
        }else if(currClass.varExists(id.getText())){
            return currClass.getVar(id.getText()).getType();
        } else if(classes.containsKey(id.getText())){
            return id.getText();
        }
        System.err.println("Can not find variable: " + id.getText() + " on line: " + id.getSymbol().getLine());
        System.exit(1);
        return null;
    }

    public VariableSymbol getVarFromId(TerminalNode id){
        if(currMethod.varExists(id.getText())){
            return currMethod.getVar(id.getText());
        }else if(currClass.varExists(id.getText())){
            return currClass.getVar(id.getText());
        }
        System.err.println("Can not find variable: " + id.getText() + " on line: " + id.getSymbol().getLine());
        System.exit(1);
        return null;
    }


}
