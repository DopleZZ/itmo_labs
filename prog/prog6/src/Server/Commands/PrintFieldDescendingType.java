package Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import Collections.OrgCollection;
import Enums.OrganizationType;
import OrgData.Organization;
import ServerOperationsPackage.RecieverModule;

public class PrintFieldDescendingType {

    
    /** 
     * Выводит элементы коллекции по убыванию типа
     * @param arg
     */
    public void execute(String arg){
        
        RecieverModule.commandResponce="";
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
        
            RecieverModule.commandResponce+=(maxId + ":" + map.get(maxId));
            map.remove(maxId);
        }
    }


    }

