package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

import Commands.Adder;
import Commands.Clearer;
import Commands.ExecuteerScript;

import Commands.Header;
import Commands.Helper;
import Commands.Historyer;
import Commands.Infoer;
import Commands.MaxerByType;
import Commands.PrinterFieldAscendingEmployeesCount;
import Commands.PrinterFieldDescendingType;
import Commands.RemoverById;
import Commands.RemoverLower;
import Commands.Saver;
import Commands.Shower;
import Commands.UpdaterId;
import Interfaces.CommandInterface;

public class CommandCollection implements CommandInterface {

    Adder add = new Adder();
    Clearer clear = new Clearer();
    ExecuteerScript executeScript = new ExecuteerScript();
    Header head = new Header();
    Helper help = new Helper();
    Historyer history = new Historyer();
    Infoer info = new Infoer();
    MaxerByType maxByType = new MaxerByType();
    PrinterFieldAscendingEmployeesCount printFieldAscendingEmployeesCount = new PrinterFieldAscendingEmployeesCount();
    PrinterFieldDescendingType printFieldDescendingType = new PrinterFieldDescendingType();
    RemoverById removeById = new RemoverById();
    RemoverLower removeLower = new RemoverLower();
    Saver save = new Saver();
    Shower show = new Shower();
    UpdaterId updateId = new UpdaterId();


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
