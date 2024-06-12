package org.server.InterfaceWorks;

import java.time.LocalDate;

import org.server.EnumWorks.OrganizationType;
import org.server.OrgDataWorks.Coordinates;
import org.server.OrgDataWorks.Address;

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
