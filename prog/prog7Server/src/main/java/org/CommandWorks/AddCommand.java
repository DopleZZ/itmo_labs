package org.CommandWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

import org.CollectionWorks.OrgCollection;
import org.DataBaseWorks.DataBaseManager;
import org.OrgDataWorks.Address;
import org.OrgDataWorks.Coordinates;
import org.OrgDataWorks.IdGenerator;
import org.OrgDataWorks.Organization;
import org.EnumWorks.OrganizationType;
import org.ServerOperationsWorks.RecieverModule;

public class  AddCommand {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null
    private int UserId;

    public static boolean customIdPresent = false;
    public static long customId;

    //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    IdGenerator gen = new IdGenerator();
    BufferedReader reader;

    OrgCollection collection;

    
    /** 
     * добавить новый элемент в коллекцию
     * @param args
     * @throws IOException
     */
    
    public String execute(Object[] args) throws IOException {

        this.name = (String) args[0];
        this.coordinates = new Coordinates(Integer.parseInt(((String) args[1]).split(";")[0]), Long.parseLong(((String) args[1]).split(";")[1]));
        this.annualTurnover = Double.parseDouble(args[2].toString());
        this.fullName = ((String) args[3]);
        this.employeesCount = Long.parseLong(args[4].toString());
        this.type = OrganizationType.valueOf(args[5].toString());
        this.officialAddress = new Address((String) args[6]);
        this.UserId = Integer.parseInt(args[7].toString());

        try {
            DataBaseManager.add(args);
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка при добавлении объекта в базу данных";
        } finally {
            create();
            return "успешно добавлено";
        }
    }


public void create(){
    long id;
        if (customIdPresent){
            id = customId;
        } else {
            id = gen.generateNew();
        }

        Organization org = new Organization(
                                            id,
                                            this.name, 
                                            this.coordinates, 
                                            LocalDate.now(), 
                                            this.annualTurnover, 
                                            this.fullName, 
                                            this.employeesCount, 
                                            this.type, 
                                            this.officialAddress,
                                            this.UserId
                );
        OrgCollection.addObj(org);

}
    }