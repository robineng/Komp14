package mjc;

import java.util.HashMap;

/**
 * Created by robin on 4/15/14.
 */
public class ClassSymbol {
    private String id;
    private HashMap<String, VariableSymbol> variables;
    private HashMap<String, MethodSymbol> methods;

    public ClassSymbol(String id){
        this.id = id;
        variables = new HashMap<String, VariableSymbol>();
        methods = new HashMap<String, MethodSymbol>();
    }

    public boolean addVar(String id, VariableSymbol var){
        if(this.variables.containsKey(id)){
            return false;
        }
        this.variables.put(id, var);
        return true;
    }

    public boolean addMethod(String id, MethodSymbol method){
        if(this.methods.containsKey(id)){
            return false;
        }
        this.methods.put(id, method);
        return true;
    }

    public MethodSymbol getMethod(String id){
        return this.methods.get(id);
    }

    public VariableSymbol getVar(String id){
        return this.variables.get(id);
    }

    public boolean varExists(String id){
        return this.variables.containsKey(id);
    }

    public boolean methodExists(String id){
        return this.methods.containsKey(id);
    }

    public String getId(){
        return this.id;
    }
}
