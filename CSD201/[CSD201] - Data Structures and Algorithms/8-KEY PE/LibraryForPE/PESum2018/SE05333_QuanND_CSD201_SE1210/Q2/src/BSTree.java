/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

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
        BQueue q = new BQueue();
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

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xColor, int xPrice) {//You should insert here statements to complete this function
        Pencil c = new Pencil(xOwner, xColor, xPrice);
        if (xOwner.charAt(0) == 'B') {

        } else {
            Node p = new Node(c);
            if (isEmpty()) {
                root = p;
                return;
            }
            //find future father of p calles f
            Node f = null, q = root;
            while (q != null) {
                if (q.info.color ==p.info.color) {
                    //System.out.println("Insertion falied, duplicated key");
                    return;
                }
                if (q.info.color > p.info.color) {
                    f = q;
                    q = q.left;

                } else {
                    f = q;
                    q = q.right;
                }
            }
            if (f.info.color > p.info.color) {
                f.left = p;
            } else {
                f.right = p;
            }
        }

    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(2);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if(p.info.price>2) fvisit(p, f);
    }

    void f2() throws Exception {
        clear();
        loadData(6);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            //System.out.println("Key dose not exists");
            return;
        }
        // find node f where f is father of p
        Node f = null, q = root;
        while (q != p) {
            if (q.info.color > p.info.color) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        //1.p is a leaf(no child)
        if (p.left == null && p.right == null) {
            if (f == null) { // a bst has a node only
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }

        } //2. p has a left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left; //remove root
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } //3. p has a right child only
        else if (p.right != null && p.left == null) {
            if (f == null) {
                root = p.right; //remove root
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        } //4. p has both left and right child
        else if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }

        }

    }
    void breadthf3(Node p) {
        int countf3=0;
        if (p == null) {
            return;
        }
        BQueue q = new BQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.info.color<5) countf3++;
            if(countf3==2) {
                deleteByCopy(r);
                return;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    void f3() throws Exception {
        clear();
        loadData(10);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        breadthf3(root);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node father(Node x) // return the father of the node q, where q.info.price = xPrice
    {
        int xS = x.info.color;
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.color == xS) {
                break;
            }
            f = p;
            if (xS < p.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }
     public Node rotateRight(Node p){
        if(p==null||p.left == null) return p;
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
    
     void breadthf4(Node p) {
        int countf4=0;
        if (p == null) {
            return;
        }
        BQueue q = new BQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.info.color<6) countf4++;
            if(countf4==2&&r.left!=null){
                Node qf4 = father(r);
                if(qf4==null) root=rotateRight(root);
                else{
                    if(qf4.left.info.color==r.info.color) qf4.left=rotateRight(r);
                    else qf4.right = rotateRight(r);
                }
                return;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    void f4() throws Exception {
        clear();
        loadData(14);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        breadthf4(root);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
