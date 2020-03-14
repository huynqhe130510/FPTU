/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Fruit;
import entity.FruitOrder;
import static business.Manager.getFruitByItem;
import static business.Manager.updateOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import ui.Validation;

/**
 *
 * @author huyNguyen
 */
public class InputHelper {

    public static void viewOrder(Hashtable<String, ArrayList<FruitOrder>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<FruitOrder> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    public static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<FruitOrder>> ht) {
        //check list empty user can't buy
        if (lf.isEmpty()) {
            System.err.println("No ha1ve item.");
            return;
        }
        //loop until user don't want to buy continue
        ArrayList<FruitOrder> lo = new ArrayList<>();
        while (true) {
            displayListFruit(lf);
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, lf.size());
            Fruit fruit = getFruitByItem(lf, item);
            System.out.print("Enter quantity: ");
            int quantity = 0;
            try {
                if(fruit.getQuantity() > 0)
                quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            } catch (Exception e) {
                System.err.println("Out of product");
                break;
            }
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //check item exist or not
            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(lo, fruit.getFruitId(), quantity);
            } else {
                lo.add(new FruitOrder(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (Validation.checkInputYN()) {
                break;
            }
        }
        System.out.println("");
        displayListOrder(lo);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        ht.put(name, lo);
    }

    //display list fruit in shop
    public static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15s$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    public static void displayListOrder(ArrayList<FruitOrder> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (FruitOrder order : lo) {
            System.out.printf("%15s%15d%15.0f$%15s$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

}
