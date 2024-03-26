package Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import Collections.OrgCollection;
import Enums.OrganizationType;
import Interfaces.Executable;
import OrgData.Organization;

public class PrintFieldDescendingType implements Executable {

    
    /** 
     * Выводит элементы коллекции по убыванию типа
     * @param arg
     */
    @Override
    public void execute(String arg){
    
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
        
            System.out.println(maxId + ":" + map.get(maxId));
            map.remove(maxId);
        }
    }


    }

