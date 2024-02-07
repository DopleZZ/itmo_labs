import java.io.BufferedReader;
import java.io.InputStreamReader;

import Exceptions.WrongArgumentException;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Commander Commander = new Commander();

        
        while (true) {

            String ask = reader.readLine();


            switch (ask) {
                case "help":
                
                Commander.help();
                    
                break;
    
                case "info":
                Commander.info();
    
                break;
    
                case"show":
                break;
    
                case"add":
                break;
    
                case"updateId":
                break;
    
                case"removeById":
                break;
    
                case"clear":
                break;
    
                case"save":
                break;
    
                case"executeScript":
                break;
    
                case"exit":
                break;
    
                case"head":
                break;
    
                case"removeLower":
                break;
    
                case"history":
                break;
    
                case"maxByType":
                break;
    
                case"printFieldAscendingEmployeesCount":
                break;
    
                case"printFieldDescendingType":
                break;
            
                default:
                    System.out.println("Команда введена неверно или не существует!");
                    break;
            }
        }
        
    }
}