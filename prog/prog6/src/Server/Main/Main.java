package Main;
import ServerOperationsPackage.RecieverModule;
import fileworkspackage.ParserFromCSV;
import fileworkspackage.ParserToCSV;

public class Main {
    public static void main(String[] args) throws Exception {
        
        RecieverModule rm = new RecieverModule();
        ParserFromCSV.path = "/home/cyberway/remoteWorks/itmo_labs/prog/prog6/src/Server/note.csv";
        ParserToCSV.path = "/home/cyberway/remoteWorks/itmo_labs/prog/prog6/src/Server/note.csv";
        ParserFromCSV.parseFrom();
        rm.runSocket();
    }
}
