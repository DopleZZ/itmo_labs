package org.ServerOperationsWorks;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.OrgDataWorks.ClientResponce;



public class RecieverModule {

    public static String responce;
    public static String commandResponce;
    private final Server mainServer;

    public RecieverModule() {
        mainServer = new Server();
    }

    public void handle(SocketChannel sock) {
        System.out.println("Получено соединение");
        RequestReader reader = new RequestReader(mainServer, sock);
        //reader.start();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(reader);
    }

    public void start() throws IOException {
        mainServer.start();
        run();
    }


    public void run() {
        SocketChannel socketchannel;
        while (true){
            try {
                socketchannel = mainServer.getSC();
                if (socketchannel == null) {
                    continue;
                }
                handle(socketchannel);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
        //serverSocket = new ServerSocket(1);

//        while (true) {
//            commandResponce = "";
//            //serverSocket = new ServerSocket(1888);
//            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//            serverSocketChannel.bind(new InetSocketAddress(1488));
//            SocketChannel server = serverSocketChannel.accept();
//            serverSocketChannel.configureBlocking(false);
//
//            //Socket server = serverSocket.accept();
//            try (
//                ObjectInputStream objectInputStream = new ObjectInputStream(server.socket().getInputStream());
//                ObjectOutputStream clientResponce = new ObjectOutputStream(server.socket().getOutputStream());
//            ){
//                System.out.println("получено");
//                RequestHandler.handle(objectInputStream.readObject());
//                ClientResponce resp = new ClientResponce();
//                resp.setResp(commandResponce);
//                clientResponce.writeObject(resp);
//                clientResponce.flush();
//                serverSocketChannel.close();
//            } catch (Exception e) {
//                System.out.println("ogo");
//               e.printStackTrace();
//
//            }
//        }
//    }



//реализовать на стороне клиента сетевые каналы (по тз). Сделать абстракцию взаимодействия с пользователем. 
// убрать массив объектов, сделать отдельные классы для специфичных комманд.  