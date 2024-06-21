package org.CommandWorks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;
import org.EnumWorks.OrganizationType;
import org.ServerOperationsWorks.RecieverModule;

public class PrintFieldDescendingTypeCommand {

    
    /** 
     * Выводит элементы коллекции по убыванию типа
     * @param arg
     */
    public String execute(String arg){
        
        String ans = "";
        PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();
        collectionCopy = OrgCollection.getCollection();
        HashMap<Long, OrganizationType> map = new HashMap<>();
        
        while (!collectionCopy.isEmpty()){
            Organization org = collectionCopy.poll();
            map.put(org.getEmployeesCount(), org.getOrganizationType());
        }

        while (!map.isEmpty()){
            ArrayList<Long> keys = new ArrayList<>();
            keys.addAll(map.keySet());
            int max =  -1;
            long maxId = -1;

            for (Long i : keys){   
                if (map.get(i).ordinal() > max){
                    max = map.get(i).ordinal();
                    maxId = i;
                }
            }
        
            ans+=(maxId + ":" + map.get(maxId));
            map.remove(maxId);
        }
        return ans;
    }


    }

