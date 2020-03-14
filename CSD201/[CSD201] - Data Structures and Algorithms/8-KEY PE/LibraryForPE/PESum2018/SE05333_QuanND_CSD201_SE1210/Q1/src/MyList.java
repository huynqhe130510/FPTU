/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//==========================================================================
  public void addLast(Pencil c) {
        Node p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

  void addLast(String xOwner, int xColor, int xPrice)
   {//You should write here appropriate statements to complete this function.
       Pencil c = new Pencil(xOwner, xColor, xPrice);
       if(xOwner.charAt(0)=='B'){
           
       }
       else{
           addLast(c);
       }
   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(3);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  public Node getNode(int k) {

        int c = 0;
        Node p = head;
        while (c < k && p != null) {
            p = p.next;
            c++;
        }
        return p;
    }
  void insert(int x, Pencil val) {
        Node q = new Node(val);
        Node p = getNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        } else {
            if (p == null) {
                return;
            }
            q.next = p.next;
            p.next = q;
            if (p == tail) {
                tail = q;
            }
        }
    }
  void f2() throws Exception
    {clear();
     loadData(7);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Pencil x, y;
     x = new Pencil("X",1,2);
     y = new Pencil("Y",2,3);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        insert(0, x);
        insert(2, y);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  public void remove(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }
  void f3() throws Exception
   {clear();
    loadData(11);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       remove(1);
       remove(2);


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  public void reverse() {
        int i, j;
        for (i = 0, j = 3; i < j; i++, j--) {
            Node pi = getNode(i);
            Node pj = getNode(j);
            Pencil temp = pi.info;
            pi.info = pj.info;
            pj.info = temp;
        }
    }
  void f4() throws Exception
   {clear();
    loadData(15);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     reverse();


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
