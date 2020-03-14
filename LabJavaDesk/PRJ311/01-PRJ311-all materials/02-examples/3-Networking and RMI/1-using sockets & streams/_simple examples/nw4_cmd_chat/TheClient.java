import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TheClient {

    public static void main(String[] args) throws Exception {
        Socket client1;
        String host1;int port1;
		client1 = null;
        ObjectInputStream in = null;
        ObjectOutputStream ou = null;
        host1 = "localhost";
        port1 = 4321;
        Scanner t = new Scanner(System.in);
        try {
          client1 = new Socket(host1,port1);  
          in = new ObjectInputStream(new DataInputStream(client1.getInputStream()));
          ou = new ObjectOutputStream(new DataOutputStream(client1.getOutputStream()));
        }
        catch(IOException e) {
          System.out.println("Host or port error");
        }
       String sTo, sFro;
       while(true) {
         System.out.print("\n Enter a string to be sent to the server s = ");
         sTo = t.nextLine();
         ou.writeObject(sTo);
         if(sTo.equalsIgnoreCase(".bye")) break;

         sFro = (String) in.readObject();
         if(sFro.equalsIgnoreCase(".bye")) break;
         System.out.println("A string received from the server: " + sFro);
       }
      in.close(); ou.close(); client1.close();
    }
    
}
