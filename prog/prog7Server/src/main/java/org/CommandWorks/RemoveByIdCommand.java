package org.CommandWorks;

import java.sql.SQLException;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;

public class RemoveByIdCommand {

    /**
     * Удаляет элемент с заданным айди
     * 
     * @param arg
     */
    public String execute(String arg) throws SQLException {
        String[] args = arg.split(" ");
        int idToRemove = Integer.parseInt(args[0]);
        int uid = Integer.parseInt(args[1]);

        if (DataBaseManager.checkOwner(uid, idToRemove)) {
            DataBaseManager.delete(idToRemove);
            OrgCollection.clear();
            DataParser.baseParse();
            return "объект коллекции удален";
        } else {
            return "Объект не принадлежит вам";
        }
    }
}
