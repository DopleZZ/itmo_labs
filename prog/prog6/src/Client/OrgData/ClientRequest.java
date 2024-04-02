package OrgData;

import java.io.Serializable;

public class ClientRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    private String command;
    private Object[] arguments;
    
    public ClientRequest(String comm, Object[] args){
        this.command = comm;
        this.arguments = args;
    }

    public String getCommand(){
        return this.command;
    }

    public Object[] getArgs(){
        return this.arguments;
    }
}