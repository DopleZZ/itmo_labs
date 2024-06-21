package org.OrgDataWorks;

import java.io.Serializable;

public abstract class ParentRequest implements Serializable {
    protected static final long serialVersionUID = 1L;

    private final PackageType packageType;

    public ParentRequest(PackageType packageType) {
        this.packageType = packageType;
    }

    public PackageType getPackageType() {
        return this.packageType;
    }

}
