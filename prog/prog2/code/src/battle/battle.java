package battle;

import mypokemons.Mamoswine;
import mypokemons.Mandibuzz;
import mypokemons.Piloswine;
import mypokemons.Relicanth;
import mypokemons.Swinub;
import mypokemons.Vullaby;
import ru.ifmo.se.pokemon.Battle;

public class battle {
    public static void main(String[] args) {
      Battle b = new Battle();
    
      Mamoswine mamoswine = new Mamoswine("Мама Хрюня", 1);
      Piloswine piloswine = new Piloswine("Хрюня-дед инсайд", 1);
      Swinub swinub = new Swinub("Хрюник", 1);
      Mandibuzz mandibuzz = new Mandibuzz("Птыца", 1);
      Vullaby vullaby = new Vullaby("Цыпик", 1);
      Relicanth relicanth = new Relicanth("Фишь", 1);

      b.addAlly(piloswine);
      b.addAlly(mandibuzz);
      b.addAlly(vullaby);
      b.addFoe(swinub);
      b.addFoe(mamoswine);
      b.addFoe(relicanth);
      b.go();
    

    }
}
