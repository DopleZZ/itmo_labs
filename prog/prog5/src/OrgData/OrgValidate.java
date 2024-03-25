package OrgData;

public class OrgValidate {
    
    public static boolean validateName(String name){
        if (name.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


}
