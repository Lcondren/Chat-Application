package ie.atu.sw;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;


public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;

    public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }

    @Override
    public void run() {
        try {
            while (true) {
                //Read in a message line by line
                String message = bufferedReader.readLine();
                //Prints out your message on the chat
                System.out.println(message);
            }
        }catch (SocketException e) {
            System.out.println("You left the chat room");
        }catch (IOException exception) {
            System.out.println(exception);
        }finally {
            try {
                bufferedReader.close();
            }catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}