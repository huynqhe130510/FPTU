public class Main
 {public static void main(String [] args)
   {ThreadA t = new ThreadA();
    ThreadB h = new ThreadB();
    t.setName("Hoa");
    h.setName("La");
    t.start();
    h.start();

   }
 }
