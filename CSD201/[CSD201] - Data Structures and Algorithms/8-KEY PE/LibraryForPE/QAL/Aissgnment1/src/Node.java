
public class Node {
    
    Book info;
    Node next;
    
    // make a new node where next = give node;
    public Node(Book info, Node next){
        this.info = info;
        this.next = next;
    }
    
    //make a new node where next = null
    public Node(Book info){
        this(info,null);
    }
}
