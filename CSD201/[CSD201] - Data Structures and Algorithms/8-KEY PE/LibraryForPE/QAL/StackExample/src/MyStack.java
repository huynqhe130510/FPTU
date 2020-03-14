
public class MyStack {

    Node head;

    //ctor
    public MyStack() {
        head = null;
    }

    //return true if stack is empty, ortherwisr return false
    public boolean isEmpty() {
        return head == null;
    }

    //push an item to the top
    public void push(Object info) {
        Node p = new Node(info);
        if (isEmpty()) {
            head = p;
        } else {
            p.next = head;
            head = p;

        }
    }

    //pop: get and remove an item on the top
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object info = head.info;
        Node p = head;
        head = head.next;
        p.next = null;
        return info;
    }

    //top: get an item on the top
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        Object info = head.info;

        return info;
    }
    //clear: empty the stack
    public void clear(){
        head = null;
    }

}
