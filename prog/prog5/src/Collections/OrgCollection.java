package Collections;


import java.util.PriorityQueue;
import Interfaces.CollectionInterface;
import OrgData.Organization;

public class OrgCollection implements CollectionInterface{

    private PriorityQueue<Organization> organizationCollection = new PriorityQueue<>();
    
    public OrgCollection(){}

    @Override
    public void addObj(Organization o){
        organizationCollection.add( o);
    }

    @Override
    public PriorityQueue getCollection(){
        return organizationCollection;
    }
}