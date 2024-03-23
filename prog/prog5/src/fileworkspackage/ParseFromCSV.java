package fileworkspackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import Collections.OrgCollection;
import Enums.OrganizationType;
import OrgData.Address;
import OrgData.Coordinates;
import OrgData.Organization;

public class ParseFromCSV {

    public static void parseFrom(){
        try {

            BufferedReader reader = new BufferedReader(new FileReader("note.csv"));
            String line = reader.readLine();

            while (line != null) {
                String[] splittedLine = line.split(";");
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
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
