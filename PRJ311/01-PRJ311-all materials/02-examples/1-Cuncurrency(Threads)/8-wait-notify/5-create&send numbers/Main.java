import java.util.*;
class TestThread
 {A t; B h;int x,count,max;
  TestThread(int max1) 
   {max=max1;count = 0;
   }

  class A extends Thread
   {//String mess;
    public void run()
     {Random r = new Random();
      while(count<max)
       {synchronized(this)
         {
          try {
            x = r.nextInt(100);
            System.out.println("\n" + getName() + " creating " + x);
            count++;
            wait();
           }catch(InterruptedException e) {}
         }
       }
     }
   }
  class B extends Thread
   {public void run()
     {int i=0;
      while(i<max)
       {if(i<count)
         {synchronized(t) 
            {System.out.println(" " + getName() + " sending " + x);
             t.notify();
             try {sleep(500);} catch(InterruptedException e) {}
            }
          i++;
         }
       }
     }
   }
  void play()
   {t = new A();
    h = new B();
    t.setName("HOA"); 
    h.setName("LA"); 
    t.start();
    try {Thread.sleep(1000);} catch(InterruptedException e) { }
    h.start();
   }
 }
public class Main
 {public static void main(String[] args)
   {TestThread u = new TestThread(10);
    u.play();
    System.out.println();
   }
 }
