
import java.util.*;

public class Exer2 {

    boolean CheckTri(double a, double b, double c) {
        if (a + b >= c || a + c >= b || c + b >= a) {
            return true;
        }
        return false;
    }

    double f5(ArrayList<Pointer> a, int type, ArrayList<Pointer> b) {

        double kc = 0;
        int k = 0, q = 0;

        if (type == 0) {
            double min = 0;
            for (int i = 0; i < a.size(); i++) {

                double bpx = Math.pow(a.get(0).getX() - a.get(1).getX(), 2);
                double bpy = Math.pow(a.get(0).getY() - a.get(1).getY(), 2);
                min = Math.sqrt(bpx + bpy);

            }
            while (k < a.size() - 1 || q < a.size()) {
                for (int i = 0; i < a.size() - 1; i++) {
                    for (int j = i + 1; j < a.size(); j++) {
                        double bpx = Math.pow(a.get(i).getX() - a.get(j).getX(), 2);
                        double bpy = Math.pow(a.get(i).getY() - a.get(j).getY(), 2);
                        kc = Math.sqrt(bpx + bpy);
                        q++;
                    }
                    k++;
                    if (min > kc) {
                        min = kc;
                    }

                }
            }
            return min;
        }
        if (type == 1) {
            double max = 0;
            for (int i = 0; i < a.size(); i++) {

                double bpx = Math.pow(a.get(0).getX() - a.get(1).getX(), 2);
                double bpy = Math.pow(a.get(0).getY() - a.get(1).getY(), 2);
                max = Math.sqrt(bpx + bpy);

            }
            while (k < a.size() - 1 || q < a.size()) {
                for (int i = 0; i < a.size() - 1; i++) {
                    for (int j = i + 1; j < a.size(); j++) {
                        double bpx = Math.pow(a.get(i).getX() - a.get(j).getX(), 2);
                        double bpy = Math.pow(a.get(i).getY() - a.get(j).getY(), 2);
                        kc = Math.sqrt(bpx + bpy);
                        q++;
                    }
                    k++;
                    if (max < kc) {
                        max = kc;
                    }

                }
            }
            return max;
        }
        if (type == 2) {
            for (int i = 0; i < a.size() - 1; i++) {
                for (int j = i + 1; j < a.size(); j++) {
                    double bpx = Math.pow(a.get(i).getX() - a.get(j).getX(), 2);
                    double bpy = Math.pow(a.get(i).getY() - a.get(j).getY(), 2);
                    kc = Math.sqrt(bpx + bpy);
                }
            }
            
        }
        return 0;
    }

    void f6(ArrayList<Pointer> a) {
        double  kc =0;
        double  kc1 =0;
        for (int i = 0; i < a.size(); i++) {
            kc = Math.sqrt(Math.pow(a.get(i).getX(), 2)+ Math.pow(a.get(i).getY(), 2));
            for (int j = i+1; j < a.size(); j++) {
                kc1 = Math.sqrt(Math.pow(a.get(j).getX(), 2)+ Math.pow(a.get(j).getY(), 2));
                if(kc > kc1){
                    double  t = kc;
                    kc = kc1;
                    kc1 = t;
                }
                else if(kc == kc1){
                    
                }
            }
            
        }
    }
    
    double f7(ArrayList<Pointer> a){
        double kc =0, sum =0;
        ArrayList b = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
           kc = Math.sqrt(Math.pow(a.get(i).getX(), 2)+ Math.pow(a.get(i).getY(), 2));
           b.add(kc);
        }
        System.out.print("The all distance to (0,0) :" + b);
        System.out.println("");
        Collections.sort(b);
        b.remove(b.size()-1);
        b.remove(b.size()-1);
        for (int i = 0; i < b.size(); i++) {
            sum += (double) b.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Pointer> a = new ArrayList();
        System.out.print("Nhap so phan tu trong list: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(" ");
            System.out.print("Nhap x: ");
            int x = Integer.parseInt(sc.nextLine());
            System.out.print("Enter y: ");
            int y = Integer.parseInt(sc.nextLine());
            a.add(new Pointer(x, y));
            System.out.println("");
        }
        int type = 0;

        System.out.print("Nhap type: ");
        type = Integer.parseInt(sc.nextLine());
        ArrayList b = new ArrayList();
        Exer2 t = new Exer2();
        System.out.println(t.f5(a, type, b));
        t.f5(a, 1, b);
        t.f5(a, 2, b);
        System.out.print("The sum of distance: " + t.f7(a));
    }
}
