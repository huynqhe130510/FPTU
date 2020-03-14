/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculatorprogram;

import java.util.Scanner;

/**
 *
 * @author ニャット
 */
public class MatrixCalculator {

    int getInputInt(String message, String error, int min, int max) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());
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

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMat;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return newMat;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    newMat[i][j] = newMat[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return newMat;
    }

    void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    int[][] newMatrix(int row, int col) {
        int[][] newMat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMat[i][j] = getInputInt(String.format("Enter Matrix[%d][%d]: ", i, j), "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return newMat;
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int option) {
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

    void matrixHandling(int option) {
        int row1 = getInputInt("Enter Row Matrix1: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int col1 = getInputInt("Enter Column Matrix1: ", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[][] mat1 = newMatrix(row1, col1);
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
        int[][] mat2 = newMatrix(row2, col2);
        int[][] result;
        switch (option) {
            case 1:
                result = new int[row1][col1];
                result = additionMatrix(mat1, mat2);
                displayResult(mat1, mat2, result, option);
                break;
            case 2:
                result = new int[row1][col1];
                result = subtractionMatrix(mat1, mat2);
                displayResult(mat1, mat2, result, option);
                break;
            case 3:
                result = new int[row1][col2];
                result = multiplicationMatrix(mat1, mat2);
                displayResult(mat1, mat2, result, option);
                break;
        }
    }

    void run() {
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = getInputInt("Your choice: ", "Choose only 1-4!", 1, 4);
            if (choice == 4) {
                System.exit(0);
            }
            matrixHandling(choice);
            System.out.println();
        }
    }
}
