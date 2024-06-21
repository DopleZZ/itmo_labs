package org.CommandWorks;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class HeadCommand {

    /**
     * вывести в консоль верхний элемент коллекции
     * 
     * @param arg
     */
    public String execute(String arg) {
        Organization org = OrgCollection.getCollection().peek();
        StringBuilder ans = new StringBuilder()
                .append(org.getId() + "\n")
                .append(org.getName() + "\n")
                .append(org.getCoordinates() + "\n")
                .append(org.getCreationDate() + "\n")
                .append(org.getAnnualTurnover() + "\n")
                .append(org.getFullName() + "\n")
                .append(org.getEmployeesCount() + "\n")
                .append(org.getOrganizationType() + "\n")
                .append(org.getAddress() + "\n");

        return ans.toString();
    }

}
