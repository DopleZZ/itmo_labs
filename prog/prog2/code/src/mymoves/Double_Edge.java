package mymoves;

import ru.ifmo.se.pokemon.*;

public class Double_Edge extends PhysicalMove{
    public Double_Edge(double pow, double acc) {
        super(Type.NORMAL, pow, acc);

    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        
    }

    @Override
    protected void applySelfDamage(Pokemon att, double def){
        super.applySelfDamage(att, def/3);

    }
    @Override
    protected java.lang.String describe() {
        return "использует Double-Edge";
    }
}
