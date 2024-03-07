package Commands;
import java.io.IOException;
import java.util.Collection;
import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;


public class Show implements Executable{
    private  OrgCollection orgCollection;


    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    @Override
    public void execute(OrgCollection orgCollection) throws IOException{
        this.orgCollection = orgCollection;
        collectionCopy = this.orgCollection.getCollection();
        Organization org;
        while (!collectionCopy.isEmpty()){
            org = collectionCopy.remove();
            System.out.println(
                org.getId() + "\n" +
                org.getName() + "\n" +
                org.getCoordinates() + "\n" +
                org.getCreationDate() + "\n" +
                org.getAnnualTurnover() + "\n" +
                org.getFullName() + "\n" +
                org.getEmployeesCount() + "\n" +
                org.getOrganizationType() + "\n" +
                org.getAddress()
            );
        
        
        }

    }
}