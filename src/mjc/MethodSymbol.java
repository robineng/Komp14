package mjc;
import java.util.HashMap;

/**
 * Created by robin on 4/15/14.
 */
public class MethodSymbol {
    private String type;
    private HashMap<String, VariableSymbol> params;
    private HashMap<String, VariableSymbol> vars;

    public MethodSymbol(){
        params = new HashMap<String, VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
    }

    public MethodSymbol(String type){
        this.type = type;
        params = new HashMap<String, VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
    }

    public boolean addParam(String id, VariableSymbol sym){
        if(this.params.containsKey(id)){
            return false;
        }
        this.params.put(id, sym);
        return true;
    }

    public boolean addVar(String id, VariableSymbol sym){
        if(this.vars.containsKey(id)){
            return false;
        }
        this.vars.put(id, sym);
        return true;
    }

    public VariableSymbol getVar(String id){
        return this.vars.get(id);
    }

    public VariableSymbol getParam(String id){
        return this.params.get(id);
    }

    public boolean varExists(String id){
        return this.vars.containsKey(id);
    }

    public boolean paramExists(String id){
        return this.params.containsKey(id);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, VariableSymbol> getParams() {
        return params;
    }

    public void setParams(HashMap<String, VariableSymbol> params) {
        this.params = params;
    }

    public HashMap<String, VariableSymbol> getVars() {
        return vars;
    }

    public void setVars(HashMap<String, VariableSymbol> vars) {
        this.vars = vars;
    }
}