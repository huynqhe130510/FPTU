/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NQH
 */
public class deQuyFibo {

    int fibo(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        deQuyFibo d = new deQuyFibo();
        for (int i = 1; i <= 5; i++) {
            System.out.print("    " + d.fibo(i));
        }
    }
}
