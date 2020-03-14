package business;

import entity.Fruit;
import entity.FruitOrder;
import entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author THAYCACAC
 */
public class Manager {

    ArrayList<Fruit> fr;
    Hashtable<String, ArrayList<FruitOrder>> hm;

    public Manager() {
    }

    public Manager(ArrayList<Fruit> fr, Hashtable<String, ArrayList<FruitOrder>> hm) {
        this.fr = fr;
        this.hm = hm;
    }

    public void addFruit(Fruit f) {
        this.fr.add(f);
    }

    public static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public static void updateOrder(ArrayList<FruitOrder> lo, String id, int quantity) {
        for (FruitOrder order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
