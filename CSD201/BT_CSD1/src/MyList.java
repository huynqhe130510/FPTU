
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node r = q.next;
        Node u = new Node(x, r);
        q.next = u;
        if (tail == q) {
            tail = u;
        }
    }

    // (5)
    void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        insertAfter(f, x);
    }

    // (6)
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void dele(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = head;
        }
    }

    // (7)
    void dele(String xName) {
        Node q = searchByName(xName);
        dele(q);
    }

    Node searchbyAge(int xAge) {
        Node q = head;
        while (q != null) {
            if (q.info.age == xAge) {
                return q;
            }
            q = q.next;
        }
        return (null);
    }
    // (8)

    void dele(int xAge) {
        Node q = searchbyAge(xAge);
        dele(q);
    }

    // (9)
    void deleAll(int xAge) {
        Node q;
        while (true) {
            q = searchbyAge(xAge);
            if (q == null) {
                break;
            }
            dele(q);
        }
    }

    // (10)
    Node pos(int k) {
        int i = 0;
        Node q = head;
        while (q != null) {
            if (i == k) {
                return q;
            }
            i++;
            q = q.next;
        }
        return (null);
    }

    // (11)
    void delePos(int k) {
        Node q = pos(k);
        dele(q);
    }

    // (12)
    void sortByName() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (14)
    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            p = p.next;
            i++;
        }

        return (i);
    }

    // (15)
    Person[] toArray() {
        int n = size();
        Person[] a = new Person[n];
        int i = 0;
        Node p = head;
        while (p != null) {
            a[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return (a);
    }

    // (16)
    void reverse() {
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(new Person(p.info.name, p.info.age));
            p = p.next;
        }
        head = t.head;
        tail = t.tail;
    }

    // (17) 
    Node findMaxAge() {
        if (isEmpty()) {
            return (null);
        }
        Node q, p;
        q = p = head;
        int xMax = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age > xMax) {
                xMax = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) {
            return (null);
        }
        Node q, p;
        q = p = head;
        int xMin = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age < xMin) {
                xMin = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (19) 
    void setData(Node p, Person x) {
        if (p == null) {
            return;
        }
        p.info = x;
    }

    // (20) 
    void sortByAge(int k, int h) {
        if (k >= h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (k > n - 1) {
            k = n - 1;
        }
        Node pi, pj;
        Person x;
        Node pk, ph;
        pk = pos(k);
        ph = pos(h + 1);
        pi = pk;
        while (pi != ph) {
            pj = pi.next;
            while (pj != ph) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
        int n = size();
        if (k >= h) {
            return;
        }
        if (k < 0 || h > n - 1) {
            return;
        }
        Person[] a = toArray();
        int i, j;
        Person x;
        i = k;
        j = h;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }
}
