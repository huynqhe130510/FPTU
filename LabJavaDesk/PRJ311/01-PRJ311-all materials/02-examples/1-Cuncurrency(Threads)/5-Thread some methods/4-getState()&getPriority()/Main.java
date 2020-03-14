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
- Tra ve trang thái hien tai cua thread.
- Là mot hang cua lop Thread.
- Các giá tri có the là :
+ NEW : thread chua duoc khoi hoat.
+ RUNNABLE : thread dang hoat dong trong JVM.
+ BLOCKED : thread cho mot monitor de unlock mot doi tuong mà nó can.
+ WAITING : thread cho không gioi han cho den khi mot thread khác dánh thuc nó.
+ TIMED_WAITING : thread cho trong mot thoi gian nhat dinh, hoac là có mot thread khác dánh thuc nó.
+ TERMINATED : thread dã ket thúc công viec cua nó.

*/
