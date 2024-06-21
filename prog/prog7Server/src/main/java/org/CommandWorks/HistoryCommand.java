package org.CommandWorks;

import java.util.stream.Collectors;

import org.CollectionWorks.HistoryCollection;

public class HistoryCommand {
    /**
     * вывести историю комманд
     * 
     * @param arg
     */
    public String execute(String arg) {
        // ну или через стрингбилдер
        System.out.println("история комманд:");
        return HistoryCollection.getCollection().stream().collect(Collectors.joining("\n"));
    };
}
