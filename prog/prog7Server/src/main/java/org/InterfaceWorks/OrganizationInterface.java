package org.InterfaceWorks;

import java.time.LocalDate;

import org.EnumWorks.OrganizationType;
import org.OrgDataWorks.Address;
import org.OrgDataWorks.Coordinates;

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
