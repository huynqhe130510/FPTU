/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author huyNguyen
 */
public class Matrix {

    private int[][] matrix;

    public Matrix() {
    }

    public Matrix(int row, int col) {
        this.matrix = new int[row][col];
    }

    public int getRow() {
        return this.matrix.length;
    }

    public int getCol() {
        return this.matrix[0].length;
    }

    public void setValue(int r, int c, int value) {
        this.matrix[r][c] = value;
    }

    public int getValue(int r, int c) {
        return this.matrix[r][c];
    }
}
