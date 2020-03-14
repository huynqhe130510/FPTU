
import java.io.FileReader;
import java.io.LineNumberReader;
import javafx.util.converter.PercentageStringConverter;

public class MyList {

    //a list of Nodes
    Node head, tail;

    //ctor
    public MyList() {
        head = tail = null;
    }

    //1. return true if list is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //2. insertion: insert a Color to the end of list O(1)
    public void addLast(Book c) {
        Node p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //3. insertion: insert a Color to the beginning of list  O(1)
    public void addFist(Book c) {
        Node p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //4. traversal a list 
    public void traversal() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    //5. remove a Node at position k, starting position is 0; O(n)
    public void remove(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    //6. get a Node at position k
    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (c < k && p != null) {
            p = p.next;
            c++;
        }
        return p;
    }

    //7. count number of nodes in the list
    public int size() {
        int c = 0;
        Node p = head;
        while (p != null) {
            p = p.next;
            c++;
        }
        return c;
    }

    public void addAfterPs(int k, Book b) {
        Node p = new Node(b);
        if (isEmpty()) {
            return;
        }
        Node r = getNode(k);
        if (r == tail) {
            r.next = p;
            tail = p;
        } else {
            Node q = getNode(k + 1);
            r.next = p;
            p.next = q;
        }

    }

//8. reverse the list
    public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);
            Node pj = getNode(j);
            Book temp = pi.info;
            pi.info = pj.info;
            pj.info = temp;
        }
    }

    //11. search: return the first Node which color name = given color name - 
    // return null if given color name does not exists in the list
    public void searchByName(String xName) {
        Node p = head;
        boolean k = false;
        System.out.printf("%-10s%-20s%-20s%-10s\n", "Code", "Name", "Author", "Price");
        while (p != null) {
            if (p.info.name.trim().equalsIgnoreCase(xName.trim())) {
                k = true;
                System.out.printf("%-10s%-20s%-20s%-10.1f\n", p.info.code, p.info.name, p.info.author, p.info.price);
            }
            p = p.next;
        }
        if (k == false) {
            System.out.println("\n\tnot found");
        }

    }

    public int getByName(String xName) {
        Node p = head;
        int c = 0;
        while (p != null) {
            if (p.info.name.trim().equalsIgnoreCase(xName.trim())) {
                break;
            }

            p = p.next;
            c++;
        }
        return c;

    }

    public int getByCode(String xCode) {
        Node p = head;
        int c = 0;
        while (p != null) {
            if (p.info.code.trim().equalsIgnoreCase(xCode.trim())) {
                break;
            }

            p = p.next;
            c++;
        }
        return ++c;

    }

    public int getByPrice(double xPrice) {
        Node p = head;
        int c = 0;
        while (p != null) {
            if (p.info.price > xPrice) {
                break;
            }

            p = p.next;
            c++;
        }
        return ++c;

    }

    public void sortByCode() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = i + 1; j < size(); j++) {

                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.code.compareToIgnoreCase(pj.info.code) > 0) {
                    Book temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;

                }
            }
        }
    }

    public void sortByCode3() {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {

                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.code.compareToIgnoreCase(pj.info.code) < 0) {
                    Book temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;

                }
            }
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
            addLast(b);
        }
        if (lnr != null) {
            lnr.close();
        }
    }

}
