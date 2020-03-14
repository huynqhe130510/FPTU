/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import business.NumberConverter;

/**
 *
 * @author NQH
 */
public class Main {

    String binaryValid = "[01]+";
    String decimalValid = "[0-9]+";
    String hexaValid = "[0-9A-Fa-f]+";

    public String inputBin() {
        Scanner sc = new Scanner(System.in);
        String result = "";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do {
            result = sc.nextLine();
            if (!result.matches(binaryValid)) {
                System.out.print("INVALID INPUT FOR BINARY. INPUT AGAIN: ");
            }
        } while (!result.matches(binaryValid));
        return result;
    }

    public String inputDec() {
        Scanner sc = new Scanner(System.in);
        String result = "";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do {
            result = sc.nextLine();
            if (!result.matches(decimalValid)) {
                System.out.print("INVALID INPUT FOR DECIMAL. INPUT AGAIN: ");
            }
        } while (!result.matches(decimalValid));
        return result;
    }

    public String inputHexa() {
        Scanner sc = new Scanner(System.in);
        String result = "";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do {
            result = sc.nextLine();
            if (!result.matches(hexaValid)) {
                System.out.print("INVALID INPUT FOR HEXADECIMAL. INPUT AGAIN: ");
            }
        } while (!result.matches(hexaValid));
        return result;
    }

    String validBase = "2|10|16";

    public int inputBase() {
        Scanner sc = new Scanner(System.in);
        String result = "";
        do {
            result = sc.nextLine();
            if (!result.matches(validBase)) {
                System.out.print("INVALID INPUT FOR BASE. INPUT AGAIN: ");
            }
        } while (!result.matches(validBase));
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Main m = new Main();
        NumberConverter numberConverter = new NumberConverter();
        Scanner sc = new Scanner(System.in);

        String input, result, temp;
        int baseInput = 0;
        int baseOutput = 0;

        System.out.print("Base number input(2|10|16): ");
        baseInput = m.inputBase();
        System.out.print("Base number output(2|10|16): ");
        baseOutput = m.inputBase();

        switch (baseInput) {
            case 2:
                input = m.inputBin();
                if (baseOutput == 10) {
                    result = numberConverter.otherBaseToDecimal(input, 2);
                    System.out.println("Converted: " + result);
                } else if (baseOutput == 16) {
                    temp = numberConverter.otherBaseToDecimal(input, 2);
                    result = numberConverter.decimalToOtherBase(temp, 16);
                    System.out.println("Converted: " + result);
                }
                break;

            case 10:
                input = m.inputDec();
                if (baseOutput == 2) {
                    result = numberConverter.decimalToOtherBase(input, 2);
                    System.out.println("Converted: " + result);
                } else if (baseOutput == 16) {
                    result = numberConverter.decimalToOtherBase(input, 16);
                    System.out.println("Converted: " + result);
                }
                break;

            case 16:
                input = m.inputHexa();
                if (baseOutput == 2) {
                    temp = numberConverter.otherBaseToDecimal(input, 16);
                    result = numberConverter.decimalToOtherBase(temp, 2);
                    System.out.println("Converted: " + result);
                } else if (baseOutput == 10) {
                    result = numberConverter.otherBaseToDecimal(input, 16);
                    System.out.println("Converted: " + result);
                }
                break;
        }
    }
}
