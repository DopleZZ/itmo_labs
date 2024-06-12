package org.server.CommandWorks;

import org.server.DataBaseWorks.EntryManager;
import org.server.InterfaceWorks.CommandInterface;
import org.server.ServerOperationsWorks.RecieverModule;

import java.sql.SQLException;

public class EntryCommand {

    public void execute(String arg) throws SQLException {

        EntryManager manager = new EntryManager();

        System.out.println("Говнище!");
        String userlogin = arg.split(" ")[0];
        String userpassword = arg.split(" ")[1];

        if (manager.authenticate(userlogin, userpassword)){
            RecieverModule.commandResponce = "Вход выполнен 123";
        } else {
            RecieverModule.commandResponce = "Вход не выполнен";
        }
    }

}
