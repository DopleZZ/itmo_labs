package org.CommandWorks;

import java.util.Comparator;
import java.util.Optional;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class MaxByTypeCommand {

    /**
     * Вывести элемент коллекции, значение типа которого максимально
     * 
     * @param arg
     */
    public String execute(String arg) {
        Optional<Organization> maxOrg = OrgCollection.getCollection().stream()
                .max(Comparator.comparing(org -> org.getOrganizationType().ordinal()));

        return maxOrg
                .map(org -> org.getName() + ":" + org.getOrganizationType())
                .orElse("элементов не обнаруженно");
    }
}
