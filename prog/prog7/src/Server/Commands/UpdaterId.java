package Commands;

import java.io.IOException;
import ServerOperationsPackage.RecieverModule;

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