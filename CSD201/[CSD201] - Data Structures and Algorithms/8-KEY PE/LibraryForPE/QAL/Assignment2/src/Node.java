
public class Node {
    Book info;
    Node left, right;

    public Node(Book x, Node left, Node right) {
        this.info = x;
        this.left = left;
        this.right = right;
    }

    public Node(Book x) {
        this(x,null,null);
    }

    
}
