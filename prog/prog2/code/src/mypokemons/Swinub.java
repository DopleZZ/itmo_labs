package mypokemons;


import mymoves.Swagger;
import mymoves.Mud_Slap;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
public class Swinub extends Pokemon{
    public Swinub (String name, int level){
        super(name,level);
        super.setType(Type.ICE, Type.GROUND);
        super.setStats(50,50,40,30,30,50);
        Mud_Slap mud_Slap = new Mud_Slap(100,30);
        Swagger swagger = new Swagger(0, 85);

        super.setMove( swagger, mud_Slap);


    }
}
