package org.main;

import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;
import org.ServerOperationsWorks.RecieverModule;


public class Main {


    public static void main(String[] args) throws Exception {
        DataBaseManager.ConnectToDatabase();
        RecieverModule rm = new RecieverModule();
        DataParser.baseParse();
        System.out.println("Татьяне Тимофеевне пизда");
        rm.start();

    }
}
