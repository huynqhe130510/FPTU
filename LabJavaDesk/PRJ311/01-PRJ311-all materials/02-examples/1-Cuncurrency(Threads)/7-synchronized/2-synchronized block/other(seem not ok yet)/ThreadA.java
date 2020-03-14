public class ThreadA extends Thread
 {public void run()
   {// This statement block does not run continuously! why? 
    synchronized(this)
     {for(int i=0;i<10;i++)
       {try {sleep(500);} catch(Exception e) {}
        System.out.println(getName() + ": " + i);
       }
     }
   }
 }
