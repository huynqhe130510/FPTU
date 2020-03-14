import java.util.*;

class InputThread extends Thread   {
   ArrayList<Integer> a;
   OutputThread  t; 
   InputThread(ArrayList<Integer> a1, OutputThread  t1) {
       a = a1; t = t1;
    }  
   public void run()  {
      int x, y, i = 0; 
      Scanner u = new Scanner(System.in); 
      while(true) {
        synchronized(this) {
          System.out.print("\n" + getName() + " enters x = ");
          x = u.nextInt();
          System.out.print(getName() + " enters y = ");
          y = u.nextInt();
          a.add(x);
          a.add(y);
          synchronized(t) { t.notify(); }
          i++;
          if(i == 5) break;
          try {sleep(500); } catch(InterruptedException e) {}
      }
   }
 }
}