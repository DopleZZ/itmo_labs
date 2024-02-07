package Enums;

public enum Location {
    ROOM ("Комната"),
    OTHER ("Другое"),
    TEST();

    private String title;

    Location(String title){
        this.title = title;
    }

    Location(){
        this.title="титл";
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return title;
    }
}
