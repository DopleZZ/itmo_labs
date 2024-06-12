package org.server;

import org.server.DataBaseWorks.DataBaseManager;
import org.server.ServerOperationsPackage.RecieverModule;
import org.server.fileworkspackage.ParserFromCSV;


public class Main {


    public static void main(String[] args) throws Exception {
        DataBaseManager.ConnectToDatabase();
        RecieverModule rm = new RecieverModule();
        //ParserFromCSV.path = "note.csv";
        //ParserToCSV.path = "note.csv";
        //ParserFromCSV.parseFrom();
        rm.runSocket();
    }
}
