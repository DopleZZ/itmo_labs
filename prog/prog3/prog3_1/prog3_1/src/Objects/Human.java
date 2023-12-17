package Objects;

import java.util.Objects;
import interfaces.OptionalHuman;
import Enums.*;

public abstract class Human implements OptionalHuman {
    protected String name;
    protected int health;
    protected Location location;  

    public Human(String name, int health, Location location){
        this.name = name;
        this.health = health;
        this.location = location;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human entity = (Human) o;
        return name == entity.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getHealth(){
        return this.health;
    }

    @Override
    public Location getLocation(){
        return this.location;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public void setLocation(Location location){
        this.location = location;
    }

    public void getDamaged(int damage){
        setHealth(getHealth()-damage);
        System.out.println(this.name + " теряет " + damage + " здоровья");
    }

    public void move(Location location){
        System.out.println(this.name + " теперь находится в " + location);
        setLocation(location);
    }
}
