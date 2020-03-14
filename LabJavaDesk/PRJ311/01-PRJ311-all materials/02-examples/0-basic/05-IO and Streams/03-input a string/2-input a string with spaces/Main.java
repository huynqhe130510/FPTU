import java.io.*;
class Main
 {public static void main(String args[]) throws IOException
   {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String a, b;
    System.out.print("\n Enter string a = ");
    a = in.readLine();
    System.out.println(" String a is: " + a);
    System.out.print("\n Enter string b = ");
    b = in.readLine();
    System.out.println(" String b is: " + b);
   }
 }