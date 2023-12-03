package Objects;

public class Thing extends Obj {
    public Thing(String name){
        super(name);
    }
    @Override
    public String toString(){
        return name;
    }

}
