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
    }
}
