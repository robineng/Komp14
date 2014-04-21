package mjc;

/**
 * Created by robin on 4/15/14.
 */
public class VariableSymbol {
    private String type;
    private boolean initiated;

    public VariableSymbol(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInitiated() {
        return initiated;
    }

    public void setInitiated(boolean initiated){
        this.initiated = initiated;
    }

    public String getArrayElementType(){
        return this.type.split("\\[")[0];
    }
}
