package Commands;

import Interfaces.Executable;

public class Exit implements Executable{

    @Override
    public void execute(String arg){
    System.exit(0);
    }
}