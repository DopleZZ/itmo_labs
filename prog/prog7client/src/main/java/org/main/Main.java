package org.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.NetWorks.CommandSender;
import org.ScriptWorks.ExecuteScript;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        boolean ent = false;
        CommandSender sender = new CommandSender();

        String userLogin;
        String userPassword;
        try {
            while (!ent) {
                System.out.println("вы зарегестрирвоаны в системе? [Y/N]");
                String userEnt = reader.readLine();
                switch (userEnt.toLowerCase()) {

                    case "n", "no":
                        System.out.println("Придумайте логин");
                        userLogin = reader.readLine();
                        System.out.println("Придумайте пароль");
                        userPassword = reader.readLine();
                        sender.sendCommand("register " + userLogin + " " + userPassword);
                    case "y", "yes":
                        while (true) {
                            System.out.println("Введите логин");
                            userLogin = reader.readLine();
                            if (userLogin.isEmpty()) {
                                continue;
                            }
                            System.out.println("Введите пароль");
                            userPassword = reader.readLine();
                            if (userPassword.isEmpty()) {
                                continue;
                            }
                            sender.sendCommand("login " + userLogin + " " + userPassword);
                            if (sender.getForsout().split(" ")[1].equals("выполнен")) {
                                sender.setLogged(true);
                                sender.setId(Integer.parseInt(sender.getForsout().split(" ")[2]));
                                System.out.println("Добро Пожаловать");
                                ent = true;
                                break;
                            }
                            System.out.println("Неверный пароль");
                        }
                        break;

                    default:
                        continue;

                }
            }
        } catch (Exception e) {
            System.out.println("нет подключения");
        }

        try {
            while (true) {
                System.out.println("Введите команду");
                String com = reader.readLine();
                if (com.split(" ")[0].equals("execute")) {
                    ExecuteScript.executeScript(com.split(" ")[1], sender);
                } else {
                    sender.sendCommand(com);
                }

            }
        } catch (Exception e) {
            System.out.println("сервер не отвечает");
        }
    }
}