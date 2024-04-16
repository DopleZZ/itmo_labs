public class Child extends Parent {

    private static final String c = "badruki";

    public Child(String a, String b) {
        super(a, b);  
    }
    
    @Override
    public String getC(){
        return this.c;
    }
}
