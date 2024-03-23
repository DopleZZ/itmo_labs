package Commands;

import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;

public class RemoveLower implements Executable {
    
    @Override
    public void execute(String arg){
        
        Long empLower = Long.parseLong(arg);
        PriorityQueue<Organization> tempCollection = new PriorityQueue<>();
        PriorityQueue<Organization> originalCollection = new PriorityQueue<>();
        originalCollection = OrgCollection.getCollectionLink();
        Organization currectOrg;
        Boolean flag = false;

        while (!originalCollection.isEmpty()){
            currectOrg = originalCollection.poll();
            if (currectOrg.getEmployeesCount() >= empLower) {
                tempCollection.add(currectOrg);
            } else {
                flag = true;
            }
        }

        originalCollection.addAll(tempCollection);

        if (!flag){
            System.err.println("Элементов с меньшим полем не найдено");
        } else {
            System.out.println("Объекты, с меньшим полем были удалены");
        }
    }
}
