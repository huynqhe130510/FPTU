public class Main
 {public static void reverse() throws Exception
   {char ch = (char) System.in.read();
    if(ch != '\n') 
     {//reverse(); // Non-tail
      System.out.print(ch);
      reverse();
     }
   }
  public static void main(String [] args) throws Exception
   {System.out.println("\nEnter a string to be reversed:");
    reverse();
    System.out.println("\n");
   }
 }
