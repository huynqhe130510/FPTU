// This program will get components in a URL and no connection is carried out.
import java.net.*;
import java.io.*;
public class TestURL
{ public static void main(String [] args)
   { try
      {  URL url = new URL("http://www.test.myExample.com");
         System.out.println("\nURL is " + url.toString());
         System.out.println("protocol is " + url.getProtocol());
         System.out.println("authority is "  + url.getAuthority());
         System.out.println("file name is " + url.getFile());
         System.out.println("host is " + url.getHost());
         System.out.println("path is " + url.getPath());
         System.out.println("port is " + url.getPort());
         System.out.println("default port is " + url.getDefaultPort());
         System.out.println("query is " + url.getQuery());
         System.out.println("ref is " + url.getRef());
      } catch(IOException e)  { e.printStackTrace();  }
     System.out.println();
   }
}
