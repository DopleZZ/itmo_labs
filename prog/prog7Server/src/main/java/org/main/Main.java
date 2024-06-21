package org.main;

import org.DataBaseWorks.DataBaseManager;
import org.DataBaseWorks.DataParser;
import org.ServerOperationsWorks.RecieverModule;


public class Main {


    public static void main(String[] args) throws Exception {
        //ataBaseManager.ConnectToDatabase();
        RecieverModule rm = new RecieverModule();
        DataParser.baseParse();
        System.out.println("Сервер запущен");
        rm.start();

    }
}
