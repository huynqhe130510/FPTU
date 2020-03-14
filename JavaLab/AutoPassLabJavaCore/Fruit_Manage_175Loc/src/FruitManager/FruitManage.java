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
import java.util.Set;

/**
 *
 * @author ニャット
 */
public class FruitManage {

    String inputNotEmptyString() {
        Scanner t = new Scanner(System.in);
        while (true) {
            String val = t.nextLine().trim();
            if (val.isEmpty()) {
                System.out.println("Enter string<not empty>: ");
                continue;
            }
            return val;

        }
    }

    Fruit createFruitWithId(String xId) {

        System.out.print("Enter name of fruit:");
        String name = inputNotEmptyString();

        System.out.print("Enter price:");
        double price = inputDouble();

        System.out.print("Enter quantity:");
        int quantity = inputInt();

        System.out.print("Enter origin:");
        String origin = inputNotEmptyString();

        return new Fruit(xId, name, price, quantity, origin);
    }

    int inputInt() {
        Scanner t = new Scanner(System.in);

        int val = 0;
        /*if input wrong , throw exp then print out and break loop, check= false 
       so that keep looping until input right, then check turn true */
        while (true) {
            try {
                val = Integer.parseInt(t.nextLine());
                // pass upper code will exit while.
                break;
            } catch (NumberFormatException e) {
                System.err.print("Enter must integer number: ");
                continue;
            }

        }
        return val;
    }

    double inputDouble() {
        Scanner t = new Scanner(System.in);
        double val = 0;
        /*if input wrong , throw exp then print out and break loop, check= false 
       so that keep looping until input right, then check turn true */
        while (true) {
            try {
                val = Double.parseDouble(t.nextLine());
                // pass upper code will exit while.

                break;
            } catch (NumberFormatException e) {
                System.err.print("Just be enter double value: ");
                continue;
            }

        }

        return val;

    }

    /*force user input y/n 
    return String : y/n*/
    String inputYN() {
        Scanner t = new Scanner(System.in);
        String yn;
        do {
            System.out.print("Enter y/n: ");
            yn = inputNotEmptyString();
        } while (!yn.equalsIgnoreCase("y") & !yn.equalsIgnoreCase("n"));

        if (yn.equalsIgnoreCase("y")) {
            return "y";
        }
        return "n";

    }

    /*display Fruit list */
    void displayFlist(ArrayList<Fruit> listFr) {
        int len = listFr.size();

        System.out.println("List of Fruit:");
        /*| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |*/
        System.out.printf("%-15s%-20s%-20s%-20s\n",
                "| ++ Item ++ ",
                "| ++ Fruit Name ++",
                "| ++ Origin ++ ",
                "| ++ Price ++ |");
        /*1 	Coconut	      Vietnam	      2$ */
        for (int i = 0; i < len; i++) {
            System.out.printf("%-15d", i + 1);
            listFr.get(i).disFruit();
        }

    }

    /*
    Product | Quantity | Price | Amount
    1. Apple       3	          1$	3$
    2. Mango     2               2$              4$
    Total: 7$
     */
    void displayOrders(ArrayList<Order> ListOrder) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
        for (int i = 0; i < ListOrder.size(); i++) {
            System.out.print((i + 1) + ".");
            System.out.println(ListOrder.get(i));
        }

