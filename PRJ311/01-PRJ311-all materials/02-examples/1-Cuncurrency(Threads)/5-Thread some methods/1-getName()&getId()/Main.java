public class Main
 {public static void main(String [] args)
   {Thread a = new Thread("HOA");
    System.out.println(" (a) The thread name is: " + a.getName());
    System.out.println(" (a) The thread ID is: " + a.getId());
    Thread b = new Thread();
    System.out.println(" (b) The thread name is: " + b.getName());
    System.out.println(" (b) The thread ID is: " + b.getId());
    System.out.println(" (main) The currently running thread Id is: " + Thread.currentThread().getId());
    System.out.println(" (main) The currently running thread name is: " + Thread.currentThread().getName());
    System.out.println(" Before starting, the thread " + a.getName() + " isAlive?  " + a.isAlive());
    a.start();
    System.out.println(" After starting, the thread " + a.getName() + " isAlive?  " + a.isAlive());
    long startTime = System.currentTimeMillis();
    try {a.sleep(2000);} catch(InterruptedException e) {}
    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println(" The thread " + a.getName() + " has slept " + (elapsedTime/1000.0) + " seconds.");
    System.out.println(" The thread " + a.getName() + " isAlive?  " + a.isAlive());
   }
 }
