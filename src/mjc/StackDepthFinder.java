package mjc;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;

/**
 * Created by robin on 2014-05-12.
 */
public class StackDepthFinder extends javagrammarBaseListener{

    HashMap<String, ClassSymbol> classes;
    ClassSymbol currClass;
    MethodSymbol currMethod;
    int stackCount;
    int maxStack;

    public StackDepthFinder(HashMap<String, ClassSymbol> classes){
        this.classes = classes;

    }

    @Override public void enterMainclass(javagrammarParser.MainclassContext ctx) {
        currClass = classes.get(ctx.ID(0).getText());
        currMethod = currClass.getMethod("main");
        stackCount = 0;
        maxStack = 0;
    }

    @Override public void exitMainclass(javagrammarParser.MainclassContext ctx) {
        currMethod.setStackCounter(maxStack);
        currClass = null;
        currMethod = null;
    }

    @Override public void enterClassdecl(javagrammarParser.ClassdeclContext ctx) {
        currClass = classes.get(ctx.ID().getText());
    }

    @Override public void exitClassdecl(javagrammarParser.ClassdeclContext ctx) {
        currClass = null;
    }

    @Override public void enterMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        currMethod = currClass.getMethod(ctx.ID().getText());
        stackCount = 0;
        maxStack = 0;
    }

    @Override public void exitMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        currMethod.setStackCounter(maxStack);
        currMethod = null;
    }

    @Override public void enterStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.IF() != null || ctx.WHILE() != null){
            evaluateExp(ctx.exp(0));
            incStack(-1);
        }
        if(ctx.SYSO() != null){
            incStack(1);
            evaluateExp(ctx.exp(0));
            incStack(-1);
        }
        if(ctx.ASSIGNMENT() != null){
            if(ctx.LEFTBRACKET() != null){
                evaluateExp(ctx.exp(0));
                if(idIsLong(ctx.ID())){
                    incStack(-2);
                } else {
                    incStack(-1);
                }
            } else {
                evaluateExp(ctx.exp(0));
                int dec = evaluateExp(ctx.exp(1));
                incStack(dec * -1);
            }
        }
    }

    private int evaluateExp(javagrammarParser.ExpContext exp){
        if(exp.LESSTHAN() != null || exp.MORETHAN() != null || exp.MEQ() != null || exp.LEQ() != null || exp.EQ() != null || exp.NEQ() != null){
            int e1 = evaluateExp(exp.exp(0));
            int e2 = evaluateExp(exp.exp(1));
            if(e1 == 2 || e2 == 2){
                incStack(4);
                incStack(-3);
                return 1;
            } else {
                incStack(2);
                incStack(-1);
                return 1;
            }
        }
        if(exp.OR() != null || exp.AND() != null){
            evaluateExp(exp.exp(0));
            evaluateExp(exp.exp(1));
            incStack(-1);
            return 1;
        }
        if(exp.NOT() != null){
            evaluateExp(exp.exp(0));
            return 1;
        }
        if(exp.INT_LIT() != null || exp.TRUE() != null || exp.FALSE() != null || exp.THIS() != null){
            incStack(1);
            return 1;
        }
        if(exp.LONG_LIT() != null){
            incStack(2);
            return 2;
        }
        if(exp.LENGTH() != null){
            evaluateExp(exp.exp(0));
            return 1;
        }
        if(true){
            
        }
        return -1;
    }



    private void incStack(int val){
        stackCount += val;
        if(stackCount > maxStack){
            maxStack = stackCount;
        }
    }

    private boolean idIsLong(TerminalNode id){
        if(currMethod.getVar(id.getText()).getType().equals("long")){
            return true;
        }
        return false;
    }

}
