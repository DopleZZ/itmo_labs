package org.CollectionWorks;

import java.util.LinkedHashMap;
import java.util.Map;

import org.CommandWorks.*;

public class CommandCollection {
    // Map<String, AbstractCommand> <3
    private static Map<String, Object> commandCollection = new LinkedHashMap<String, Object>() {
        {
            put("add", new AddCommand());
            put("clear", new ClearCommand());
            // put("executeScript", new ExecuteScriptCommand()); // deprecated
            put("head", new HeadCommand());
            put("help", new HelpCommand());
            put("history", new HistoryCommand());
            put("info", new InfoCommand());
            put("maxByType", new MaxByTypeCommand());
            put("printFieldAscendingEmployeesCount", new PrintFieldAscendingEmployeesCountCommand());
            put("printFieldDescendingType", new PrintFieldDescendingTypeCommand());
            put("removeById", new RemoveByIdCommand());
            put("removeLower", new RemoveLowerCommand());
            // put("save", new SaveCommand()); // deprecated
            put("show", new ShowCommand());
            put("updateId", new UpdateIdCommand());
        }
    };

    /**
     * получить объект комманды
     * 
     * @param command
     * @return Object
     */
    public static Object get(String command) {
        return commandCollection.get(command);
    }

}
