package enums;
public enum VladLoh {
    AHHAHAHAH("студенты"),
    Upiter("готовьтесь, завтра"),
    kolokol("kolokvium");


    private String name;
    private VladLoh(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
