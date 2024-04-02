package Commands;

import java.io.IOException;
import ServerOperationsPackage.RecieverModule;

public class UpdateId {

    public static boolean fromFile = false;
    

    
    /** 
     * Обновляет значения выбранного по айди элемента
     * @param idToUpdateString
     * @throws IOException
     */
    public void execute(Object[] args) throws IOException{

        String idToUpdateLong = args[7].toString();
        RemoveById remove = new RemoveById();
        Add add = new Add();



        remove.execute(idToUpdateLong);
        Add.customIdPresent = true;
        Add.customId = Long.parseLong(idToUpdateLong);

        add.execute(args);

        RecieverModule.commandResponce="объект коллекции обновлен";

    }
}