package org.CommandWorks;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.CollectionWorks.CommandCollection;
import org.CollectionWorks.HistoryCollection;
import org.OrgDataWorks.ClientResponce;

public class InvokeCommand {

    

    
    /** 
     * Метод исполнитель комманд
     * @param input_line
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static ClientResponce invoke(String input_line) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        CommandCollection col = new CommandCollection();
        String ans = "";
                    if (!(input_line.isEmpty())) {
                        String arg;
                        input_line = input_line.trim();
                        input_line = input_line.replaceAll("[\\s+]{2,}", " ");
                        String command = input_line.split(" ")[0];
                    if (input_line.split(" ").length > 1) {arg = input_line.split(" ")[1];} else {arg = "";}
                        HistoryCollection.update(command);
                        Method method = col.get(command).getClass().getMethod("execute", String.class);
                        ans = method.invoke(col.get(command),  arg).toString();
            }       else {
                        System.out.println("Введите команду");
            }
        return new ClientResponce(ans);
    }
}
