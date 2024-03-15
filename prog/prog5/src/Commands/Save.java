package Commands;

import java.io.FileNotFoundException;

import Interfaces.Executable;
import fileworkspackage.*;

public class Save implements Executable{
    

    @Override
    public void execute() throws FileNotFoundException{
        ParseToCSV.parseTo();
    }
    
}
