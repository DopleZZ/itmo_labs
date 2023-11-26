package mymoves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Aqua_tail extends PhysicalMove{
    public Aqua_tail(double pow, double acc) {
        super(Type.WATER, pow, acc);

    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Aqua Tail";
    }


    
}
