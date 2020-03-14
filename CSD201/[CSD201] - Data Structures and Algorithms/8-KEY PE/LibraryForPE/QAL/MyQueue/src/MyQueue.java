
public class MyQueue {

    Node head, tail;

    //ctor
    public MyQueue() {
        head = tail = null;
    }

    //isEmpty
    public boolean isEmpty() {
        return head == null;
    }

    //enqueue: add element in the last 
    public void enqueue(Object info) {
        Node p = new Node(info);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //dequeue: get and remove element in the top
    public Object dequeue() {
        if(isEmpty()) return null;
        Node p = head;
        head = head.next;
        p.next = null;
        return p.info;
    }
    
    //front: get element in the top
    public Object front() {
        if(isEmpty()) return null;
        Object info = head.info;
        return info;
        
    }
    //clear the queue
    public void clear(){
        head = tail = null;
    }


}
