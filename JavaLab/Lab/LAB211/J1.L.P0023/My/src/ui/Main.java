package ui;

import entity.Fruit;
import entity.FruitOrder;
import business.Manager;
import entity.Fruit;
import entity.FruitOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import ui.InputHelper;
import ui.Validation;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        Fruit f = new Fruit();
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<FruitOrder>> ht = new Hashtable<>();
        Manager m = new Manager(lf, ht);

        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter fruit id: ");
                        String fruitId = Validation.checkInputString();
                        if (!Validation.checkIdExist(lf, fruitId)) {
                            System.err.println("Id exist");
                            return;
                        }
                        System.out.print("Enter fruit name: ");
                        String fruitName = Validation.checkInputName();
                        System.out.print("Enter price: ");
                        double price = Validation.checkInputDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = Validation.checkInputInt();
                        System.out.print("Enter origin: ");
                        String origin = Validation.checkInputOrigin();
                        f = new Fruit(fruitId, fruitName, price, quantity, origin);
                        m.addFruit(f);
                        if (!Validation.checkInputYN()) {
                            break;
                        }
                    }
                case 2:
                    InputHelper.viewOrder(ht);
                    break;
                case 3:
                    InputHelper.shopping(lf, ht);
                    break;
                case 4:
                    return;
            }
        }
    }

}
