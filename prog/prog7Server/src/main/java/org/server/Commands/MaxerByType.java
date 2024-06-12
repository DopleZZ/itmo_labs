package org.server.Commands;

import java.util.PriorityQueue;

import org.server.Collections.OrgCollection;
import org.server.Enums.OrganizationType;
import org.server.OrgData.Organization;
import org.server.ServerOperationsPackage.RecieverModule;

public class MaxerByType{

    
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