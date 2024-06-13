package org.CommandWorks;

import org.ServerOperationsWorks.RecieverModule;
import org.DataBaseWorks.EntryManager;

import java.sql.SQLException;

public class EntryCommand {

    public static void execute(String arg) throws SQLException {

        EntryManager manager = new EntryManager();

        System.out.println("Говнище!");
        String userlogin = arg.split(" ")[0];
        String userpassword = arg.split(" ")[1];

        if (manager.authenticate(userlogin, userpassword)){
            RecieverModule.commandResponce = "Вход выполнен";
        } else {
            RecieverModule.commandResponce = "Вход не выполнен";
        }
    }

}
