package Commands;

import Collections.OrgCollection;
import Interfaces.Executable;

public class Clear implements Executable {

    @Override
    public void execute(String arg){
        OrgCollection.clear();
    }

}