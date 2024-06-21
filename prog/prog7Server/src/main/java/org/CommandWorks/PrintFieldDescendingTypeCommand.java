package org.CommandWorks;

import java.util.Comparator;
import java.util.stream.Collectors;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;


public class PrintFieldDescendingTypeCommand {

    /**
     * Выводит элементы коллекции по убыванию типа
     * 
     * @param arg
     */
    public String execute(String arg) {
        return OrgCollection.getCollection()
            .stream()
            .sorted(Comparator.comparing((Organization org) -> org.getOrganizationType().ordinal()).reversed())
            .map(org -> org.getEmployeesCount() + ":" + org.getOrganizationType())
            .collect(Collectors.joining(", "));
    }
}
