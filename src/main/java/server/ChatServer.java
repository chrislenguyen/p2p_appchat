package server;

import utils.ClientInfo;
import utils.ClientInfoServer;

import java.beans.XMLDecoder;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChatServer {
    private ArrayList<ClientHandler> clientHandlerList = new ArrayList<>();
    private HashMap<String, ClientInfoServer> clientList = new HashMap<>();
    private int serverPort;
    private ServerSocket serverSocket;
    private int numThreads = 10;

    public ChatServer(int port) {
        this.serverPort     = port;
        this.serverSocket   = null;
    }

    public ChatServer(int port, int num) {
        this.serverPort     = port;
        this.serverSocket   = null;
        this.numThreads     = num;
    }

    public void initServer() throws IOException {
        File folder = new File("dtb");
        File[] listOfFiles = folder.listFiles();
        for (File file: listOfFiles) {
            FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis);
            ClientInfoServer tempClientInfo = (ClientInfoServer) decoder.readObject();
            ClientInfoServer temp = new ClientInfoServer(tempClientInfo.getClientName(), tempClientInfo.getClientPassword(), tempClientInfo.getClientStatus(), tempClientInfo.getFriendList());
            clientList.put(tempClientInfo.getClientName(), temp);
            decoder.close();
            fis.close();
        }
        ClientInfoServer temp = clientList.get("khoa");
        System.out.println(temp.getClientName());
        System.out.println(temp.getClientPassword());
        System.out.println(temp.getClientStatus());
        System.out.println(temp.getFriendList()
        );
    }

    public void markOnline(String username) {
        String status = "on";
        ClientInfoServer temp = new ClientInfoServer(username, clientList.get(username).getClientPassword(), status,
                clientList.get(username).getFriendList());
        clientList.replace(username, temp);
    }

    public boolean findriend(String username, int port) {
        return true;
    }

    public String checkLogout() {
        return "a";
    }

    public boolean checkPassword(String username, String password) {
        ClientInfoServer value = clientList.get(username);
        return password.equals(value.getClientPassword());
    }

    public String findUsername(String username) {
        ClientInfoServer value = clientList.get(username);
        if (value != null) return value.getClientName();
        return username;
    }

    public void start() throws IOException {
        System.out.println("[SERVER] Start server.");
        initServer();
        Executor executor = Executors.newFixedThreadPool(this.numThreads);
        try {
            serverSocket = new ServerSocket(this.serverPort);
            while (true) {
                Socket client = serverSocket.accept();
                executor.execute(new ClientHandler(this, client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}