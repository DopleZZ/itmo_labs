package Commands;

import Interfaces.Executable;

public class Exit implements Executable{

    @Override
    public void execute(){
    System.exit(0);
    }
}
