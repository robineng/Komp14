package mjc;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.io.File;
import java.io.FileWriter;
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

    public JasminTranslator(HashMap<String, ClassSymbol> classes) {
        this.classes = classes;
    }

    @Override public void enterMainclass(javagrammarParser.MainclassContext ctx) {
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
    }

    @Override public void enterStmt(javagrammarParser.StmtContext ctx) {
        if(ctx.ASSIGNMENT() != null) {
        }
    }

    @Override public void enterClassdecl(javagrammarParser.ClassdeclContext ctx) {
        currClassFile = new File(ctx.ID().getText() + ".j");
        try {
            filePrinter = new PrintWriter(currClassFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override public void exitClassdecl(javagrammarParser.ClassdeclContext ctx) {
        filePrinter.flush();
        filePrinter.close();
    }
}
