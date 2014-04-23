package mjc;

/**
 * Created by robin on 4/15/14.
 */
public class VariableSymbol {
    private String type;

    public VariableSymbol(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArrayElementType(){
        return this.type.split("\\[")[0];
    }
}
