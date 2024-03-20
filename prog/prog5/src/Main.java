import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import Collections.CommandCollection;
import Collections.HistoryCollection;
import Collections.OrgCollection;
import fileworkspackage.ParseFromCSV;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OrgCollection orgCol = new OrgCollection();
        CommandCollection col = new CommandCollection();

        ParseFromCSV.parseFrom();

        while (true) {

            String input_line = reader.readLine();
           
            if (!(input_line.isEmpty())) {
                    String arg;
                    String command = input_line.split(" ")[0];
                    if (input_line.split(" ").length > 1) {arg = input_line.split(" ")[1];} else {arg = "";}
                    HistoryCollection.update(command);
                    Method method = col.get(command).getClass().getMethod("execute", String.class);
                    method.invoke(col.get(command),  arg);
            } else {
                System.out.println("Введите команду");
            }
        }

    }
}
