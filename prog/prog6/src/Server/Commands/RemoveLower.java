package Commands;

import java.util.PriorityQueue;
import Collections.OrgCollection;
import OrgData.Organization;
import ServerOperationsPackage.RecieverModule;

public class RemoveLower {
    
    
    /** 
     * удаляет все элементы коллекции, значение количества сотрудников которых ниже заданного
     * @param arg
     */
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
            RecieverModule.commandResponce= "Элементов с меньшим полем не найдено";
        } else {
            RecieverModule.commandResponce= "Объекты, с меньшим полем были удалены";
        }
    }
}
