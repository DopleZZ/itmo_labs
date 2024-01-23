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
    //вложенный класс
    public class Organ {

        private String organTitle;

        public Organ(String organTitle){
            this.organTitle = organTitle;
        }

        public void pain(){
            System.out.println("У "+ Human.this.name + " болит " + this.organTitle);
        }
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

    public void giveItem(String title, String endOwner){
        //локальный
        class GivenItem{
            private String title;
            private String owner;

            public GivenItem(String title){
                this.title = title;
            }

            public void setOwner(String currectOwner){
                this.owner = currectOwner;
                System.out.println(name + " Передал " + this.owner + " " + this.title);
            }
        }

        GivenItem item = new GivenItem(title);
        item.setOwner(endOwner);

    }

    public void say(String smth){
        System.out.println("'" + smth + "'" + " - говорит " + this.name);
    }

}
