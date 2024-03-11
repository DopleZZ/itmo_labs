package OrgData;

public class IdGenerator {
    
private long id  = 0;

public long generateNew(){
    this.id = this.id +1;
    return this.id;
}

}