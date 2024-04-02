import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import java.net.Socket;

import OrgData.ClientRequest;
import Validators.OrganizationValidator;

public class Main{
    

    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        int port = 1;
       
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
                    ObjectOutputStream outputStream= new ObjectOutputStream(new DataOutputStream(client.getOutputStream()));
                    DataInputStream inputStream = new DataInputStream(client.getInputStream());
                )
                {

                    if (com.equals("add")){
                        Object[] arguments = {
                            valid.getName(),
                            valid.getCoordinates(),
                            valid.getAnnualTurnover(),
                            valid.getFullName(),
                            valid.getEmployeesCount(),
                            valid.getType(),
                            valid.getAdress()};
                            ClientRequest ob = new ClientRequest(com, arguments);
                            outputStream.writeObject(ob);
                            outputStream.flush();
                    } else if (com.split(" ")[0].equals("updateById")) {
                        Object[] arguments = {
                            valid.getName(),
                            valid.getCoordinates(),
                            valid.getAnnualTurnover(),
                            valid.getFullName(),
                            valid.getEmployeesCount(),
                            valid.getType(),
                            valid.getAdress(),
                            com.split(" ")[1]};
                            ClientRequest ob = new ClientRequest(com, arguments);
                            outputStream.writeObject(ob);
                            outputStream.flush();
                    } else {

                    Object[] arguments = {};
                    ClientRequest ob = new ClientRequest(com, arguments);
                    outputStream.writeObject(ob);
                    }

                    System.out.println(inputStream.readUTF());

                } catch (Exception e) {
                   System.err.println("что-то пошло не так при обработке запроса");
                }
             }
        }
    }
