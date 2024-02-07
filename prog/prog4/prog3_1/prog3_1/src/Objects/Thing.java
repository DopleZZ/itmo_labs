package Objects;

import Errors.WrongDamageException;
import interfaces.OptionalThing;
import interfaces.Weapon;

public abstract class Thing implements OptionalThing, Weapon{
    protected int damage;
    protected String name;

    public Thing(int damage, String name){
        this.damage = damage;
        this.name = name;
    }

    @Override
    public void setDamage(int damage){
        this.damage = damage;
    }

    @Override
    public int getDamage(){
        return this.damage;
    }

    @Override
    public void dealDamage(String kto, String kogo) throws WrongDamageException{
        if (this.damage < 0){
            
            throw new WrongDamageException(kto + " пытается нанести " + kogo + " " + this.damage + " урона, но не получается, так как это значение ошибочно - сообщает WrongDamageException");
        } else{
        System.out.println(kto + " наносит " + this.damage+ " урона " + kogo + " используя " + this.name);
        }
    }


}
