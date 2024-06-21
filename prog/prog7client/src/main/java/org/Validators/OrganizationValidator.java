package org.Validators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.EnumWorks.OrganizationType;



public class OrganizationValidator {

    public static boolean pointer = false;
    public static BufferedReader reader;


    public String getName() throws  IOException{



        System.out.println("Введите имя организации");

        if (!pointer){
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean isRunning = true;
        String ans = "";
        
        while (isRunning) {
            try {

                ans = reader.readLine();

                if (ans.isEmpty()) {
                    System.err.println("Имя организации не может быть пустым");
                } else {
                    isRunning = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return ans;
    }

    public String getCoordinates() throws IOException{
        System.out.println("Введите координаты");


        Boolean isRunning1 = true;
        boolean isRunning2 = true;
        String x;
        String cords = "";
        
        while (isRunning1) {
            try {
                
                System.out.println("Введите координату х (int) ");
                String ans = reader.readLine();
                
                if (ans.isEmpty()) {
                    System.out.println("Введите корректную координату");
                } else {
                    Integer.parseInt(ans);
                    x = ans;
                    while (isRunning2) {

                        System.out.println("Введите координату у (long)");
                        ans = reader.readLine();
                        Long.parseLong(ans);
                        if (ans.isEmpty()) {
                            System.out.println("Введите корректную координату");
                        } else {
                            cords = x+";"+ans;
                            isRunning1 = false;
                            isRunning2 = false;
                        }
                    }
                }  
            } catch (Exception e) {
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return cords;
    }


    public Double getAnnualTurnover() throws IOException{

        System.out.println("Введите годовой доход (double)");

        boolean isRunning = true;
        Double annualTurnover = 0.0;
        
        while (isRunning) {
            try {
                String ans = reader.readLine();
            if (Integer.parseInt(ans) > 0){
                annualTurnover = Double.parseDouble(ans);
                isRunning = false;
            } else {
                System.out.println("Введите корректный годовой доход");
            }
            } catch (Exception e) {
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return annualTurnover;
    }


    public String getFullName() throws IOException{

        System.out.println("Введите полное имя организации");

        boolean isRunning = true;
        String fullName = "";

        while (isRunning) {
            try {
                String ans = reader.readLine();
            if (ans.isEmpty()){
                System.out.println("Полное имя организации не может быть пустым");
            } else {
                fullName = ans;
                isRunning = false;
            }
            } catch (Exception e) {
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return fullName;
    }


    public Long getEmployeesCount() throws IOException{

        System.out.println("Введите число сотрудников");

        boolean isRunning = true;
        Long employeesCount = (long) 0;

        while (isRunning){
            try {
                String ans = reader.readLine();
            if (Integer.parseInt(ans) < 1){
                System.out.println("Введите корректное число сотрудников");
            } else {
                employeesCount = Long.parseLong(ans);
                isRunning = false;
            }
            } catch (Exception e) {
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return employeesCount;
    }


    public OrganizationType getType() throws IOException{

        System.out.println("выберете тип организации\n");

        String[] array = Arrays
        .toString(OrganizationType.values())
        .substring(1, Arrays.toString(OrganizationType.values()).length()-1).split(", ");
        for (int i = 0; i<=array.length-1; i++){System.out.println(array[i]);}
        boolean isRunning = true;
        OrganizationType type = OrganizationType.NONE;


        while (isRunning) {
            try {
                String ans = reader.readLine();
            if (Arrays.toString(OrganizationType.values())
                .substring(1, Arrays.toString(OrganizationType.values()).length()-1)
                .indexOf(ans)==-1){
                System.out.println("Введите корректный тип организации");
            } else {
                type = OrganizationType.valueOf(ans);
                isRunning = false;
            }
            } catch (Exception e) {
                System.out.println("не стоит пытаться поломать ввод");
            }
        }
        return type;
    }


    public String getAdress() throws IOException{

    System.out.println("Введите адрес организации");

    boolean isRunning = true;
    String officialAddress = "";

    while (isRunning) {
        try {
            String ans = reader.readLine();
        if (ans.isEmpty()) {
            System.out.println("Введите корректный адрес");
        } else {
            officialAddress  = ans;
            isRunning = false;
        }
        } catch (Exception e) {
            System.out.println("не стоит пытаться поломать ввод");
        }   
    }
    return officialAddress;
}   
}
