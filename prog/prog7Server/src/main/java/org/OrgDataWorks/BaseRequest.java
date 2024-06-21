package org.OrgDataWorks;

public class BaseRequest extends AuthedRequest {
    private String command;

    public BaseRequest(String comm, String userId) {
        super(PackageType.BASE, userId);
        this.command = comm;
    }

    public String getCommand() {
        return this.command;
    }
}