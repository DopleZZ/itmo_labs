package Commands;

import java.util.PriorityQueue;

import Collections.OrgCollection;
import Enums.OrganizationType;
import Interfaces.Executable;
import OrgData.Organization;

public class MaxByType implements Executable{

    
    /** 
     * Вывести элемент коллекции, значение типа которого максимально
     * @param arg
     */
    @Override
    public void execute(String arg){

PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

        collectionCopy = OrgCollection.getCollection();
        String orgName = "none";
        Organization org;
        int maxTypeOrd = -1;
        boolean flag = false;
        OrganizationType maxType = OrganizationType.NONE;


        
        while (!collectionCopy.isEmpty()){
            org = collectionCopy.poll();
            if (org.getOrganizationType().ordinal() > maxTypeOrd){
                maxTypeOrd = org.getOrganizationType().ordinal();
                orgName = org.getName();
                flag = true;
                maxType = org.getOrganizationType();
            }
        }

        if (flag){
            System.out.println(orgName + ":" + maxType);
        } else {
            System.out.println("'элементов не обнаруженно");
            }
        }
    }