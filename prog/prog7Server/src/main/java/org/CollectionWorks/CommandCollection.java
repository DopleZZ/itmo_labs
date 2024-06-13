package org.CollectionWorks;

import java.util.LinkedHashMap;
import java.util.Map;


import org.CommandWorks.*;
import org.CommandWorks.*;
import org.InterfaceWorks.CommandInterface;

public class CommandCollection implements CommandInterface {

    AddCommand add = new AddCommand();
    ClearCommand clear = new ClearCommand();
    ExecuteScriptCommand executeScript = new ExecuteScriptCommand();
    HeadCommand head = new HeadCommand();
    HelpCommand help = new HelpCommand();
    HistoryCommand history = new HistoryCommand();
    InfoCommand info = new InfoCommand();
    MaxByTypeCommand maxByType = new MaxByTypeCommand();
    PrintFieldAscendingEmployeesCountCommand printFieldAscendingEmployeesCount = new PrintFieldAscendingEmployeesCountCommand();
    PrintFieldDescendingTypeCommand printFieldDescendingType = new PrintFieldDescendingTypeCommand();
    RemoveByIdCommand removeById = new RemoveByIdCommand();
    RemoveLowerCommand removeLower = new RemoveLowerCommand();
    SaveCommand save = new SaveCommand();
    ShowCommand show = new ShowCommand();
    UpdateIdCommand updateId = new UpdateIdCommand();


    private Map<String, Object> commandCollection = new LinkedHashMap<String, Object>(){{
        put("add", add);
        put("clear", clear);
        put("executeScript", executeScript);
        put("head", head);
        put("help", help);
        put("history", history);
        put("info", info);
        put("maxByType", maxByType);
        put("printFieldAscendingEmployeesCount", printFieldAscendingEmployeesCount);
        put("printFieldDescendingType", printFieldDescendingType);
        put("removeById", removeById);
        put("removeLower", removeLower);
        put("save", save);
        put("show", show);
        put("updateId", updateId);
    }};

    
    
    /** 
     * получить объект комманды
     * @param command
     * @return Object
     */
    @Override
    public Object get(String command){
        return commandCollection.get(command);
    }



    

}
