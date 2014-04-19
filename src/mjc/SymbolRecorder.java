package mjc;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;

/**
 * Created by robin on 4/15/14.
 */
public class SymbolRecorder extends javagrammarBaseListener{

    private HashMap<String, ClassSymbol> classes;
    private ClassSymbol currClass;
    private MethodSymbol currMethod;

    public SymbolRecorder(){
        classes = new HashMap<String, ClassSymbol>();

    }

    public HashMap<String, ClassSymbol> getClasses(){
        return this.classes;
    }

    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        ClassSymbol mainClass = new ClassSymbol(ctx.ID(0).getText());
        MethodSymbol mainMethod = new MethodSymbol("void");
        mainMethod.addParam(ctx.ID(2).getText(), new VariableSymbol("String[]"));
        mainClass.addMethod("main", mainMethod);
        this.classes.put(ctx.ID(0).getText(), mainClass);
        this.currClass = mainClass;
        this.currMethod = mainMethod;
    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        this.currMethod = null;
    }

    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx){
        if(this.classes.containsKey(ctx.ID().getText())){
            System.err.println("Class name already exists on line: " + ctx.ID().getSymbol().getLine());
            System.exit(1);
        }
        ClassSymbol cl = new ClassSymbol(ctx.ID().getText());
        this.classes.put(ctx.ID().getText(), cl);
        this.currClass = cl;
    }

    @Override public void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        MethodSymbol meth = new MethodSymbol(ctx.type().getText());
        if(ctx.formallist().ID() != null){
            meth.addParam(ctx.formallist().ID().getText(), new VariableSymbol(ctx.formallist().type().getText()));
            for(javagrammarParser.FormalrestContext frest : ctx.formallist().formalrest()){
                if(!meth.addParam(frest.ID().getText(), new VariableSymbol(frest.type().getText()))){
                    System.err.println("Param id already exists on line: " + ctx.ID().getSymbol().getLine());
                    System.exit(1);
                }

            }
        }
        currMethod = meth;
        if(this.currClass.addMethod(ctx.ID().getText(), meth)){
            return;
        }else{
            System.err.println("Method id already exists on line: " + ctx.ID().getSymbol().getLine());
            System.exit(1);
        }


    }

    @Override public void exitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = null;
    }


    @Override public void enterVardecl(@NotNull javagrammarParser.VardeclContext ctx) {
        if(this.currMethod == null){
            VariableSymbol var = new VariableSymbol(ctx.type().getText());
            var.setInitiated(true);
            if(this.currClass.addVar(ctx.ID().getText(), var)){
                return;
            }else{
                System.err.println("Class variable already defined at line: " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }else{
            if(this.currMethod.addVar(ctx.ID().getText(), new VariableSymbol(ctx.type().getText()))){
                return;
            }else{
                System.err.println("Method variable already defined at line: " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }
    }




}
