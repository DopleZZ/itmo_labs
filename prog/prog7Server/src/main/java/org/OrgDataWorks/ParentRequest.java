package org.OrgDataWorks;

import java.io.Serializable;

public class ParentRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public final String packageType = "parent";

    public String getPackageType(){
        return this.packageType;
    }
    
}
