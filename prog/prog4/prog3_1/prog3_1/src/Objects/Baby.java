package Objects;

import Enums.*;

public class Baby extends Human{

    public Baby(String name, int health, Location location){
        super(name,health,location);
    }

    public void lol(){
        System.out.println(this.name + " хохочет до слез");
    }

    public void stomach(){
        System.out.println("У " + this.name + " заболел живот");
    }

    public void bed(){
        System.out.println(this.name + " кинулся на кровать");
    }

    public void noMore(){
        System.out.println("У " + this.name + " больше нет сил");
    }

    public void accept(){
        System.out.println(this.name + " был с этим согласен");
    }

    public void goodDes(String kto){
        System.out.println(this.name + " считает, что " + kto + " хорош во всех отношениях");
    }

}