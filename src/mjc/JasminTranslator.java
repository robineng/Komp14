package mjc;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private int labelCount;

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
        labelCount = 0;

    }

    private String getTypeDescriptor(String type){
        if(typeDescriptors.containsKey(type)){
            return typeDescriptors.get(type);
        }
        return String.format("L%s;", type);
    }

    private String getTypeMnemonic (String type) {
        if(typeMnemonic.containsKey(type)) {
            return typeMnemonic.get(type);
        }
        else {
            return String.format("a");
        }
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
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getLocalCounter()));
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


    }

    @Override public void exitClassdecl(javagrammarParser.ClassdeclContext ctx) {
        filePrinter.append(String.format(".method public <init>()V\n"));
        filePrinter.append(String.format("aload_0\n"));
        filePrinter.append(String.format("invokenonvirtual java/lang/Object/<init>()V\n"));
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".end method\n\n"));
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
                filePrinter.append("lconst_0\n");
                filePrinter.append(String.format("lstore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
            } else if(var.getType().matches("int|boolean")) {
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("istore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
            } else {
                filePrinter.append("aconst_null\n");
                filePrinter.append(String.format("astore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
            }
        }
    }

    @Override public void enterMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        this.currMethod = this.currClass.getMethod(ctx.ID().getText());
        filePrinter.append(String.format(".method public %s(", ctx.ID().getText()));
        ArrayList<VariableSymbol> params = currMethod.getParams();
        for(VariableSymbol var : params){
            filePrinter.append(getTypeDescriptor(var.getType()));
        }
        filePrinter.append(String.format(")%s\n", getTypeDescriptor(ctx.type().getText())));
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getLocalCounter()));
        //This seems to be needed
        //TODO Better way of finding stack limit
        filePrinter.append(String.format(".limit stack %d\n", 10));
    }

    @Override public void exitMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        evaluateExp(ctx.exp());
        filePrinter.append(String.format("%sreturn\n", getTypeMnemonic(getTypeDescriptor(currMethod.getType()))));
        filePrinter.append(".end method\n");
        this.currMethod = null;
    }

    /*
    Här händer snart en jävla massa grejer.
     */
    @Override public void enterStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.ASSIGNMENT() != null) {
            if(ctx.LEFTBRACKET() == null){
                if(currMethod.varExists(ctx.ID().getText())) {
                    String type = evaluateExp(ctx.exp(0));
                    String prefix = getTypeMnemonic(getTypeDescriptor(currMethod.getVar(ctx.ID().getText()).getType()));
                    if(type.equals("I") && prefix.equals("l")){
                        filePrinter.append("i2l\n");
                    }
                    int local = currMethod.getVarLocal(ctx.ID().getText());
                    filePrinter.append(String.format("%sstore %d\n", prefix, local));
                } else {
                    //"this"
                    filePrinter.append(String.format("aload 0\n"));
                    String val = evaluateExp(ctx.exp(0));
                    String type = getTypeDescriptor(currClass.getVar(ctx.ID().getText()).getType());
                    if(val.equals("I") && type.equals("J")){
                        filePrinter.append("i2l\n");
                    }
                    filePrinter.append(String.format("putfield %s/%s %s\n", currClass.getId(), ctx.ID().getText(), type));
                }

            } else {
                if(currMethod.varExists(ctx.ID().getText())){
                    filePrinter.append(String.format("aload %d\n", currMethod.getVarLocal(ctx.ID().getText())));
                    evaluateExp(ctx.exp(0));
                    String type = evaluateExp(ctx.exp(1));
                    String arrtype = getTypeDescriptor(currMethod.getVar(ctx.ID().getText()).getArrayElementType());
                    if(type.equals("I") && arrtype.equals("J")){
                        filePrinter.append("i2l\n");
                    }
                    filePrinter.append(String.format("%sastore\n", getTypeMnemonic(arrtype)));
                } else {
                    String type = currClass.getVar(ctx.ID().getText()).getType();
                    filePrinter.append("aload 0\n");
                    filePrinter.append(String.format("getfield %s/%s %s\n", currClass.getId(), ctx.ID().getText(), getTypeDescriptor(type)));
                    evaluateExp(ctx.exp(0));
                    String valtype = evaluateExp(ctx.exp(1));
                    String arrtype = getTypeDescriptor(currClass.getVar(ctx.ID().getText()).getArrayElementType());
                    if(valtype.equals("I") && arrtype.equals("J")){
                        filePrinter.append("i2l\n");
                    }
                    filePrinter.append(String.format("%sastore\n", getTypeMnemonic(arrtype)));
                }
            }
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
        if(exp.AND() != null){
            evaluateExp(exp.exp(0));
            evaluateExp(exp.exp(1));
            String.format("iand\n");
            return "Z";
        }
        if(exp.OR() != null){
            evaluateExp(exp.exp(0));
            evaluateExp(exp.exp(1));
            String.format("ior\n");
            return "Z";
        }
        if(exp.EQ() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("if_icmpeq Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
            else if(type1.equals("I") && type2.equals("I") || type1.equals("Z") && type2.equals("Z")){
                filePrinter.append(String.format("if_icmpeq Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Har vi kommit hit så dealar vi med objektreferenser
                filePrinter.append(String.format("if_acmpeq Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.NEQ() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("if_icmpne Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
            else if(type1.equals("I") && type2.equals("I") || type1.equals("Z") && type2.equals("Z")){
                filePrinter.append(String.format("if_icmpne Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Har vi kommit hit så dealar vi med objektreferenser
                filePrinter.append(String.format("if_acmpne Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.LESSTHAN() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                    filePrinter.append("dup2_x2\n");
                    filePrinter.append("pop2\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append(String.format("iflt Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmplt Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.MORETHAN() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                    filePrinter.append("dup2_x2\n");
                    filePrinter.append("pop2\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append(String.format("ifgt Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmpgt Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.LEQ() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                    filePrinter.append("dup2_x2\n");
                    filePrinter.append("pop2\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append(String.format("ifle Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmple Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.MEQ() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    filePrinter.append("pop2\n");
                    filePrinter.append("i2l\n");
                    filePrinter.append("dup2_x2\n");
                    filePrinter.append("pop2\n");
                }
                filePrinter.append("lcmp\n");
                filePrinter.append(String.format("ifge Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmpge Label%d\n", this.labelCount));
                filePrinter.append("ldc 0\n");
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }


        if(exp.NEW() != null){
            if(exp.INT() != null){
                evaluateExp(exp.exp(0));
                filePrinter.append(String.format("newarray %s\n", "int"));
                return getTypeDescriptor("int[]");
            }
            if(exp.LONG() != null){
                evaluateExp(exp.exp(0));{
                    filePrinter.append(String.format("newarray %s\n", "long"));
                    return getTypeDescriptor("int[]");
                }
            }
            if(exp.ID() != null){
                filePrinter.append(String.format("new %s\n", exp.ID().getText()));
                filePrinter.append("dup\n");
                filePrinter.append(String.format("invokespecial %s/<init>()V\n", exp.ID().getText()));
                return getTypeDescriptor(exp.ID().getText());
            }
        }

        if(exp.LEFTBRACKET() != null){
            String type = evaluateExp(exp.exp(0));
            String prefix;
            String ret;
            if(type.indexOf("I") != -1){
                prefix = "i";
                ret = "I";
            } else {
                prefix = "l";
                ret = "J";
            }
            evaluateExp(exp.exp(1));
            filePrinter.append(String.format("%saload\n", prefix));
            return ret;
        }

        if(exp.THIS() != null){
            filePrinter.append("aload 0\n");
            return getTypeDescriptor(currClass.getId());
        }
        if(exp.LENGTH() != null){
            evaluateExp(exp.exp(0));
            filePrinter.append("arraylength\n");
            return getTypeDescriptor("int");
        }
        if(exp.ID() != null && exp.LEFTPAREN() != null){
            //TODO Varning för fulhack?
            String classname = evaluateExp(exp.exp(0)).split("L|;")[1];
            String methodType = getTypeDescriptor(this.classes.get(classname).getMethod(exp.ID().getText()).getType());
            ArrayList<String> types = new ArrayList<String>();
            if(exp.explist().exp() != null){
                types.add(evaluateExp(exp.explist().exp()));
                for(javagrammarParser.ExprestContext rest : exp.explist().exprest()){
                   types.add(evaluateExp(rest.exp()));
                }
            }
            filePrinter.append(String.format("invokevirtual %s/%s(", classname, exp.ID().getText()));
            for(String type : types){
                filePrinter.append(type);
            }
            filePrinter.append(String.format(")%s\n", methodType));
            return methodType;

        }

        if(exp.ID() == null && exp.LEFTPAREN() != null){
            String type = evaluateExp(exp.exp(0));
            return getTypeDescriptor(type);
        }

        if(exp.ID() != null){
            if(currMethod.varExists(exp.ID().getText())){
                String type = currMethod.getVar(exp.ID().getText()).getType();
                String prefix = getTypeMnemonic(getTypeDescriptor(type)) ;
                int local = currMethod.getVarLocal(exp.ID().getText());
                filePrinter.append(String.format("%sload %d\n", prefix, local));
                return getTypeDescriptor(type);
            } else {
                String type = currClass.getVar(exp.ID().getText()).getType();
                filePrinter.append("aload 0\n");
                filePrinter.append(String.format("getfield %s/%s %s\n", currClass.getId(), exp.ID().getText(), getTypeDescriptor(type)));
                return getTypeDescriptor(type);
            }
        }
        return null;
    }
}
