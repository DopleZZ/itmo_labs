package org.CommandWorks;

import java.io.IOException;
import java.sql.SQLException;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;
import org.ServerOperationsWorks.RecieverModule;


public class UpdateIdCommand {

    public static boolean fromFile = false;
    

    
    /** 
     * Обновляет значения выбранного по айди элемента
     * @param idToUpdateString
     * @throws IOException
     */
    public String execute(Object[] args) throws IOException, SQLException {

        if (DataBaseManager.checkOwner(Integer.parseInt((String) args[8]), Integer.parseInt((String) args[7]))){
            DataBaseManager.update(args);
            OrgCollection.clear();
            DataParser.baseParse();
            return "объект коллекции обновлен";
        } else {
            return "Объект не принадлежит вам";
        }
    }
}