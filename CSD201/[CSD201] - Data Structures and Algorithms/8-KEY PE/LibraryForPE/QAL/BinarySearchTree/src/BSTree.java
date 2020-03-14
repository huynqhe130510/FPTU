
import java.util.ArrayList;

public class BSTree {

    Node root;
    //create an empty BSTree

    public BSTree() {
        root = null;
    }

    //return true if BSTree is empty, ...
    public boolean isEmpty() {
        return root == null;
    }

    //visit a Node
    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
    }

    //breadth - first traversal
    public void bfs(Node p) {
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
            visit(q);
        }
    }
    //count Node
    public int countNode(Node p){
        int k = 0;
        if (p == null) {
            return 0;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            if (q.left != null) {
                m.enqueue(q.left);
               
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
            k++;
        }
        return k;
    }
        public Node findNodeMax(Node p) { // Node phải nhất
        if (p.right == null) {
            return p;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    //depth - first traversal - preorder
    public void preoder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preoder(p.left);
        preoder(p.right);

    }
    //depth - first traversal - inorder

    public void inoder(Node p) {
        if (p == null) {
            return;
        }

        inoder(p.left);
        visit(p);
        inoder(p.right);

    }

    //insertion
    public void insert(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            root = p;
            return;
        }

        //find future father of p calles f
        Node f = null, q = root;
        while (q != null) {
            if (q.info == x) {
                System.out.println("Insertion falied, duplicated key");
                return;
            }
            if (q.info > x) {
                f = q;
                q = q.left;

            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info > x) {
            f.left = p;
        } else {
            f.right = p;
        }
    }

    //search
    public Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (p.info > x) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    public Node search(int x) {
        return search(root, x);
    }

    //count the numbers of node
    public int count() {
        int c = 0;
        Node p = root;
        if (isEmpty()) {
            return c;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (p != null) {
            Node q = (Node) m.dequeue();
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
            c++;
        }
        return c;
    }
    //Deletion: remove from a BST, a node which key = x

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
            if (q.info > p.info) {
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

    public void deleteByMerging(int x) {
        if (isEmpty()) {
            return;
        }
        Node p = search(x);
        if (p == null) {
            //System.out.println("Key dose not exists");
            return;
        }
        // find node f where f is father of p
        Node f = null, q = root;
        while (q != p) {
            if (q.info > x) {
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
            //tìm node lớn nhất bên cây con trái(q) của p
            q = p.left;
            Node t = null;// t  là cha của q
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node r = p.right;
            q.right = r;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }

        }

    }

    //copy all nodes to tree by inorder traversal
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //balance tree
    public void balance(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last) /2;
        int x =((Node)a.get(m)).info;
        insert(x);
        balance(a, first,m-1);
        balance(a, m+1, last);
        
    }
    
    public void banlance(Node p){
        ArrayList a = new ArrayList();
        buildArray(a, p);
        BSTree b = new BSTree();
        b.balance(a, 0, a.size()-1);
        root = b.root;
    }
    
    //balance: rotate left
    public Node rotateLeft(Node p){
        if(p==null||p.right == null) return p;
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
    //balance: rotate right
    public Node rotateRight(Node p){
        if(p==null||p.left == null) return p;
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
    
    public int height(Node p){
        if(p == null) return 0;
        int l = height(p.left) +1;
        int r = height(p.right) +1;
        return (l > r) ? l : r;
    }
    public int balanceFactor(Node p){
        return (height(p.right) - height(p.left));
    }
    Node father(Node x) // return the father of the node q, where q.info.price = xPrice
    {
        int xS = x.info;
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == xS) {
                break;
            }
            f = p;
            if (xS < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }
    int level(Node x) {      
        int count = 1;
        Node f, p;
        f = null;
        p = root;
        while (true) {
            if (p.info==x.info) {
                break;
            }
            f = p;
            if (x.info<p.info) {
                p = p.left;
                count++;
            } else {
                p = p.right;
                count++;
            }
        }
        return count;
    }
    Node findNodeMin(Node p){
        if(p.left==null){
            return p;
        }
        while(p.left!=null){
            p=p.left;
        }
        return p;
    }
}
