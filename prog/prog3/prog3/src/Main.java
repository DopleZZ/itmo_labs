
import Enums.Action;
import Objects.Entity;
import Objects.Thing;

public class Main {
    public static void main(String[] args){
        Entity frek = new Entity("фрекен Бок");
        Entity mal = new Entity("малыш");
        Entity karl = new Entity("карлсон");

        Thing room = new Thing("комната");
        Thing bed = new Thing("кровать");
        Thing vybivalka = new Thing("выбивалка");

        frek.dosmth(Action.Bored, 1);
        frek.dosmth(Action.Jumping,1);
        frek.dosmth(Action.slapping_the_floor,1);
        frek.dosmth(Action.withot_boots,1);
        frek.dosmth(Action.will_not_surrender,1);
        frek.dosmth(Action.Jumping, 1);
        karl.uses(vybivalka);
        frek.dosmth(Action.strike, karl);
        karl.dosmth(Action.laugh, 1);
        karl.dosmth(Action.pull_up, 1);
        mal.dosmth(Action.laugh, 1);
        mal.dosmth(Action.stomach_ache, 1);
        karl.dosmth(Action.to_room, room);
        frek.dosmth(Action.to_room, room);
        mal.dosmth(Action.to_room, room);
        mal.dosmth(Action.to_bed, bed);
        mal.dosmth(Action.rest, 1);
        mal.dosmth(Action.laugh_hard, 1);
        frek.dosmth(Action.by_the_wall,1);
        karl.drop(karl);
        frek.dosmth(Action.try_to_catch, karl);


    }
}
 