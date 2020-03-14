import java.util.*;
class Main
 {public static void main(String args[]) throws Exception
   {String a = null;  int x;double y;
    Scanner t = new Scanner(System.in);
    System.out.print(" Enter a string: ");
    a = t.next(); // A string cannot contain spaces
    System.out.print(" Enter integer number: ");
    x = t.nextInt();
    System.out.print(" Enter double number: ");
    y = t.nextDouble();
    System.out.println(" A string entered is: " + a);
    System.out.println(" An integer number entered is: " + x);
    System.out.println(" A double number entered is: " + y);
   }
 }
