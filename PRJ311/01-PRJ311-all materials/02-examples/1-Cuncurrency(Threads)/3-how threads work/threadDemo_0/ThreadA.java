public class ThreadA extends Thread
 {public void run()
   {for(int i=0;i<10;i++)
     {try {sleep(500);} catch(Exception e) {}
      System.out.println(getName() + ": " + i);
     }
   }
 }
