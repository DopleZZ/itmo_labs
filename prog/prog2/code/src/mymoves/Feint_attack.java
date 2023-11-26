package mymoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Feint_attack extends  PhysicalMove{
    public Feint_attack(double acc, double pow){
        super(Type.DARK, pow, acc);

    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Feint Attack";
    }
    
}
