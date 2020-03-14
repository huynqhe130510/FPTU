/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Operation;
import entity.Matrix;
import java.util.Scanner;
import static ui.Validation.displayResult;
import static ui.Validation.getInputInt;
import static ui.Validation.inputNewMatrix;

/**
 *
 * @author huyNguyen
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int option = Validation.getInputInt("Your choice: ", "Choose only 1-4!", 1, 4);
            if (option == 4) {
                System.exit(0);
            }

            int row1 = getInputInt("Enter Row Matrix1: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int col1 = getInputInt("Enter Column Matrix1: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            Matrix mat1 = new Matrix(row1, col1);
            inputNewMatrix(mat1);
            int row2, col2;
            while (true) {
                row2 = getInputInt("Enter Row Matrix2: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (option != 3) {
                    if (row2 != row1) {
                        System.out.println("Two matrix must be same size!");
                    } else {
                        break;
                    }
                } else {
                    if (row2 != col1) {
                        System.out.println("Matrix2 columns number must equal Matrix1 rows number!");
                    } else {
                        break;
                    }
                }
            }
            while (true) {
                col2 = getInputInt("Enter Column Matrix2: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (option != 3) {
                    if (col2 != col1) {
                        System.out.println("Two matrix must be same size!");
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            Matrix mat2 = new Matrix(row2, col2);
            inputNewMatrix(mat2);
            Matrix result = new Matrix();
            switch (option) {
                case 1:
                    result = Operation.addMatrixOperator(mat1, mat2);
                    displayResult(mat1, mat2, result, option);
                    break;
                case 2:
                    result = Operation.subMatrixOperator(mat1, mat2);
                    displayResult(mat1, mat2, result, option);
                    break;
                case 3:
                    result = Operation.mulMatrixOperator(mat1, mat2);
                    displayResult(mat1, mat2, result, option);
                    break;
            }

            System.out.println();
        }
    }
}
