package Objects;

import interfaces.Helicopter;
import Enums.*;

public class Karlson extends Human implements Helicopter{



    public Karlson(String name, int health, Location location){
        super(name,health,location);
    }

    public static class Propeller{
        private boolean power;


        public void turnOn(){
            this.power = true;
            System.out.println("Пропеллер теперь включен");
        }

        public void turnOff(){
            this.power = false;
            System.out.println("Пропеллер теперь выключен");
        }
    }

    @Override
    public void fly(){
        System.out.println(this.name + " набирает высоту");
    }

    public void laugh(){
        System.out.println(this.name + " смеется");
    }

    public void dontCare(){
        System.out.println(this.name + " не обращает внимание, лишь бы ему давали еду");
    }

    public void eat(){
        System.out.println(this.name + " ест со всеми");
    }
}

