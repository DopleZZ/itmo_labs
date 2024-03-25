import java.io.BufferedReader;
import java.io.InputStreamReader;

import Collections.OrgCollection;
import Commands.Invoker;
import fileworkspackage.ParseFromCSV;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OrgCollection orgCol = new OrgCollection();

        ParseFromCSV.parseFrom();

        while (true) {

            String input_line = reader.readLine();
            Invoker.invoke(input_line);
           
        }
    }
}
