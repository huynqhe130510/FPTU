/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitManager;

import Entity.Order;
import Entity.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author ニャット
 */
public class Main {

    public static void main(String[] args) {

        String[] name = {"Strawberry", "Mango", "Tomatoe", "Grape", "Watermellon"};
        String[] id = {"st01", "mg02", "tt03", "gp04", "wm05"};
        String[] origin = {"usa", "vietnam", "thailan", "singapore", "Denmark"};
        double[] price = {1.2, 3.5, 5.8, 9.0, 10.5};
        int[] quantity = {100, 244, 1313, 566, 788};

        FruitManage m = new FruitManage();
        Hashtable<String, ArrayList<Order>> htable = new Hashtable<>();
        ArrayList<Fruit> listShopFruit = new ArrayList<>();
        listShopFruit = m.addManyFruit(id, name, price, quantity, origin, listShopFruit);

        while (true) {
            System.out.println("==================");
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("   1.Create Fruit");
            System.out.println("   2.View Order");
            System.out.println("   3.Shopping (For Buyer)");
            System.out.println("   4.Exit");
            System.out.print("Enter your choice:");
            int i = m.inputInt();
            switch (i) {
                case 1: {
                    System.out.println("Create fruit");
                    m.addFruit(listShopFruit);
                    continue;
                }
                case 2: {
                    System.out.println("View order");
                    m.ViewHistoryBills(htable);
                    continue;
                }
                case 3: {
                    System.out.println("Shopping");
                    ArrayList<Order> CusOrders = m.shopping(listShopFruit);
                    m.displayOrders(CusOrders);
                    System.out.print("Enter your name:");
                    String cusName = m.inputNotEmptyString();
                    htable.put(cusName, CusOrders);
                    continue;
                }
                case 4: {
                    System.out.println("Exit");
                    break;
                }
                default: {
                    continue;
                }

            }
        }

    }

}
