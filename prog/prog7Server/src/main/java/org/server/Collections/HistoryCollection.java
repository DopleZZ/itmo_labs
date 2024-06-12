package org.server.Collections;

import java.util.ArrayDeque;
import java.util.Deque;


public class HistoryCollection {
    
    private static Deque<String> historyCollection = new ArrayDeque<>();

    
    /** 
     * добавить комманду в историю
     * @param com
     */
    public static void update(String com){
        historyCollection.addFirst(com);
        if (historyCollection.size()==7){
            historyCollection.pollLast();
        }
        
    }
    /**
     * получить историю комманд
     * @return Deque<String>
     */
    public static Deque<String> getCollection(){
        Deque<String> historyCollectioncopy = new ArrayDeque<>();
        historyCollectioncopy.addAll(historyCollection);
        return historyCollectioncopy;
    }
}