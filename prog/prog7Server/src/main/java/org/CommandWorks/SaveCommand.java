package org.CommandWorks;

import java.io.FileNotFoundException;
import org.FileWorks.ParserToCSV;

public class SaveCommand {
    
    
    /** 
     * Сохраняет текущую коллекцию в файл
     * @param arg
     * @throws FileNotFoundException
     */
    public static void save() throws FileNotFoundException{
        ParserToCSV.parseTo();
    }
}
