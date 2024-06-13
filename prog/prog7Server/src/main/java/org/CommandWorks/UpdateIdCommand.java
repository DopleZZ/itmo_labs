package org.CommandWorks;

import java.io.IOException;
import org.ServerOperationsWorks.RecieverModule;


public class UpdateIdCommand {

    public static boolean fromFile = false;
    

    
    /** 
     * Обновляет значения выбранного по айди элемента
     * @param idToUpdateString
     * @throws IOException
     */
    public void execute(Object[] args) throws IOException{

        String idToUpdateLong = args[7].toString();
        RemoveByIdCommand remove = new RemoveByIdCommand();
        AddCommand add = new AddCommand();



        remove.execute(idToUpdateLong);
        AddCommand.customIdPresent = true;
        AddCommand.customId = Long.parseLong(idToUpdateLong);

        add.execute(args);

        RecieverModule.commandResponce="объект коллекции обновлен";

    }
}