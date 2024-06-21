package org.OrgDataWorks;

public class RegisterRequest extends ParentRequest {

    public String login;
    public String password;

    public RegisterRequest(String login, String password) {
        super(PackageType.REGISTER);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

}
