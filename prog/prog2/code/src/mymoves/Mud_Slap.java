package mymoves;

import ru.ifmo.se.pokemon.*;

public class Mud_Slap extends SpecialMove {
    public Mud_Slap(double acc, double pow){
        super(Type.GROUND, pow, acc);

    }
    @Override
    protected void applyOppEffects(Pokemon p){

        super.applyOppEffects(p);
        Effect e = new Effect().stat(Stat.ACCURACY,1);
        p.addEffect(e);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Mud-Slap";
    }
}
