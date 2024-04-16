package ServerOperationsPackage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import Commands.Saver;
import OrgData.*;

public class RecieverModule {

    public static String responce;

    public static String commandResponce;
     
    
    
    public  void runSocket() throws IOException{

        ServerResponce responce = new ServerResponce();

        //serverSocket = new ServerSocket(1);

        while (true) {
            commandResponce = "";
            //serverSocket = new ServerSocket(1888);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(1889));
            SocketChannel server = serverSocketChannel.accept();
            serverSocketChannel.configureBlocking(false);

            //Socket server = serverSocket.accept();
            try (
                ObjectInputStream objectInputStream = new ObjectInputStream(server.socket().getInputStream());
                //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new DataOutputStream(server.socket().getOutputStream()));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.socket().getOutputStream());

            ){
                //Class<? extends ParentRequest> request = (Class) objectInputStream.readObject();
                RequestHandler.handle(objectInputStream.readObject());
                responce.setResponce(commandResponce);
                objectOutputStream.writeObject(responce);
                Saver.save();
                serverSocketChannel.close();
                objectOutputStream.flush();
            } catch (Exception e) {
               e.printStackTrace();
               System.out.println("govnou");
            }
        }
    }
}


//реализовать на стороне клиента сетевые каналы (по тз). Сделать абстракцию взаимодействия с пользователем. 
// убрать массив объектов, сделать отдельные классы для специфичных комманд.  