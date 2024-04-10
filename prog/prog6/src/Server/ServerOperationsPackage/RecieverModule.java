package ServerOperationsPackage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Commands.Saver;
import OrgData.ClientRequest;

public class RecieverModule {

    public static String responce;
    private ServerSocket serverSocket;
    public static String commandResponce;
     
    
    
    public  void runSocket() throws IOException{

        //serverSocket = new ServerSocket(1);

        while (true) {
            commandResponce = "";
            serverSocket = new ServerSocket(1888);
            Socket server = serverSocket.accept();
            try (
                ObjectInputStream objectInputStream = new ObjectInputStream(server.getInputStream());
                DataOutputStream clientResponce = new DataOutputStream(server.getOutputStream());
            ){
                ClientRequest request = (ClientRequest) objectInputStream.readObject();
                RequestHandler.handle(request);
                clientResponce.writeUTF(commandResponce);
                Saver.save();
                serverSocket.close();
            } catch (Exception e) {
               
            }
        }
    }
}


//реализовать на стороне клиента сетевые каналы (по тз). Сделать абстракцию взаимодействия с пользователем. 
// убрать массив объектов, сделать отдельные классы для специфичных комманд.  