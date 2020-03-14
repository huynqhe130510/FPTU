/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.FruitShopManagement;
import entity.Fruit;
import entity.Order;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author huyNguyen
 */
public class Helper {

    public static boolean checkName(String name) {
        return name.trim().matches("[A-Za-z ]+");
    }

    public static boolean checkNumber(String number) {
        return number.trim().matches("[0-9]+");
    }

    public static boolean checkYN(String yn) {
        return yn.trim().matches("[YNyn]");
    }

    public static boolean checkChoice(String choice) {
        return choice.trim().matches("[1-4]");
    }

    FruitShopManagement fsm = new FruitShopManagement();

    public void menu() {
        System.out.println("");
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Order");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void enterNewFruit() {
        Scanner sc = new Scanner(System.in);
        String id = null;
        String name = null;
        String origin = null;
        String fruit;
        String quantity;
        String price;
        boolean checkId = false;
        boolean checkFruit = false;

        while (checkId == false) {
            checkId = true;
            System.out.print("Enter fruit id: ");
            while (checkNumber(id = sc.nextLine().trim()) == false) {
                System.err.println("Wrong input");
                System.out.print("Please enter id again: ");
            }

            checkId = fsm.checkDuplicateId(id);
            if (checkId == false) {
                System.err.println("This id is already exist");
                System.out.print("Enter other id: ");
            }
        }

        while (checkFruit == false) {
            checkFruit = true;
            System.out.print("Enter fruit name: ");
            while (checkName(name = sc.nextLine().trim().replaceAll("\\s+", " ")) == false) {
                System.err.println("Wrong input");
                System.out.print("Please enter fruit name again: ");
            }

            System.out.print("Enter fruit origin: ");
            while (checkName(origin = sc.nextLine().trim().replaceAll("\\s+", " ")) == false) {
                System.err.println("Wrong input");
                System.out.print("Please enter fruit origin again: ");
            }

            checkFruit = fsm.checkDuplicateFruit(name, origin);
            if (checkFruit == false) {
                System.err.println("This fruit is exist");
            } else {
                break;
            }
        }

        if (checkId == true && checkFruit == true) {
            System.out.print("Enter fruit quantity: ");
            while (checkNumber(quantity = sc.nextLine().trim()) == false) {
                System.err.println("Wrong input");
                System.out.print("Please enter quantity again: ");
            }

            System.out.print("Enter fruit price: ");
            while (checkNumber(price = sc.nextLine().trim()) == false) {
                System.err.println("Wrong input");
                System.out.print("Please enter price again: ");
            }
            fsm.addFruit(new Fruit(id, name, price, quantity, origin));
        }
    }

