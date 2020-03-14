/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import ui.CheckInputNumber;

/**
 *
 * @author NQH
 */
public class NomalCal {

    static double memory =0;

    public static double addCal(double number) {
        memory += number;
        return memory;
    }

    public static double subCal(double number) {
        memory -= number;
        return memory;
    }

    public static double mulCal(double number) {
        memory *= number;
        return memory;
    }

    public static double divCal(double number) {
        memory /= number;
        return memory;
    }

    public static double powCal(double number) {
        memory = Math.pow(memory, number);
        return memory;
    }
}
