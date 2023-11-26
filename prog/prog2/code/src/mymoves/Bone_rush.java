package mymoves;


import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Bone_rush extends PhysicalMove {
    public Bone_rush(double pow, double acc) {
        super(Type.GROUND, pow, acc);

    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
    
    }
    @Override
    protected java.lang.String describe() {
        return "использует Bone Rush";
    }
    
}
