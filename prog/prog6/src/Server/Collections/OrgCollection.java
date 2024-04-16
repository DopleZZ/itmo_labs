package Collections;


import java.time.LocalDate;
import java.util.PriorityQueue;

import OrgData.Organization;
import ServerOperationsPackage.RecieverModule;

public class OrgCollection{

    private static LocalDate initDate;
    private static PriorityQueue<Organization> organizationCollection = new PriorityQueue<>();
    
    public OrgCollection(){
        OrgCollection.initDate = LocalDate.now();
    }

    /** 
     * Добавить объект в коллекцию
     * @param o
     */
    public static void addObj(Organization o){
        organizationCollection.add( o);
    }

    /** 
     * получить копию коллекции
     * @return PriorityQueue<Organization>
     */
    public static PriorityQueue<Organization> getCollection(){
        PriorityQueue<Organization> collectionCopy = new PriorityQueue<>(organizationCollection);
        //collectionCopy = organizationCollection;
        return collectionCopy;
    }

    /**
     * Очистить коллекцию
     */
    public static void clear(){
        while (!organizationCollection.isEmpty()) {
            organizationCollection.clear();
        }
    }

    /** 
     * получить количество объектов в коллекции
     * @return int
     */
    public static int getSize(){
        return organizationCollection.size();
    }
    
    /**
     * получить информацию о коллекции
     */
    public static void info(){
        RecieverModule.commandResponce = 
        "Дата создания: "+initDate+"\nКоличество элементов: "+ organizationCollection.size();
    }

    /**
     * получить оригинальную коллекцию
     * @return PriorityQueue<Organization>
     */
    public static PriorityQueue<Organization> getCollectionLink(){
        return organizationCollection;
    }

    
}