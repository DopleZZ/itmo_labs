package mymoves;

import ru.ifmo.se.pokemon.*;

public class Double_team extends StatusMove {
    public Double_team(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applySelfEffects (Pokemon p){
        Effect e = new Effect().stat(Stat.EVASION, 1);
        super.applySelfEffects(p);
        p.addEffect(e);

    }
    @Override
    protected java.lang.String describe() {
        return "использует Duble Team";
    }
}

