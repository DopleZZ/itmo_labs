package org.server.OrgData;

public class RegisterRequest extends ParentRequest{
    public final String packageType = "register";
    public String login;
    public String password;

    public RegisterRequest(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

}
