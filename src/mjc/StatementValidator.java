package mjc;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
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
                if(!arr.isInitiated()){
                    System.err.println("Variable isn't initiated on line: " + ctx.ASSIGNMENT().getSymbol().getLine());
                    System.exit(1);
                }
                if(!expType.equals(arr.getArrayElementType())){
                    System.err.println("Can not assign " + expType + " to " + arr.getArrayElementType() + " array on line: " + ctx.ASSIGNMENT().getSymbol().getLine());
                    System.exit(1);
                }

            }

        }
    }


    public String getTypeFromExp(javagrammarParser.ExpContext exp){
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
            if(exp.INT() != null){
                return "int[]";
            }
            if(exp.LONG() != null){
                return "long[]";
            }
            if(exp.ID() != null){
                return getTypeFromId(exp.ID());
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
            }
            MethodSymbol meth = cs.getMethod(exp.ID().getText());

        }
        return null;
    }

    public String getTypeFromId(TerminalNode id){
        if(currMethod.varExists(id.getText())){
            return currMethod.getVar(id.getText()).getType();
        }else if(currMethod.paramExists(id.getText())){
            return currMethod.getParam(id.getText()).getType();
        }else if(currClass.varExists(id.getText())){
            return currClass.getVar(id.getText()).getType();
        }
        System.err.println("Can not find variable: " + id.getText() + " on line: " + id.getSymbol().getLine());
        System.exit(1);
        return null;
    }

    public VariableSymbol getVarFromId(TerminalNode id){
        if(currMethod.varExists(id.getText())){
            return currMethod.getVar(id.getText());
        }else if(currMethod.paramExists(id.getText())){
            return currMethod.getParam(id.getText());
        }else if(currClass.varExists(id.getText())){
            return currClass.getVar(id.getText());
        }
        System.err.println("Can not find variable: " + id.getText() + " on line: " + id.getSymbol().getLine());
        System.exit(1);
        return null;
    }


}
