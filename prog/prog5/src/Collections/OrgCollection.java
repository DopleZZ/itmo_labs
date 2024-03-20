package Collections;


import java.time.LocalDate;
import java.util.PriorityQueue;
import OrgData.Organization;

public class OrgCollection{

    private static LocalDate initDate;
    private static PriorityQueue<Organization> organizationCollection = new PriorityQueue<>();
    
    public OrgCollection(){
        this.initDate = LocalDate.now();
    }

    public static void addObj(Organization o){
        organizationCollection.add( o);
    }

    
    public static PriorityQueue getCollection(){
        PriorityQueue<Organization> collectionCopy = new PriorityQueue<>(organizationCollection);
        //collectionCopy = organizationCollection;
        return collectionCopy;
    }

    public static void clear(){
        while (!organizationCollection.isEmpty()) {
            organizationCollection.clear();
        }
    }

    public static int getSize(){
        return organizationCollection.size();
    }

    public static void info(){
        System.out.println("Дата создания: "+initDate+"\nКоличество элементов: "+ organizationCollection.size());
    }

    public static PriorityQueue getCollectionLink(){
        return organizationCollection;
    }
}