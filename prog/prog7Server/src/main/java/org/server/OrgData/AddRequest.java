package org.server.OrgData;

import org.server.Enums.OrganizationType;

public class AddRequest extends ParentRequest{

    private static final long serialVersionUID = 1L;

    public final String packageType = "add";
    
    private String name;
    private String coordinates;
    private Double annualTurnover;
    private String fullName;
    private Long employeesCount;
    private OrganizationType type;
    private String adress;

    public AddRequest(String name, String coordinates, Double annualTurnover, 
                        String fullName, Long employeesCount, 
                        OrganizationType type, String adress){
        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.adress = adress;
    }

    public String getName(){
        return this.name;
    }

    public String getCoordinates(){
        return this.coordinates;
    }

    public Double getAnnualTurnover(){
        return this.annualTurnover;
    }

    public String getFullName(){
        return this.fullName;
    }

    public Long getEmployeesCount(){
        return this.employeesCount;
    }

    public OrganizationType getType(){
        return this.type;
    }

    public String getAdress(){
        return this.adress;
    }

    @Override
    public String getPackageType(){
        return this.packageType;
    }

}
