package Commands;

import java.io.FileNotFoundException;

import Interfaces.Executable;
import fileworkspackage.ParseToCSV;

public class Save implements Executable{
    
    @Override
    public void execute(String arg) throws FileNotFoundException{
        ParseToCSV.parseTo();
    }
}
