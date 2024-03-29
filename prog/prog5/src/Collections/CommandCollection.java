package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

import Commands.Add;
import Commands.Clear;
import Commands.ExecuteScript;
import Commands.Exit;
import Commands.Head;
import Commands.Help;
import Commands.History;
import Commands.Info;
import Commands.MaxByType;
import Commands.PrintFieldAscendingEmployeesCount;
import Commands.PrintFieldDescendingType;
import Commands.RemoveById;
import Commands.RemoveLower;
import Commands.Save;
import Commands.Show;
import Commands.UpdateId;
import Interfaces.CommandInterface;

public class CommandCollection implements CommandInterface {

    Add add = new Add();
    Clear clear = new Clear();
    ExecuteScript executeScript = new ExecuteScript();
    Exit exit = new Exit();
    Head head = new Head();
    Help help = new Help();
    History history = new History();
    Info info = new Info();
    MaxByType maxByType = new MaxByType();
    PrintFieldAscendingEmployeesCount printFieldAscendingEmployeesCount = new PrintFieldAscendingEmployeesCount();
    PrintFieldDescendingType printFieldDescendingType = new PrintFieldDescendingType();
    RemoveById removeById = new RemoveById();
    RemoveLower removeLower = new RemoveLower();
    Save save = new Save();
    Show show = new Show();
    UpdateId updateId = new UpdateId();


    private Map<String, Object> commandCollection = new LinkedHashMap<String, Object>(){{
        put("add", add);
        put("clear", clear);
        put("executeScript", executeScript);
        put("exit", exit);
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
