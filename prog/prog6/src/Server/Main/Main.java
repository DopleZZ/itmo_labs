package Main;
import ServerOperationsPackage.RecieverModule;
import fileworkspackage.ParseFromCSV;
import fileworkspackage.ParseToCSV;

public class Main {
    public static void main(String[] args) throws Exception {
        
        RecieverModule rm = new RecieverModule();
        ParseFromCSV.path = "note.csv";
        ParseToCSV.path = "note.csv";
        ParseFromCSV.parseFrom();
        rm.runSocket();

    }
}
