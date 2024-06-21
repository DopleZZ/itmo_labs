package org.CommandWorks;

import java.sql.SQLException;
import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;
import org.OrgDataWorks.Organization;

public class RemoveLowerCommand {
    
    
    /** 
     * удаляет все элементы коллекции, значение количества сотрудников которых ниже заданного
     * @param arg
     */
    public String execute(String args) throws SQLException {
        int idToRemove = Integer.parseInt(args.split(" ")[0]);
        int uid = Integer.parseInt(args.split(" ")[1]);
        String ans =  DataBaseManager.removeLower(idToRemove, uid);
        OrgCollection.clear();
        DataParser.baseParse();
        return ans;
    }
}
