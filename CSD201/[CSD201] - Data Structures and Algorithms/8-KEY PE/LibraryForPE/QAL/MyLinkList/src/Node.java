
public class Node<T> {
    
    T info;
    Node next;
    
    // make a new node where next = give node;
    public Node(T info, Node next){
        this.info = info;
        this.next = next;
    }
    
    //make a new node where next = null
    public Node(T info){
        this(info,null);
    }
}
