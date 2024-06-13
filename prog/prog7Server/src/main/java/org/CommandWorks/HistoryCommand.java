package org.CommandWorks;

import java.util.ArrayDeque;
import java.util.Deque;

import org.CollectionWorks.HistoryCollection;
import org.ServerOperationsWorks.RecieverModule;

public class HistoryCommand {

    private static Deque<String> historyCollectionCopy = new ArrayDeque<>();
    
    
    /** 
     * вывести историю комманд
     * @param arg
     */
    public void execute(String arg){
        
        RecieverModule.commandResponce = "";
        historyCollectionCopy = HistoryCollection.getCollection();

        System.out.println("история комманд:");
        while (!historyCollectionCopy.isEmpty()){
            RecieverModule.commandResponce += historyCollectionCopy.pollLast() + "\n";
        }   
        };
    }
