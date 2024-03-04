import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import Collections.CommandCollection;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandCollection col = new CommandCollection();


        
        while (true) {
            String command = reader.readLine();
            
                
            if (!(command.isEmpty())) {
                Method method = col.get(command).getClass().getMethod("execute");
                method.invoke(col.get(command));
            } else {
                System.out.println("Введите команду \n");
            }
            }
    }
}
