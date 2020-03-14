
import java.util.Random;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();

        QuickSort quickSort = new QuickSort(arr);
        quickSort.quickSort(0, length - 1);
        System.out.print("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

}