    public void order() {
        Scanner sc = new Scanner(System.in);
        if (fsm.getAllFruit().isEmpty()) {
            System.err.println("Don't have fruit");
        } else {
            String xQuantity = null;// gia cu
            String xPrice = null;
            String xName = null;
            String quantity = null; // gia moi
            fsm.sort(); // sort by id
            double total = 0;
            ArrayList<OrderItem> orderItem = new ArrayList<>();

            while (true) {
                System.out.println(" ++Item++|++Fruit Name++|++Quantity++|++Origin++|++Price++");
                for (int i = 0; i < fsm.getAllFruit().size(); i++) {
                    System.out.format("%-15s%-15s%-15s%-15s%-15s\n", fsm.getAllFruit().get(i).getFruitId(), fsm.getAllFruit().get(i).getFruitName(),
                            fsm.getAllFruit().get(i).getQuantity(), fsm.getAllFruit().get(i).getOrigin(), fsm.getAllFruit().get(i).getPrice());
                }
                boolean flat = true;
                String item = "";
                boolean check1 = true;
                while (true) {
                    System.out.print("Please enter item: ");
                    int count = 0;

                    while (checkNumber(item = sc.nextLine().trim()) == false) {
                        System.err.println("Wrong input");
                        System.out.print("Please enter item again: ");
                    }

                    for (int i = 0; i < fsm.getAllFruit().size(); i++) {
                        //kiem tra xem id nhap vao co dung voi is trong order hay khong
                        if (item.compareToIgnoreCase(fsm.getAllFruit().get(i).getFruitId()) == 0) {
                            count++;
                            break;
                        }
                    }

                    if (count != 0) {
                        break;
                    } else if (fsm.getAllFruit().isEmpty()) {
                        check1 = false;
                        break;
                    } else {
                        System.err.println("This item do not exist");
                    }
                }
                //neu trong orderItem khong rong
                if (check1 == true) {
                    System.out.print("Please input quantity: ");
                    while (checkNumber(quantity = sc.nextLine().trim()) == false) {
                        System.err.println("Wrong input");
                        System.out.print("Enter quantity again: ");
                    }

                    String price = "";
                    int mark = 0;// danh dau id cua item 
                    for (int i = 0; i < fsm.getAllFruit().size(); i++) {
                        if (fsm.getAllFruit().get(i).getFruitId().compareToIgnoreCase(item) == 0) {
                            xQuantity = fsm.getAllFruit().get(i).getQuantity();
                            price = fsm.getAllFruit().get(i).getPrice();
                            mark = i;
                            xName = fsm.getAllFruit().get(i).getFruitName();
                            break;
                        }
                    }

                    if (Integer.parseInt(quantity) > Integer.parseInt(xQuantity)) {
                        System.err.println("Don't enough fruit for you");

                    } else {
                        if (flat == true) {

                            fsm.getAllFruit().get(mark).setQuantity(String.valueOf(Integer.parseInt(xQuantity) - Integer.parseInt(quantity)));
                            // neu khong con item thi remove item do
                            if (fsm.getAllFruit().get(mark).getQuantity().compareTo("0") == 0) {
                                fsm.getAllFruit().remove(mark);
                            }
                            
                            OrderItem od = new OrderItem(item, xName, Integer.parseInt(quantity), Double.parseDouble(price));
                            //khi mua mot item se chi in ra 1 lan
                            boolean check123 = true;
                            total += od.getAmount();
                            for (int i = 0; i < orderItem.size(); i++) {
                                if (od.getItem().compareToIgnoreCase(orderItem.get(i).getItem()) == 0) {
                                    od = new OrderItem(item, xName, orderItem.get(i).getQuantity() + Integer.parseInt(quantity), Double.parseDouble(price));
                                    orderItem.set(i, od);
                                    check123 = false;
                                    break;
                                }
                            }
                            if (check123 == true) {
                                orderItem.add(od);
                            }

                            System.out.println("Do you want to order now (Y/N) ?");
                            String xOrder = "";
                            while (checkYN(xOrder = sc.nextLine().trim()) == false) {
                                System.err.println("Wrong input");
                                System.out.print("Please enter again: ");
                            }

                            if (xOrder.compareToIgnoreCase("Y") == 0) {
                                System.out.format("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
                                for (int i = 0; i < orderItem.size(); i++) {
                                    System.out.print(orderItem.get(i));
                                }
                                System.out.println("Total: " + total);
                                System.out.print("Enter your name: ");
                                String name;
                                while (checkName(name = sc.nextLine().trim()) == false) {
                                    System.err.println("Wrong input");
                                    System.out.print("Please enter name again: ");
                                }
                                fsm.addOrder(new Order(name, orderItem));
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    System.err.println("Sorry we out of fruit");
                    System.out.format("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
                    for (int i = 0; i < orderItem.size(); i++) {
                        System.out.println(orderItem.get(i));
                    }
                    System.out.println("Total: " + total);
                    System.out.print("Enter your name: ");
                    String name;
                    while (checkName(name = sc.nextLine().trim()) == false) {
                        System.err.println("Wrong input");
                        System.out.print("Please enter name again: ");
                    }
                    fsm.addOrder(new Order(name, orderItem));
                    break;
                }
            }
        }
    }

    public void viewOrder() {
        if (fsm.getAllOrder().isEmpty()) {
            System.err.println("Don't have any order");
        } else {
            for (int i = 0; i < fsm.getAllOrder().size(); i++) {
                System.out.println("Name: " + fsm.getAllOrder().get(i).getName());
                System.out.format("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
                System.out.print(fsm.getAllOrder().get(i).toString().trim());
                System.out.println("Total = " + fsm.total(fsm.getAllOrder().get(i)));
            }
        }
    }

}
