package UI;

import business.BbSort;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Display dp = new Display();
        BbSort bs = new BbSort();
        Random rd = new Random();
        System.out.println("Enter number of array:");
        int length = 0;
        boolean Check = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                length = scanner.nextInt();
                Check = true;
            } catch (Exception e) {
                Check = false;
                scanner.nextLine();
                System.out.println("Error input");
            }
        } while (!Check);
    
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(length);
        }
        System.out.print("Unsorted array: ");
        dp.displayArray(array);

        System.out.println();

        bs.bubbleSort(array);
        System.out.print("Sorted array: ");
        dp.displayArray(array);
    }
}
