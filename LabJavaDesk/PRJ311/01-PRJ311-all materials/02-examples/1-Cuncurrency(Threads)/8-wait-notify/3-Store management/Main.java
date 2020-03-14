import java.util.*;
class Store
 {Integer [] a; int n,max;
  Store(int size)
   {max = size;
    a = new Integer[max];
    n = 0;
   }
  boolean isEmpty() {return(n==0);}
  boolean isFull() {return(n==max);}
  void grow()
   {int newMax = max + max/2 + 1;
    Integer [] b = new Integer[newMax];
    for(int i=0;i<n;i++) b[i]=a[i];
    max = newMax;
    a = b;
   }
  void put(Integer x)
   {if(isFull()) grow();
    a[n++] = x;
   }
  Integer get()
   {if(isEmpty()) return(null);
    Integer x = a[0];
    for(int i=0;i<n-1;i++) a[i]=a[i+1];
    n--;
    return(x);
   }
  void putMany(Integer [] b)
   {for(int i=0;i<b.length;i++) put(b[i]);
   }
  void traverse()
   {for(int i=0;i<n;i++) System.out.print(a[i] + "  ");
    System.out.println();
   }
 }

class Producer extends Thread
 {Random r;
  Store t;
  Producer(Store h) {t = h; r = new Random();}
  public void run()
   {int i,x;
     for(i=0;i<5;i++)
      {x = r.nextInt(100);
       t.put(x);
        System.out.println("\n" + getName() + " puts " + x);
       synchronized(this) {
        try {wait();} catch(InterruptedException e) {}
        } 
      }
   }
   
 }

class Consumer extends Thread
 {Store t;
  Producer r;
  Consumer(Store h, Producer w) {t = h; r = w;}
  public void run()
   {int i,x;
    for(i=0;i<5;i++)
     {x = t.get();
      System.out.println(getName() + " gets " + x);
      synchronized(r) {r.notify();}
      try {sleep(100);} catch(InterruptedException e) {} 
     }
   }
   
 }

class testThread
 {void test()
   {Producer u; Consumer v;
    Store t = new Store(10);
    t.put(1);t.put(2);t.put(3);
    u = new Producer(t);
    v = new Consumer(t,u);
    u.setName("Hoa");
    v.setName("La");
    u.start();
    try {Thread.sleep(50);} catch(InterruptedException e) {}
    v.start();
   }
 }

public class Main
 {public static void main(String [] args)
   {testThread g = new testThread();
    g.test();
    System.out.println();  
   }
 }
