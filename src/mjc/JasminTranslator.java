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
    private ClassSymbol currClass;
    private MethodSymbol currMethod;
    private HashMap <String, String> typeDescriptors;
    private HashMap <String, String> typeMnemonic;

    public JasminTranslator(HashMap<String, ClassSymbol> classes) {
        super();
        this.classes = classes;
        typeDescriptors = new HashMap<String, String>();
        typeDescriptors.put("int", "I");
        typeDescriptors.put("long", "J");
        typeDescriptors.put("boolean", "Z");
        typeDescriptors.put("int[]", "[I");
        typeDescriptors.put("long[]", "[J");
        typeMnemonic = new HashMap<String, String>();
        typeMnemonic.put("I", "i");
        typeMnemonic.put("J", "l");
        typeMnemonic.put("Z", "i");

    }

    private String getTypeDescriptor(String type){
        if(typeDescriptors.containsKey(type)){
            return typeDescriptors.get(type);
        }
        return String.format("L%s;", type);
    }

    @Override public void enterMainclass(javagrammarParser.MainclassContext ctx) {
        this.currClass = this.classes.get(ctx.ID(0).getText());
        this.currMethod = this.currClass.getMethod("main");

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
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getVars().size() + currMethod.getParams().size() + 1));
        //TODO Better way of finding stack limit
        //Must we limit the stack size at all?
        filePrinter.append(String.format(".limit stack %d\n", 10));

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

    @Override public void enterVardecl(javagrammarParser.VardeclContext ctx) {
        if(currMethod == null) {
            VariableSymbol field = currClass.getVar(ctx.ID().getText());
            filePrinter.append(String.format(".field public %s %s\n", ctx.ID().getText(), getTypeDescriptor(field.getType())));
        } else{
            VariableSymbol var = currMethod.getVar(ctx.ID().getText());
            if(var.getType().equals("long")){
                filePrinter.append("ldc2_w 0");
                filePrinter.append(String.format("lstore %d", currMethod.getVarLocal(ctx.ID().getText())));
            }
        }
    }

    @Override public void enterMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = this.currClass.getMethod(ctx.ID().getText());
        filePrinter.append(String.format(".method public %s(", ctx.ID().getText()));
        VariableSymbol[] params = (VariableSymbol[]) currMethod.getParams().toArray();
        for(VariableSymbol var : params){
            if(typeDescriptors.containsKey(var.getType())){
                //If it's a primitive type
                filePrinter.append(typeDescriptors.get(var.getType()));
            } else {
                //If it's another class
                filePrinter.append(String.format("L%s;", var.getType()));
            }
        }
        if(typeDescriptors.containsKey(ctx.type().getText())){
            filePrinter.append(String.format(")%s\n", typeDescriptors.get(ctx.type().getText())));
        }else{
            filePrinter.append(String.format(")L%s;\n", ctx.type().getText()));
        }
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getVars().size() + currMethod.getParams().size() + 1));
        //This seems to be needed
        //TODO Better way of finding stack limit
        filePrinter.append(String.format(".limit stack %d\n", 10));
    }

    @Override public void exitMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        evaluateExp(ctx.exp());
        filePrinter.append("return\n");
        filePrinter.append(".end method\n");
        this.currMethod = null;
    }

    /*
    Här händer snart en jävla massa grejer.
     */
    @Override public void enterStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.ASSIGNMENT() != null) {
            //TODO En grej
        }
        if(ctx.SYSO() != null){
            filePrinter.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            String type = evaluateExp(ctx.exp(0));
            filePrinter.append(String.format("invokevirtual java/io/PrintStream/println(%s)V\n", type));
        }
    }

    /*
     * Förslag:
     * Alla exps är i slutändan ett enda värde (antingen en primitiv typ eller en pekare)
     * denna metod appendar jasminkod för att räkna ut expen och sedan lägger värdet överst
     * i stacken. Det är sedan upp till Stmt att bestämma vad som ska göras med den.
     *
     * Vi returnerar en string med typen av expen för att det är information som kan behövas
     * vid val av instruktion.
     *
     * Det var typ det jag tänkt. Låter asbra
     */
    public String evaluateExp(javagrammarParser.ExpContext exp){
        if(exp.INT_LIT() !=  null){
            filePrinter.append(String.format("ldc %s\n", exp.INT_LIT().getText()));
            return typeDescriptors.get("int");
        }
        if(exp.LONG_LIT() != null){
            //ldc2_w är för att ladda category 2 konstanter (double och long)
            filePrinter.append(String.format("ldc2_w %s\n", exp.LONG_LIT().getText().split("L|l")[0]));
            return typeDescriptors.get("long");
        }
        if(exp.TRUE() != null){
            filePrinter.append("ldc 1\n");
            return typeDescriptors.get("boolean");
        }
        if(exp.FALSE() != null){
            filePrinter.append("ldc 0\n");
            return typeDescriptors.get("boolean");
        }
        if(exp.PLUS() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))){
                if(type2.equals(typeDescriptors.get("int"))){
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    //swap = byt plats på första och andra värdet på stacken
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                }
                filePrinter.append("ladd\n");
                return typeDescriptors.get("long");
            }else{
                filePrinter.append("iadd\n");
                return typeDescriptors.get("int");
            }
        }
        if(exp.MULT() != null) {
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))) {
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                }
                filePrinter.append("lmul\n");
                return typeDescriptors.get("long");
            } else {
                filePrinter.append("imul\n");
                return typeDescriptors.get("int");
            }
        }

        if(exp.MINUS() != null) {
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))) {
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                    filePrinter.append("dup2_x2\n");
                    filePrinter.append("pop2\n");
                }
                filePrinter.append("lsub\n");
                return typeDescriptors.get("long");
            }
            else {
                filePrinter.append("isub\n");
                return typeDescriptors.get("int");
            }
        }

        if(exp.ID() != null){
            if(currMethod.varExists(exp.ID().getText())){
                String type = currMethod.getVar(exp.ID().getText()).getType();
                String prefix = typeMnemonic.get(typeDescriptors.get(type));
                int local = currMethod.getVarLocal(exp.ID().getText());
                filePrinter.append(String.format("%sload %d\n", prefix, local));
            }
        }
        return null;
    }
}
