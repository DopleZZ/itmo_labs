package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        DataBaseManager.ConnectToDatabase();
        Connection connection = DataBaseManager.getConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntryManager manager = new EntryManager(connection);
        String userEnt;


        System.out.println("вы зарегестрирвоаны в системе? [Y/N]");
        userEnt = reader.readLine();

        switch (userEnt.toLowerCase()) {

            case "n",  "no":
                manager.register();

            case "y", "yes":
                while (true) {
                    System.out.println("Введите логин");
                    String userLogin = reader.readLine();
                    if (userLogin.isEmpty()) {
                        continue;
                    }
                    System.out.println("Введите пароль");
                    String userPassword = reader.readLine();
                    if (manager.validUser(userLogin, userPassword)){

                        System.out.println("ok");
                        break;
                    }
                    System.out.println("Неверный пароль");


                }
                break;

            default: break;
        }

        }
    }