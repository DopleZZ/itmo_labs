package org.CommandWorks;

import java.sql.SQLException;
import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;
import org.OrgDataWorks.Organization;
import org.ServerOperationsWorks.RecieverModule;

public class RemoveByIdCommand {
    
    
    /** 
     * Удаляет элемент с заданным айди
     * @param idToRemove
     */
    public String execute(String args) throws SQLException {
    int idToRemove = Integer.parseInt(args.split(" ")[0]);
    int uid = Integer.parseInt(args.split(" ")[1]);

    if (DataBaseManager.checkOwner(uid, idToRemove)){
        DataBaseManager.delete(idToRemove);
        OrgCollection.clear();
        DataParser.baseParse();
        return "объект коллекции удален";
        }
    else {
        return "Объект не принадлежит вам";
    }
    }
}
