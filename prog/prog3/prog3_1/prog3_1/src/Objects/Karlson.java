package Objects;

import interfaces.Helicopter;
import Enums.*;

public class Karlson extends Human implements Helicopter{

    public Karlson(String name, int health, Location location){
        super(name,health,location);
    }

    @Override
    public void fly(){
        System.out.println(this.name + " набирает высоту");
    }

    public void laugh(){
        System.out.println(this.name + " смеется");
    }



}

