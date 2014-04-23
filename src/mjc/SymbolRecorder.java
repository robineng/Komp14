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

    @Override public void enterProgram(@NotNull javagrammarParser.ProgramContext ctx){
        javagrammarParser.MainclassContext main = ctx.mainclass();
        ClassSymbol mainClass = new ClassSymbol(main.ID(0).getText());
        MethodSymbol mainMethod = new MethodSymbol("void");
        mainMethod.addParam(main.ID(2).getText(), new VariableSymbol("String[]"));
        mainClass.addMethod("main", mainMethod);
        this.classes.put(main.ID(0).getText(), mainClass);

        for(javagrammarParser.ClassdeclContext cl : ctx.classdecl()){
            if(this.classes.containsKey(cl.ID().getText())){
                System.err.println("Class name already exists on line: " + cl.ID().getSymbol().getLine());
                System.exit(1);
            }
            ClassSymbol cla = new ClassSymbol(cl.ID().getText());
            this.classes.put(cl.ID().getText(), cla);
        }
    }

    @Override public void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        this.currClass = this.classes.get(ctx.ID(0).getText());
        this.currMethod = this.currClass.getMethod("main");
    }

    @Override public void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx) {
        this.currMethod = null;
    }

    @Override public void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx){
        this.currClass = this.classes.get(ctx.ID().getText());
    }

    @Override public void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx) {
        MethodSymbol meth = new MethodSymbol(ctx.type().getText());
        if(ctx.formallist().ID() != null){
            VariableSymbol var = new VariableSymbol(ctx.formallist().type().getText());
            meth.addParam(ctx.formallist().ID().getText(), var);
            for(javagrammarParser.FormalrestContext frest : ctx.formallist().formalrest()){
                var = new VariableSymbol(frest.type().getText());
                if(!meth.addParam(frest.ID().getText(), var)){
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
            if(ctx.type().ID() != null && !classes.containsKey(ctx.type().ID().getText())){
                System.err.println("Can not find class " + ctx.type().ID().getText() + " on line " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
            if(this.currClass.addVar(ctx.ID().getText(), var)){
                return;
            }else{
                System.err.println("Class variable already defined at line: " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }else{
            if(ctx.type().ID() != null && !classes.containsKey(ctx.type().ID().getText())){
                System.err.println("Can not find class " + ctx.type().ID().getText() + " on line " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
            VariableSymbol var = new VariableSymbol(ctx.type().getText());
            if(this.currMethod.addVar(ctx.ID().getText(), var)){
                return;
            }else{
                System.err.println("Method variable already defined at line: " + ctx.ID().getSymbol().getLine());
                System.exit(1);
            }
        }
    }




}
