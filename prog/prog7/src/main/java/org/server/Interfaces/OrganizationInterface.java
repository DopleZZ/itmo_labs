package Interfaces;

import java.time.LocalDate;

import Enums.OrganizationType;
import OrgData.Coordinates;
import OrgData.Address;

public interface OrganizationInterface {

    public long getId();
    public String getName();
    public Coordinates getCoordinates();
    public LocalDate getCreationDate();
    public double getAnnualTurnover();
    public String getFullName();
    public long getEmployeesCount();
    public OrganizationType getOrganizationType();
    public Address getAddress();

}
