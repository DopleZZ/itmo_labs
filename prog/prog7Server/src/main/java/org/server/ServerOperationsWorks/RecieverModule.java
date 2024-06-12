package org.server.ServerOperationsWorks;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import org.server.CommandWorks.SaveCommand;
import org.server.OrgDataWorks.*;


public class RecieverModule {

    public static String responce;

    public static String commandResponce;
     
    
    
    public  void runSocket() throws IOException{

        //serverSocket = new ServerSocket(1);

        while (true) {
            commandResponce = "";
            //serverSocket = new ServerSocket(1888);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(1488));
            SocketChannel server = serverSocketChannel.accept();
            serverSocketChannel.configureBlocking(false);

            //Socket server = serverSocket.accept();
            try (
                ObjectInputStream objectInputStream = new ObjectInputStream(server.socket().getInputStream());
                ObjectOutputStream clientResponce = new ObjectOutputStream(server.socket().getOutputStream());
            ){
                //Class<? extends ParentRequest> request = (Class) objectInputStream.readObject();
                RequestHandler.handle(objectInputStream.readObject());
                //clientResponce.writeUTF(commandResponce);
                //SaveCommand.save();
                ClientResponce resp = new ClientResponce();
                resp.setResp(commandResponce);
                clientResponce.writeObject(resp);
                clientResponce.flush();
                serverSocketChannel.close();
            } catch (Exception e) {
                System.out.println("ogo");
               e.printStackTrace();
               
            }
        }
    }
}


//реализовать на стороне клиента сетевые каналы (по тз). Сделать абстракцию взаимодействия с пользователем. 
// убрать массив объектов, сделать отдельные классы для специфичных комманд.  