package org.CommandWorks;

import org.ServerOperationsWorks.RecieverModule;
import org.DataBaseWorks.EntryManager;

import java.sql.SQLException;

public class EntryCommand {

    public static void execute(String arg) throws SQLException {

        EntryManager manager = new EntryManager();

        String userlogin = arg.split(" ")[0];
        String userpassword = arg.split(" ")[1];
        System.out.println(userlogin + " " + userpassword);
        System.out.println(manager.authenticate(userlogin, userpassword));
        if (manager.authenticate(userlogin, userpassword)){
            RecieverModule.commandResponce = "Вход выполнен " + manager.getUserId(userlogin);
            System.out.println("Вход выполнен " + manager.getUserId(userlogin));
        } else {
            RecieverModule.commandResponce = "Вход не выполнен";
        }
    }

}
