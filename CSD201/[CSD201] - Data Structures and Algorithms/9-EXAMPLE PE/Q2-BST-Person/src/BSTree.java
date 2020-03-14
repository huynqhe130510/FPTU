/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {
    
    Node root;
    
    BSTree() {
        root = null;
    }
    
    boolean isEmpty() {
        return (root == null);
    }
    
    void clear() {
        root = null;
    }
    
    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    
    void fvisitBal(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.bal + ") ");
        }
    }
    
    void fvisitLevel(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.level + ") ");
        }
    }
    
    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }
    
    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }
    
    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void breadthBal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitBal(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void breadthLevel(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitLevel(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
    //insertion
    public void insert(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            root = p;
            return;
        }
        //find future father of p called f
        Node f = null, q = root;
        while (q != null) {
            if (q.info.name.equals(x.name)) {
                System.out.println("Insertion failed, duplicated key");
                return;
            }
            if (q.info.name.compareToIgnoreCase(x.name) > 0) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.name.compareToIgnoreCase(x.name) > 0) {
            f.left = p;
        } else {
            f.right = p;
        }
    }
    
    void insert(String xName, int xAge) {
        Person p = new Person(xName, xAge);
        if (!p.name.startsWith("B")) {
            insert(p);
        }
    }
    
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        inOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void deleteByCopy(Node x) {
        if (isEmpty()) {
            return;
        }
        Node p = x;
        if (p == null) {
            return;
        }
        //find f as the father of p
        Node f = null, q = root;//f is the father of q
        while (q != null) {
            if (p == q) {
                break;
            }
            if (q.info.name.compareTo(x.info.name) > 0) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        //p is the leaf -> no left and right child
        if (p.left == null && p.right == null) {
            if (f == null) //remove root
            {
                root = null;
            } else if (f.left == p) //p is left child of f
            {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        //p has one right child 
        if (p.right != null && p.left == null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        //p has one left child 
        if (p.right == null && p.left != null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        //p has both left and right child
        if (p.left != null && p.right != null) {
            Node rp = p.left;
            Node frp = p;//frp is the father of rp
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == p) {
                p.left = rp.left;
            } else {
                frp.right = rp.left;
            }
        }
        
    }
    int count = 0;
    Node secondSmallest;
    //inorder: left, node, right

    void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        count++;
        if (count == 2) {
            secondSmallest = p;
        }
        // visit(p); 
        inorder(p.right);
    }
    
    void f2() throws Exception {
        clear();
        loadData(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");

        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //sau hàm inorder tìm ra node nhỏ nhất  
        //sau hàn inorder-> tìm ra node nhỏ thứ 2
        inorder(root);
        //tìm đến phần tử thứ 2 nhỏ nhất để xóa
        deleteByCopy(secondSmallest);
        //-------------------------------------------------------------------------------------
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    int countNode3(Node node) {
        if (node == null) {
            return 0;
        }
        //node có 2 con -
        if (node.left != null && node.right != null) {
            return 0 + countNode3(node.left) + countNode3(node.right);
        } else if (node.left == null && node.right == null) {
            return 0 + countNode3(node.left) + countNode3(node.right);
        }
        
        return 1 + countNode3(node.left) + countNode3(node.right);
    }
    
    void f3() throws Exception {
        clear();
        loadData(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        k = countNode3(root);
        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }

//===============================================================
    int countNode4(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.right != null && node.left != null) {
            return 1 + countNode4(node.left) + countNode4(node.right);
        } else {
            return 0 + countNode4(node.left) + countNode4(node.right);
        }
        
    }

    void f4() throws Exception {
        clear();
        loadData(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        k = countNode4(root);
        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }

//===============================================================
    // Finding node with min value
    public Node findMinimum(Node node) {
        if (node.left != null) {
            return findMinimum(node.left);
        }
        return node;
    }

    // Finding node with max value    
    public Node findMaximum(Node node) {
        if (node.right != null) {
            return findMaximum(node.right);
        }
        return node;
    }

//   	public Person getMaxPerson(){
//        if(isEmpty()) return null;
//        Person max = head.info;                
//        Node p = head;
//        while( p != null){
//            if(p.info.age > max.age) max = p.info;
//            p = p.next;
//        }
//        return max; 
//    }
    void f5() throws Exception {
        clear();
        loadData(1);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        Node node = findMaximum(root);
        node.info.age++;
        //-------------------------------------------------------------------------------------
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    //inorder: left, node, right
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.age >= 4) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
    
    void f6() throws Exception {
        clear();
        loadData(1);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void f7() throws Exception {
        clear();
        loadData(5);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node node1 = findMaximum(root);
        deleteByCopy(node1.left);
        //-------------------------------------------------------------------------------------
        breadth(root, f123);
        f123.close();
    }

//===============================================================
    Node rotateLeft(Node p) {
        if (p.right == null) {
            return p;
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
 
//    Node parent(Node x) {
//        if (x == null || x == root) return null;
//        Node p = null, q = root;
//        while(q != null) {
//            p = q;
//            if (q.info.name.compareTo(x.info.name) >0) q = q.left;
//            else q = q.right;
//            if (q.info == x.info) return p;
//        }
//        return null;
//    }
    void f8() throws Exception {
        clear();
        loadData(5);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        root.left = rotateLeft(root.left);
        //-------------------------------------------------------------------------------------
        breadth(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
   
    int count1 = 0;//traversal tree by bft
    void bft2(Node p) {
        if(p == null) return;
       
        MyQueue mq = new MyQueue();
        mq.enqueue(p);
        while(!mq.isEmpty()) {
            Node q = (Node)mq.dequeue();
            if(q.left != null) mq.enqueue(q.left);
            if(q.right != null) mq.enqueue(q.right);
            //visit(q);
            if (q.info.age>=5) 
                count1++;
                if (count1 == 2) {
                    q.info.age = 10;
                    break;
                
            }

        }
    }
    void f9() throws Exception {
        clear();
        loadData(5);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        bft2(root);
        //-------------------------------------------------------------------------------------
        breadth(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }
    
}
