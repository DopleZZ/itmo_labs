import java.net.Socket;
import java.nio.Buffer;
import java.net.*;
import java.io.*;

public class Main{




   public static void main(String [] args) {
      String serverName = "localhost";
      int port = 4444;

      String[] go = {"1", "2"};
        Serka ob = new Serka("ahah", go);

        String a;
        a = "a";
        a = a +1;
        System.out.println(a);
/* 
      try {
         Socket client = new Socket(serverName, port);
         
         OutputStream outToServer = client.getOutputStream();
         
         DataOutputStream out = new DataOutputStream(outToServer);
         ObjectOutputStream outputS = new ObjectOutputStream(out);
         
         //out.writeUTF("говноу ");
         outputS.writeObject(ob);

         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         //System.out.println("Сервер ответил " + in.readUTF());
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
*/
   }}