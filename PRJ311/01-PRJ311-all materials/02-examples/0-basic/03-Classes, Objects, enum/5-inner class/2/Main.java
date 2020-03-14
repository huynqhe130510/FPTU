class A
 {int x=5;
    void display() {System.out.println(" x = " + x);}
    void foo()
     {B t = new B();
      t.display();
     }
  class B
   {void fun() 
     {A t = new A();
      t.display();
     }
    void display() {System.out.println(" x = " + x);}
   }
 }
class Main
 {public static void main(String args[]) throws Exception
   {A t = new A();
    t.foo();
    A.B h = t.new B();
    h.fun();   
    System.out.println();
   }
 }
