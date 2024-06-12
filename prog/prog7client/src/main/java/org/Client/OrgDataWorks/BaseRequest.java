package org.Client.OrgDataWorks;

public class BaseRequest extends ParentRequest{

    public final String packageType = "base";

    private String command;
    
    public BaseRequest(String comm, String userId){
        this.command = comm;
        this.userId = userId;
    }

    public String getCommand(){
        return this.command;
    }

    public String getPackageType(){
        return this.packageType;
    }
}