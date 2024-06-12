package org.server.Interfaces;

import java.time.LocalDate;

import org.server.Enums.OrganizationType;
import org.server.OrgData.Coordinates;
import org.server.OrgData.Address;

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
