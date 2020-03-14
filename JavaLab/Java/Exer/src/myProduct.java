
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class myProduct implements iProduct {

    boolean check(Product p, double x) {
        return p.amount * p.price < x;
    }

    @Override
    public void f1(List<Product> a, double totalPrice) {
        ArrayList<Product> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (check(a.get(i), totalPrice)) {
                b.add(a.get(i));
            }
        }
        Collections.sort(b, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getAmount() * o1.getPrice() > o2.getAmount() * o2.getPrice() ? 1 : -1;
            }
        });
        int k=0;
        for (int i = 0; i < a.size(); i++) {
            if(check(a.get(i), totalPrice)){
                a.set(i, b.get(k++));
            }
        }
    }

    @Override
    public Product f2(List<Product> a, double totalPrice) {
        int p =0;
        for (int i = 0; i < a.size(); i++) {
            double x = Math.abs(a.get(p).getAmount()*a.get(p).getPrice() - totalPrice);
            double y = Math.abs(a.get(i).getAmount()*a.get(i).getPrice() - totalPrice);
            if(y <x){
                p =i;
            }
        }
        return a.get(p);
    }

    public static void main(String[] args) {

        System.out.print("Enter number of product:");
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> v = new ArrayList();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Enter amount: ");
            int amount = Integer.parseInt(sc.nextLine());
            v.add(new Product(name, price, amount));
            System.out.println("");
        }
        myProduct mp = new myProduct();
        System.out.print("Enter totalprice: ");
        double rp = Double.parseDouble(sc.nextLine());
        System.out.println("OUTPUT:");
        mp.f1(v, rp);
        System.out.println(v);
        System.out.println(mp.f2(v, rp));
    }
}
