package org.server.Commands;

import org.server.Collections.OrgCollection;

public class Infoer {

    
    /** 
     * вывести информацию о коллекции
     * @param arg
     */
    public void execute(String arg){
        OrgCollection.info();
    }
}
