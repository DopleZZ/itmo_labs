package Commands;

import Collections.OrgCollection;
import Interfaces.Executable;

public class Info implements Executable {

    @Override
    public void execute(String arg){
        OrgCollection.info();
    }
    
}
