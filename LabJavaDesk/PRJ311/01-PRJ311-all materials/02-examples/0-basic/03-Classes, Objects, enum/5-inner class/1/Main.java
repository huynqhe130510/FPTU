class A
 {int x=5;
    void display() {System.out.println(" outside x = " + x);}
  class B
   {//int x=10;
    void display() {System.out.println(" inside x = " + x);}
   }
 }
class Main
 {public static void main(String args[]) throws Exception
   {A t = new A();
    A.B h = t.new B();
    t.display();   
    h.display();   
    System.out.println();
   }
 }
