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

    private int x;
    private long y;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void execute() throws IOException{
        System.out.println("Создание новой организации \n");
        getName();
    }

    public void getName() throws  IOException{
        System.out.println("Введите имя организации \n");
        boolean isRunning = true;
        
        while (isRunning) {
            String ans = reader.readLine();

            if (ans.isEmpty()) {
                System.out.println("Имя организации не может быть пустым\n");
            } else {
                this.name = ans;
                isRunning = false;
                getCoordinates();
            }

        }

    }

    public void getCoordinates() throws IOException{
        System.out.println("Введите координаты\n");

        Boolean isRunning1 = true;
        boolean isRunning2 = true;
        int x;
        long y;

        while (isRunning1) {

            System.out.println("Введите координату х (int) \n");
            String ans = reader.readLine();
            if (ans.isEmpty()) {
                System.out.println("Введите корректную координату\n");
            } else {
                x = Integer.parseInt(ans);
                System.out.println();
                
                while (isRunning2) {
                    System.out.println("Введите координату у (long) \n");
                    ans = reader.readLine();
                    if (ans.isEmpty()) {
                        System.out.println("Введите корректную координату \n");
                    } else {
                        this.x = x;
                        this.y = Long.parseLong(ans);
                        isRunning1 = false;
                        isRunning2 = false;
                        System.out.println();
                    }
                }
            }
            
        }
    }


    
}
