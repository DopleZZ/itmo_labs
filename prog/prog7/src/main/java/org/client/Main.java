import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import NetWorks.CommandSender;
import OrgData.AddRequest;
import OrgData.BaseRequest;
import OrgData.ClientResponce;
import OrgData.UpdateRequest;
import Validators.OrganizationValidator;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("вы зарегестрирвоаны в системе? [Y/N]");
        String userEnt = reader.readLine();
        CommandSender sender = new CommandSender();

        String userLogin;
        String userPassword;

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
                    if (sender.getForsout().split(" ")[0].equals("Вход выполнен")) {
                        sender.setLogged(true);
                        sender.setId(Integer.parseInt(sender.getForsout().split(",")[0]));
                        System.out.println("Добро Пожаловать");
                        break;
                    }
                    System.out.println("Неверный пароль");
                }
                break;

            default:
                break;
        }

        while (true) {
            System.out.println("Введите команду");
            String com = reader.readLine();
            sender.sendCommand(com);


        }
    }
}