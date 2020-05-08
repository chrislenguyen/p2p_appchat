package example;

import server.ChatServer;

import java.io.IOException;

public class TestServer {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(11200, 30);
        chatServer.start();
    }
}
