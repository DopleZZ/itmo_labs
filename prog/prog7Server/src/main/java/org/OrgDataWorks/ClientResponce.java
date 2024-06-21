package org.OrgDataWorks;

import java.io.Serializable;

public class ClientResponce implements Serializable {

    private static final long serialVersionUID = 1L;
    private String resp;

    public ClientResponce(String resp) {
        this.resp = resp;
    }

    public String getResp() {
        return this.resp;
    }

}
