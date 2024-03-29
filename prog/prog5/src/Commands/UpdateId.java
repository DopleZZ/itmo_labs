package Commands;

import java.io.IOException;

import Interfaces.Executable;

public class UpdateId implements Executable {

    public static boolean fromFile = false;
    

    
    /** 
     * Обновляет значения выбранного по айди элемента
     * @param idToUpdateString
     * @throws IOException
     */
    @Override
    public void execute(String idToUpdateString) throws IOException{

        long idToUpdateLong = Long.parseLong(idToUpdateString);
        RemoveById remove = new RemoveById();
        Add add = new Add();

        if (fromFile) {
            Add.fromFile = true;
        }

        remove.execute(idToUpdateString);
        Add.customIdPresent = true;
        Add.customId = idToUpdateLong;

        add.execute("");

        System.out.println("объект коллекции обновлен");

    }
}