package org.ServerOperationsWorks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

    private final String host;
    private final int port;
    private ServerSocketChannel serv;

    public Server(){
        this.host = "localhost";
        this.port = 1488;
    }

    public void start() throws IOException {
        serv = ServerSocketChannel.open();
        serv.configureBlocking(false);
        serv.bind(new InetSocketAddress(host, port));
    }

    public SocketChannel getSC() throws IOException {
        return serv.accept();
    }

    public Object getObject(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInput = new ObjectInputStream(socketChannel.socket().getInputStream());
        return objectInput.readObject();
    }

    public void writeObject(SocketChannel socketChannel, Object obj) throws IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(socketChannel.socket().getOutputStream());
        objectOutput.writeObject(obj);
    }
}
