package UI;

import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static String checkName() {
        String name = sc.nextLine();
        if (name.trim().matches("[A-Za-z ]+") == true) {
            return name.replaceAll("\\s+", " ");
        }
        System.out.println("Wrong input, please enter again");
        return checkName();
    }

    public static String checkID() {
        String ID = sc.nextLine();
        if (ID.trim().matches("[0-9]+") == true) {
            return ID.replaceAll("\\s+", " ");
        }
        System.out.println("Wrong input, please enter again");
        return checkID();
    }

    public static String CheckYN() {
        String YN = sc.nextLine();
        if (YN.trim().matches("[YNny]") == true) {
            return YN.replaceAll("\\s+", " ");
        }
        System.out.println("Wrong input, please enter again");
        return CheckYN();
    }

}
