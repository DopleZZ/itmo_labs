package Commands;

import Collections.OrgCollection;


public class Clear  {

    
    /** 
     * очистить коллекцию
     * @param arg
     */
    
    public void execute(String arg){
        OrgCollection.clear();
    }

}
