package org.CommandWorks;

import org.DataBaseWorks.EntryManager;

import java.sql.SQLException;

public class EntryCommand {

    public static String execute(String userLogin, String userPass) throws SQLException {

        EntryManager manager = new EntryManager();
        String ans;
        if (manager.authenticate(userLogin, userPass)){
            ans = "Вход выполнен " + manager.getUserId(userLogin);
            System.out.println("Вход выполнен " + manager.getUserId(userLogin));
        } else {
            ans = "Вход не выполнен";
        }

        return ans;
    }

}
