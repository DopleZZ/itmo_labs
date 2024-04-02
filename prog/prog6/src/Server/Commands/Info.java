package Commands;

import Collections.OrgCollection;

public class Info {

    
    /** 
     * вывести информацию о коллекции
     * @param arg
     */
    public void execute(String arg){
        OrgCollection.info();
    }
}
