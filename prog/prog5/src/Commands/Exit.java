package Commands;

import Interfaces.Executable;

public class Exit implements Executable{

    
    /** 
     * завершить работу программы без сохранения
     * @param arg
     */
    @Override
    public void execute(String arg){
    System.exit(0);
    }
}
