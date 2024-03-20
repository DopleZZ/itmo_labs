package fileworkspackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;

import Collections.OrgCollection;
import OrgData.Organization;

public class ParseToCSV {

    private static PriorityQueue<Organization> collectionCopy = new PriorityQueue<>();
    
    public static void parseTo() throws FileNotFoundException{

        try {
            PrintWriter pw = new PrintWriter("note.csv");

            collectionCopy = OrgCollection.getCollection();
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
