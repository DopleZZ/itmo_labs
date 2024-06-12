package org.server.CommandWorks;

import org.server.CollectionWorks.OrgCollection;


public class ClearCommand {

    
    /** 
     * очистить коллекцию
     * @param arg
     */
    
    public void execute(String arg){
        OrgCollection.clear();
    }

}
