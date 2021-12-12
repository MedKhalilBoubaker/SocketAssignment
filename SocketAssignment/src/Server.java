import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {


        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept();
        System.out.println("Connection established");

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);
        String received = inServer.readLine();
        System.out.println("INPUT : "+received);
        System.out.println("OUTPUT : "+received.replaceAll("[aeiouyAEIOUY]",""));

        inServer.close();
        outServer.close();

        socClient.close();
        serverSocket.close();
    }
}
