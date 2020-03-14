package UI;

import java.util.Scanner;

public class Main {

    public static void displayMenu() {
        System.out.println("WELLCOME TO Fruit shop management");
        System.out.println("1.   Add new Fruit");
        System.out.println("2.   View Order");
        System.out.println("3.   Shopping");
        System.out.println("4.    Exit");
        System.out.print("Plese choose 1 to 4: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHelper io = new InputHelper();
        while (true) {
            displayMenu();
            int option = 0;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
            }
            switch (option) {
                case 1:
                    while (true) {
                        io.addNewFr();
                        System.out.println("Do you want to add more (Y/N)");
                        String choice = Validation.CheckYN();
                        if (choice.charAt(0) == 'n' || choice.charAt(0) == 'N') {
                            break;
                        }
                    }
                case 2:
                    io.viewOrder();
                    break;
                case 3:
                    io.shopping();
                    break;
                default:
                    System.err.println("Please choice [1-4]");
                    break;
            }
        }
    }

}
