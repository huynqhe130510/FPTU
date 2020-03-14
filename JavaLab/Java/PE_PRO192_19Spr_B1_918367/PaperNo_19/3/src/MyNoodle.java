
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyNoodle implements INoodle{

    @Override
    public int f1(List<Noodle> list, double d) {
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPrice() >= d){
                count ++;
            }
        }
        return count;
    }

    @Override
    public void f2(List<Noodle> list) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(1).getPrice() <= list.get(i).getPrice()){
                list.remove(i);
            }
        }
    }

    @Override
    public List<String> f3(List<Noodle> list) {
        ArrayList<Noodle> b = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            b.add(list.get(i));
        }
        Collections.sort(list, new Comparator<Noodle>() {
            @Override
            public int compare(Noodle o1, Noodle o2) {
                 if(o1.getName() != o2.getName()){
                    return o1.getName().compareToIgnoreCase(o2.getName());
                    
                 }
                 else{
                     return o1.getPrice()>o2.getPrice() ?1:-1;
                 }
            }
        });
        ArrayList c = new ArrayList();
        for (int i = 0; i < b.size(); i++) {
            c.add(b.get(i).getName());
        }
        return c;
    }
    
}
