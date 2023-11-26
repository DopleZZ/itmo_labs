package mymoves;

import ru.ifmo.se.pokemon.*;

public class Amnesia extends StatusMove {
    public Amnesia(double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);

    }

    @Override
    protected void applySelfEffects(Pokemon p){

        super.applySelfEffects(p);
        Effect e = new Effect().stat(Stat.SPECIAL_DEFENSE,2);
        p.addEffect(e);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Amnesia";
    }
    
    
}


