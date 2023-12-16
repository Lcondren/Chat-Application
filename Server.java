package ie.atu.sw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;//Initialise the Server Socket

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    public void startServer(){
        try{

            while(!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();//While the Server Socket is not closed it will accept the clients on the server
                System.out.println("A new client has connected!");//Prints out message to let others on the server know that someone has joined
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread t = new Thread(clientHandler);
                t.start();

            }
        } catch (IOException e) {

        }
    }


    public static void main(String[] args) throws IOException{
        //The Server Socket is on port 3000, all clietns that want to get on the server must be on port 3000
        ServerSocket serverSocket = new ServerSocket(3000);
        Server server = new Server(serverSocket);
        server.startServer();
    }

}
