package Exceptions;

public class EmptyOrganizationNameException extends Exception{

        @Override 
    public String getMessage(){
        return "Organization name must not be empty";
    }
}
