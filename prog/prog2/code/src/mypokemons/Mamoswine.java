package mypokemons;


import mymoves.Amnesia;
import mymoves.Swagger;
import mymoves.Double_team;
import mymoves.Mud_Slap;
import ru.ifmo.se.pokemon.Type;



public class Mamoswine extends Piloswine {
    public Mamoswine(String name, int level) {
        super(name, level);
        super.setType(Type.ICE, Type.GROUND);
        super.setStats(110, 130, 80, 70, 60, 80);
        Amnesia amnesia = new Amnesia(0,0);
        Swagger swagger = new Swagger(60, 100);
        Double_team double_team = new Double_team(0,0);
        Mud_Slap mud_slap = new Mud_Slap(100,20);

        super.setMove(amnesia, swagger, double_team, mud_slap);
    }
}