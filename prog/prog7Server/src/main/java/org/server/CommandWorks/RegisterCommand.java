package org.server.CommandWorks;

import org.server.DataBaseWorks.DataBaseManager;

import java.sql.Connection;

public class RegisterCommand {

    public void execute(String login, String password){
        Connection connection = DataBaseManager.getConnection();


    }
}
