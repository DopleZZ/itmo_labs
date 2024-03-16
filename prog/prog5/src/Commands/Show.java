package Commands;
import java.io.IOException;
import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;


public class Show implements Executable{
    private  OrgCollection orgCollection;


    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    @Override
    public void execute(String arg) throws IOException{
       
        collectionCopy = OrgCollection.getCollection();

        if (collectionCopy.isEmpty()){
            System.out.println("Записей не обнаружено");
        }
        
        while (!collectionCopy.isEmpty()){
            Organization org = collectionCopy.remove();
            System.out.println();
            System.out.println(
                org.getId() + "\n" +
                org.getName() + "\n" +
                org.getCoordinates() + "\n" +
                org.getCreationDate() + "\n" +
                org.getAnnualTurnover() + "\n" +
                org.getFullName() + "\n" +
                org.getEmployeesCount() + "\n" +
                org.getOrganizationType() + "\n" +
                org.getAddress() + "\n"
            );
        }

    }
}