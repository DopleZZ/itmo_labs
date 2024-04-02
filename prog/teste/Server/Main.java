import java.net.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Main  {
   private ServerSocket serverSocket;
   
   

   public static void main(String[] args) throws IOException, ClassNotFoundException {
     ServerSocket serverSocket = new ServerSocket(4444);
      while(true) {

         try {
            Socket server = serverSocket.accept();
            
            
            //DataInputStream in = new DataInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(server.getInputStream());

            
            //System.out.println(in.readUTF());

            //DataOutputStream out = new DataOutputStream(server.getOutputStream());
            //out.writeUTF("сам говноу");
            Serka ser = (Serka) objectInputStream.readObject();

            System.out.println(ser.getCom());

            server.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Время сокета истекло!");
            break;
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
}