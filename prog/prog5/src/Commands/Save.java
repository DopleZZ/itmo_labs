package Commands;

import java.io.FileNotFoundException;

import Interfaces.Executable;
import fileworkspackage.ParseToCSV;

public class Save implements Executable{
    
    
    /** 
     * Сохраняет текущую коллекцию в файл
     * @param arg
     * @throws FileNotFoundException
     */
    @Override
    public void execute(String arg) throws FileNotFoundException{
        ParseToCSV.parseTo();
    }
}
