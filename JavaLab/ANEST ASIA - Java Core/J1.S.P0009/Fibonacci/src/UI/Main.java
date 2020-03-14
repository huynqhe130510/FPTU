
import Business.Fibo;

public class Main {

    public static void main(String[] args) {
        int []a = Fibo.fib(45);
        System.out.println("The 45 sequence fibonacci: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
