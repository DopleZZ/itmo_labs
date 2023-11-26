package mypokemons;

import mymoves.Confide;
import mymoves.Feint_attack;
import mymoves.Snarl;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public static class Vullaby extends Pokemon{
    public Vullaby(String name, int level){
        super(name, level);
        super.setType(Type.DARK, Type.FLYING);
        super.setStats(70,55,75,45,65,60);
        Feint_attack feint_attack = new Feint_attack(999999, 60);
        Snarl snarl = new Snarl(55, 95);
        Confide confide = new Confide(0, 0);
        super.setMove(feint_attack, snarl, confide);
    }
    
}
