package src;
import packageA.*;
public class MyClass {
    public void test() {
      System.out.println("I am in src package");  
    }
    public static void main(String[] args)
     {ClassA t = new ClassA();
      t.test();
      System.out.println();
     }
    
}
