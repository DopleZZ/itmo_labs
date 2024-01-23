package Objects;

import Enums.Location;

public class Yulius extends Human {

    public Yulius(String name, int health, Location location){
        super(name, health, location);
    }

    public void attach(String kKomu){
        System.out.println(this.name + " уже тоже привязался к " + kKomu);
    }
    
    public void dontForget(){
        System.out.println(this.name + " Этого не забудет");
    }
}
