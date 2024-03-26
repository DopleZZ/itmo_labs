package Commands;

import Collections.OrgCollection;
import Interfaces.Executable;

public class Info implements Executable {

    
    /** 
     * вывести информацию о коллекции
     * @param arg
     */
    @Override
    public void execute(String arg){
        OrgCollection.info();
    }
}
