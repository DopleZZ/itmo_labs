package org.server.Commands;

import java.io.FileNotFoundException;
import fileworkspackage.ParserToCSV;

public class Saver{
    
    
    /** 
     * Сохраняет текущую коллекцию в файл
     * @param arg
     * @throws FileNotFoundException
     */
    public static void save() throws FileNotFoundException{
        ParserToCSV.parseTo();
    }
}
