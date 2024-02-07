package Exceptions;

public class WrongArgumentException extends Exception {


    @Override 
    public String getMessage(){
        return "Wrong Argument";
    }
}
