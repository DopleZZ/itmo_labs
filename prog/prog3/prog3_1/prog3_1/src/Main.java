import Enums.Location;
import Objects.*;


public class Main {
    public static void main(String[] args){
        Frek frek = new Frek("Фрекен Бок", 10, Location.ROOM);
        Karlson karl = new Karlson("Карлсон", 10, Location.OTHER);
        Baby baby = new Baby("Малыш", 10, Location.OTHER);
        Vybivalka vyb = new Vybivalka(2,"Выбивалка" );

        frek.breathe();
        frek.jumping();
        frek.slapping();
        frek.nochoes();
        frek.tired();
        frek.notSurrender();
        frek.jumping();
        vyb.dealDamage(frek.getName(), karl.getName());
        karl.getDamaged(vyb.getDamage());
        karl.laugh();
        karl.fly();
        baby.lol();
        baby.stomach();
        frek.move(Location.ROOM);
        baby.move(Location.ROOM);
        karl.move(Location.ROOM);
        baby.bed();
        baby.noMore();
        frek.runningNearWalls();
        frek.tryToCatch(karl.getName());
        
    }
}