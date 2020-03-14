/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am;

import java.util.Scanner;

/**
 *
 * @author qa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        Class m = new Class(n);
        System.out.println("");
        System.out.println("" + m.reverseWord());
        System.out.println("" + m.reverseChar());
        m.evenChar();
        m.evenWord();
        System.out.println("" + m.sumChar());
        System.out.println("" + m.sumNum());
        System.out.println("" + m.sumNum2());
        System.out.println("" + m.count());
        System.out.println("" + m.count1());
        System.out.println("" + m.count2());
        System.out.println("" + m.count3());
        System.out.println("" + m.count4());
        System.out.println("" + m.count5());
        System.out.println("" + m.count6());
        System.out.println("" + m.count7());
        System.out.println("" + m.count8());
        System.out.println("" + m.count9());
    }

}
