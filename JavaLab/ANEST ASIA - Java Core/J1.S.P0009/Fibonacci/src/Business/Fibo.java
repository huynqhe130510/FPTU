/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author NQH
 */
public class Fibo {
    
    /**
     * return value of fibonacci number 
     * @param n: number of fibonacci
     * @return list of fibonacci
     */
    public static int[] fib(int n) {
        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a;
    }
}