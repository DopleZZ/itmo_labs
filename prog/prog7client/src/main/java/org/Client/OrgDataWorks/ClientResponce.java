package org.Client.OrgDataWorks;

import java.io.Serializable;

public class ClientResponce implements Serializable{
    
    //private static final long serialVersionUID = 1L;

    public String resp;

    public String getResp(){
        return this.resp;
    }

    public void setResp(String resp){
        this.resp = resp;
    }
}
