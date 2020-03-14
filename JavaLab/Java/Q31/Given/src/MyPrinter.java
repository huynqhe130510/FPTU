
import java.util.Collection;
import java.util.Comparator;
import java.util.*;

public class MyPrinter implements IPrinter {

    @Override
    public void f1(List<Printer> a, double price) {
        int k = (int) price;
        ArrayList b = new ArrayList();
        for (int i = 0; i < k; i++) {
            b.add(a.get(i));
        }
        Collections.sort(b, new Comparator<Printer>() {
            @Override
            public int compare(Printer o1, Printer o2) {
                if (o1.getName() != o2.getName()) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o1.getPrice() > o2.getPrice() ? 1 : -1;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            a.remove(a.get(i));
        }
        a.addAll(b);
//        Collections.sort(a, new Comparator<Printer>() {
//            @Override
//            public int compare(Printer o1, Printer o2) {
//                if (o1.getPrice() != o2.getPrice()) {
//                    return o1.getPrice() > o2.getPrice() ? 1 : -1;
//                } else {
//                    return o1.getName().compareTo(o2.getName());
//                }
//            }
//        });
//        Printer p1 = null;
//        Printer p2 = null;
//        for (int i = 0; i < a.size() - 1; i++) {
//            p1 = a.get(i);
//            for (int j = i + 1; j < a.size(); j++) {
//                p2 = a.get(j);
//                if (p1.getPrice() < p2.getPrice()
//                        || (p1.getPrice() == p2.getPrice()
//                        && (p1.getName().compareTo(p2.getName()) > 0))) {
//                    a.set(i, p2);
//                    a.set(j, p2);
//                }
//            }
//        }
    }

    @Override
    public int f2(List<Printer> a, String name) {
        int count = 0;
        name = name.toLowerCase();
        for (int i = 0; i < a.size(); i++) {
            String temp = a.get(i).getName().toLowerCase();
            count += temp.contains(name) ? 1 : 0;
        }
        return count;
    }

}
