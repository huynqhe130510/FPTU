import java.util.*;

class TestWaitNotify {
   ArrayList<Integer> t;
   InputThread u;
   OutputThread  v; 
   void test() {
     t = new ArrayList<Integer>();
     u = new InputThread();
     v = new OutputThread();
     u.setName("Hoa");
     v.setName("La");
     u.start();
     v.start();
    } 

   class InputThread extends Thread   {
      public void run()  {
         int x, y, i = 0; 
         Scanner r = new Scanner(System.in); 
         while(true) {
           synchronized(this) {
             System.out.print("\n" + getName() + " enters x = ");
             x = r.nextInt();
             System.out.print(getName() + " enters y = ");
             y = r.nextInt();
             t.add(x);
             t.add(y);
             synchronized(v) { v.notify(); }
             i++;
             if(i == 5) break;
             try { wait(); } catch(InterruptedException e) {}
         }
       }
     }
   }

   class OutputThread extends Thread   {
      public void run() {
         int x, y, z, i;
         i = 0;
         while(true) {
           synchronized(this) {
             try {
               wait();
               x = t.remove(0);
               y = t.remove(0);
               z = x + y;
               System.out.println(getName() + " calculates sum  = " + z);
               }
               catch(InterruptedException e) {}
               i++;
               if(i == 5) break;
               synchronized(u) { u.notify(); }
             }
          }
        }
    }


}