import java.net.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
     ServerSocket server;   
     int fro, to, i;
     fro = 0; to = 1024;
     System.out.printf("List of ports being used in the interval [%d,%d]:\n",fro,to);
     for(i=fro;i<=to;i++) {
       try {
         server = new ServerSocket(i);  
       }
       catch(IOException e) {
         System.out.println(i);  
       }
     }
     
    }
    
}
