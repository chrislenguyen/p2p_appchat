package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.commons.lang3.StringUtils;
import utils.ClientInfo;

public class ClientHandler implements Runnable{
    private final ChatServer server;
    private final Socket client;

    private DataInputStream reader;
    private DataOutputStream writer;

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
                            this.handleLogout(segments[1]);
                            break;
                        case "addfriend":
                            this.handleAddFriend(segments[1]);
                            break;
                        case "connectfriend":
                            this.handleConnectFriend();
                            break;
                        case "removefriend":
                            this.handleRemoveFriend();
                            break;
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

    private void handleSignup(String[] segments) throws IOException {
        System.out.println(String.format("[SERVER] Sign-up with username %s, password %s", segments[1], segments[2]));
        String temp = server.findUsername(segments[1]);
        if (temp.equals(segments[1])) {
            sendSuccessRes(segments[0], segments[1], segments[2]);
            return;
        }
        sendFailedRes(segments[0]);
    }

    private void handleLogin(String[] segments) throws IOException {
        String username = server.findUsername(segments[1]);
        String password = server.findUsername(segments[2]);
        if (server.checkPassword(username, password)) {
            server.markOnline(segments[0]);
            sendSuccessRes(segments[0], segments[1], segments[2]);
        } else {
            sendFailedRes(segments[0]);
        };
    }

    private void handleLogout(String username) {

    }

    private void handleAddFriend(String name) {
        String temp = server.findUsername(name);
    }

    private void handleConnectFriend() {

    }

    private void handleRemoveFriend() {

    }

    private void sendSuccessRes(String req, String username, String others) throws IOException {
        switch (req) {
            case "signup":
                writer.writeUTF("signup-" + "success-" + username + '-' + client.getPort());
                break;
            case "login":
                writer.writeUTF("login-" + "success-" + username + "-" + client.getPort());
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
}
