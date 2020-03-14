import java.util.*;
class TestThread
 {A t; B h;ArrayList g;int count,max;
  TestThread(int max1) 
   {max=max1;count = 0; g = new ArrayList();
   }

  class A extends Thread
   {String mess;
    public void run()
     {createMessages();
     }
    public void createMessages()
     {int i=0;
      while(i<max)
       {create();
        g.add(mess);
        i++;
        synchronized(this) {
          try {wait();}catch(InterruptedException e) {}
         }
       }
     }
    void create()
     {Random t = new Random();
      String s = "ABCDEFGHIJKLMNOPQ";
      char [] a = s.toCharArray();
      String x = "";
      for(int i=0;i<5;i++)
       {x += a[t.nextInt(16)];
       }
      count++;
      mess = new String(x+ "-" + count);
      System.out.println("\n " + getName() + " created " + mess);
     }
   }
  class B extends Thread
   {public void run()
      {sendMessages();
      }
    void sendMessages()
      {int i=0;
       while(i<max)
        {if(i<g.size())
          {send((String) g.get(i));
           i++;
          }
        }
      }
    void send(String x)
     {System.out.println(" " + getName() + " sending " + x);
      synchronized(t) {t.notify();}
      try {sleep(500);} catch(InterruptedException e) {}
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
