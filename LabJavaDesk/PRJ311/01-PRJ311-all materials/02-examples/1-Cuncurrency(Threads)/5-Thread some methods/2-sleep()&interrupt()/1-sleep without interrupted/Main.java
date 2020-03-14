public class Main
 {public static void main(String [] args)
   {Thread a = new Thread() {
      public void run()
        {long startTime = System.currentTimeMillis();
         try {sleep(2000);}
         catch(Exception e) {
           System.out.println(" The thread " + getName() + " has been interrupted.");
          }
         long elapsedTime = System.currentTimeMillis() - startTime;
         System.out.println(" The thread " + getName() + " has slept " + (elapsedTime/1000.0) + " seconds.");
        }
      };

    a.start();
    a.setName("Hoa");
    try {Thread.sleep(500);} catch(InterruptedException e) {}
    //a.interrupt();
   }
 }
