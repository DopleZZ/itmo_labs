import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.server.ServerRef;

import OrgData.AddRequest;
import OrgData.BaseRequest;
import OrgData.ServerResponce;
import OrgData.UpdateRequest;
import Validators.OrganizationValidator;

public class Main{
    

    public static void main(String[] args) throws IOException {
        String serverName = "jupiterium.ru";
        int port = 1889;
       
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            OrganizationValidator valid = new OrganizationValidator();

             while (true) {
                String com = reader.readLine();
                com = com.trim();
                com = com.replaceAll("[\\s+]{2,}", " ");

                if (com.equals("exit")){
                    System.exit(0);
                }

                
                try (
                    Socket client = new Socket(serverName, port);
                    ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                    ObjectOutputStream outputStream= new ObjectOutputStream(new DataOutputStream(client.getOutputStream()));
                    //DataInputStream inputStream = new DataInputStream(client.getInputStream());
                )
                {

                    if (com.equals("add")){
                        AddRequest ob = new AddRequest(
                            valid.getName(),
                            valid.getCoordinates(),
                            valid.getAnnualTurnover(),
                            valid.getFullName(),
                            valid.getEmployeesCount(),
                            valid.getType(),
                            valid.getAdress());
                            
                            outputStream.writeObject(ob);
                            outputStream.flush();
                    } else if (com.split(" ")[0].equals("updateById")) {
                        UpdateRequest ob = new UpdateRequest(
                            valid.getName(),
                            valid.getCoordinates(),
                            valid.getAnnualTurnover(),
                            valid.getFullName(),
                            valid.getEmployeesCount(),
                            valid.getType(),
                            valid.getAdress(),
                            com.split(" ")[1]);
                            outputStream.writeObject(ob);
                            outputStream.flush();
                    } else {
                    BaseRequest ob = new BaseRequest(com);
                    outputStream.writeObject(ob);
                    }

                    ServerResponce resp = (ServerResponce) objectInputStream.readObject();
                    //System.out.println(inputStream.readUTF());
                    System.out.println(resp.getResponce());

                } catch (Exception e) {
                   System.err.println("что-то пошло не так при обработке запроса");
                   e.printStackTrace();
                }
             }
        }
    }
