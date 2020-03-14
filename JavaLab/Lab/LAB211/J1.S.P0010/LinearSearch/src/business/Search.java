/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 * use linnerSearch to search position of number
 * @param arr array
 * @param key number needs to search
 * @return position of number, if it presents in the array or -1, if it is
 * absent
 */
public class Search {

    static int arr[];

    public Search(int arr[]) {
        this.arr = arr;
    }

    public static int linerSearch(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
