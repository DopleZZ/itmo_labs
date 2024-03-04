package Collections;

import java.util.LinkedHashMap;
import java.util.Map;
import Commands.*;
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

    private Map<String, Object> commandCollection = new LinkedHashMap<String, Object>(){{
        put("add", add);
        put("clear", clear);
        put("execute Script", executeScript);
        put("exit", exit);
        put("head", head);
        put("help", help);
        put("history", history);
        put("info", info);
    }};

    
    @Override
    public Object get(String command){
        return commandCollection.get(command);
    }



    

}
