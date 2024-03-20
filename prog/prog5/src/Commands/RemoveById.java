package Commands;

import java.util.PriorityQueue;

import Collections.OrgCollection;
import Interfaces.Executable;
import OrgData.Organization;

public class RemoveById implements Executable{
    
    @Override
    public void execute(String idToRemove){

        Long idToSearch = Long.parseLong(idToRemove);
        PriorityQueue<Organization> tempCollection = new PriorityQueue<>();
        PriorityQueue<Organization> originalCollection = new PriorityQueue<>();
        originalCollection = OrgCollection.getCollectionLink();
        Organization currectOrg;

        while (!originalCollection.isEmpty()){
            currectOrg = originalCollection.poll();
            if (currectOrg.getId() != idToSearch) {
                tempCollection.add(currectOrg);
            }
        }

        originalCollection.addAll(tempCollection);
    }
}
