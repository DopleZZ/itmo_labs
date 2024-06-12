package org.server.Commands;
import java.io.IOException;
import java.util.PriorityQueue;
import org.server.Collections.OrgCollection;
import org.server.OrgData.Organization;
import org.server.ServerOperationsPackage.RecieverModule;


public class Shower {



    private PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

    
    /** 
     * Вывести в консоль текущую коллекцию
     * @param arg
     * @throws IOException
     */
    public void execute(String arg) throws IOException{
       
        collectionCopy = OrgCollection.getCollection();
        String finalString = " ";

        if (collectionCopy.isEmpty()){
            System.out.println("Записей не обнаружено");
        }
        while (!collectionCopy.isEmpty()){
            Organization org = collectionCopy.remove();
            finalString = finalString + "\n";
            finalString = finalString + 
                org.getId() + "\n" +
                "Название: " + org.getName() + "\n" +
                "Координаты (х,у): " + org.getCoordinates() + "\n" +
                "Дата создания: " + org.getCreationDate() + "\n" +
                "Годовой доход: " + org.getAnnualTurnover() + "\n" +
                "Полное название: " + org.getFullName() + "\n" +
                "количество сотрудников: " + org.getEmployeesCount() + "\n" +
                "Тип: " + org.getOrganizationType() + "\n" +
                "Адресс: " + org.getAddress() + "\n"
            ;
        }
        RecieverModule.commandResponce = finalString;
    }
}