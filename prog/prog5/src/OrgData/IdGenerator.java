package OrgData;

public class IdGenerator {
    
public static long id;

public long generateNew(){
    id = id +1;
    return IdGenerator.id;
    }
}