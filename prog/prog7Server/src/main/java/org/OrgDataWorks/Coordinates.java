package org.OrgDataWorks;

public class Coordinates {
    private int x;
    private Long y; //Максимальное значение поля: 694, Поле не может быть null\

    public Coordinates(int x, long y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + "," + this.y;
    }

    public String getX() {
        return String.valueOf(x);
    }

    public String getY() {
        return String.valueOf(y);
    }
}