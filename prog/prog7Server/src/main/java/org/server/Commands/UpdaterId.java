package org.server.Commands;

import java.io.IOException;
import org.server.ServerOperationsPackage.RecieverModule;
import org.server.Commands.RemoverById;
import org.server.Commands.Adder;


public class UpdaterId {

    public static boolean fromFile = false;
    

    
    /** 
     * Обновляет значения выбранного по айди элемента
     * @param idToUpdateString
     * @throws IOException
     */
    public void execute(Object[] args) throws IOException{

        String idToUpdateLong = args[7].toString();
        RemoverById remove = new RemoverById();
        Adder add = new Adder();



        remove.execute(idToUpdateLong);
        Adder.customIdPresent = true;
        Adder.customId = Long.parseLong(idToUpdateLong);

        add.execute(args);

        RecieverModule.commandResponce="объект коллекции обновлен";

    }
}