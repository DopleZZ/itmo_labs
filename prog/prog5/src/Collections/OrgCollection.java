package Collections;


import java.util.PriorityQueue;
import OrgData.Organization;

public class OrgCollection{

    private static PriorityQueue<Organization> organizationCollection = new PriorityQueue<>();
    
    public OrgCollection(){}

    public static void addObj(Organization o){
        organizationCollection.add( o);
    }

    
    public static PriorityQueue getCollection(){
        return OrgCollection.organizationCollection;
    }
}