package Commands;

import java.io.BufferedReader;
import java.io.FileReader;

import Interfaces.Executable;

public class ExecuteScript implements Executable{

    public static BufferedReader reader;

    @Override
    public void execute(String arg) throws Exception{
        reader = new BufferedReader(new FileReader(arg));
        //try {
            String line;

            line = reader.readLine();
            
            while (line != null) {
                if (line.equals("add")){
                    Add.fromFile = true;
                    Invoker.invoke(line);
                } else {
                Invoker.invoke(line);
                }
                line = reader.readLine();
            }
        //} catch (Exception e) {
            //System.out.println("Файл содержит ошибочную команду или рекурсию");
        //}

    }
    
}
