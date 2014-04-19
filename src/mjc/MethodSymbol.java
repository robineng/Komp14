package mjc;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by robin on 4/15/14.
 */
public class MethodSymbol {
    private String type;
    private ArrayList<VariableSymbol> params;
    private HashMap<String, VariableSymbol> vars;

    public MethodSymbol(){
        params = new ArrayList<VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
    }

    public MethodSymbol(String type){
        this.type = type;
        params = new ArrayList<VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
    }

    public boolean addParam(String id, VariableSymbol sym){
        if(this.vars.containsKey(id)){
            return false;
        }
        sym.setInitiated(true);
        this.vars.put(id, sym);
        this.params.add(sym);
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

    public ArrayList<VariableSymbol> getParams(){
        return this.params;
    }

    public boolean varExists(String id){
        return this.vars.containsKey(id);
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, VariableSymbol> getVars() {
        return vars;
    }

}