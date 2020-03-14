public class Main
 {public static void main(String [] args)
   {ThreadA t = new ThreadA(); // extends Thread class
    ThreadB x = new ThreadB(); // implements Runnable interface
    Thread h = new Thread(x);
    Thread u = new Thread() {  // using anonymous object from Thread class
      public void run()
       {for(int i=0;i<10;i++)
         {try {sleep(300);} catch(Exception e) {}
          System.out.println(getName() + ": " + i);
         }
       }
     };
    t.setName("Hoa");
    h.setName("La");
    u.setName("Canh");
    t.start();
    h.start();
    u.start();

   }
 }
