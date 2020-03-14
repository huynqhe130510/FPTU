import java.util.*;

class OutputThread extends Thread   {
   ArrayList<Integer> b;
   OutputThread(ArrayList<Integer> b1) {
      b = b1; 
    }  
   public void run() {
      int x, y, z, i;
      i = 0;
      while(true) {
        synchronized(this) {
          try {
            wait();
            x = b.remove(0);
            y = b.remove(0);
            z = x + y;
            System.out.println(getName() + " calculates sum  = " + z);
            }
            catch(InterruptedException e) {}
            i++;
            if(i == 5) break;
          }
       }
     }
 }