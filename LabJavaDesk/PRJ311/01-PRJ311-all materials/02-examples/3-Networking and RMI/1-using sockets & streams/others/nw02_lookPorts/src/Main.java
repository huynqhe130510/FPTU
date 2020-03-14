import java.net.*;
import java.io.*;

public class Main
 {public static void main(String[] args)
   {ServerSocket ser;
    int fro,to, i;
    fro = 0; to = 500;
    System.out.printf("List of ports (in the interval [%d,%d]) already used\n",fro, to);
    for(i=fro;i<=to;i++) {
    try {
      ser = new ServerSocket(i); }
      catch(IOException e) {System.out.println("Port " + i);}
    }
   }
  
 }

