package org.CommandWorks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.CollectionWorks.CommandCollection;
import org.CollectionWorks.HistoryCollection;

public class InvokeCommand {

    /**
     * Метод исполнитель комманд
     * 
     * @param input_line
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static String invoke(String input_line, String uid) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        String ans = "";
        try {
            if (!(input_line.isEmpty())) {
                String arg;
                input_line = input_line.trim();
                input_line = input_line.replaceAll("[\\s+]{2,}", " ");
                String command = input_line.split(" ")[0];
                if (input_line.split(" ").length > 1) {
                    arg = input_line.split(" ")[1] + " " + uid;
                } else {
                    arg = "";
                }
                HistoryCollection.update(command);

                // TODO вот у тебя эта мозгоебка потому что нет абстрактного класса/интерфейса
                Method method = CommandCollection.get(command).getClass().getMethod("execute", String.class);
                ans = method.invoke(CommandCollection.get(command), arg).toString();
            }
        } catch (Exception e) {
            System.out.println("получена ложная команда");
        }
        return ans;
    }
}
