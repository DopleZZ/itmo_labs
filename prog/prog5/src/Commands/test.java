package Commands;

import Interfaces.Executable;

public class test implements Executable{
    
    @Override
    public void execute(String arg){
        System.out.println(arg);
    }


    public void bebebe(){
        System.out.println("be");
    }

}
