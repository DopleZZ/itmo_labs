package Interfaces;

import java.util.PriorityQueue;

import OrgData.Organization;

public interface CollectionInterface {
    
    public void addObj(Organization o);

    public PriorityQueue getCollection();

}