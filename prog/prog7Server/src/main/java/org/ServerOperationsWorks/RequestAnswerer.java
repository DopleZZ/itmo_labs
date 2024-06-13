package org.ServerOperationsWorks;

import org.OrgDataWorks.ClientResponce;

import java.nio.channels.SocketChannel;

public class RequestAnswerer implements Runnable{

    private final ClientResponce response;
    private final Server server;
    private final SocketChannel socketChannel;

    public RequestAnswerer(ClientResponce response, Server server, SocketChannel socketChannel) {
        this.response = response;
        this.server = server;
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try(socketChannel) {
            server.writeObject(socketChannel, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
