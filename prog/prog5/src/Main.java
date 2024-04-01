import java.io.BufferedReader;
import java.io.InputStreamReader;

import Collections.OrgCollection;
import Commands.Invoker;
import fileworkspackage.ParseFromCSV;
import fileworkspackage.ParseToCSV;

public class Main {
    
    

    /** 
     * Основной класс, циклично принимает пользовательский ввод
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        
        OrgCollection col = new OrgCollection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ParseToCSV.path = "note.csv";
        ParseFromCSV.path = "note.csv";
        ParseFromCSV.parseFrom();

        while (true) {
            try{
            String input_line = reader.readLine();
            Invoker.invoke(input_line);
            } catch (Exception e){
                System.out.println("команда введена неправильно, или не существует");
            }
        }
    }
}