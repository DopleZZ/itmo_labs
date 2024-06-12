package org.server.OrgDataWorks;

import org.server.EnumWorks.OrganizationType;

public class UpdateRequest extends AddRequest {

    private String idToUpdate;

    public final String packageType = "update";

    public UpdateRequest(String name, String coordinates, Double annualTurnover, String fullName, Long employeesCount,
            OrganizationType type, String adress, String idToUpdate) {
        super(name, coordinates, annualTurnover, fullName, employeesCount, type, adress);
        this.idToUpdate = idToUpdate;
    }

    public String getId(){
        return this.idToUpdate;
    }

    @Override
    public String getPackageType(){
        return this.packageType;
    }
    
}
