import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class SocketServer {

    public static void main(String[] args)
    {
        String s;
        Scanner input;
        PrintWriter outputStream;
        ServerSocket serverSocket;
        try {
            System.out.println("Server ok: waiting connection.");
            serverSocket = new ServerSocket(6789);
            Socket socket = serverSocket.accept();
            input = new Scanner(
                new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintWriter(new DataOutputStream(
                socket.getOutputStream()));
            
            s = input.nextLine();
            outputStream.println("Salve, "+s);
            outputStream.println("connesione da Macbook Pro.");
            outputStream.println("Come va? tutto bene. Addio!");
            outputStream.flush();
            
            System.out.println("Chiudiamo tutto.");
            input.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("problemi."+e);
        }
    }

}