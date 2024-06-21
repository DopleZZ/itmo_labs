package org.CommandWorks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;
import org.ServerOperationsWorks.RecieverModule;

public class PrintFieldAscendingEmployeesCountCommand {

    
    /** 
     * Выводит в консоль элементы коллекции по возрастанию количества работников
     * @param arg
     */
    public String execute(String arg){
        String ans = "";
        PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();
        collectionCopy = OrgCollection.getCollection();
        HashMap<Long, String> map = new HashMap<>();
        
        while (!collectionCopy.isEmpty()){
            Organization org = collectionCopy.poll();
            map.put(org.getEmployeesCount(), org.getName());
        }

        while (!map.isEmpty()){
            ArrayList<Long> keys = new ArrayList<>();
            keys.addAll(map.keySet());
            Long min = (long) Long.MAX_VALUE;

            for (Long i : keys){
                min = Long.min(min, i);
            }
        
           ans+=(map.get(min) + ":" + min);
            map.remove(min);
        }
        return ans;
    }
}