public class Main
 {public static void main(String [] args)
   {Thread a = new Thread("HOA");
    System.out.println(a.getState());
    System.out.println(a.getPriority());
    a.start();
   }
 }
/*
public Thread.State getState()
- Tra ve trang th�i hien tai cua thread.
- L� mot hang cua lop Thread.
- C�c gi� tri c� the l� :
+ NEW : thread chua duoc khoi hoat.
+ RUNNABLE : thread dang hoat dong trong JVM.
+ BLOCKED : thread cho mot monitor de unlock mot doi tuong m� n� can.
+ WAITING : thread cho kh�ng gioi han cho den khi mot thread kh�c d�nh thuc n�.
+ TIMED_WAITING : thread cho trong mot thoi gian nhat dinh, hoac l� c� mot thread kh�c d�nh thuc n�.
+ TERMINATED : thread d� ket th�c c�ng viec cua n�.

*/
