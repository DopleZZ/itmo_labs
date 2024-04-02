import java.io.Serializable;

public class Serka implements Serializable {

    private static final long serialVersionUID = 1L;
    private String com;
    private String[] arguments;


    public Serka(String com, String[] arg){
        this.arguments = arg;
        this.com = com;
    }

    public String getCom(){
        return this.com;
    }

    public String[] getArg(){
        return this.arguments;
    }

    @Override
    public String toString(){
        return this.com;
    }
}
