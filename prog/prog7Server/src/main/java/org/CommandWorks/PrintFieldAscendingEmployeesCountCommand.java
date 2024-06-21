package org.CommandWorks;

import java.util.Comparator;
import java.util.stream.Collectors;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class PrintFieldAscendingEmployeesCountCommand {

    /**
     * Выводит в консоль элементы коллекции по возрастанию количества работников
     * 
     * @param arg
     */
    public String execute(String arg) {
        return OrgCollection.getCollection()
                .stream()
                .sorted(Comparator.comparingLong(Organization::getEmployeesCount))
                .map(org -> org.getName() + ":" + org.getEmployeesCount())
                .collect(Collectors.joining(", "));
    }
}
