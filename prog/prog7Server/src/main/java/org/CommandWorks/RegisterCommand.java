package org.CommandWorks;

import org.DataBaseWorks.DataBaseManager;

public class RegisterCommand {

    public static String execute(String login, String password) {
        DataBaseManager.addUser(login, password);
        return "Пользователь зарегистрирован";
    }
}
