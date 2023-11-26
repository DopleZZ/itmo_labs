package mypokemons;

import mymoves.Bone_rush;
import mymoves.Confide;
import mymoves.Feint_attack;
import mymoves.Snarl;
import ru.ifmo.se.pokemon.Type;

public class Mandibuzz extends Vullaby{
    public Mandibuzz(String name, int level){
        super(name, level);
        super.setType(Type.DARK, Type.FLYING);
        super.setStats(110, 65, 105, 55, 95, 80);
        Feint_attack feint_attack = new Feint_attack(99999, 60);
        Snarl snarl = new Snarl(55, 95);
        Confide confide = new Confide(0, 0);
        Bone_rush bone_rush = new Bone_rush(25, 90);

        super.setMove(feint_attack, snarl, confide, bone_rush);
    }
    
}