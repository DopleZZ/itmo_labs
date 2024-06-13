package org.main;

import org.DataBaseWorks.DataBaseManager;
import org.ServerOperationsWorks.RecieverModule;


public class Main {


    public static void main(String[] args) throws Exception {
        DataBaseManager.ConnectToDatabase();
        RecieverModule rm = new RecieverModule();
        System.out.println("Татьяне Тимофеевне пизда");
        rm.runSocket();

    }
}
