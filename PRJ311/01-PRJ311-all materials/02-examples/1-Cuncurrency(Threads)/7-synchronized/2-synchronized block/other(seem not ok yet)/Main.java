public class Main
 {public static void main(String [] args)
   {ThreadA a = new ThreadA();
    ThreadB b = new ThreadB();
    a.setName("Hoa");
    b.setName("La");
    a.start();
    try {Thread.sleep(1000);} catch(InterruptedException e) {}
    b.start();

   }
 }
