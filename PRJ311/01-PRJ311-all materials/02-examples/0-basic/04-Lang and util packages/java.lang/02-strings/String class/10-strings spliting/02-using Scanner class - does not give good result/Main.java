import java.util.*;
public class Main
 {
  public static void main(String[] args) throws Exception
   {
    // using default delimiter
    String a = "ABC  UV   XYZ";
    String s;
    Scanner t = new Scanner(a);
    t.useDelimiter(" ");
    while(t.hasNext()) 
      {s = t.next();
       System.out.println(s);
      }
    System.out.println();

    // using specified delimeter
    String b = "AB C | UV | X YZ";
    t = new Scanner(b);
    t.useDelimiter("|");
    while(t.hasNext()) 
      {s = t.next();
       System.out.println(s);
      }
    System.out.println();

   }
}
