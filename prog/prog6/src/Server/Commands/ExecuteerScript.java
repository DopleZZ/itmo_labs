package Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class ExecuteerScript{

    public static BufferedReader reader;

    
    /** 
     * Выполнить скрипт
     * @param arg
     * @throws Exception
     */
    public void execute(String arg) throws Exception{
        File file = new File(arg);
        reader = new BufferedReader(new FileReader(file));
        Adder add = new Adder();
        UpdaterId up = new UpdaterId();
        try {
            String line;

            line = reader.readLine();
            
            while (line != null) {
                if (line.equals("add")){
                    Object[] addArg={
                        reader.readLine(),
                        reader.readLine()+";"+reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        

                    };
                    add.execute(addArg);
                } else if (line.contains("updateById")){
                    Object[] updateArg={
                        reader.readLine(),
                        reader.readLine()+";"+reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        line.split(" ")[1]
                    };
                    up.execute(updateArg);
                } else {
                Invoker.invoke(line);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Файл содержит ошибочную команду или рекурсию");
        }
    }
}
