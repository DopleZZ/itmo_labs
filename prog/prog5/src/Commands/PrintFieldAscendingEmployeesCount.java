package Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;

public class PrintFieldAscendingEmployeesCount implements Executable{

    @Override
    public void execute(String arg){
        
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
        
            System.out.println(map.get(min) + ":" + min);
            map.remove(min);
        }
    }
}