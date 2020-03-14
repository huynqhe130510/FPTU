/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author NQH
 */
public class QuadraticEquation {

    double a, b, c, x, x1;
    int result;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = -1;
    }

    public int quadraticEquation() {

        if (a == 0) {
            this.result = 0;
            return 0;
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            this.result = 1;
        } else if (delta == 0) {
            x = -(b / (2 * a));
            x1 = x;
            this.result = 2;
        } else {
            double rootDelta = Math.sqrt(delta);
            x = (-b + rootDelta) / (2 * a);
            x1 = (-b - rootDelta) / (2 * a);
            this.result = 3;
        }
        return this.result;
    }
    
    public int getResutl(){
        return this.result;
    }

    public double getX() {
        return x;
    }

    public double getX1() {
        return x1;
    }
    
    

}
