package Enums;

public enum Location {
    ROOM ("Комната"),
    OTHER ("Другое");

    private String title;

    Location(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return title;
    }
}
