package org.Client.OrgDataWorks;

public class EntryRequest  extends ParentRequest{

    private static final long serialVersionUID = 1L;
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
