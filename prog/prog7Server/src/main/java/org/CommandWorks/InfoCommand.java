package org.CommandWorks;

import org.CollectionWorks.OrgCollection;

public class InfoCommand {

    
    /** 
     * вывести информацию о коллекции
     * @param arg
     */
    public void execute(String arg){
        OrgCollection.info();
    }
}
