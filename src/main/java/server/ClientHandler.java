package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import utils.ClientInfo;

public class ClientHandler implements Runnable{
    private final ChatServer server;
    private final Socket client;

    private DataInputStream reader;
    private DataOutputStream writer;

    public boolean logged = false;

    private ClientInfo clientInfo;

    public ClientHandler(ChatServer server, Socket client) {
        this.server = server;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            this.reader = new DataInputStream(client.getInputStream());
            this.writer = new DataOutputStream(client.getOutputStream());

            String message      = null;
            String[] segments   = null;
            while(true) {
                message = reader.readUTF();
                System.out.print(String.format("[SERVER] Received request: %s\n", message));
                segments = StringUtils.split(message,'-');
                if (segments != null && segments.length > 0) {
                    String type = segments[0];
                    switch (type) {
                        case "signup":
                            this.handleSignup(segments);
                            break;
                        case "login":
                            this.handleLogin(segments);
                            break;
                        case "logout":
                            this.handleLogout();
                            break;
                        case "addfriend":
                            this.handleAddFriend(segments[0], segments[1]);
                            break;
                        case "connectfriendto":
                            this.handleConnectFriend(segments[1]);
                            break;
                        case "removefriend":
                            this.handleRemoveFriend(segments[0], segments[1]);
                            break;
                        case "acceptconnectfriend":
                            this.handleConnectFriendFrom(segments[1], segments[2]);
                            break;
//                        case "notifyonline":
//                            this.handleNotifyLogIn();
//                            break;
//                        case "notifyoffline":
//                            this.handleNotifyLogOut();
//                            break;
                        default:
                            System.out.println("Unknown " + type);
                    }
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("[SERVER] Client disconnected");
        }
    }

    private void notifyOnline() throws IOException {
        LinkedList<String> listOfOnlineFriend = server.findOnlineFriend(clientInfo.getClientName());
        for (String friend : listOfOnlineFriend) {
            writer.writeUTF("notifyonline" + friend);
        }
    }

    private void notifyOffline() throws IOException {
        LinkedList<String> listOfOnlineFriend = server.findOnlineFriend(clientInfo.getClientName());
        for (String friend : listOfOnlineFriend) {
            writer.writeUTF("notifyoffline" + friend);
        }
    }

    private void handleSignup(String[] segments) throws IOException {
        System.out.println(String.format("[SERVER] Sign-up with username %s, password %s", segments[1], segments[2]));
        if (!server.findUsername(segments[1])) {
            server.createAccount(segments[1], segments[2]);
            this.clientInfo = new ClientInfo(segments[1]);
            server.markOnline(clientInfo.getClientName());
            sendSuccessRes(segments[0], segments[1]);
        } else {
            sendFailedRes(segments[0]);
        }
    }

    private void handleLogin(String[] segments) throws IOException {
        if (server.checkPassword(segments[1], segments[2])) {
//            clientInfo.setClientName(segments[1]);
            this.clientInfo = new ClientInfo(segments[1]);
            server.markOnline(clientInfo.getClientName());
            notifyOnline();
            sendSuccessRes(segments[0], segments[1]);
        } else {
            sendFailedRes(segments[0]);
        };
    }

    private void handleLogout() throws IOException {
        server.markOffline(clientInfo.getClientName());
        notifyOffline();
    }

    private void handleAddFriend(String req, String friendName) throws IOException {
        if (server.findUsername(friendName)) {
            server.removeFriend(clientInfo.getClientName(), friendName);
            notifyOnline();
            sendSuccessRes(req, friendName);
        } else {
            sendFailedRes(req);
        }
    }

    private void handleConnectFriend(String friendName) throws IOException {
        ClientHandler c = server.getClientHandler(friendName);
        if (c != null) {
            c.sendRequestConnectFriend(this.clientInfo.getClientName());
        }
    }

    private void handleConnectFriendFrom(String username, String port) throws IOException {
        ClientHandler c = server.getClientHandler(username);
        if (c != null) {
            c.sendReponseConnectFriend(this.clientInfo.getClientName(), port);
        }
    }

    private void handleRemoveFriend(String req, String friendName) throws IOException {
        if (server.findUsername(friendName)) {
            server.addFriend(clientInfo.getClientName(), friendName);
            notifyOnline();
            sendSuccessRes(req, friendName);
        } else {
            sendFailedRes(req);
        }
    }

    private void sendSuccessRes(String req, String username) throws IOException {
        switch (req) {
            case "signup":
                writer.writeUTF("signup-" + "success-" + username + '-' + "0");
                break;
            case "login":
                LinkedList<String> friend = server.getFriendList(clientInfo.getClientName());
                String res = "login-" + "success-" + username + "-" + String.valueOf(friend.size());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(res);
                for (String n:friend) {
                    stringBuilder.append("-").append(n);
                    stringBuilder.append("-").append(server.getClientStatus(n));
                }
                writer.writeUTF(stringBuilder.toString());
                break;
            case "logout":
                writer.writeUTF("logout-" + "success");
                break;
            case "addfriend":
                writer.writeUTF("addfriend-" + "success");
                break;
            case "connectfriend":
                writer.writeUTF("connectfriend-" + "success-" + client.getPort() + "-" + client.getPort());
                break;
        }
    }

    private void sendFailedRes(String req) throws IOException {
        switch (req) {
            case "signup":
                writer.writeUTF("signup-" + "failed");
                break;
            case "login":
                writer.writeUTF("login-" + "failed");
                break;
            case "addfriend":
                writer.writeUTF("addfriend-" + "failed");
                break;
            case "connectfriend":
                writer.writeUTF("connectfriend-" + "failed");
                break;
        }
    }

    public void sendRequestConnectFriend(String targetName) throws IOException {
        this.writer.writeUTF("connectfriendto-" + targetName);
    }

    public void sendReponseConnectFriend(String targetName, String port) throws IOException{
        this.writer.writeUTF("acceptconnectfriend-" + targetName + client.getInetAddress().toString().substring(1) + port);
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public String getNameClientInfo() {
        return clientInfo.getClientName();
    }
}
