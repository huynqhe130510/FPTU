/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkstack;

import java.util.*;

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

public class LinkStack {

    protected Node head;

    public LinkStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    Object top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (head.info);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = head.info;
        head = head.next;
        return (x);
    }

    public void pushMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            push(a[i]);
        }

    }

    public void popMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + pop());
        }

    }

    public static void main(String[] args) {
        int a[] = {5, 3, 5, 7, 1, 4};
        LinkStack s = new linkstack.LinkStack();
        s.pushMany(a);
        s.popMany(a);
    }

}
