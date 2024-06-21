package org.CommandWorks;

import org.CollectionWorks.OrgCollection;

public class InfoCommand {

    /**
     * вывести информацию о коллекции
     * 
     * @param arg
     */
    public String execute(String arg) {
        return OrgCollection.info();
    }
}
