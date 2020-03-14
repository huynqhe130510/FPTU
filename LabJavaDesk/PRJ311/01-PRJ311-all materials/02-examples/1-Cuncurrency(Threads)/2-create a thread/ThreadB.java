//implements Runnable interface
public class ThreadB implements Runnable
 {public void run()
   {for(int i=0;i<10;i++)
     {try {Thread.sleep(400);} catch(Exception e) {}
      System.out.println(Thread.currentThread().getName() + ": " + i);
     }
   }
 }
