package packageA;
import packageB.*;
public class ClassA {
  public void test() {
    System.out.println("I am a ClassA object in the package packageA");     
   }    
  public static void main(String[] args)
     { ClassB t = new ClassB();
       t.test();
       System.out.println();
     }
    
}
