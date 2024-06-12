package org.server.CommandWorks;

import java.io.FileNotFoundException;
import org.server.FileWorks.ParserToCSV;

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
