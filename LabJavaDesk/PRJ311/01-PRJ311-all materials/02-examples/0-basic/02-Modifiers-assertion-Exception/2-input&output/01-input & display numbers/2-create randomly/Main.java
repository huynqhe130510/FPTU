import java.util.*;
class MyArray
 {int [] a; int n;
  MyArray() {}
  MyArray(int [] b)
   {int i;
    n = b.length;
    a = new int[n];
    for(i=0;i<n;i++) a[i]= b[i];
   }
  void setData(int [] b)
   {int i;
    n = b.length;
    a = new int[n];
    for(i=0;i<n;i++)
       a[i]= b[i];
   }
  void setRandom()
   {int i;
    Scanner s = new Scanner(System.in);
    System.out.print(" Enter n = ");
    n = s.nextInt();
    a = new int[n];
    //System.out.print("  " + a.length); // = n
    // Create a random number generator,
    // seeds with current time by default:
    Random r = new Random();
    for(i=0;i<n;i++)
       a[i]= r.nextInt(100); // Choose value from 0 to 99
   }
  void display()
   {int i;
    for(i=0;i<n;i++)
      System.out.print("  " + a[i]);
    System.out.println();
   }
 }
//==================================================
public class Main
 {public static void main(String args[])
   {Scanner s = new Scanner(System.in);
    int choice;
    int [] b = {5,7,11,3,9,2,6};
    MyArray t = new MyArray(b);
    while(true)
      {System.out.println("\n Choose your option:");
       System.out.println("  1. Create list randomly");
       System.out.println("  2. Display data");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 2): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1:  t.setRandom();
                  break;
         case 2:  t.display();
                  break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
      }
   }
 }
