package Main;
import ServerOperationsPackage.RecieverModule;
import fileworkspackage.ParserFromCSV;
import fileworkspackage.ParserToCSV;

public class Main {
    public static void main(String[] args) throws Exception {
        
        RecieverModule rm = new RecieverModule();
        ParserFromCSV.path = "note.csv";
        ParserToCSV.path = "note.csv";
        ParserFromCSV.parseFrom();
        rm.runSocket();

    }
}
