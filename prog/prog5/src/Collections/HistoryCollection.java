package Collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class HistoryCollection {
    
    private static Deque<String> historyCollection = new ArrayDeque<>();

    public static void update(String com){
        historyCollection.addFirst(com);
        if (historyCollection.size()==7){
            historyCollection.pollLast();
        }
        
    }

    public static Deque getCollection(){
        return historyCollection;
    }
}