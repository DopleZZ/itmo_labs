package org.FileWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;


import org.CollectionWorks.OrgCollection;
import org.OrgDataWorks.Organization;

public class ParserToCSV {

    public static String path;
    
    private static PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();
    
    /**
     *  Метод для сохранения текущей коллекции в файл
     */
    public static void parseTo() throws FileNotFoundException{
        collectionCopy = OrgCollection.getCollection();
        File file = new File(path);
        new PrintWriter(path).close();

        if (collectionCopy.isEmpty()) {
            new PrintWriter(file).close();
        } else {

        try {
            PrintWriter pw = new PrintWriter(path);

            
            Organization org;
    
            while (!collectionCopy.isEmpty()){
                org = collectionCopy.poll();
                pw.println(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s", 
                                                                            org.getId(),
                                                                            org.getName(),
                                                                            org.getCoordinates(),
                                                                            org.getCreationDate(),
                                                                            org.getAnnualTurnover(),
                                                                            org.getFullName(),
                                                                            org.getEmployeesCount(),
                                                                            org.getOrganizationType(),
                                                                            org.getAddress()));
            } 
            pw.close();
            System.out.println("Коллекция сохранена");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }

    }
    }
}
