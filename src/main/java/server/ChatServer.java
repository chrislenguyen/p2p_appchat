package server;

import utils.ClientInfo;
import utils.ClientInfoServer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
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
        for (File file : listOfFiles) {
            FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis);
            ClientInfoServer tempClientInfo = (ClientInfoServer) decoder.readObject();
            ClientInfoServer temp = new ClientInfoServer(tempClientInfo.getClientName(),
                    tempClientInfo.getClientPassword(), tempClientInfo.getClientStatus(), tempClientInfo.getFriendList());
            clientList.put(tempClientInfo.getClientName(), temp);
            decoder.close();
            fis.close();
        }
        //---------------TEST ZONE---------------------//
        ClientInfoServer temp = clientList.get("khoa");
        System.out.println(temp.getClientName());
        System.out.println(temp.getClientPassword());
        System.out.println(temp.getClientStatus());
        System.out.println(temp.getFriendList());
        String user = "tom";
        String password = "321";
        createAccount(user, password);
        markOnline("khoa");
        System.out.println(temp.getClientStatus());
    }

    public void createAccount(String username, String password) throws IOException {
        ClientInfoServer newClient = new ClientInfoServer(username, password, "onl", "");
        clientList.put(username, newClient);
    }

    public void markOnline(String username) throws IOException {
        String status = "on";
        ClientInfoServer temp = clientList.get(username);
        temp.setClientStatus(status);
        clientList.replace(username, temp);
//        FileOutputStream fos = new FileOutputStream(new File("dtb/" + username + ".xml"));
//        XMLEncoder encoder = new XMLEncoder(fos);
//        encoder.writeObject(temp);
//        encoder.close();
//        fos.close();
    }

    public void markOffline(String username) {
        String status = "off";
        ClientInfoServer temp = clientList.get(username);
        temp.setClientStatus(status);
        clientList.replace(username, temp);
    }

    public void addFriend(String friendName) {
        
    }

    public String checkLogout() {
        return "a";
    }

    public boolean checkPassword(String username, String password) {
        ClientInfoServer value = clientList.get(username);
        return password.equals(value.getClientPassword());
    }

    public boolean findUsername(String username) {
        ClientInfoServer value = clientList.get(username);
        return value != null;
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