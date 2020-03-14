enum Light
 {//static int x;/*ERROR*/
  BLUE,YELLOW,RED;//must appear first
  static boolean stop=true;
  static int y;
  static void display() // must be static
    {System.out.println(BLUE + " " + YELLOW + " " + RED + " " + stop);
    }
 }
public class Main
 {public static void main(String [] args)
   {//Light t = new Light(); /*ERROR*/
    Light.display();
    System.out.println();

   }
 }
