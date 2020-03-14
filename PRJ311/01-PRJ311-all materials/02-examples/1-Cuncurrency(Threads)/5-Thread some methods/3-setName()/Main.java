public class Main
 {public static void main(String [] args)
   {Thread a = new Thread("HOA");
    a.start();
    System.out.println(" After starting, the thread " + a.getName() + " isAlive?  " + a.isAlive());
    System.out.println(" The state of the thread " + a.getName() + " is:  " + a.getState());
    System.out.println(" Now the thread " + a.getName() + " isAlive?  " + a.isAlive());
    System.out.print(" The new name of the thread " + a.getName() + " is: ");
    a.setName("LA");
    System.out.println(a.getName());
   }
 }
/*
public Thread.State getState()
- Tra ve trang thái hien tai cua thread.
- Là m?t h?ng c?a l?p Thread.
- Các giá tri có the là :
+ NEW : thread chua duoc khoi hoat.
+ RUNNABLE : thread dang hoat dong trong JVM.
+ BLOCKED : thread cho mot monitor de unlock mot doi tuong mà nó can.
+ WAITING : thread cho không gioi han cho den khi mot thread khác dánh thuc nó.
+ TIMED_WAITING : thread cho trong mot thoi gian nhat dinh, hoac là có mot thread khác dánh thuc nó.
+ TERMINATED : thread dã ket thúc công viec cua nó.

*/
