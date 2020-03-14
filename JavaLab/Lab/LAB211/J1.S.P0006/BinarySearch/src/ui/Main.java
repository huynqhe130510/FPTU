/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.SortAndSearch;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NQH
 */
public class Main {
    /*
    * check input for size of array and number wants to search
    * @return number 
    */
    public static int check(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.err.println("Error input");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        int length = check();
        
        System.out.println("Enter search value:");
        int search = check();
        
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }

        SortAndSearch sortAndSearch = new SortAndSearch(arr);
        sortAndSearch.bubbleSort(arr);
        System.out.print("Sorted array: ");
        System.out.print("[");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("\nFound " + search + " at index: " + sortAndSearch.binarySearch(search));
    }
}
