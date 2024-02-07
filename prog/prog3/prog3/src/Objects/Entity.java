package Objects;

import java.util.Objects;

import Enums.Action;
import interfaces.*;

public class Entity extends Obj implements Property, Use, Drop_name {


    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return name == entity.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }



    private String name;
    private String name_reserved;

    public Entity(String name){
        super(name);
        this.name = name;
    }

    public void dosmth(Action act, int end){
        String end_of_Str;
        if (end==1){
            end_of_Str="\n";
        } else{
            end_of_Str="";
        }
       switch (act) {
        case Bored:
            System.out.print(super.name + " запыхается" + end_of_Str);
            
            break;
        case Jumping:
            System.out.print(super.name + " подпрыгивает" + end_of_Str);
            break;

        case slapping_the_floor:
            System.out.print(super.name + " шлепает ногами по полу" + end_of_Str);
            break;

        case withot_boots:
            System.out.print(super.name + " не успевает обуться" + end_of_Str);
            break;

        case will_not_surrender:
            System.out.print(super.name + " не собирается сдаваться" + end_of_Str);
            break;

        case strike:
            System.out.print(super.name + " ударяет" + end_of_Str);
            break;

        case laugh:
            System.out.print(super.name + " смеется" + end_of_Str);
            break;

        case pull_up:
            System.out.print(super.name + " набирает высоту" + end_of_Str);
            break;
        
        case stomach_ache:
            System.out.print("У " + super.name + " заболел живот" + end_of_Str);
            break;

        case to_room:
            System.out.print(super.name + " теперь находится в" + end_of_Str);
            break;

        case to_bed:
            System.out.print(super.name + " падает на" + end_of_Str);
            break;

        case rest:
            System.out.print(super.name + " немного отдыхает" + end_of_Str);
            break;

        case laugh_hard:
            System.out.print(super.name + " стонет от смеха" + end_of_Str);
            break;

        case by_the_wall:
            System.out.print(super.name + " мечется вдоль стены" + end_of_Str);
            break;

        case try_to_catch:
            System.out.print(super.name + " пытается поймать" + end_of_Str);
            break;


        default:
            break;
       }

    }
    
    public void dosmth(Action act, Obj o){
        dosmth(act, 0);
        System.out.print(" "+ o+"\n");
    }



    @Override
    public void propertyes(String property){
        this.name_reserved = this.name;
        this.name = " " + property + " " + this.name;
    }

    @Override
    public void uses(Object o){
        this.name_reserved = this.name;
        this.name = this.name + " используя " + o;
    }

    @Override
    public void drop(Object o){
        this.name = this.name_reserved;
    }
}
