package ServerOperationsPackage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import Commands.Saver;
import OrgData.*;
import OrgData.ParentRequest;

public class RecieverModule {

    public static String responce;

    public static String commandResponce;
     
    
    
    public  void runSocket() throws IOException{

        //serverSocket = new ServerSocket(1);

        while (true) {
            commandResponce = "";
            //serverSocket = new ServerSocket(1888);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(1888));
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
                Saver.save();
                ClientResponce resp = new ClientResponce();
                resp.setResp(commandResponce);
                clientResponce.writeObject(resp);
                clientResponce.flush();
                serverSocketChannel.close();
            } catch (Exception e) {
               e.printStackTrace();
               
            }
        }
    }
}


//реализовать на стороне клиента сетевые каналы (по тз). Сделать абстракцию взаимодействия с пользователем. 
// убрать массив объектов, сделать отдельные классы для специфичных комманд.  