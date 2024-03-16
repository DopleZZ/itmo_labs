package Commands;

import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;




public class Head implements Executable {

    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    @Override
    public void execute(String arg){

        collectionCopy=OrgCollection.getCollection();

        Organization org = collectionCopy.peek();
            System.out.println(
                org.getId() + "\n" +
                org.getName() + "\n" +
                org.getCoordinates() + "\n" +
                org.getCreationDate() + "\n" +
                org.getAnnualTurnover() + "\n" +
                org.getFullName() + "\n" +
                org.getEmployeesCount() + "\n" +
                org.getOrganizationType() + "\n" +
                org.getAddress() + "\n");
    }
}
