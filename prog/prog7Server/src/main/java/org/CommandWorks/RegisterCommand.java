package org.CommandWorks;

import org.DataBaseWorks.DataBaseManager;

import java.sql.Connection;

public class RegisterCommand {

    public static String execute(String login, String password){
        DataBaseManager.addUser(login, password);
        return "Пользователь зарегистрирован";
    }
}
