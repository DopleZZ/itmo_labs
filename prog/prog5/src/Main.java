import java.io.BufferedReader;
import java.io.InputStreamReader;

import Commands.Invoker;
import fileworkspackage.ParseFromCSV;

public class Main {
    
    /** 
     * Основной класс, циклично принимает пользовательский ввод
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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