package org.EnumWorks;

public enum OrganizationType {
    COMMERCIAL,
    PUBLIC,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY,
    OPEN_JOINT_STOCK_COMPANY,
    NONE;
    
    @Override
    public String toString(){
        return name();
    }
}


