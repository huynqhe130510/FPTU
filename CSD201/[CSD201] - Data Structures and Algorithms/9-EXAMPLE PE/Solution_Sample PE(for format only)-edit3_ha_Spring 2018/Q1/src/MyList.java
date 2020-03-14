

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(Car x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void addLast(String xOwner, int xColor, int xsize) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Car x = new Car(xOwner, xColor, xsize);
        addLast(x);
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
//    void addposition3(Car x) {//You should write here appropriate statements to complete this function.
//        Node q = new Node(x, head);
//        Node p;
//        p = head;
//        if (isEmpty()) {
//            head = tail = q;
//        } else {
//            int count = 0;
//            while (count != 2) {
//                p = p.next;
//                count++;
//            }
//            q.next = p.next;
//            p.next = q;
//        }
//
//    }
    public void insertPositionK(Car x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Car x = new Car("X", 10, 5);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertPositionK(x, 3);
        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;//q is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    void dele() {
        int j = 0;

        Node p = head;
        Node max = head;
        while (p != null) {
            if ((p.info.color + p.info.size) > (max.info.color + max.info.size)) {
                max = p;
            }
            p = p.next;
        }
        if (max != null) {
            dele(max);
        }
    }

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        dele();
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void addFirst(Car x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        MyList h = new MyList();
        //Đảo 4 vị trí đầu
        Node p = head;
        Car x;
        int count = 1;

        while (count <= 4) {
            x = p.info;
            h.addFirst(x);
            count++;
            p = p.next;
        }
        head = h.head;;
        tail = h.tail;

        //Đảo 4 vị trí cuối cùng  
/*    Node p=head; Car x;int count1=0; 
   
       while(p!=null)
         {count1++;
          p=p.next; 
         }
      int count2=0;
      p=head;
       while(count2<count1-4) {p=p.next;count2++;}
     
       while(p!=null)
         {x=p.info;h.addFirst(x); 
          p=p.next; 
         }
        head=h.head;
        tail=h.tail;
         */
//8--------------------------------------------------------------------------------
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
