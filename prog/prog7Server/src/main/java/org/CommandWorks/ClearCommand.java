package org.CommandWorks;

import org.CollectionWorks.OrgCollection;

public class ClearCommand {

    /**
     * очистить коллекцию
     * 
     * @param arg
     */

    public void execute(String arg) {
        OrgCollection.clear();
    }

}
