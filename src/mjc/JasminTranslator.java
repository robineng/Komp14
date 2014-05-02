package mjc;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by suicidal on 4/3/14.
 */
public class JasminTranslator extends javagrammarBaseListener {

    private File currClassFile;
    private PrintWriter filePrinter;
    private HashMap<String, ClassSymbol> classes;
    private HashMap<String, VariableSymbol> currFields;
    private HashMap<String, MethodSymbol> currMethods;
    private ClassSymbol currClass;
    private MethodSymbol currMethod;
    private HashMap <String, String> primitiveTypes;

    public JasminTranslator(HashMap<String, ClassSymbol> classes) {
        super();
        this.classes = classes;
        primitiveTypes = new HashMap<String, String>();
        primitiveTypes.put("int", "I");
        primitiveTypes.put("long", "L");
        primitiveTypes.put("boolean", "B");
        primitiveTypes.put("int[]", "[I");
        primitiveTypes.put("long[]", "[L");
    }

    @Override public void enterMainclass(javagrammarParser.MainclassContext ctx) {
        this.currClass = this.classes.get(ctx.ID(0).getText());
        this.currMethod = this.currClass.getMethod("main");
        //localvars = new HashMap<String,Integer>();
        currClassFile = new File(ctx.ID(0).getText() + ".j");
        try {
            filePrinter = new PrintWriter(currClassFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        filePrinter.append(String.format(".class public %s\n", ctx.ID(0).getText()));
        filePrinter.append(String.format(".super java/lang/Object\n\n"));
        filePrinter.append(String.format(".method public <init>()V\n"));
        filePrinter.append(String.format("aload_0\n"));
        filePrinter.append(String.format("invokenonvirtual java/lang/Object/<init>()V\n"));
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".end method\n\n"));
        filePrinter.append(String.format(".method public static main([Ljava/lang/String;)V\n"));
        //+1 because args is the only argument
        filePrinter.append(String.format(".limit locals %d\n", ctx.vardecl().size()+1));

        currFields = classes.get(ctx.ID(0)).getVariables();
        currMethods = classes.get(ctx.ID(0)).getMethods();
    }

    @Override public void exitMainclass(javagrammarParser.MainclassContext ctx) {
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".end method\n\n"));
        filePrinter.flush();
        filePrinter.close();
        this.currClass = null;
        this.currMethod = null;
    }

    @Override public void enterClassdecl(javagrammarParser.ClassdeclContext ctx) {
        this.currClass = this.classes.get(ctx.ID().getText());
        currClassFile = new File(ctx.ID().getText() + ".j");
        try {
            filePrinter = new PrintWriter(currClassFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        filePrinter.append(String.format(".class public %s\n", ctx.ID().getText()));
        filePrinter.append(String.format(".super java/lang/Object\n\n"));
        filePrinter.append(String.format(".method public <init>()V\n"));
        filePrinter.append(String.format("aload_0\n"));
        filePrinter.append(String.format("invokenonvirtual java/lang/Object/<init>()V\n"));
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".end method\n\n"));

    }

    @Override public void exitClassdecl(javagrammarParser.ClassdeclContext ctx) {
        filePrinter.flush();
        filePrinter.close();
        this.currClass = null;
    }

    @Override public void enterMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = this.currClass.getMethod(ctx.ID().getText());
        filePrinter.append(String.format(".method public %s(", ctx.ID().getText()));
        VariableSymbol[] params = (VariableSymbol[]) currMethod.getParams().toArray();
        for(VariableSymbol var : params){
            if(primitiveTypes.containsKey(var.getType())){
                //If it's a primitive type
                filePrinter.append(primitiveTypes.get(var.getType()));
            } else {
                //If it's an other class
                filePrinter.append(String.format("L%s;", var.getType()));
            }
        }
        if(primitiveTypes.containsKey(ctx.type().getText())){
            filePrinter.append(String.format(")%s\n", primitiveTypes.get(ctx.type().getText())));
        }else{
            filePrinter.append(String.format(")L%s;\n", ctx.type().getText()));
        }
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getVars().size()+1));
        //TODO Vad ska vi returnera?
        filePrinter.append("return\n");
        filePrinter.append(".end method\n");


    }

    @Override public void exitMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = null;
    }

    @Override public void enterStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.ASSIGNMENT() != null) {

        }
    }

    public int evaluateExp(javagrammarParser.ExpContext exp){
        if(exp.PLUS() != null){
            if(exp.exp(0).INT_LIT() != null) {
                filePrinter.append(String.format("ipush %s\n", exp.exp(0).INT_LIT().getText()));
                filePrinter.append(String.format("iload %d\n", evaluateExp(exp.exp(1))));
                filePrinter.append(String.format("iadd\n"));
                filePrinter.append(String.format("istore %d\n")); //TODO: Add number to return here
                return 0; //Return said number!
                //add to local variable
                //Return local variable number
            }
        }
    }
}
