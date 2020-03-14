/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author NQH
 */
public class SortAndSearch {

    static int arr[];

    public SortAndSearch(int[] arr) {
        this.arr = arr;
    }

    /**
     * using bubble sort algorithm
     * @param a the array
     */
    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * searches for a value in sorted array
     * @param array array to search in
     * @param value searched value
     * @param left index of left boundary
     * @param right index of right boundary
     * @return position of searched value, if it presents in the array or -1, if
     * it is absent
     */
    public static int binarySearch(int value) {
        int min = 0;
        int max = arr.length - 1;
        int mid = 0;

        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }
}
