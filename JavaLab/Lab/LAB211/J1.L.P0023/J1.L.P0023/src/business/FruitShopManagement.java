package business;

import entity.Fruit;
import java.util.*;

public class FruitShopManagement {

    ArrayList<Fruit> fr;
    HashMap<String, ArrayList> hm;

    public FruitShopManagement() {
        fr = new ArrayList<>();
        hm = new HashMap<>();
    }

    public Fruit show(Fruit f) {
        return f;
    }

    public ArrayList<Fruit> re() {
        return fr;
    }

    public HashMap<String, ArrayList> list() {
        return hm;
    }

    public boolean addNewFr(Fruit f) {
        for (Fruit frItem : fr) {
            if (frItem.getFruitID().equals(f.getFruitID())) {
                return false;
            }
            if (checkDup(frItem, f)) {
                break;
            } else {
                return false;
            }
        }
        this.fr.add(f);
        return true;
    }

    public void addOrder(String name, ArrayList a) {
        if (hm.containsKey(name) == false) {
            hm.put(name, a);
        }
    }

    public boolean checkDup(Fruit f1, Fruit f2) {
        if (f1.getFruitName().compareTo(f2.getFruitName()) == 0) {
            if (f1.getOrigin().compareTo(f2.getOrigin()) == 0) {
                if (f1.getPrice().compareTo(f2.getPrice()) == 0) {
                    if (f1.getQuantity().compareTo(f2.getQuantity()) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public String getName(String ID) {
        for (Fruit frItem : fr) {
            if (frItem.getFruitID().equals(ID)) {
                return frItem.getFruitName();
            }
        }
        return null;
    }

    public String getPrice(String ID) {
        for (Fruit frItem : fr) {
            if (frItem.getFruitID().equals(ID)) {
                return frItem.getPrice();
            }
        }
        return null;
    }

    public boolean orderByID(String ID) {
        for (Fruit frItem : fr) {
            if (frItem.getFruitID().equals(ID)) {
                return true;
            }
        }
        return false;
    }
}
