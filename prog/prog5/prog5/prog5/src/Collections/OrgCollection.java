package Collections;


import java.util.PriorityQueue;

import Interfaces.CollectionInterface;
import OrgData.Organization;

public class OrgCollection implements CollectionInterface {

    private PriorityQueue<Organization> kakashki = new PriorityQueue<>();
    

    public OrgCollection(){}

    @Override
    public void add(Organization o){
        kakashki.add(o);
    }
}
