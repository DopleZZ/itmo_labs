package org.server.CommandWorks;

import java.util.PriorityQueue;

import org.server.CollectionWorks.OrgCollection;
import org.server.OrgDataWorks.Organization;
import org.server.ServerOperationsWorks.RecieverModule;




public class HeadCommand {

    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    
    /** 
     * вывести в консоль верхний элемент коллекции
     * @param arg
     */
    public void execute(String arg){

        RecieverModule.commandResponce = "";
        collectionCopy=OrgCollection.getCollection();


        Organization org = collectionCopy.peek();
            RecieverModule.commandResponce +=
                org.getId() + "\n" +
                org.getName() + "\n" +
                org.getCoordinates() + "\n" +
                org.getCreationDate() + "\n" +
                org.getAnnualTurnover() + "\n" +
                org.getFullName() + "\n" +
                org.getEmployeesCount() + "\n" +
                org.getOrganizationType() + "\n" +
                org.getAddress() + "\n";
    }
}
