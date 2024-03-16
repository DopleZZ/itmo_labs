package OrgData;

public class IdGenerator {
    
private static long id  = 0;

public long generateNew(){
    id = id +1;
    return IdGenerator.id;
    }
}