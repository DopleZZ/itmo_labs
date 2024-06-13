package org.ServerOperationsWorks;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestReader extends Thread{

    private final Server server;
    private final SocketChannel socketChannel;

    public RequestReader(Server server, SocketChannel socketChannel) {
        this.server = server;
        this.socketChannel = socketChannel;
    }

    public void run() {
        try {
            System.out.println("RequestReader");
            RequestHandler handler = new RequestHandler(server.getObject(socketChannel), server, socketChannel);
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.submit(handler);
            //handler.start();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
