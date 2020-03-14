
import java.util.List;
import java.util.Collections;
import java.util.TreeSet;

public class BaitapVN {

    private static boolean IsPrimeNumber(int k) {
        if (k < 2) {
            return false;
        } else {
            int root = (int) Math.sqrt(k);
            for (int i = 2; i <= root; i++) {
                if (k % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void f1(List<Integer> v, int type) {
        int max = 0;
        int IndexOfMax = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) > max) {
                max = v.get(i);
                IndexOfMax = i;
            }
        }
        if (type == 1) {
            v.remove(IndexOfMax);
        }
        if (type == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (v.get(i) > v.get(j)) {
                        int temp = v.get(j);
                        v.set(j, v.get(i));
                        v.set(i, temp);
                    }
                }
            }
        }
        if (type == 3) {
            v.set(IndexOfMax, 99);
        }
        if (type == 4) {
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    if (v.get(j) == v.get(i)) {
                        v.remove(j);
                        j--;
                    }
                }
            }
        }
        if (type == 5) {
            TreeSet t = new TreeSet();
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    if (v.get(i) == v.get(j)) {
                        t.add(v.get(i));
                    }
                }
            }
            v.clear();
            v.addAll(t);
        }
        if (type == 6) {
            int count = 0;
            for (int i = 0; i < v.size(); i++) {
                if (IsPrimeNumber(v.get(i)) == true) {
                    count++;
                }
                if (count == 2) {
                    v.remove(v.get(i));
                }
            }
        }
        if (type == 7) {
            int count = 0;
            for (int i = 0; i < v.size(); i++) {
                if (IsPrimeNumber(v.get(i)) == true) {
                    v.remove(v.get(i));
                    count++;    
                    i--;
                }
                if (count ==2 ) {
                    break;
                }
                
            }
        }

        //1.xoa bo phan tu lon nhat ( be nhat) dau tien (cuoi cung) trong list
        //2. sort 5 phan tu dau tien cua list theo thu tu tang dan
        //3. thay the gia tri lon nhat bang 99
        //4. xoa bo tat ca cac phan tu la duplicate
        //5. chi giu lai cac phan tu la duplicate
        //6. xoa bo phan tu thu 2 la so nguyen to trong list
        //7. xoa bo 2 phan tu nguyen to dau tien
    }

    int f2(List<Integer> v, int type) {
        int sum = 0;
        if (type == 1) {
            int max = v.size();
            int min = v.size();
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) > max) {
                    max = v.get(i);
                }
                if (v.get(i) < min) {
                    min = v.get(i);
                }
                sum = max + min;
            }

        }
        if (type == 2) {
            int kq = 0;
            int max = v.size();
            int min = v.size();
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) > max) {
                    max = v.get(i);
                }
                if (v.get(i) < min) {
                    min = v.get(i);
                    if (min == 0) {
                        min += 1;
                    }
                }
            }
            return kq = max + min;
        } else if (type == 3) {
            int SumNotDup = 0;
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    if (v.get(j) == v.get(i)) {
                        v.remove(j);
                        j--;
                    }
                }
            }
            for (int i = 0; i < v.size(); i++) {
                SumNotDup += v.get(i);
            }
            return SumNotDup;

        } else if (type == 4) {
            int SumDup = 0;
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    if (v.get(j) == v.get(i)) {
                        SumDup = v.get(i) + v.get(j);
                    }
                }
            }
            return SumDup;
        } 
        else if (type == 5) {
            for (int i = 0; i < v.get(i); i++) {
                if(v.get(i) > v.get(i)+1)
                    return -1;
                else 
                   return 0;
            }
            return 1;
        }
        return sum;
    }

    
}
//1. tinh tong 2 chu so lon nhat, be nhat trong list voi dieu kien khong lam thay doi thu tu cua list
//2. tong,hieu, nhan , chia phan tu lon nhat va be nhat trong list, neu phan tu be nhat la 0 thi set kq lam max +1
//3. tim tong cac phan tu khong phai la duplicate
//4. tinh tong ca phan tu la duplicate
//5. kiem tra list da sort chua, neu chua thi tra ve 0, neu tang dan thi tra ve 1, neu giam dan thi tra ve -1
