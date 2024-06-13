package org.CommandWorks;

import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class RemoveLowerCommand {
    
    
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



        RemoveByIdCommand rem = new RemoveByIdCommand();




        originalCollection.stream().filter(x -> x.getEmployeesCount()<empLower).forEach(x -> rem.execute(x.getSId()));

        //Stream.of(tempCollection).filter(x -> x.getEmployeesCount()<empLower).forEach(x -> rem.execute(x.getSId()));





       /*  while (!originalCollection.isEmpty()){
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
        */
    }
}
