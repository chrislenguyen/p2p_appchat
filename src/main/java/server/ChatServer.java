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
import java.util.LinkedList;
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
//        String user = "tom";
//        String password = "321";
//        LinkedList<String> friend = new LinkedList<>();
                    //----CREATE NEW USER----//

//        friend.add("khuong");
//        friend.add("khoa");
//        ClientInfoServer tempNew = new ClientInfoServer(user, password, "off", friend);
//        FileOutputStream fos = new FileOutputStream(new File("dtb/" + user + ".xml"));
//        XMLEncoder encoder = new XMLEncoder(fos);
//        encoder.writeObject(tempNew);
//        encoder.close();
//        fos.close();
                    //---------------------//
        String name = "khuong";
//        createAccount(user, password);
        addFriend(name, "tom");
        addFriend(name, "tom");
        ClientInfoServer temp = clientList.get(name);
//        temp.setFriendList(friend);
        System.out.println(temp.getClientName());
//        System.out.println(temp.getClientPassword());
//        System.out.println(temp.getClientStatus());
        System.out.println(temp.getFriendList());
//        markOffline(name);
//        System.out.println(temp.getClientStatus());
        ClientInfoServer anotherTemp = clientList.get("tom");
        System.out.println(anotherTemp.getClientName());
        System.out.println(anotherTemp.getFriendList());
        //-------------------------------------------------------------//
    }

    public void createAccount(String username, String password) throws IOException {
        LinkedList<String> empty = new LinkedList<>();
        ClientInfoServer newClient = new ClientInfoServer(username, password, "on", empty);
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

    public LinkedList<String> findOnlineFriend(String username) {
        ClientInfoServer temp = clientList.get(username);
        LinkedList<String> tempList = new LinkedList<>();
        for (String friend : temp.getFriendList()) {
            if (clientList.get(friend).getClientStatus().equals("on")) {
                tempList.add(clientList.get(friend).getClientName());
            }
        }
        return tempList;
    }

    public void markOffline(String username) {
        String status = "off";
        ClientInfoServer temp = clientList.get(username);
        temp.setClientStatus(status);
        clientList.replace(username, temp);
    }

    public void addFriend(String username, String friendName) {
        ClientInfoServer temp = clientList.get(username);
        for (String friend : temp.getFriendList()) {
            if (friend.equals(friendName)) return;
        }
        temp.getFriendList().add(friendName);
        ClientInfoServer anotherTemp = clientList.get(friendName);
        anotherTemp.getFriendList().add(username);
    }

    public boolean checkPassword(String username, String password) {
        ClientInfoServer value = clientList.get(username);
        return password.equals(value.getClientPassword());
    }

    public boolean findUsername(String username) {
        ClientInfoServer value = clientList.get(username);
        return value != null;
    }

    public void logEverything() {

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