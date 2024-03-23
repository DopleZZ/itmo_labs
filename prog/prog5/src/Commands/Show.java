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
                "Название: " + org.getName() + "\n" +
                "Координаты (х,у): " + org.getCoordinates() + "\n" +
                "Дата создания: " + org.getCreationDate() + "\n" +
                "Годовой доход: " + org.getAnnualTurnover() + "\n" +
                "Полное название: " + org.getFullName() + "\n" +
                "количество сотрудников: " + org.getEmployeesCount() + "\n" +
                "Тип: " + org.getOrganizationType() + "\n" +
                "Адресс: " + org.getAddress() + "\n"
            );
        }
    }
}