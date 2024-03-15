package enums;
public enum VladLoh {
    AHHAHAHAH("студенты",1),
    Upiter("готовьтесь, завтра",2),
    kolokol("kolokvium",3);


    private String name;
    private int num;

    private VladLoh(String name, int num){
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString(){
        return name;
    }
}




