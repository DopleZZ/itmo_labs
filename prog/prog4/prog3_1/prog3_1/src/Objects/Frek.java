package Objects;

import Enums.*;

public class Frek extends Human{

    public Frek(String name, int health, Location location){
        super(name,health,location);
    }

    public void breathe(){
        System.out.println(this.name + " запыхалась");
    }

    public void onFloor(){
        System.out.println(this.name + " шлепает ногами по полу");
    }

    public void jumping(){
        System.out.println(this.name + " продолжает подпрыгивать");
    }

    public void nochoes(){
        System.out.println(this.name + " еще не успела обуться");
    }

    public void tired(){
        System.out.println(this.name + " очень устала");
    }

    public void notSurrender(){
        System.out.println(this.name + " не собирается сдаваться");
    }

    public void runningNearWalls(){
        System.out.println(this.name + " мечется вдоль стен");
    }

    public void tryToCatch(String kogo){
        System.out.println(this.name + " пытается поймать " + kogo);
    }

    public void angry(){
        System.out.println(this.name + " сердится");
    }

    public void dream(){
        System.out.println(this.name + " мечтает, чтобы Карслон не проводил у них время");
    }

    public void grumble(){
        System.out.println(this.name + " ворчит");
    }

}
