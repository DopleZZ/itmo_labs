package Commands;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Collections.CommandCollection;
import Collections.HistoryCollection;

public class Invoker {

    

    public static void invoke(String input_line) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        CommandCollection col = new CommandCollection();
                    if (!(input_line.isEmpty())) {
                        String arg;
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
