package org.CommandWorks;

import org.DataBaseWorks.EntryManager;

import java.sql.SQLException;

public class EntryCommand {

    public static String execute(String userLogin, String userPass) throws SQLException {
        EntryManager manager = new EntryManager();
        if (manager.authenticate(userLogin, userPass)) {
            return "Вход выполнен " + manager.getUserId(userLogin);
            // System.out.println("Вход выполнен " + manager.getUserId(userLogin));
            // TODO по идеи тебе надо логгер подключить на сервере и весь вывод туда
            // log.info("Выполнен вход: %s", manager.getUserId(userLogin))
        }
        return "Вход не выполнен";

    }

}
