/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import com.sun.javafx.css.Combinator;
import entity.Fruit;
import entity.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author huyNguyen
 */
public class FruitShopManagement {

    ArrayList<Fruit> fruit;
    ArrayList<Order> order;

    public FruitShopManagement() {
        fruit = new ArrayList<>();
        order = new ArrayList<>();
    }

    public ArrayList<Fruit> getAllFruit() {
        return fruit;
    }

    public ArrayList<Order> getAllOrder() {
        return order;
    }

    public void addFruit(Fruit f) {
        fruit.add(f);
    }

    public void addOrder(Order o) {
        order.add(o);
    }

    public double total(Order o) {
        double total = 0;
        for (int i = 0; i < o.getOrderItem().size(); i++) {
            total += o.getOrderItem().get(i).getAmount();
        }
        return total;
    }

    public boolean checkDuplicateId(String id) {
        for (int i = 0; i < fruit.size(); i++) {
            if (fruit.get(i).getFruitId().compareToIgnoreCase(id) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicateFruit(String name, String origin) {
        for (int i = 0; i < fruit.size(); i++) {
            if (fruit.get(i).getFruitName().compareToIgnoreCase(name) == 0
                    && fruit.get(i).getOrigin().compareToIgnoreCase(origin) == 0) {
                return false;
            }
        }
        return true;
    }

    public void sort() {
        Collections.sort(fruit, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if (o1.getFruitId().compareToIgnoreCase(o2.getFruitId()) != 0) {
                    return o1.getFruitId().compareToIgnoreCase(o2.getFruitId());
                }
                return 0;
            }
        });
    }

}
