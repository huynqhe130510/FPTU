/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author huyNguyen
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Helper h = new Helper();
        while (true) {
            h.menu();
            String choice = "";
            while (h.checkChoice(choice = sc.nextLine().trim()) == false) {
                System.err.println("Wrong input");
                System.out.print("Enter your choice again [1-4]: ");
            }
            if (choice.compareToIgnoreCase("1") == 0) {
                h.enterNewFruit();
            } else if (choice.compareToIgnoreCase("2") == 0) {
                h.viewOrder();
            } else if (choice.compareToIgnoreCase("3") == 0) {
                h.order();
            } else {
                break;
            }
        }
    }

}
