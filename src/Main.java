import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Main {

  public static void main(String[] args) throws Exception {

      final ServerSocket server = new ServerSocket(8080);
      System.out.println("Waiting for client on port 8080...");
      
          while (true) {
            try(Socket client = server.accept()){
                LocalDateTime today = LocalDateTime.now();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));



                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
    
                while(!line.isEmpty()){
                    System.out.println(line);
                    line = br.readLine();
                }
                
            }

              
          }
      }

  }
