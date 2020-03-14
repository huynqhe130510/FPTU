import static java.lang.Thread.sleep;
import java.util.*;
public class TestThreads {
  Thread a; Thread b; int k;
  void initThreadA() {
   a = new Thread() {
    public void run() {
      Random u = new Random();
      while(true) {
        k = u.nextInt(100);
        System.out.println(getName() + " created " + k);
        try {sleep(1000);} catch(InterruptedException e) { } 
        synchronized(b) {b.notify();}
        try {
            synchronized(this) {wait();}  
          }
          catch(InterruptedException e) {            
          }
        }
      }
        
    };
      
  }
  void initThreadB() {
    b = new Thread() {
    public void run() {
      while(true) {
        try {
            synchronized(this) {wait();}  
          }
          catch(InterruptedException e) {            
          }
         System.out.println(getName() + " displays " + k + "\r\n");
         try {
           sleep(1000);  
         }
         catch(InterruptedException e) {
             
         }
         synchronized(a) {a.notify(); }
        }  
      }  
        
    };      
  }

  void test() {
    initThreadA();
    initThreadB();
    a.setName("Hoa");
    b.setName("La");
    b.start();
    a.start();
  } 
}
