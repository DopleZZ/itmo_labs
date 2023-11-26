package mymoves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Calm_Mind extends StatusMove{
    public Calm_Mind(double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);

    }
    @Override
    protected void applySelfEffects(Pokemon p){
        super.applySelfEffects(p);
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK,1).stat(Stat.SPECIAL_DEFENSE, 1);
        p.addEffect(e);

    }
    @Override
    protected java.lang.String describe() {
        return "использует Calm Mind";
    }
    
}
