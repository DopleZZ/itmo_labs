package org.OrgDataWorks;

public class Address {
    private String zipCode; // Поле может быть null

    public Address(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return this.zipCode;
    }

    public String getStreet() {
        return zipCode;
    }
}