package org.OrgDataWorks;

public abstract class AuthedRequest extends ParentRequest {
    protected final String userId;

    public AuthedRequest(PackageType packageType, String userId) {
        super(packageType);
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

}
