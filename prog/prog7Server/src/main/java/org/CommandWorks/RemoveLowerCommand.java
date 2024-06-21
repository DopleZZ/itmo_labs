package org.CommandWorks;

import java.sql.SQLException;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;

public class RemoveLowerCommand {

    /**
     * удаляет все элементы коллекции, значение количества сотрудников которых ниже
     * заданного
     * 
     * @param args
     * @throws SQLException
     */
    public String execute(String arg) throws SQLException {
        String[] args = arg.split(" ");
        int idToRemove = Integer.parseInt(args[0]);
        int uid = Integer.parseInt(args[1]);
        
        String ans = DataBaseManager.removeLower(idToRemove, uid);
        OrgCollection.clear();
        DataParser.baseParse();
        return ans;
    }
}
