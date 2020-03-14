/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlinklist;

/**
 *
 * @author Admin
 */
class Node {

    int info;
    Node next;

    Node() {
    }

    Node(int x, Node p) {
        info = x;
        next = p;
    }

    Node(int x) {
        this(x, null);
    }
}

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

    void addtail(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void add_head(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    void addMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            addtail(a[i]);
        }
    }

    void addMany_head(int[] a) {
        for (int i = 0; i < a.length; i++) {
            add_head(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);//ho?c System.out.print(p.info + "  ");
            p = p.next;
        }
    }

    void sort() {
        Node pi, pj;
        int t;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info < pi.info) {
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    void delete_head() {
        Node pi;
        int t;
        pi = head;
        if (isEmpty()) {
            return;
        }
        pi = head.next;
        head = pi;

    }

    void delete_tail() {
        Node temp;
        int t;
        temp = head;
        if (isEmpty()) {
            return;
        }
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;

    }

    int search_one(int x) {
        Node p, temp;
        if (isEmpty()) {
            return (-1);
        }
        temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.info == x) {
                return (count);
            }
            temp = temp.next;
            count++;
        }
        return (-1);
    }

    int Delte(int x) {
        Node p, temp;
        if (isEmpty()) {
            return (-1);
        }
        temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.info == x) {
                temp = temp.next;
            }
        }
        return (-1);
    }
}

public class InLinkList {

    public static void main(String[] args) {
        MyList t = new MyList();
        int[] a = {7, 2, 9, 8, 6, 3};
        t.addMany_head(a);
        System.out.println("\n Before sorting:");
        t.traverse();
//    System.out.println("\n After sorting:");  
//    t.sort();
//    t.traverse();
//    System.out.println("\n Vị trí cần cần tìm"+t.search_one(8));
//    t.Delte(7);
//    t.traverse();

        /*
    t.delete_head();
     System.out.println("\n After Delete:");  
     t.traverse();
     t.delete_tail();
     System.out.println("\n After Delete:");  
     t.traverse();*/
        System.out.println();
    }
}
