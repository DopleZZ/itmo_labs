package Commands;

import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;

public class RemoveById implements Executable{
    
    
    /** 
     * Удаляет элемент с заданным айди
     * @param idToRemove
     */
    @Override
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
            System.err.println("Элемента с таким айди не существует");
        } else {
            System.out.println("Объект удален");
        }
    }
}
