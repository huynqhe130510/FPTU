import java.io.*;
class Main
 {public static void main(String args[]) throws Exception
   {String a = null;  int x;
    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(" Enter integer number: ");
    a = b.readLine();
    x = Integer.parseInt(a.trim());
    System.out.println(" An integer number entered is: " + x);
   }
 }
