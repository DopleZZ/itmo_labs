package mypokemons;


import mymoves.Aqua_tail;
import mymoves.Calm_Mind;
import mymoves.Double_Edge;
import mymoves.Muddy_Water;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Relicanth extends Pokemon{
    public Relicanth(String name, int level){
        super(name, level);
        super.setType(Type.WATER, Type.ROCK);
        super.setStats(100,90,130,45,65,55);
        Muddy_Water muddy_Water = new Muddy_Water(90, 80);
        Calm_Mind calm_Mind = new Calm_Mind(0, 0);
        Aqua_tail aqua_tail = new Aqua_tail(90, 90);
        Double_Edge double_Edge = new Double_Edge(120, 100);
        super.setMove(muddy_Water, calm_Mind, aqua_tail, double_Edge);
    }
}
