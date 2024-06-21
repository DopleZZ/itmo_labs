package org.OrgDataWorks;

public class EntryRequest extends ParentRequest {
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;

    public EntryRequest(String login, String password) {
        super(PackageType.ENTRY);
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
