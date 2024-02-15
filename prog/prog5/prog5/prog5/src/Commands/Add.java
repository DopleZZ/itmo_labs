package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Enums.OrganizationType;
import Exceptions.EmptyOrganizationNameException;
import Interfaces.Executable;
import OrgData.Address;
import OrgData.Coordinates;
import Exceptions.EmptyOrganizationNameException;

public class Add implements Executable {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void execute() throws IOException{
        getName();
    }

    public void getName() throws  IOException{
        String ans = reader.readLine();
        if (ans == null){
            System.out.println("Имя организвации не может быть null");
            getName();
        } else if (ans.isEmpty()) {
            System.out.println("Имя организации не может быть пустым");
            getName();
        } else {
            this.name = ans;
            getCoordinates();
        }
    }

    public void getCoordinates(){

    }


    
}
