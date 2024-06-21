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
import org.OrgDataWorks.ParentRequest;


public class RecieverModule {

    public static ClientResponce responce;
    public static String commandResponce;
    private ParentRequest request;
    private final String host = "localhost";
    private final int port = 1488;
    private ServerSocketChannel serv;
    private SocketChannel sock;
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();



    public RecieverModule() throws IOException {

    }

    public void handle() {
        System.out.println("обработка");
        try (ObjectInputStream objectInput = new ObjectInputStream(sock.socket().getInputStream());
             ObjectOutputStream objectOutput = new ObjectOutputStream(sock.socket().getOutputStream()) ) {

            cachedThreadPool.submit(() -> {
                try {
                    readRequest(objectInput);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }).get();

            cachedThreadPool.submit(() -> {
                try {
                    commandExecute();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).get();

            cachedThreadPool.submit(() -> {
                try {
                    writeResponse(objectOutput, responce);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).get();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void readRequest(ObjectInputStream objectInput) throws IOException, ClassNotFoundException {
        try {
            System.out.println("получение запроса");
            request  = (ParentRequest) objectInput.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void start() throws IOException {
        serv = ServerSocketChannel.open();
        serv.configureBlocking(false);
        serv.bind(new InetSocketAddress(host, port));
        run();
    }

    public void commandExecute() {
        System.out.println("выполнение команды");
        RequestHandler handler = new RequestHandler();
        responce = handler.execute(request);

    }

    public synchronized void writeResponse(ObjectOutputStream objectOutput, ClientResponce responce) throws IOException {
        try {
            System.out.println("отправка ответа");
            objectOutput.writeObject(responce);
            objectOutput.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void run() throws IOException {
        try {
            while (true) {
                sock = serv.accept();
                if (sock != null) {
                    handle();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}