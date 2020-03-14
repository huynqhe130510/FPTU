

import java.util.Scanner;

class Node {

    int infor;
    Node next;

    public Node() {
    }

    public Node(int infor, Node next) {
        this.infor = infor;
        this.next = next;
    }
}

public class MyList {

    Node Head, Tail;

    public MyList() {
    }

    public MyList(Node Head, Node Tail) {
        this.Head = Head;
        this.Tail = Tail;
    }

    Boolean isEmpty() {
        return (Head == null);
    }

    void Clear() {
        Head = Tail = null;
    }

    void addHead(int x) {
        if (isEmpty()) {
            Head = Tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            q.next = Head;
            Head = q;
        }
    }

    void addTail(int x) {

        if (isEmpty()) {
            Head = Tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            Tail.next = q;
            Tail = q;
        }
    }

    void addManyHead(int a[]) {
        for (int i = 0; i < a.length; i++) {
            addHead(a[i]);
        }
    }

    void addManyTail(int a[]) {
        for (int i = 0; i < a.length; i++) {
            addTail(a[i]);
        }
    }

    void Traver() {
        Node p;
        p = Head;
        while (p != null) {
            System.out.println("\t" + p.infor);
            p = p.next;
        }
    }

    void DeleteHead() {
        if (isEmpty()) {
            return;
        }
        Head = Head.next;
        if (Head == null) {
            Tail = null;
        }
    }

    void DeleteTail() {
        if (isEmpty()) {
            return;
        }
        if (Head == Tail) {
            Head = Tail = null;
        } else {
            Node p = Head;
            while (p.next != Tail) {
                p = p.next;
            }
            p.next = null;
            Tail = p;
        }
    }

    void deleteRandom(int n, int k) {
        if (k == 1) {
            DeleteHead();
        } else if (k == n) {
            DeleteTail();
        } else {
            int count = 0;
            if (!isEmpty()) {
                Node p = Head;
                Node q = new Node();
                while (p != null) {//tìm vị trí k
                    count++;
                    q = p;
                    if (count == k) {//Nếu tìm thấy thì break
                        break;
                    } else {
                        p = p.next;  //Nếu không tìm thấy thì tiếp tục
                    }
                }
                Node r = Head;
                while (r.next != q) {//tìm vị trí thứ k-1
                    r = r.next;
                }
                r.next = q.next; //gắn k-1 vào k+1
            }
        }
    }
    
    void add_position(int x, int k) {
        Node p = Head;
        int count = 0;
        if (k == 0) {
            addHead(x);
            return;
        }
        while (p != null) {
            count++;
            if (count == k) {
                Node q = new Node(x, null);
                q.next = p.next;
                p.next = q;
            }
            p = p.next;
        }
        if (Tail.next != null) {
            Tail = Tail.next;
        }

    }

    public static void main(String[] args) {
        MyList t = new MyList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of list: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the element of list: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            t.addHead(a[i]);
        }
        System.out.println("The elements of list:");
        t.Traver();
        System.out.println("The position needs to delete: ");
        int k = sc.nextInt();
        t.deleteRandom(n, k);
        System.out.println("The list after delete: ");
        t.Traver();
        System.out.println("Enter the element needs to add: ");
        int b = sc.nextInt();
        System.out.println("In position: ");
        int c = sc.nextInt();
        t.add_position(b, c);
        System.out.println("The list after add: ");
        t.Traver();
    }
}

/*
Viết chương trình để cập nhật 1 danh sách các số nguyên (danh sách được cài đặt dưới dạng linklist). Chương trình gồm các chức năng:
1.Nhập vào danh sách số nguyên
2.Hiển thị
3.Xóa đi 1 phần tử bất kỳ trong danh sách
 */
