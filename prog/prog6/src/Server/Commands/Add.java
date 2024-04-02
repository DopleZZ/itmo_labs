package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import Collections.OrgCollection;
import Enums.OrganizationType;
import OrgData.Address;
import OrgData.Coordinates;
import OrgData.IdGenerator;
import OrgData.Organization;
import ServerOperationsPackage.RecieverModule;

public class Add {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null

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
    
    public void execute(Object[] args) throws IOException{

        this.name = (String) args[0];
        this.coordinates = new Coordinates(Integer.parseInt(((String) args[1]).split(";")[0]),  Long.parseLong(((String) args[1]).split(";")[1]));
        this.annualTurnover = Double.parseDouble((String) args[2].toString());
        this.fullName = ((String) args[3]);
        this.employeesCount = Long.parseLong((String) args[4].toString());
        this.type = OrganizationType.valueOf((String) args[5].toString());
        this.officialAddress = new Address((String) args[6]);
        
        create();
    }


public void create(){
    long id;
        if (customIdPresent){
            id = customId;
        } else {
            id = gen.generateNew();
        }

        Organization org = new Organization(id, 
                                            this.name, 
                                            this.coordinates, 
                                            LocalDate.now(), 
                                            this.annualTurnover, 
                                            this.fullName, 
                                            this.employeesCount, 
                                            this.type, 
                                            this.officialAddress);
        OrgCollection.addObj(org);
        RecieverModule.commandResponce="Добавление организации завершено";
}
    }