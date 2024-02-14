package test;

import java.util.Objects;

public class Invoker implements Comparable<Invoker>{

    private String name;
    private int id;

    public Invoker(String name, int id){
        this.name = name;
        this.id = id;
    }

    public void quas(){
        System.out.println("quas");
    }

    public void wex(){
        System.out.println("wex");
    }

    public void exort(){
        System.out.println("Exort");
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }


    @Override
    public String toString(){
        return this.name;
    }


    @Override
    public int compareTo(Invoker o) {
        if (o == null)return 0;
        else {
            return compare(this.id, o.getId());
        }
        return name.compareTo(this.name);
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoker entity = (Invoker) o;
        return name == entity.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    
}
