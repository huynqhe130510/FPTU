package UI;

import entity.Fruit;
import entity.FruitOrder;
import business.FruitShopManagement;
import java.util.ArrayList;

public class InputHelper {

    FruitShopManagement f = new FruitShopManagement();

    public void addNewFr() {
        Fruit fr = inputFruit();
        boolean check = f.addNewFr(fr);
        if (check) {
            System.out.println("This fruit just add: ");
            System.out.println(f.show(fr));
        } else {
            System.out.println("Add fail");
        }
    }

    public void viewOrder() {
        System.out.println(f.list());
    }

    public void shopping() {
        ArrayList<FruitOrder> frOd = new ArrayList<>();
        while (true) {
            for (int i = 0; i < f.re().size(); i++) {
                System.out.println(f.re().get(i));
            }
            System.out.println("Customer select item: ");
            String inputItem = Validation.checkID();
            boolean check = f.orderByID(inputItem);
            if (check == false) {
                System.out.println("Cannot find that fruit");
                break;
            }
            System.out.println("Enter quantity: ");
            String inputQuantity = Validation.checkID();
            String frName = f.getName(inputItem);
            String frPrice = f.getPrice(inputItem);
            String amount = String.valueOf(Integer.parseInt(inputQuantity) * Integer.parseInt(frPrice));
            frOd.add(new FruitOrder(frName, inputQuantity, frPrice, amount));
            System.out.println("Do you want to order now(Y/N)");
            String choice = Validation.CheckYN();
            if (choice.charAt(0) == 'Y' || choice.charAt(0) == 'y') {
                System.out.println("Enter your name: ");
                String name = Validation.checkName();
                int total = 0;
                for (FruitOrder frOd1 : frOd) {
                    total += Integer.parseInt(frOd1.getAmount());
                }
                frOd.get(frOd.size() - 1).setAmount(frOd.get(frOd.size() - 1).getAmount() + "\n" + "Total = " + total);
                f.addOrder(name, frOd);
                System.out.println("List order: ");
                for (int i = 0; i < frOd.size(); i++) {
                    System.out.println(frOd.get(i));
                }
                break;
            }
        }
    }

    public Fruit inputFruit() {
        System.out.println("Enter fruit ID: ");
        String fruitID = Validation.checkID();
        System.out.println("Enter fruit name: ");
        String fruitName = Validation.checkName();
        System.out.println("Enter price of this fruit: ");
        String price = Validation.checkID();
        System.out.println("Enter quantity: ");
        String quantity = Validation.checkID();
        System.out.println("Enter origin: ");
        String origin = Validation.checkName();
        Fruit fr = new Fruit(fruitID, fruitName, price, quantity, origin);
        return fr;
    }

}
