package OrgData;

public class EntryRequest extends ParentRequest{
    public final String packageType = "entry";

    public String login;
    public String password;

    public EntryRequest(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getPackageType(){
        return this.packageType;
    }

    public String getLogin(){
        return this.login;
    }
}
