package test;

import java.util.PriorityQueue;

public class OrgCollection implements getter {

    private PriorityQueue<Object> kakashki = new PriorityQueue<>();

    public OrgCollection(){}

    @Override
    public void setO(Object obj){
        kakashki.add(obj);
    }

    @Override
    public Object[] get(){
        return kakashki.toArray();
    }

    @Override
    public Object remove(){
        return kakashki.remove();
    }

    public Object peek(){
        return kakashki.peek();
    }



    

    
}
