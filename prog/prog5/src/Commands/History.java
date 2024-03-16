package Commands;

import java.util.ArrayDeque;
import java.util.Deque;

import Collections.HistoryCollection;
import Interfaces.Executable;

public class History implements Executable{

    private static Deque<String> historyCollectionCopy = new ArrayDeque<>();
    
    @Override
    public void execute(String arg){
        
        historyCollectionCopy = HistoryCollection.getCollection();
        System.out.println("история комманд:");
        while (!historyCollectionCopy.isEmpty()){
            System.out.println(historyCollectionCopy.pollLast());
        }
            
        };
    }
