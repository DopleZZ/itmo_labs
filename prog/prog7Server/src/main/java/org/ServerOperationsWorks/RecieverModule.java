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

public class RecieverModule implements Runnable {
    private final String host = "localhost"; // to config
    private final int port = 1488;           // to config
    

    private static ClientResponce responce; // public->private
    // private static String commandResponce; // never used

    private ParentRequest request;
    private ServerSocketChannel serv;
    private SocketChannel sock;

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public RecieverModule() throws IOException {

    }

    public void handle() {
        System.out.println("обработка");
        try (ObjectInputStream objectInput = new ObjectInputStream(sock.socket().getInputStream());
                ObjectOutputStream objectOutput = new ObjectOutputStream(sock.socket().getOutputStream())) {

            cachedThreadPool.submit(() -> {
                try {
                    readRequest(objectInput);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    System.out.println("что-то пошло не так при чтении запроса");
                }
            }).get();

            cachedThreadPool.submit(() -> {
                System.out.println("выполнение запроса");
                try {
                    commandExecute();
                } catch (Exception e) {
                    System.out.println("что-то пошло не так при выполнении запроса");
                }
            }).get();

            cachedThreadPool.submit(() -> {
                System.out.println("написание ответа");
                try {
                    writeResponse(objectOutput, responce);
                } catch (IOException e) {
                    System.out.println("что-то пошло не так при написании ответа");
                }
            }).get();

        } catch (Exception e) {
            System.out.println("что-то произошло с подключением");
        }
    }

    public synchronized void readRequest(ObjectInputStream objectInput) throws IOException, ClassNotFoundException {
        try {
            System.out.println("получение запроса");
            request = (ParentRequest) objectInput.readObject();
        } catch (Exception e) {
            System.out.println("возникла ошибка при получении запроса");
        }
    }

    public void start() throws IOException {
        try (ServerSocketChannel serv = ServerSocketChannel.open()) {
            serv.configureBlocking(false);
            serv.bind(new InetSocketAddress(host, port));
            run();
        }
       
    }

    public void commandExecute() {
        System.out.println("выполнение команды");
        responce = RequestHandler.execute(request);
    }

    public synchronized void writeResponse(ObjectOutputStream objectOutput, ClientResponce responce)
            throws IOException {
        try {
            System.out.println("отправка ответа");
            objectOutput.writeObject(responce);
            objectOutput.flush();
        } catch (Exception e) {
            System.out.println("что-то пошло не так при отправке ответа");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                sock = serv.accept();
                if (sock != null) {
                    handle();
                }
            }
        } catch (Exception e) {
            System.out.println("сокет заболел :P");
        }
    }
}