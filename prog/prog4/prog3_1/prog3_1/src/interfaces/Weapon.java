package interfaces;

import Errors.WrongDamageException;

public interface Weapon {
    public void dealDamage(String kto, String kogo) throws WrongDamageException;

}