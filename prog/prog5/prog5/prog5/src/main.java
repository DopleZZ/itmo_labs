import java.io.BufferedReader;
import java.io.InputStreamReader;

import Exceptions.WrongArgumentException;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Commander Commander = new Commander();

        String ask = reader.readLine();

        switch (ask) {
            case "help":
            try {
                Commander.help(ask);
            } catch (WrongArgumentException e) {
                System.out.println(e.getMessage());
            }
                
            break;

            case "info":

            break;

            case"show":
            break;

            case"add":
            break;

            case"updateId":
            break;
        
            default:
                System.out.println("Команда введена неверно или не существует!");
                break;
        }
    }
}