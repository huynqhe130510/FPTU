class A
 {static int x=0;
  static class B
    {//int x;
     void set()
      {x = 10;
      }
     void display()
      {System.out.println(x);
      }
    }
  void display()
    {System.out.println(x);
    }
 }
public class Main
 {public static void main(String [] args)
   {
    A t = new A();
    A.B h = new A.B();
    h.set();
    h.display();
    t.display();
    System.out.println();
   }
 }
