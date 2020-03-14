/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Search;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NQH
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter search value:");
        int search = scanner.nextInt();
        
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }        
        
        System.out.print("The array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        Search s = new Search(arr);
        
        System.out.println("\nFound " + search + " at index: " + s.linerSearch(search));
    }
}
