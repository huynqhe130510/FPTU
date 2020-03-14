public class ThreadB extends Thread
 {public void run()
   {for(int i=0;i<10;i++)
     {try {sleep(400);} catch(Exception e) {}
      System.out.println(getName() + ": " + i);
     }
   }
 }
