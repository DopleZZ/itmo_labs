package org.CommandWorks;

import java.util.PriorityQueue;

import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;
import org.EnumWorks.OrganizationType;
import org.ServerOperationsWorks.RecieverModule;

public class MaxByTypeCommand {

    
    /** 
     * Вывести элемент коллекции, значение типа которого максимально
     * @param arg
     */
    public String execute(String arg){

PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();

        collectionCopy = OrgCollection.getCollection();
        String orgName = "none";
        Organization org;
        int maxTypeOrd = -1;
        boolean flag = false;
        String ans;
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
            ans=orgName + ":" + maxType;
        } else {
            ans="элементов не обнаруженно";
            }
        return ans;
    }
    }