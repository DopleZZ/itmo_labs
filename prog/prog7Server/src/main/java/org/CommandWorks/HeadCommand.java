package org.CommandWorks;

import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;
import org.ServerOperationsWorks.RecieverModule;




public class HeadCommand {

    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    
    /** 
     * вывести в консоль верхний элемент коллекции
     * @param arg
     */
    public String execute(String arg){

        String ans = "";
        collectionCopy= OrgCollection.getCollection();


        Organization org = collectionCopy.peek();
            ans +=
                org.getId() + "\n" +
                org.getName() + "\n" +
                org.getCoordinates() + "\n" +
                org.getCreationDate() + "\n" +
                org.getAnnualTurnover() + "\n" +
                org.getFullName() + "\n" +
                org.getEmployeesCount() + "\n" +
                org.getOrganizationType() + "\n" +
                org.getAddress() + "\n";
        return ans;
    }

}
