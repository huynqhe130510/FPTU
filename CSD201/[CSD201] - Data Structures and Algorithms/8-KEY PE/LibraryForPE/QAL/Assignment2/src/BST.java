
import java.io.FileReader;
import java.io.LineNumberReader;


public class BST {
   
    Node root;
    
    public BST() {
        root = null;
    }

    //return true if BSTree is empty, ...
    public boolean isEmpty() {
        return root == null;
    }
    //insertion
    public void insert(Book x) {
        Node p = new Node(x);
        if (isEmpty()) {
            root = p;
            return;
        }

        //find future father of p calles f
        Node f = null, q = root;
        while (q != null) {
            if (q.info.code.equalsIgnoreCase(x.code)) {
                System.out.println("Insertion falied, duplicated key");
                return;
            }
            if (q.info.code.compareToIgnoreCase(x.code) > 0) {
                f = q;
                q = q.left;

            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.code.compareToIgnoreCase(x.code) > 0) {
            f.left = p;
        } else {
            f.right = p;
        }
    }
    
      //load book to list
    public void load() throws Exception {
        LineNumberReader lnr = null;
        lnr = new LineNumberReader(new FileReader("Book.txt"));
        String s;
        while ((s = lnr.readLine()) != null) {
            if (s.equals("")) {
                continue;
            }
            String[] st = s.split("-");
            String code = st[0].trim();
            String name = st[1].trim();
            String author = st[2].trim();
            double price = Double.valueOf(st[3].trim());
            Book b = new Book(code, name, author, price);
            insert(b);
        }
        if (lnr != null) {
            lnr.close();
        }
    }
    
    
    
    
    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.printf("%-10s%-20s%-20s%-10.1f\n", p.info.code, p.info.name, p.info.author, p.info.price);
    }
    
     public void bfs() {
        Node p = root;
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
     
    public void searchByCode (String xCode){
        Node p = root;
        boolean k = false;
        System.out.printf("%-10s%-20s%-20s%-10s\n", "Code", "Name", "Author", "Price");
        while (p != null) {
            if (p.info.code.trim().equalsIgnoreCase(xCode.trim())) {
                k = true;
                System.out.printf("%-10s%-20s%-20s%-10.1f\n", p.info.code, p.info.name, p.info.author, p.info.price);
            }
            if(p.info.code.trim().compareToIgnoreCase(xCode.trim()) > 0){
                p = p.left;
            }
            else p = p.right;
        }
        if (k == false) {
            System.out.println("\n\tnot found");
        }

    }
    

    
    public Node search(Node p, String xCode) {
        if (p == null) {
            return null;
        }
        if (p.info.code.trim().equalsIgnoreCase(xCode.trim())) {
            return p;
        }
        if (p.info.code.trim().compareToIgnoreCase(xCode.trim()) > 0) {
            return search(p.left, xCode);
        } else {
            return search(p.right, xCode);
        }
    }

    public Node search(String xCode) {
        return search(root, xCode);
    }
    
    public void deleteByCopy(String xCode) {
        if (isEmpty()) {
            return;
        }
        Node p = search(xCode);
        if (p == null) {
            System.out.println("Key dose not exists");
            return;
        }
        // find node f where f is father of p
        Node f = null, q = root;
        while (q != p) {
            if (q.info.code.compareToIgnoreCase(xCode) > 0) {
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
            p.info.code = rp.info.code;
            if (f == null) {
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }

        }

    }
    
    public void update(String xCode, double xPrice){
        Node p = search(xCode);
        if(p != null){
            p.info.price = xPrice;
        }
        else{
            System.out.println("");
            System.out.println("xCode not exits");
            
        }
    }
}
