package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

import Collections.OrgCollection;
import Enums.OrganizationType;
import Interfaces.Executable;
import OrgData.Address;
import OrgData.Coordinates;
import OrgData.IdGenerator;
import OrgData.Organization;

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

    @Override
    public void execute(String arg) throws IOException{
        System.out.println("Создание новой организации");
        getName();
    }

    public void getName() throws  IOException{
        System.out.println("Введите имя организации");
        boolean isRunning = true;
        
        while (isRunning) {
            String ans = reader.readLine();

            if (ans.isEmpty()) {
                System.err.println("Имя организации не может быть пустым");
            } else {
                this.name = ans;
                isRunning = false;
                System.out.println();
                getCoordinates();
            }
        }
    }

    public void getCoordinates() throws IOException{
        System.out.println("Введите координаты");

        Boolean isRunning1 = true;
        boolean isRunning2 = true;
        int x;
        long y;

        while (isRunning1) {

            System.out.println("Введите координату х (int) ");
            String ans = reader.readLine();
            if (ans.isEmpty()) {
                System.out.println("Введите корректную координату");
            } else {
                x = Integer.parseInt(ans);
                
                while (isRunning2) {
                    System.out.println("Введите координату у (long)");
                    ans = reader.readLine();
                    if (ans.isEmpty()) {
                        System.out.println("Введите корректную координату");
                    } else {
                        this.x = x;
                        this.y = Long.parseLong(ans);
                        this.coordinates = new Coordinates(this.x, this.y);
                        isRunning1 = false;
                        isRunning2 = false;
                        getAnnualTurnover();
                    }
                }
            }  
        }
    }

    public void getAnnualTurnover() throws IOException{
        System.out.println("Введите годовой доход (double)");
        boolean isRunning = true;
        

        while (isRunning) {
            String ans = reader.readLine();
            if (Integer.parseInt(ans) > 0){
                this.annualTurnover = Double.parseDouble(ans);
                isRunning = false;
                getFullName();
            } else {
                System.out.println("Введите корректный годовой доход");
            }
        }
    }

    public void getFullName() throws IOException{
        System.out.println("Введите полное имя организации");
        boolean isRunning = true;

        while (isRunning) {
            String ans = reader.readLine();
            if (ans.isEmpty()){
                System.out.println("Полное имя организации не может быть пустым");
            } else {
                this.fullName = ans;
                isRunning = false;
                getEmployeesCount();
            }
        }
    }

    public void getEmployeesCount() throws IOException{
        System.out.println("Введите число сотрудников");
        boolean isRunning = true;

        while (isRunning){
            String ans = reader.readLine();
            if (Integer.parseInt(ans) < 1){
                System.out.println("Введите корректное число сотрудников");
            } else {
                this.employeesCount = Long.parseLong(ans);
                isRunning = false;
                getType();
            }
        }
    }

    public void getType() throws IOException{
        System.out.println("выберете тип организации\n");
        String[] array = Arrays
        .toString(OrganizationType.values())
        .substring(1, Arrays.toString(OrganizationType.values()).length()-1).split(", ");
        for (int i = 0; i<=array.length-1; i++){System.out.println(array[i]);}
        boolean isRunning = true;

        while (isRunning) {
            String ans = reader.readLine();
            if (Arrays.toString(OrganizationType.values())
                .substring(1, Arrays.toString(OrganizationType.values()).length()-1)
                .indexOf(ans)==-1){
                System.out.println("Введите корректный тип организации");
            } else {
                this.type = OrganizationType.valueOf(ans);
                isRunning = false;
                getAdress();
            }
        }
    }

 public void getAdress() throws IOException{
    System.out.println("Введите адрес организации");
    boolean isRunning = true;
    while (isRunning) {
        String ans = reader.readLine();
        if (ans.isEmpty()) {
            System.out.println("Введите корректный адрес");
        } else {
            this.officialAddress  = new Address(ans);
            isRunning = false;
            create();
        }
    }
}   

public void create(){

    Organization org = new Organization(gen.generateNew(), 
                                        this.name, 
                                        this.coordinates, 
                                        LocalDate.now(), 
                                        this.annualTurnover, 
                                        this.fullName, 
                                        this.employeesCount, 
                                        this.type, 
                                        this.officialAddress);
    OrgCollection.addObj(org);
    System.out.println();
    System.out.println("Добавление организации завершено");
    }   
}