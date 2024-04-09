package fileworkspackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import Collections.OrgCollection;
import Enums.OrganizationType;
import OrgData.Address;
import OrgData.Coordinates;
import OrgData.IdGenerator;
import OrgData.Organization;

public class ParserFromCSV {

    public static String path;
    /**
     * Метод выгрузки организаций из файла в коллекцию
     */
    public static void parseFrom(){


        try {
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            ArrayList<String> fileId = new ArrayList<String>();





            while (line != null) {
                String[] splittedLine = line.split(";");
                if (!fileId.contains(splittedLine[0])){
                OrgCollection.addObj(
                                    new Organization(
                                        Long.parseLong(splittedLine[0]), 
                                    splittedLine[1], 
                                    new Coordinates(
                                        Integer.parseInt(splittedLine[2].split(",")[0]),
                                        Long.parseLong(splittedLine[2].split(",")[1])), 
                                    LocalDate.of(
                                        Integer.parseInt(splittedLine[3].split("-")[0]),
                                        Integer.parseInt(splittedLine[3].split("-")[1]),
                                        Integer.parseInt(splittedLine[3].split("-")[2])), 
                                    Double.parseDouble(splittedLine[4]),
                                    splittedLine[5],
                                    Long.parseLong(
                                        splittedLine[6]),
                                    OrganizationType.valueOf(
                                        splittedLine[7]),
                                    new Address(
                                        splittedLine[8])));
                fileId.add(splittedLine[0]);
                line = reader.readLine();}
                else {
                    throw new Exception();
                }
            }
            reader.close();

            Long maxId = (long) -1;

            for (String i : fileId){
                maxId = Long.max(Long.parseLong(i), maxId);
            }
            IdGenerator.id = maxId;

        } catch (Exception e) {
            System.err.println("Возникли проблемы с файлом");
            System.exit(0);
        }
    }
}
