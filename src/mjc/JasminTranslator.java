package mjc;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * JasminTranslator is a walkable class using the javagrammarBaseListener.
 * This class is specficly used for appending jasmin code to files using information both from
 * the syntax tree and from the data (classes HashMap) generated in the SymbolRecorder class.
 *
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
    private int stacklimit;
    private int currStack;

    //If true: Prints the evaluated stack depth after every expression
    private final static boolean STACK_DEBUG = false;

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

    /**
     * Returns the Jasmin type descriptor of the desired type
     * @param type the type, for example "int" or "long[]"
     * @return the jasmin typeDescriptor
     */
    private String getTypeDescriptor(String type){
        if(typeDescriptors.containsKey(type)){
            return typeDescriptors.get(type);
        }
        return String.format("L%s;", type);
    }

    /**
     * Returns the JVM instruction type mnemonic of desired type descriptor
     *
     * @param type The type descriptor, for example "I" or "[J"
     * @return the type mnemonic, for example "i" or "l"
     */
    private String getTypeMnemonic (String type) {
        if(typeMnemonic.containsKey(type)) {
            return typeMnemonic.get(type);
        }
        else {
            return String.format("a");
        }
    }

    /**
     * Makes a new class file (.j) and writes initial code and starts on main method.
     *
     * @param ctx
     */
    @Override public void enterMainclass(javagrammarParser.MainclassContext ctx) {
        this.currClass = this.classes.get(ctx.ID(0).getText());
        this.currMethod = this.currClass.getMethod("main");
        this.stacklimit = 0;
        this.currStack = 0;

        currClassFile = new File(ctx.ID(0).getText() + ".j");
        try {
            filePrinter = new PrintWriter(currClassFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        filePrinter.append(String.format(".class public '%s'\n", ctx.ID(0).getText()));
        filePrinter.append(String.format(".super java/lang/Object\n\n"));
        filePrinter.append(String.format(".method public <init>()V\n"));
        filePrinter.append(String.format("aload_0\n"));
        filePrinter.append(String.format("invokenonvirtual java/lang/Object/<init>()V\n"));
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".end method\n\n"));
        filePrinter.append(String.format(".method public static main([Ljava/lang/String;)V\n"));
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getLocalCounter()));
        for(javagrammarParser.VardeclContext var : ctx.vardecl()){
            handleVardecl(var);
        }
        for(javagrammarParser.StmtContext stmt : ctx.stmt()){
            handleStmt(stmt);
        }

    }

    /**
     * Closes the main method and exits the mainclass.
     *
     * @param ctx
     */
    @Override public void exitMainclass(javagrammarParser.MainclassContext ctx) {
        filePrinter.append(String.format("return\n"));
        filePrinter.append(String.format(".limit stack %d\n", stacklimit));
        filePrinter.append(String.format(".end method\n\n"));
        filePrinter.flush();
        filePrinter.close();
        this.currClass = null;
        this.currMethod = null;
    }

    /**
     * Enters a new class, creating a new file and appending initial code.
     *
     * @param ctx
     */
    @Override public void enterClassdecl(javagrammarParser.ClassdeclContext ctx) {
        this.currClass = this.classes.get(ctx.ID().getText());
        currClassFile = new File(ctx.ID().getText() + ".j");
        try {
            filePrinter = new PrintWriter(currClassFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        filePrinter.append(String.format(".class public '%s'\n", ctx.ID().getText()));
        filePrinter.append(String.format(".super java/lang/Object\n\n"));
        for(javagrammarParser.VardeclContext var : ctx.vardecl()){
            handleVardecl(var);
        }


    }

    /**
     * Appends code for class constructor and exits the class.
     *
     * @param ctx
     */
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

    /**
     * Handles a varaible declaration by appending neccesary jasmin code depending
     * on type as well as if it's in a local or global context.
     *
     * @param ctx The variable context.
     */
    public void handleVardecl(javagrammarParser.VardeclContext ctx) {
        if(currMethod == null) {
            VariableSymbol field = currClass.getVar(ctx.ID().getText());
            filePrinter.append(String.format(".field public '%s' %s\n", ctx.ID().getText(), getTypeDescriptor(field.getType())));
        } else{
            VariableSymbol var = currMethod.getVar(ctx.ID().getText());
            if(var.getType().equals("long")){
                filePrinter.append(String.format("lconst_0\n"));
                incStack(2);
                filePrinter.append(String.format("lstore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
                incStack(-2);
            } else if(var.getType().matches("int|boolean")) {
                filePrinter.append(String.format("ldc 0\n"));
                incStack(1);
                filePrinter.append(String.format("istore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
                incStack(-1);
            } else {
                filePrinter.append(String.format("aconst_null\n"));
                incStack(1);
                filePrinter.append(String.format("astore %d\n", currMethod.getVarLocal(ctx.ID().getText())));
                incStack(-1);
            }
        }
    }

    /**
     * Enters a method declaration, appends neccesary method code to the file.
     *
     * @param ctx
     */
    @Override public void enterMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        this.stacklimit = 0;
        this.currStack = 0;
        this.currMethod = this.currClass.getMethod(ctx.ID().getText());
        filePrinter.append(String.format(".method public %s(", ctx.ID().getText()));
        ArrayList<VariableSymbol> params = currMethod.getParams();
        for(VariableSymbol var : params){
            filePrinter.append(getTypeDescriptor(var.getType()));
        }
        filePrinter.append(String.format(")%s\n", getTypeDescriptor(ctx.type().getText())));
        filePrinter.append(String.format(".limit locals %d\n", currMethod.getLocalCounter()));
        for(javagrammarParser.VardeclContext var : ctx.vardecl()){
            handleVardecl(var);
        }
        for(javagrammarParser.StmtContext stmt : ctx.stmt()){
            handleStmt(stmt);
        }
    }

    /**
     * Exits a method declaration, appending neccesary code as well as the stack limit.
     *
     * @param ctx
     */
    @Override public void exitMethoddecl(javagrammarParser.MethoddeclContext ctx) {
        evaluateExp(ctx.exp());
        filePrinter.append(String.format("%sreturn\n", getTypeMnemonic(getTypeDescriptor(currMethod.getType()))));
        filePrinter.append(String.format(".limit stack %d\n", stacklimit));
        filePrinter.append(".end method\n");
        this.currMethod = null;
    }


    /**
     * Handles a Stmt by:
     * Making branches if we deal with IF or WHILE
     * Evaluates expressions and stores the values if we deal with assignments
     * Printing expression with SYSO
     *
     * @param ctx
     */
    public void handleStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.IF() != null){
            if(ctx.ELSE() == null){
                evaluateExp(ctx.exp(0));
                int label1 = this.labelCount;
                this.labelCount++;
                filePrinter.append(String.format("ifeq Label%d\n", label1));
                incStack(-1);
                handleStmt(ctx.stmt(0));
                filePrinter.append(String.format("Label%d:\n", label1));
            } else {
                evaluateExp(ctx.exp(0));
                int label1 = this.labelCount;
                int label2 = this.labelCount + 1;
                this.labelCount += 2;
                filePrinter.append(String.format("ifeq Label%d\n", label1));
                incStack(-1);
                handleStmt(ctx.stmt(0));
                filePrinter.append(String.format("goto Label%d\n", label2));
                filePrinter.append(String.format("Label%d:\n", label1));
                handleStmt(ctx.stmt(1));
                filePrinter.append(String.format("Label%d:\n", label2));
            }

        }
        if(ctx.WHILE() != null){
            int label1 = this.labelCount;
            int label2 = this.labelCount + 1;
            labelCount += 2;
            filePrinter.append(String.format("Label%d:\n", label1));
            evaluateExp(ctx.exp(0));
            filePrinter.append(String.format("ifeq Label%d\n", label2));
            incStack(-1);
            handleStmt(ctx.stmt(0));
            filePrinter.append(String.format("goto Label%d\n", label1));
            filePrinter.append(String.format("Label%d:\n", label2));

        }
        if(ctx.LEFTBRACE() != null){
            for(javagrammarParser.StmtContext stmt : ctx.stmt()){
                handleStmt(stmt);
            }
        }
        if(ctx.ASSIGNMENT() != null) {
            if(ctx.LEFTBRACKET() == null){
                if(currMethod.varExists(ctx.ID().getText())) {
                    String type = evaluateExp(ctx.exp(0));
                    String prefix = getTypeMnemonic(getTypeDescriptor(currMethod.getVar(ctx.ID().getText()).getType()));
                    if(type.equals("I") && prefix.equals("l")){
                        filePrinter.append("i2l\n");
                        incStack(1);
                    }
                    int local = currMethod.getVarLocal(ctx.ID().getText());
                    filePrinter.append(String.format("%sstore %d\n", prefix, local));
                    if(prefix.equals("l")){
                        incStack(-2);
                    } else {
                        incStack(-1);
                    }
                } else {
                    //"this"
                    filePrinter.append(String.format("aload 0\n"));
                    incStack(1);
                    String val = evaluateExp(ctx.exp(0));
                    String type = getTypeDescriptor(currClass.getVar(ctx.ID().getText()).getType());
                    if(val.equals("I") && type.equals("J")){
                        filePrinter.append("i2l\n");
                        incStack(1);
                    }
                    filePrinter.append(String.format("putfield %s/%s %s\n", currClass.getId(), ctx.ID().getText(), type));
                    if(type.equals("J")){
                        incStack(-3);
                    } else {
                        incStack(-2);
                    }
                }

            } else {
                if(currMethod.varExists(ctx.ID().getText())){
                    filePrinter.append(String.format("aload %d\n", currMethod.getVarLocal(ctx.ID().getText())));
                    incStack(1);
                    evaluateExp(ctx.exp(0));
                    String type = evaluateExp(ctx.exp(1));
                    String arrtype = getTypeDescriptor(currMethod.getVar(ctx.ID().getText()).getArrayElementType());
                    if(type.equals("I") && arrtype.equals("J")){
                        filePrinter.append("i2l\n");
                        incStack(1);
                    }
                    filePrinter.append(String.format("%sastore\n", getTypeMnemonic(arrtype)));
                    if(getTypeMnemonic(arrtype).equals("l")){
                        incStack(-4);
                    } else {
                        incStack(-3);
                    }
                } else {
                    String type = currClass.getVar(ctx.ID().getText()).getType();
                    filePrinter.append("aload 0\n");
                    incStack(1);
                    filePrinter.append(String.format("getfield %s/%s %s\n", currClass.getId(), ctx.ID().getText(), getTypeDescriptor(type)));
                    if(getTypeDescriptor(type).equals("J")){
                        incStack(1);
                    }
                    evaluateExp(ctx.exp(0));
                    String valtype = evaluateExp(ctx.exp(1));
                    String arrtype = getTypeDescriptor(currClass.getVar(ctx.ID().getText()).getArrayElementType());
                    if(valtype.equals("I") && arrtype.equals("J")){
                        filePrinter.append("i2l\n");
                        incStack(1);
                    }
                    filePrinter.append(String.format("%sastore\n", getTypeMnemonic(arrtype)));
                    if(getTypeMnemonic(arrtype).equals("l")){
                        incStack(-4);
                    } else {
                        incStack(-3);
                    }
                }
            }
        }
        if(ctx.SYSO() != null){
            filePrinter.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            incStack(1);
            String type = evaluateExp(ctx.exp(0));
            filePrinter.append(String.format("invokevirtual java/io/PrintStream/println(%s)V\n", type));
            if(type.equals("J")){
                incStack(-3);
            } else {
                incStack(-2);
            }
        }
    }

    /**
     * Evaluates an expression by appending the code neccesary to do an
     * evaluation. The answer should be on top of the stack when the method returns.
     *
     *
     * @param exp The expression context to evaluate
     * @return a Jasmin type descriptor descriing the type of the result.
     */
    public String evaluateExp(javagrammarParser.ExpContext exp){
        if(exp.INT_LIT() !=  null){
            filePrinter.append(String.format("ldc %s\n", exp.INT_LIT().getText()));
            incStack(1);
            return typeDescriptors.get("int");
        }
        if(exp.LONG_LIT() != null){
            //ldc2_w är för att ladda category 2 konstanter (double och long)
            filePrinter.append(String.format("ldc2_w %s\n", exp.LONG_LIT().getText().split("L|l")[0]));
            incStack(2);
            return typeDescriptors.get("long");
        }
        if(exp.TRUE() != null){
            filePrinter.append("ldc 1\n");
            incStack(1);
            return typeDescriptors.get("boolean");
        }
        if(exp.FALSE() != null){
            filePrinter.append("ldc 0\n");
            incStack(1);
            return typeDescriptors.get("boolean");
        }
        if(exp.PLUS() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))){
                if(type2.equals(typeDescriptors.get("int"))){
                    filePrinter.append("i2l\n");
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                }
                filePrinter.append("ladd\n");
                incStack(-2);
                return typeDescriptors.get("long");
            }else{
                filePrinter.append("iadd\n");
                incStack(-1);
                return typeDescriptors.get("int");
            }
        }
        if(exp.MULT() != null) {
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))) {
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                }
                filePrinter.append("lmul\n");
                incStack(-2);
                return typeDescriptors.get("long");
            } else {
                filePrinter.append("imul\n");
                incStack(-1);
                return typeDescriptors.get("int");
            }
        }

        if(exp.MINUS() != null) {
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals(typeDescriptors.get("long")) || type2.equals(typeDescriptors.get("long"))) {
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                    filePrinter.append("dup2_x2\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                }
                filePrinter.append("lsub\n");
                incStack(-2);
                return typeDescriptors.get("long");
            }
            else {
                filePrinter.append("isub\n");
                incStack(-1);
                return typeDescriptors.get("int");
            }
        }
        if(exp.AND() != null){
            evaluateExp(exp.exp(0));
            int label1 = this.labelCount;
            int label2 = this.labelCount + 1;
            this.labelCount += 2;
            filePrinter.append(String.format(String.format("ifeq Label%d\n", label1)));
            incStack(-1);
            evaluateExp(exp.exp(1));
            filePrinter.append(String.format("goto Label%d\n", label2));
            filePrinter.append(String.format(String.format("Label%d:\n", label1)));
            filePrinter.append("ldc 0\n");
            incStack(1);
            filePrinter.append(String.format("Label%d:\n", label2));
            return "Z";
        }
        if(exp.OR() != null){
            evaluateExp(exp.exp(0));
            int label1 = this.labelCount;
            int label2 = this.labelCount + 1;
            this.labelCount += 2;
            filePrinter.append(String.format(String.format("ifne Label%d\n", label1)));
            incStack(-1);
            evaluateExp(exp.exp(1));
            filePrinter.append(String.format("goto Label%d\n", label2));
            filePrinter.append(String.format(String.format("Label%d:\n", label1)));
            filePrinter.append("ldc 1\n");
            incStack(1);
            filePrinter.append(String.format("Label%d:\n", label2));
            return "Z";
        }
        if(exp.EQ() != null){
            String type1 = evaluateExp(exp.exp(0));
            String type2 = evaluateExp(exp.exp(1));
            if(type1.equals("J") || type2.equals("J")){
                if(type2.equals(typeDescriptors.get("int"))) {
                    filePrinter.append("i2l\n");
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append("ldc 0\n");
                incStack(1);
                filePrinter.append(String.format("if_icmpeq Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
            else if(type1.equals("I") && type2.equals("I") || type1.equals("Z") && type2.equals("Z")){
                filePrinter.append(String.format("if_icmpeq Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Har vi kommit hit så dealar vi med objektreferenser
                filePrinter.append(String.format("if_acmpeq Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
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
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append("ldc 0\n");
                incStack(1);
                filePrinter.append(String.format("if_icmpne Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                ///incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
            else if(type1.equals("I") && type2.equals("I") || type1.equals("Z") && type2.equals("Z")){
                filePrinter.append(String.format("if_icmpne Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Har vi kommit hit så dealar vi med objektreferenser
                filePrinter.append(String.format("if_acmpne Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
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
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                    filePrinter.append("dup2_x2\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append(String.format("iflt Label%d\n", this.labelCount));
                incStack(-1);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmplt Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
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
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                    filePrinter.append("dup2_x2\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append(String.format("ifgt Label%d\n", this.labelCount));
                incStack(-1);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmpgt Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
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
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                    filePrinter.append("dup2_x2\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append(String.format("ifle Label%d\n", this.labelCount));
                incStack(-1);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmple Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
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
                    incStack(1);
                } else if(type1.equals(typeDescriptors.get("int"))){
                    filePrinter.append("dup2_x1\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                    filePrinter.append("i2l\n");
                    incStack(1);
                    filePrinter.append("dup2_x2\n");
                    incStack(2);
                    filePrinter.append("pop2\n");
                    incStack(-2);
                }
                filePrinter.append("lcmp\n");
                incStack(-3);
                filePrinter.append(String.format("ifge Label%d\n", this.labelCount));
                incStack(-1);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            } else {
                //Måste vara enbart ints
                filePrinter.append(String.format("if_icmpge Label%d\n", this.labelCount));
                incStack(-2);
                filePrinter.append("ldc 0\n");
                //incStack(1);
                filePrinter.append(String.format("goto Label%d\n", this.labelCount + 1));
                filePrinter.append(String.format("Label%d:\n", this.labelCount));
                filePrinter.append("ldc 1\n");
                incStack(1);
                filePrinter.append(String.format("Label%d:\n", this.labelCount + 1));
                this.labelCount += 2;
                return "Z";
            }
        }

        if(exp.NOT() != null){
            int label1 = this.labelCount;
            int label2 = this.labelCount + 1;
            this.labelCount += 2;
            evaluateExp(exp.exp(0));
            filePrinter.append(String.format("ifeq Label%d\n", label1));
            incStack(-1);
            filePrinter.append("ldc 0\n");
            //incStack(1);
            filePrinter.append(String.format("goto Label%d\n", label2));
            filePrinter.append(String.format("Label%d:\n", label1));
            filePrinter.append("ldc 1\n");
            incStack(1);
            filePrinter.append(String.format("Label%d:\n", label2));
            return "Z";
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
                    return getTypeDescriptor("long[]");
                }
            }
            if(exp.ID() != null){
                filePrinter.append(String.format("new '%s'\n", exp.ID().getText()));
                incStack(1);
                filePrinter.append("dup\n");
                incStack(1);
                filePrinter.append(String.format("invokespecial %s/<init>()V\n", exp.ID().getText()));
                incStack(-1);
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
            if(prefix.equals("i")){
                incStack(-1);
            }
            return ret;
        }

        if(exp.THIS() != null){
            filePrinter.append("aload 0\n");
            incStack(1);
            return getTypeDescriptor(currClass.getId());
        }
        if(exp.LENGTH() != null){
            evaluateExp(exp.exp(0));
            filePrinter.append("arraylength\n");
            return getTypeDescriptor("int");
        }
        if(exp.ID() != null && exp.LEFTPAREN() != null){
            String classname = evaluateExp(exp.exp(0));
            classname = classname.substring(1, classname.length()-1);
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
                //Minus for all the args
                if(type.equals("J")){
                    incStack(-2);
                } else {
                    incStack(-1);
                }

            }
            filePrinter.append(String.format(")%s\n", methodType));
            //Minus for object ref removed
            incStack(-1);
            //Handles return value
            if(methodType.equals("J")){
                incStack(2);
            } else {
                incStack(1);
            }
            return methodType;

        }

        if(exp.ID() == null && exp.LEFTPAREN() != null){
            String type = evaluateExp(exp.exp(0));
            return type;
        }

        if(exp.ID() != null){
            if(currMethod.varExists(exp.ID().getText())){
                String type = currMethod.getVar(exp.ID().getText()).getType();
                String prefix = getTypeMnemonic(getTypeDescriptor(type)) ;
                int local = currMethod.getVarLocal(exp.ID().getText());
                filePrinter.append(String.format("%sload %d\n", prefix, local));
                if(prefix.equals("l")){
                    incStack(2);
                } else {
                    incStack(1);
                }
                return getTypeDescriptor(type);
            } else {
                String type = currClass.getVar(exp.ID().getText()).getType();
                filePrinter.append("aload 0\n");
                incStack(1);
                filePrinter.append(String.format("getfield %s/%s %s\n", currClass.getId(), exp.ID().getText(), getTypeDescriptor(type)));
                if(getTypeDescriptor(type).equals("J")){
                    incStack(1);
                }
                return getTypeDescriptor(type);
            }
        }
        return null;
    }

    /**
     * Inreases OR decreases the value of the current stack depth.
     * Saves the value to stacklimit if the current stack depth is higher.
     *
     * @param inc The value to increase or decrease the current stack depth with.
     */
    private void incStack(int inc){
        this.currStack += inc;
        if(this.currStack>this.stacklimit){
            this.stacklimit = this.currStack;
        }
        if(STACK_DEBUG){
            filePrinter.append(String.format("; Stack: %d\n", this.currStack));
        }
    }
}
