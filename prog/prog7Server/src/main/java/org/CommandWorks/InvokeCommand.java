package org.CommandWorks;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.CollectionWorks.CommandCollection;
import org.CollectionWorks.HistoryCollection;

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
    public static void invoke(String input_line) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        CommandCollection col = new CommandCollection();
                    if (!(input_line.isEmpty())) {
                        String arg;
                        input_line = input_line.trim();
                        input_line = input_line.replaceAll("[\\s+]{2,}", " ");
                        String command = input_line.split(" ")[0];
                    if (input_line.split(" ").length > 1) {arg = input_line.split(" ")[1];} else {arg = "";}
                        HistoryCollection.update(command);
                        Method method = col.get(command).getClass().getMethod("execute", String.class);
                        method.invoke(col.get(command),  arg);
                        
            }       else {
                        System.out.println("Введите команду");
            }
    }
}
