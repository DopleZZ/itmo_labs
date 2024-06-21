package org.NetWorks;

import java.io.*;
import java.net.Socket;
import org.OrgDataWorks.*;
import org.Validators.OrganizationValidator;

public class CommandSender {

    private boolean isLogged = false;
    public String forsout;
    public Integer id;

    public void setLogged(boolean isLogged){
        this.isLogged = isLogged;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getForsout(){
        return this.forsout;
    }



    public void sendCommand(String com) throws IOException {

        String serverName = "localhost";
        int port = 1488;


        OrganizationValidator valid = new OrganizationValidator();



        com = com.trim();
        com = com.replaceAll("[\\s+]{2,}", " ");

        if (com.equals("exit")){
            System.exit(0);
        }


        try (
                Socket client = new Socket(serverName, port);
                ObjectOutputStream outputStream= new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());

        )
        {

            if (com.equals("add") & isLogged){

                AddRequest ob = new AddRequest(
                        valid.getName(),
                        valid.getCoordinates(),
                        valid.getAnnualTurnover(),
                        valid.getFullName(),
                        valid.getEmployeesCount(),
                        valid.getType(),
                        valid.getAdress(),
                        id.toString());
                outputStream.writeObject(ob);
                outputStream.flush();
                ClientResponce response = (ClientResponce) inputStream.readObject();
                forsout = response.getResp();
                System.out.println(forsout);
            } else if (com.split(" ")[0].equals("updateById") & isLogged) {

                UpdateRequest ob = new UpdateRequest(
                        valid.getName(),
                        valid.getCoordinates(),
                        valid.getAnnualTurnover(),
                        valid.getFullName(),
                        valid.getEmployeesCount(),
                        valid.getType(),
                        valid.getAdress(),
                        com.split(" ")[1],
                        id.toString());
                outputStream.writeObject(ob);
                outputStream.flush();
                ClientResponce response = (ClientResponce) inputStream.readObject();
                forsout = response.getResp();
                System.out.println(forsout);

            } else if (com.split(" ")[0].equals("login")){
                EntryRequest ob = new EntryRequest(com.split(" ")[1], com.split(" ")[2]);

                outputStream.writeObject(ob);
                outputStream.flush();
                ClientResponce response = (ClientResponce) inputStream.readObject();
                forsout = response.getResp();
                System.out.println(forsout);

            } else if (com.split(" ")[0].equals("register")){
                RegisterRequest ob = new RegisterRequest(com.split(" ")[1], com.split(" ")[2]);

                outputStream.writeObject(ob);
                outputStream.flush();
                ClientResponce response = (ClientResponce) inputStream.readObject();
                forsout = response.getResp();
                System.out.println(forsout);

            } else if (isLogged){

                BaseRequest ob = new BaseRequest(com, id.toString());
                outputStream.writeObject(ob);
                outputStream.flush();
                ClientResponce response = (ClientResponce) inputStream.readObject();
                forsout = response.getResp();
                System.out.println(forsout);

            } else {
                System.out.println("вы не авторизованы");
            }




        } catch (Exception e) {
            System.err.println("что-то пошло не так при обработке запроса");

        }

    }
}
