package org.OrgDataWorks;

public class EntryRequest extends ParentRequest{
    public final String packageType = "entry";
    private static final long serialVersionUID = 1L;

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

    public String getPassword(){
        return this.password;
    }
}
