/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList
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

  void loadDataToLast(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

  void loadDataToFirst(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addFirst(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  public void addLast(Person c) {
        //make a new Node where next = null
        Node p = new Node(c);
        if(isEmpty()) head = tail = p;
        else {
            tail.next = p;
            tail = p;
        }
    }
  
  void addLast(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if(xName.startsWith("B")) return;
       //make a new Node where next = null
       Person c = new Person(xName, xAge);
       addLast(c);
   }

  public void addFirst(Person c) {
        //make a new Node where next = null
        Node p = new Node(c);
        if(isEmpty()) head = tail = p;
        else {
            p.next = head;
            head = p;
        }
    }
  
  void addFirst(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if(xName.startsWith("B")) return;
       Person c = new Person(xName, xAge);
       addFirst(c);
   }

//=================================================================
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadDataToLast(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f2() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
     */
     clear();
     loadDataToFirst(1);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void remove(Node p) {
      if(p == null || isEmpty()) return;
      Node f = null, q = head;
      //find the a node before p
      while(q != null && q != p) {
          f = q; q = q.next;
      }
      if(f == null) {//remove head
          head = head.next;
          if(head == null) tail = null;
      }else {
          f.next = p.next;
          if(p == tail) tail = f;
      }
  }
  
  void f3() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);

    
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node p = head;
    while(p != null) {
        if(p.info.age > 4) remove(p);
        p = p.next;
    }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while(p != null && c < k) {
            p = p.next;
            c ++;
        }
        return p;
    }
  public int size() {
        int c = 0;
        Node p = head;
        while(p != null) {
            p = p.next;
            c ++;
        }
        return c;
    }
  void f4() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     int c = 0;
     for(int i = size() - 1; i >= 0; i--) {
         Node p = getNode(i);
         if(p.info.age > 5) {
             c++;
             remove(p);
             if(c >= 2)break;
         }
     }
     
    //-------------------------------------------------------------------------------------
     ftraverse(f123);
     f123.close();
   }

//=================================================================
  
  void f5() throws Exception 
   {clear();
    loadDataToLast(4);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    
    int n = (size() > 3) ? 3: size();
       for (int i = 0; i < n - 1; i++) {
           for (int j = i + 1; j < n; j++) {
               Node pi = getNode(i), pj = getNode(j);
               if(pi.info.name.compareToIgnoreCase(pj.info.name) > 0) {
                   Person t = pi.info; pi.info = pj.info; pj.info = t;
               }
           }
       }
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }


//=================================================================
  void f6() throws Exception 
   {clear();
    loadDataToLast(4);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    int n = size();
       for (int i = n - 4; i < n - 1; i++) {
           for (int j = i + 1; j < n; j++) {
               Node pi = getNode(i), pj = getNode(j);
               if(pi.info.name.compareToIgnoreCase(pj.info.name) > 0) {
                   Person t = pi.info; pi.info = pj.info; pj.info = t;
               }
           }
       }
     
    //--------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  
  public Node getMax() {
        if(isEmpty()) return null;
        Node max = head;
        Node p = head;
        while(p != null) {
            if(p.info.age > max.info.age) max = p;
            p = p.next;
        }
        return max;
    }
  
  public Node getMin() {
        if(isEmpty()) return null;
        Node max = head;
        Node p = head;
        while(p != null) {
            if(p.info.age < max.info.age) max = p;
            p = p.next;
        }
        return max;
    }
  
  void f7() throws Exception  
   {clear();
    loadDataToLast(4);
    String fname = "f7.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node min = getMin(), max = getMax();
     Person t = min.info; min.info = max.info; max.info = t;
     
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  
  void f8() throws Exception 
   {clear();
    loadDataToLast(4);
    String fname = "f8.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node p = head;
     while(p != null && p.info.age != 9) p = p.next;
     if(p == null || p.next == null) return;
     remove(p.next.next);
     
     
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f9() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f9.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    String xName = "C6";
    String yName = "CX";
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    int c = 0;
    Node p = head;
    while(p != null) {
        if(p.info.name.equalsIgnoreCase(xName)) {
            c ++; 
            if(c >= 2) break;
        }
        p = p.next;
    }
    if(p != null) p.info.name = yName; 
     
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

 }
