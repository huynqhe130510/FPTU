import java.util.*;
class TestThread
 {A t; B h;ArrayList g;int max;
  TestThread(int max1) 
   {max=max1; g = new ArrayList();
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
      mess = new String(x);
      System.out.println(" " + getName() + " created " + mess);
      try {sleep(500);}catch(InterruptedException e) {}
     }
   }
  class B extends Thread
   {public void run()
      {try {t.join();}catch(InterruptedException e) {}
       sendMessages();
      }
    public void sendMessages()
      {for(int i=0;i<g.size();i++) send((String) g.get(i));
      }
    void send(String x)
     {System.out.println(" " + getName() + " sending " + x);
     }
   }
  void play()
   {t = new A();
    h = new B();
    t.setName("HOA"); 
    h.setName("LA"); 
    t.start();
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
