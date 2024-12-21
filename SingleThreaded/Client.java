package SingleThreaded;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.PrintWriter; 
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {
    
      public void run() throws UnknownHostException, IOException{
        int port = 8010; 
        InetAddress address = InetAddress.getByName("localhost");   
        Socket socket = new Socket(address, port);
        PrintWriter toSokcet = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSokcet.println("Hello from the client"); 
        String line = fromSocket.readLine();
        System.out.println("Response from socket: " + line);
    }

    public static void main(String[] args) {
        
       try{
          Client client = new Client();
            client.run();
        }catch(Exception ex){
            ex.printStackTrace();
    }
  }
}
