
public class MyList {

    //a list of Nodes
    Node<People> head, tail;

    //ctor
    public MyList() {
        head = tail = null;
    }

    //1. return true if list is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //2. insertion: insert a People to the end of list O(1)
    public void addLast(People c) {
        Node<People> p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //3. insertion: insert a People to the beginning of list  O(1)
    public void addFrist(People c) {
        Node<People> p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //4. traversal a list 
    public void traversal() {
        Node<People> p = head;
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
            Node<People> p = head;
            head = head.next;
            p.next = null;
        } else {
            Node<People> p = getNode(k);
            if (p == null) {
                return;
            }
            Node<People> q = getNode(k - 1);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    void remove(Node p) {
        if (p == null || isEmpty()) {
            return;
        }
        Node f = null, q = head;
        //find the a node before p
        while (q != null && q != p) {
            f = q;
            q = q.next;
        }
        if (f == null) {// remove head
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            f.next = p.next;
            if (p == tail) {
                tail = f;
            }
        }
    }

    //6. get a Node at position k
    public Node<People> getNode(int k) {

        int c = 0;
        Node<People> p = head;
        while (c < k && p != null) {
            p = p.next;
            c++;
        }
        return p;
    }

    //7. count number of nodes in the list
    public int size() {
        int c = 0;
        Node<People> p = head;
        while (p != null) {
            p = p.next;
            c++;
        }
        return c;
    }

    //8. reverse the list
    public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node<People> pi = getNode(i);
            Node<People> pj = getNode(j);
            People temp = pi.info;
            pi.info = pj.info;
            pj.info = temp;
        }
    }

    //9. sort the list ascending by age
    public void sort() {
        Node<People> pi, pj;
        pi = head;
        int c = 0;
        while (pi != null) {

            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    People temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                    c++;
                    if (c == 3) {
                        return;
                    }

                }
                pj = pj.next;
            }
            pi = pi.next;
        }

    }

    public void sort1() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = i + 1; j < size(); j++) {

                Node<People> pi = getNode(i);
                Node<People> pj = getNode(j);
                if (pi.info.age > pj.info.age) {
                    People temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;

                }
            }
        }
    }

    //10. remove the second biggest color age in the list
    public void removeSecond() {
        People firstMax = getMaxPeople();
        if (firstMax == null) {
            return;
        }
        if (size() <= 1) {
            return;
        }
        int imax = 0;
        Node<People> p = head;
        while (p != null && p.info.age == firstMax.age) {
            imax++;
            p = p.next;
        }
        //find second max starting from imax
        People secondMax = (p != null) ? p.info : null;
        for (int i = 0; i < size() - 1; i++) {
            if (getNode(i).info.age > secondMax.age && getNode(i).info.age != firstMax.age) {
                imax = i;
                secondMax = getNode(i).info;
            }
        }
        if (imax < size()) {
            remove(imax);
        }
    }

    //11. search: return the first Node which color name = given color name - 
    // return null if given color name does not exists in the list
    public Node<People> search(String xName) {
        Node<People> p = head;
        while (p != null) {
            if (p.info.name.equalsIgnoreCase(xName)) {
                break;
            }
            p = p.next;
        }

        return p;
    }

    //0. helper: return the first biggest color age node in the list 
    public People getMaxPeople() {
        if (isEmpty()) {
            return null;
        }
        People max = head.info;
        Node<People> p = head;
        while (p != null) {
            if (p.info.age > max.age) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

    public Node<People> getMax() {
        if (isEmpty()) {
            return null;
        }
        Node<People> max = head;
        Node<People> p = head;
        while (p != null) {
            if (p.info.age > max.info.age) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }

    public Node getSecondMax() {
        int count = 0;
        Node<People> p = head;
        while (p != null) {
            if (p.info.age == getMaxPeople().age) {
                count++;
            }
            if (count == 2) {
                break;
            }
            p = p.next;
        }
        return p;
    }

    //Insert after xth index of the list
    void insert(int x, People val) {
        Node<People> q = new Node(val);
        Node<People> p = getNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        } else {
            if (p == null) {
                return;
            }
            q.next = p.next;
            p.next = q;
            if (p == tail) {
                tail = q;
            }
        }
    }
    void traverseFromTo(int h, int k) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (count>=h && count<=k) {
                System.out.println(p.info);
            } // You will use this statement to write information of the node p to the file
            p = p.next;
            count++;
        }
    }
}
