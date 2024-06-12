package org.Client.Enums;

public enum OrganizationType {
    COMMERCIAL("COMMERCIAL"),
    PUBLIC("PUBLIC"),
    GOVERNMENT("GOVERNMENT"),
    PRIVATE_LIMITED_COMPANY("PRIVATE_LIMITED_COMPANY"),
    OPEN_JOINT_STOCK_COMPANY("OPEN_JOINT_STOCK_COMPANY"),
    NONE("NONE");
    

    private String title;
    private OrganizationType(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return title;
    }
}


