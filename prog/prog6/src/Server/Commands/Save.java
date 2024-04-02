package Commands;

import java.io.FileNotFoundException;
import fileworkspackage.ParseToCSV;

public class Save{
    
    
    /** 
     * Сохраняет текущую коллекцию в файл
     * @param arg
     * @throws FileNotFoundException
     */
    public static void save() throws FileNotFoundException{
        ParseToCSV.parseTo();
    }
}
