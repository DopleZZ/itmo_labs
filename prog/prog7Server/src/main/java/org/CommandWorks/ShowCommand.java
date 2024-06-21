package org.CommandWorks;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class ShowCommand {

    /**
     * Вывести в консоль текущую коллекцию
     * 
     * @param arg
     * @throws IOException
     */
    public String execute(String arg) throws IOException {
        PriorityQueue<Organization> collectionCopy = OrgCollection.getCollection();

        if (collectionCopy.isEmpty()) {
            return "Записей не обнаружено";
        }

        return collectionCopy.stream()
                .map(org -> String.format(
                        "%d\nНазвание: %s\nКоординаты (х,у): %s\nДата создания: %s\nГодовой доход: %s\nПолное название: %s\nколичество сотрудников: %d\nТип: %s\nАдресс: %s\n",
                        org.getId(), org.getName(), org.getCoordinates(), org.getCreationDate(),
                        org.getAnnualTurnover(),
                        org.getFullName(), org.getEmployeesCount(), org.getOrganizationType(), org.getAddress()))
                .collect(Collectors.joining("\n"));
    }
}
