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
    private HashMap<String, Integer> varsLocal;
    private int localCounter;

    public MethodSymbol(){
        params = new ArrayList<VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
        varsLocal = new HashMap<String, Integer>();
        localCounter = 0;
    }

    public MethodSymbol(String type){
        this.type = type;
        params = new ArrayList<VariableSymbol>();
        vars = new HashMap<String, VariableSymbol>();
        varsLocal = new HashMap<String, Integer>();
        localCounter = 0;
    }

    public int getLocalCounter(){
        return this.localCounter;
    }

    public boolean addParam(String id, VariableSymbol sym){
        if(this.vars.containsKey(id)){
            return false;
        }
        this.vars.put(id, sym);
        this.params.add(sym);
        this.varsLocal.put(id, this.localCounter);
        if(sym.getType().equals("long")){
            this.localCounter++;
        }
        this.localCounter++;
        return true;
    }

    public boolean addVar(String id, VariableSymbol sym){
        if(this.vars.containsKey(id)){
            return false;
        }
        this.vars.put(id, sym);
        this.varsLocal.put(id, this.localCounter);
        if(sym.getType().equals("long")){
            this.localCounter++;
        }
        this.localCounter++;
        return true;
    }

    public int getVarLocal(String var){
        if(!this.varsLocal.containsKey(var)){
            return -1;
        }
        return this.varsLocal.get(var);
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