        double total = 0;
        for (Order o : ListOrder) {
            total += o.getAmount();
        }
        System.out.printf("Total: %.3f$\n", total);

    }

    ArrayList<Fruit> addManyFruit(String[] id, String[] name,
            double[] price, int[] quantity, String[] origin, ArrayList<Fruit> ListShopFruit) {

        for (int i = 0; i < name.length; i++) {
            Fruit fruit = new Fruit(id[i], name[i], price[i], quantity[i], origin[i]);
            ListShopFruit.add(fruit);

        }
        return ListShopFruit;

    }

    /*Customer: Marry Carie
Product | Quantity | Price | Amount
1. Apple       3	          1$	3$
2. Mango     2               2$              4$
Total: 7$

Customer: John Smith
Product | Quantity | Price | Amount
1. JackFruit       3          3$	9$
2. Mango          2          2$              4$
Total: 13$
     */
    void ViewHistoryBills(Hashtable<String, ArrayList<Order>> ht) {
        Set<String> CusName = ht.keySet();
        Iterator<String> it = CusName.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println("Customer: " + key);
            displayOrders(ht.get(key));
            System.out.println("");
        }

    }

    /*para: take listShopFruit as data to customer consider/ buy.
    Each time call shopping. user will get a big-order contain 
    many products-not duplicate.*/
    ArrayList<Order> shopping(ArrayList<Fruit> ListShopFruit) {

        String ans = null;
        int xQuan = 0;
        /*store info of a cus orders*/
        ArrayList<Order> CusOrders = new ArrayList<Order>();

        do {
            /*user select an item from arrayListFruitShop.*/
            displayFlist(ListShopFruit);
            int sel;
            while (true) {
                System.out.print("Enter Your Choice: ");
                sel = inputInt();
                if (sel > ListShopFruit.size() || sel < 1) {
                    System.err.println("Just enter records in range [" + 1 + "," + ListShopFruit.size() + "]");
                    continue;
                }
                break;
            }
            Fruit selectedF = ListShopFruit.get(sel - 1);

            System.out.println("Your Selected: " + selectedF.getName());
            /*check quantity*/
 /*keep loop until meet else, if buy more than shop had 
                    , then re-enter.*/

            if (selectedF.getQuantity() == 0) {
                System.err.println("Oops ! Out of stock !");   /// Còn lỗi ae tự fix nhé, sửa trên lớp rồi nhác fix lại quá !
                break;
            } else {
                while (true) {
                    System.out.print("Enter quantity:");
                    xQuan = inputInt();
                    if (xQuan > selectedF.getQuantity()) {
                        System.out.println("Please enter less, We only have :"
                                + selectedF.getQuantity() + " - " + selectedF.getName());
                        continue;
                    } else {
                        System.out.println("Buy Success!");
                        selectedF.setQuantity(selectedF.getQuantity() - xQuan);
                        break;
                    }
                }
            }
            /*gathering duplicate order- same id*/
            Order xOrder = new Order(selectedF.getId(), selectedF.getName(),
                    xQuan, selectedF.getPrice());
            //check if user bought exist Fruit, if false -> add
            //if true , by isgatherable itself gathering .
            if (isGatherAble(CusOrders, xOrder) == false) {
                CusOrders.add(xOrder);
            }
            /*add order this customer-list-order*/
 /*order: name of fruit, quantity, price */

 /*only allow input y/n*/
            System.out.println("Do you want to order NOW?");
            ans = inputYN();
        } while (ans.equalsIgnoreCase("n"));
        System.out.println("---");
        return CusOrders;

    }

    /*Create fruit with name, id, quantity, price of each unit . 
    if dont duplicate, then ad, if yes then we take new data and add quantity 
    with old quan
     */
    void addFruit(ArrayList<Fruit> ListShopFruit) {
        String k;
        /*loop until k is "y"*/
        do {
            /*Create& input fruit*/

            System.out.print("Enter id: ");
            String xId = inputNotEmptyString();
            //check if exist then return right then.
            if (isExistId(xId, ListShopFruit)) {
                System.out.print("Failed! ID:" + xId + " have been existed!!");
                return;
            }
            Fruit fr = createFruitWithId(xId);
            ListShopFruit.add(fr);
            System.out.println("Do you want to continue?");
            k = inputYN();
        } while (k.equalsIgnoreCase("Y"));
        /*if enter n , break out and return true, keep loop the menu*/

    }

    /*check each Fruit in list , if found id of Fruit then return i
    dont found when i run over the for loop then i= listFr.size*/
    int searchById(ArrayList<Fruit> listfr, String xId) {
        int i;
        for (i = 0; i < listfr.size(); i++) {
            if (xId.equalsIgnoreCase(listfr.get(i).getId())) {
                return i;
            }
        }
        /*if exit for with out return , then i= size of list*/
        return i;
    }

    /*gather any duplicte order(order have same id of Fruit-bought)*/
    boolean isGatherAble(ArrayList<Order> CusOrders, Order xOrder) {
        int i;
        for (i = 0; i < CusOrders.size(); i++) {
            if (xOrder.getId().equalsIgnoreCase(CusOrders.get(i).getId())) {
                Order oi = CusOrders.get(i);
                // gather 2 quantity
                oi.setQuantity(oi.getQuantity() + xOrder.getQuantity());
                //gather amount
                oi.setAmount(oi.getAmount() + xOrder.getAmount());
                return true;
            }
        }
        return false;
    }

    boolean isExistId(String xId, ArrayList<Fruit> ListShopFruit) {
        int i = searchById(ListShopFruit, xId);
        if (i == ListShopFruit.size()) {
            return false;
        }
        return true;
    }

}
