class Osin extends Thread
 {int count;
  Osin() { count=0;}
  void cleanFloor(int i)
    {try {System.out.println("\nThe floor " + i + " is cleaned and to be checked.");
          count++;
          synchronized(this) {wait();}
         } 
         catch(InterruptedException e) {}
    }
  void cleanHouse()
    {for(int i=0;i<5;i++)
      {cleanFloor(i);
      }
    }
  public void run() {cleanHouse();}
 }
class HouseHolder extends Thread
 {Osin t;
  HouseHolder(Osin x) {t=x;}
  void checkFloor(int i)
    {System.out.println(getName() + " is checking the floor " + i);
     synchronized(t) {t.notify();}
     try {sleep(500);} catch(InterruptedException e) {}
    }
  void checkHouse()
    {int i=0;
     while(i<5)
      {if(i<t.count)
         {checkFloor(i);i++;
         }
      }
    }
  public void run() {checkHouse();}
 }
public class Main
 {public static void main(String [] args)
   {Osin t = new Osin();
    t.setName("HOA");
    t.start();
     try {Thread.sleep(1000);} catch(InterruptedException e) { }

    HouseHolder h = new HouseHolder(t);
    h.setName("QUANG");
    h.start();
    System.out.println();
   }
 }
