package org.server.Commands;

import org.server.Collections.OrgCollection;


public class Clearer  {

    
    /** 
     * очистить коллекцию
     * @param arg
     */
    
    public void execute(String arg){
        OrgCollection.clear();
    }

}
