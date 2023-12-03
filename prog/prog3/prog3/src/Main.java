
import Enums.Action;
import Objects.Entity;
import Objects.Thing;

public class Main {
    public static void main(String[] args){
        Entity frek = new Entity("Фрекен Бок");
        Entity mal = new Entity("Малыш");
        Entity karl = new Entity("Карлсон");
        Thing room = new Thing("комната");
        Thing bed = new Thing("кровать");
        frek.dosmth(Action.Bored, 1);
        frek.dosmth(Action.Jumping,1);
        frek.dosmth(Action.slapping_the_floor,1);
        frek.dosmth(Action.withot_boots,1);
        frek.dosmth(Action.will_not_surrender,1);
        frek.dosmth(Action.Jumping, 1);
        frek.dosmth(Action.strike, karl);
        karl.dosmth(Action.laugh, 1);
        karl.dosmth(Action.pull_up, 1);
        mal.dosmth(Action.laugh, 1);
        mal.dosmth(Action.stomach_ache, 1);
        karl.dosmth(Action.to_room, room);
        frek.dosmth(Action.to_room, room);
        mal.dosmth(Action.to_room, room);
        mal.dosmth(Action.to_bed, bed);


    }
}
