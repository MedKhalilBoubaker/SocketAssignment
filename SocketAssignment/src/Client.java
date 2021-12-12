import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        System.out.println("enter your example : ");
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        outClient.println(read.readLine());

        inClient.close();
        outClient.close();

        socket.close();
    }
}
