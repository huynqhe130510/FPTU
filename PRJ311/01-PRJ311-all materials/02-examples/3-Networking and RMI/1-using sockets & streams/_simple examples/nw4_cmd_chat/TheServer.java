import java.io.*;
import java.util.*;
import java.net.*;
public class TheServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server1; Socket service1;
        int port1;
        server1 = null; service1 = null;
        ObjectInputStream in = null;
        ObjectOutputStream ou = null;
        port1 = 4321;
        Scanner t = new Scanner(System.in);
        try {
          server1 = new ServerSocket(port1);  
        }
        catch(IOException e) {
          System.out.println("The port " + port1 + " is busy");
        }
        try {
          service1 = server1.accept();   
          ou = new ObjectOutputStream(new DataOutputStream(service1.getOutputStream()));
          in = new ObjectInputStream(new DataInputStream(service1.getInputStream()));
        }
        catch(IOException e) {
          System.out.println("Cannot connect to the client");
         }
        String sTo, sFro;
        while(true) {
          sFro = (String) in.readObject();
          if(sFro.equalsIgnoreCase(".bye")) break;
          System.out.println("A string received from the client: " + sFro);

          System.out.print("\n Enter a string to be sent to the client s = ");
          sTo = t.nextLine();
          ou.writeObject(sTo);
          if(sTo.equalsIgnoreCase(".bye")) break;
        }
       in.close(); ou.close(); service1.close(); server1.close();
    }
    
}
