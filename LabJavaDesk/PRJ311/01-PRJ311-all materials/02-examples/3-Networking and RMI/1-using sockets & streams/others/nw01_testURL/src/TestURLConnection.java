// This program needs connection. If not the java.net.UnknownHostException will be thrown
import java.net.*;
import java.io.*;
public class TestURLConnection  {
 public static void main(String [] args)  {
   try  {
    URL url = new URL("http://www.fpt.vn");
    URLConnection urlCon = url.openConnection();
     HttpURLConnection con = null;
     if(urlCon instanceof HttpURLConnection) {
            con = (HttpURLConnection) urlCon;
      }
       else  {
        System.out.println("Please enter an HTTP URL.");
         return;
        }
     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
     String urlString = "";
     String current;
     while((current = in.readLine()) != null)  {
            urlString += current + "\r\n";
       }
     System.out.println(urlString);
      }catch(IOException e)  { e.printStackTrace(); }
   }
}
