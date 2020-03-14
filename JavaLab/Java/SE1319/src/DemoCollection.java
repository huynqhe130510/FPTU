
import java.util.*;
class Mysort implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int kt=0;
        
        if(o1 instanceof Integer && o2 instanceof Double) kt =1;
        if(o2 instanceof Integer && o1 instanceof Double) kt =-1;
        if(o2 instanceof Integer && o1 instanceof Integer)
            kt= Integer.compare((int)o1, (int)o2);
        if(o2 instanceof Double && o1 instanceof Double)
            kt= -Double.compare((double)o1, (double )o2);
        return kt;
    }
    
}

public class DemoCollection {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        TreeSet v= new TreeSet(new Mysort());
        System.out.println("Nhap vao kich thuoc cua vector");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int x = rd.nextInt(10);
            if(rd.nextInt()%2==0)
            v.add(x);
            else v.add(x*1.0);
        }
        System.out.println(v);
//        BaitapVN bt = new BaitapVN();
//        bt.f1((List<Integer>) v,7);
//        System.out.println("OUTPUT");
//        System.out.println(v);
//        System.out.println("OUTPUT f2");
//        System.out.println(bt.f2((List<Integer>) v,5));
//        Collections.sort(v);
//        System.out.println(v);
//        Collections.reverse(v);
//        System.out.println(v);
//        ArrayList ar = new ArrayList();
//        ar.add("Hello");
//        ar.add(true);
//        ar.add(10.0);
//        ar.add(5);
//        ar.add('a');
//        System.out.println("OUTPUT");
//        System.out.println(ar);
//        System.out.println("OutPut by individual element");
//        for (int i = 0; i < ar.size(); i++) {
//            System.out.println(ar.get(i));
//        }
//        Vector vec = new Vector();
//        vec.add("Xin chao");
//        vec.add(50);
//        vec.add(50);
//        vec.addAll(vec);
//        System.out.println(ar.retainAll(vec));       
    }
}
