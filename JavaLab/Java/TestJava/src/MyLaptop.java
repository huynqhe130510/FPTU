
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyLaptop implements ILaptop {

    @Override
    public String f1(ArrayList<Laptop> a) {
        ArrayList b = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i).getName());
        }
        Collections.sort(b);
        Collections.reverse(b);
        String s = "";
        for (int i = 0; i < b.size(); i++) {
            s += b.get(b.size()-1);
            break;
        }
        return s;
    }

    @Override
    public int f2(ArrayList<Laptop> a) {
        int count =0;
        ArrayList b = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i).getHDD());
        }
        for (int i = 0; i < b.size(); i++) {
            Collections.sort(b);
//            Collections.reverse(b);
            for (int j = b.size()-1; j >=0; j--) {
                if(b.get(i) == b.get(j)){
                    count ++;}
                break;
            }
        }
        return count;
    }

}
