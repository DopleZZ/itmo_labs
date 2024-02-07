import Enums.Location;
import Objects.*;
import interfaces.BeOnSide;
import Errors.FileReadException;

import java.lang.Math;
import Errors.WrongDamageException;

public class Main {
    public static void main(String[] args){

        Frek frek = new Frek("Фрекен Бок", 100, Location.OTHER);
        Karlson karl = new Karlson("Карлсон", 100, Location.OTHER);
        Baby baby = new Baby("Малыш", 100, Location.OTHER);
        Vybivalka vyb = new Vybivalka(-100 + (int) (Math.random() * 201),"Выбивалка" );
        Yulius yul = new Yulius("дядя Юлиус", 100, Location.OTHER);

        Baby.Organ stomach =  baby.new Organ("живот");
        Karlson.Propeller propeller = new Karlson.Propeller();



        Reader reader = new Reader();        
        //checked IOException
        try{
            reader.read();
        } catch(FileReadException e){
            System.out.println(e.getMessage());
        }

        System.out.println();

        frek.breathe();
        frek.jumping();
        frek.onFloor();
        frek.nochoes();
        frek.tired();
        frek.notSurrender();
        frek.jumping();

        //unchecked IllegalArgument
        try{
            vyb.dealDamage(frek.getName(), karl.getName());
            karl.getDamaged(vyb.getDamage());
        } catch (WrongDamageException e){
            e.initCause(new WrongDamageException("Damage value is less than zero"));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }





        karl.laugh();
        propeller.turnOn();
        karl.fly();
        baby.lol();
        stomach.pain();
        frek.move(Location.ROOM);
        baby.move(Location.ROOM);
        karl.move(Location.ROOM);
        baby.bed();
        baby.noMore();
        frek.runningNearWalls();
        frek.tryToCatch(karl.getName());

        System.out.println();
        System.out.println("act2");

        baby.accept();
        baby.goodDes(karl.getName());
        yul.attach(karl.getName());
        karl.giveItem("кошелек", yul.getName());
        karl.giveItem("часы", yul.getName());
        yul.dontForget();
        frek.angry();
        karl.dontCare();
        karl.say("Если меня не кормят, я уже не я");
        frek.dream();

        //анонимный класс
        BeOnSide beOnSide = () -> System.out.println("Малыш и дядя Юлиус на стороне Карлсона");
        beOnSide.beOnSide();

        karl.eat();
        frek.grumble();


        
    }
}