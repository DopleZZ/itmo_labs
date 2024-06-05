package OrgData;

public class BaseRequest extends ParentRequest{

    public final String packageType = "base";

    private String command;
    
    public BaseRequest(String comm){
        this.command = comm;
    }

    public String getCommand(){
        return this.command;
    }

    @Override
    public String getPackageType(){
        return this.packageType;
    }
}