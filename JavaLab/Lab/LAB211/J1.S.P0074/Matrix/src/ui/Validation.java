/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Matrix;
import java.util.Scanner;

/**
 *
 * @author huyNguyen
 */
public class Validation {

    public static int getInputInt(String message, String error, int min, int max) {
        int number = 0;
        String input;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(input = sc.nextLine());
                if (number < min || number > max) {
                    System.out.println(error);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number!");
            }
        }
        return number;
    }

    public static void displayMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getCol(); j++) {
                System.out.print("[" + matrix.getValue(i, j) + "]");
            }
            System.out.println();
        }
    }

    public static void inputNewMatrix(Matrix a) {
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                a.setValue(i, j, getInputInt(String.format("Enter Matrix[%d][%d]: ", i, j), "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
        }
    }

    public static void displayResult(Matrix matrix1, Matrix matrix2, Matrix result, int option) {
        System.out.println("--------- Result ---------");
        displayMatrix(matrix1);
        switch (option) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

}
