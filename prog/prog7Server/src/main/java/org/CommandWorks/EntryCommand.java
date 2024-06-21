package org.CommandWorks;

import org.DataBaseWorks.EntryManager;

import java.sql.SQLException;

public class EntryCommand {

    public static String execute(String userLogin, String userPass) throws SQLException {

        EntryManager manager = new EntryManager();
        String ans;
        System.out.println(userLogin + " " + userPass);
        System.out.println(manager.authenticate(userLogin, userPass));
        if (manager.authenticate(userLogin, userPass)){
            ans = "Вход выполнен " + manager.getUserId(userLogin);
            System.out.println("Вход выполнен " + manager.getUserId(userLogin));
        } else {
            ans = "Вход не выполнен";
        }

        return ans;
    }

}
