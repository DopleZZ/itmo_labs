package org.OrgDataWorks;

import org.EnumWorks.OrganizationType;

public class UpdateRequest extends AuthedRequest {

    private String idToUpdate;

    private String name;
    private String coordinates;
    private Double annualTurnover;
    private String fullName;
    private Long employeesCount;
    private OrganizationType type;
    private String adress;

    public UpdateRequest(String name, String coordinates, Double annualTurnover, String fullName, Long employeesCount,
            OrganizationType type, String adress, String idToUpdate, String userId) {
        super(PackageType.UPDATE, userId);
        this.idToUpdate = idToUpdate;

        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.adress = adress;
    }

    public String getName() {
        return this.name;
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    public Double getAnnualTurnover() {
        return this.annualTurnover;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Long getEmployeesCount() {
        return this.employeesCount;
    }

    public OrganizationType getType() {
        return this.type;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getId() {
        return this.idToUpdate;
    }

}
