package queuedemo;

class Node {

    public Object info;
    public Node next;

    public Node(Object x, Node p) {
        info = x;
        next = p;
    }

    public Node(Object x) {
        this(x, null);
    }
}

public class MyQueue {

    protected Node head, tail;

    MyQueue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (x);
    }

    void enqueue(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void enqueueMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            enqueue(a[i]);
        }
    }
    
    void dequeMany(int a[]) throws Exception {
        for (int i = 0; i < a.length; i++) {
            System.out.println("\t" + dequeue());
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue mq = new MyQueue();
        int a[] = {1, 4, 6, 3, 8, 9};
        mq.enqueueMany(a);
        mq.dequeMany(a);
    }
}

/*
    Xây dựng 1 dãy số nguyên dạng Queue bằng Linklist sau đó hiển thị ra màn hình
 */
