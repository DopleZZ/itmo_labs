package org.server.Commands;

import java.util.PriorityQueue;

import org.server.Collections.OrgCollection;
import org.server.OrgData.Organization;
import org.server.ServerOperationsPackage.RecieverModule;




public class Header  {

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
