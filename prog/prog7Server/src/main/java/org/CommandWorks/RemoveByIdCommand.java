package org.CommandWorks;

import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;
import org.ServerOperationsWorks.RecieverModule;

public class RemoveByIdCommand {
    
    
    /** 
     * Удаляет элемент с заданным айди
     * @param idToRemove
     */
    public void execute(String idToRemove){

        Long idToSearch = Long.parseLong(idToRemove);
        PriorityQueue<Organization> tempCollection = new PriorityQueue<>();
        PriorityQueue<Organization> originalCollection = new PriorityQueue<>();
        originalCollection = OrgCollection.getCollectionLink();
        Organization currectOrg;
        Boolean flag = false;

        while (!originalCollection.isEmpty()){
            currectOrg = originalCollection.poll();
            if (currectOrg.getId() != idToSearch) {
                tempCollection.add(currectOrg);
            } else {
                flag = true;
            }
        }

        originalCollection.addAll(tempCollection);

        if (!flag){
            RecieverModule.commandResponce= "Элемента с таким айди не существует";
        } else {
            RecieverModule.commandResponce="Объект удален";
        }
    }
}
