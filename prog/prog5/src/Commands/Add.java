package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import Collections.OrgCollection;
import Enums.OrganizationType;
import Interfaces.Executable;
import OrgData.Address;
import OrgData.Coordinates;
import OrgData.Organization;
import OrgData.IdGenerator;

public class Add implements Executable {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null

    private int x;
    private long y;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    IdGenerator gen = new IdGenerator();

    OrgCollection collection;

    public void execute(OrgCollection o) throws IOException{
        System.out.println("Создание новой организации \n");
        this.collection = o;
        getName();
    }

    public void getName() throws  IOException{
        System.out.println("Введите имя организации \n");
        boolean isRunning = true;
        
        while (isRunning) {
            String ans = reader.readLine();

            if (ans.isEmpty()) {
                System.err.println("Имя организации не может быть пустым\n");
            } else {
                this.name = ans;
                isRunning = false;
                System.out.println();
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
                        this.coordinates = new Coordinates(this.x, this.y);
                        isRunning1 = false;
                        isRunning2 = false;
                        System.out.println();
                        getAnnualTurnover();
                    }
                }
            }  
        }
    }

    public void getAnnualTurnover() throws IOException{
        System.out.println("Введите годовой доход (double)\n");
        boolean isRunning = true;
        

        while (isRunning) {
            String ans = reader.readLine();
            if (Integer.parseInt(ans) > 0){
                this.annualTurnover = Double.parseDouble(ans);
                isRunning = false;
                System.out.println();
                getFullName();

            } else {
                System.out.println();
                System.out.println("Введите корректный годовой доход\n");
            }
        }
    }

    public void getFullName() throws IOException{
        System.out.println("Введите полное имя организации\n");
        boolean isRunning = true;

        while (isRunning) {
            String ans = reader.readLine();
            if (ans.isEmpty()){
                System.out.println("Полное имя организации не может быть пустым\n");
            } else {
                this.fullName = ans;
                isRunning = false;
                System.out.println();
                getEmployeesCount();
            }
        }
    }

    public void getEmployeesCount() throws IOException{
        System.out.println("Введите число сотрудников\n");
        boolean isRunning = true;

        while (isRunning){
            String ans = reader.readLine();
            if (Integer.parseInt(ans) < 1){
                System.out.println();
                System.out.println("Введите корректное число сотрудников\n");
            } else {
                this.employeesCount = Long.parseLong(ans);
                isRunning = false;
                getType();
            }
        }
    }

    public void getType() throws IOException{
        System.out.println("выберете тип организации\n");
        String[] array = Arrays.toString(OrganizationType.values()).substring(1, Arrays.toString(OrganizationType.values()).length()-1).split(", ");
        for (int i = 0; i<=array.length-1; i++){System.out.println(array[i]);}
        System.out.println();
        boolean isRunning = true;

        while (isRunning) {
            String ans = reader.readLine();
            if (Arrays.toString(OrganizationType.values()).substring(1, Arrays.toString(OrganizationType.values()).length()-1).indexOf(ans)==-1){
                System.out.println("Введите корректный тип организации\n");
            } else {
                this.type = OrganizationType.valueOf(ans);
                isRunning = false;
                getAdress();
            }
        }
 }

 public void getAdress() throws IOException{
    System.out.println("Введите адрес организации\n");
    boolean isRunning = true;
    while (isRunning) {
        String ans = reader.readLine();
        if (ans.isEmpty()) {
            System.out.println("Введите корректный адрес\n");
        } else {
            this.officialAddress  = new Address(ans);
            isRunning = false;
            create();
        }
    }
}   

public void create(){

    Organization org = new Organization(gen.generateNew(), this.name, this.coordinates, this.annualTurnover, this.fullName, this.employeesCount, this.type, this.officialAddress);
    this.collection.addObj(org);
    System.out.println();
    System.out.println("Добавление организации завершено");

    
}
    



    
}
