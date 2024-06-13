package org.CommandWorks;

import org.OrgDataWorks.ClientResponce;
import org.ServerOperationsWorks.RecieverModule;
import org.DataBaseWorks.EntryManager;
import org.ServerOperationsWorks.RequestAnswerer;

import java.sql.SQLException;

public class EntryCommand {

    public static ClientResponce execute(String arg) throws SQLException {

        EntryManager manager = new EntryManager();
        String ans;

        String userlogin = arg.split(" ")[0];
        String userpassword = arg.split(" ")[1];
        System.out.println(userlogin + " " + userpassword);
        System.out.println(manager.authenticate(userlogin, userpassword));
        if (manager.authenticate(userlogin, userpassword)){
            ans = "Вход выполнен " + manager.getUserId(userlogin);
            System.out.println("Вход выполнен " + manager.getUserId(userlogin));
        } else {
            ans = "Вход не выполнен";
        }

        return new ClientResponce(ans);
    }

}
