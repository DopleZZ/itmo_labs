package Commands;

import java.io.BufferedReader;
import java.io.FileReader;

import Interfaces.Executable;

public class ExecuteScript implements Executable{

    @Override
    public void execute(String arg) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(arg));
        try {
            String line;

            line = reader.readLine();
            
            while (line != null) {
                Invoker.invoke(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Файл содержит ошибочную команду или рекурсию");
        }

    }
    
}
