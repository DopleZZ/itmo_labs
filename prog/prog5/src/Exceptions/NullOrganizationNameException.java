package Exceptions;

public class NullOrganizationNameException extends Exception {
    
    @Override 
    public String getMessage(){
        return "Organization name must not be null";
    }
}
