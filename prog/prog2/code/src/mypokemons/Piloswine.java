package mypokemons;
import mymoves.Amnesia;
import mymoves.Swagger;
import mymoves.Mud_Slap;
import ru.ifmo.se.pokemon.Type;

public class Piloswine extends Swinub{
    public Piloswine(String name, int level){
        super(name, level);
        super.setType(Type.ICE, Type.GROUND);
        super.setStats(100,100,80,60,60,50);
        Amnesia amnesia = new Amnesia(30,100);
        Swagger swagger = new Swagger(0, 85);
        Mud_Slap Mud_Slap = new Mud_Slap(0,0);
        super.setMove(amnesia, swagger, Mud_Slap);
    }
}
