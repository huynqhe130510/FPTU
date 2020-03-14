
public class Node {
    
    Object info;
    Node next;

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Object info) {
        this(info, null);
    }
    
    
}
