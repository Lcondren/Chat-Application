package ie.atu.sw;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String name;
        String reply;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your username for the groupchat: ");
        reply = s.nextLine();
        name = reply;

        try (Socket socket = new Socket("localhost", 3000)) {//Connect to local host will be prot 3000
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            ClientHandler threadClient = new ClientHandler(socket);
            //Start a new thread to receive message
            new Thread(threadClient).start();

            pw.println(reply + ": has joined the group");
            do{
                String msg = (name + " : ");
                reply = s.nextLine();
                //If message is typed with /q the user will leave the chat
                if (reply.equals("/q")){
                    pw.println("/q");
                    break;
                }
                pw.println(msg + reply);
            } while (!reply.equals("/q"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}
