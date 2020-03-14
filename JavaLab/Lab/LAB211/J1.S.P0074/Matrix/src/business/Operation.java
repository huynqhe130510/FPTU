/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Matrix;

/**
 *
 * @author huyNguyen
 */
public class Operation {

    public static Matrix addMatrixOperator(Matrix m1, Matrix m2) {
        Matrix newMatrix = new Matrix(m1.getRow(), m1.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m1.getCol(); j++) {
                newMatrix.setValue(i, j, m1.getValue(i, j) + m2.getValue(i, j));
            }
        }
        return newMatrix;
    }

    public static Matrix subMatrixOperator(Matrix m1, Matrix m2) {
        Matrix newMatrix = new Matrix(m1.getRow(), m1.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m1.getCol(); j++) {
                newMatrix.setValue(i, j, m1.getValue(i, j) - m2.getValue(i, j));
            }
        }
        return newMatrix;
    }

    public static Matrix mulMatrixOperator(Matrix m1, Matrix m2) {
        Matrix newMatrix = new Matrix(m1.getRow(), m2.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getCol(); j++) {
                for (int k = 0; k < m1.getCol(); k++) {
                    newMatrix.setValue(i, j, newMatrix.getValue(i, j) + m1.getValue(i, k) * m2.getValue(k, j));
                }
            }
        }
        return newMatrix;
    }

}
