
import java.util.*;


class Node {

    int info;
    Node next;

    public Node() {
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
}

class MyStack {

    LinkedList h;

    public MyStack() {
        h = new LinkedList();
    }

    boolean isEmpty() {
        return (h.isEmpty());
    }

    void push(Object x) {
        h.add(x);
    }

    public static void main(String[] args) {
        MyStack s1 = new MyStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of list: ");
        int n = sc.nextInt();
        int sum = 0;
        int[] a = new int[n];
        System.out.println("Enter element of list: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s1.push(a[i]);
            sum += a[i];
        }
        System.out.println("The list: ");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        System.out.println("The sum of list: " + sum);
    }

}
/*Viết 1 danh sách số nguyên stack dưới dạng LinkList
    1.Nhập vào 1 dãy các số nguyên
    2.Hiển thị tất cả các số nguyên đó ra màn hình và tính tổng
 */
