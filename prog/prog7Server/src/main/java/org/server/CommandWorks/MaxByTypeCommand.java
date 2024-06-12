package org.server.CommandWorks;

import java.util.PriorityQueue;

import org.server.CollectionWorks.OrgCollection;
import org.server.EnumWorks.OrganizationType;
import org.server.OrgDataWorks.Organization;
import org.server.ServerOperationsWorks.RecieverModule;

public class MaxByTypeCommand {

    
    /** 
     * Вывести элемент коллекции, значение типа которого максимально
     * @param arg
     */
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
            RecieverModule.commandResponce=orgName + ":" + maxType;
        } else {
            RecieverModule.commandResponce="элементов не обнаруженно";
            }
        }
    }