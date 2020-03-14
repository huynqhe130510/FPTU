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
public class SuperLativeEquation {
    
    double a, b, x;
    int result;

    public SuperLativeEquation(double a, double b) {
        this.a = a;
        this.b = b;
        this.result = -1;
    }
    
    public int superlativeEquation() {
        if (a != 0) {
            x = -b / a;
            this.result = 0;
        } else {
            if (b == 0) {
                this.result = 1;
            }
        }
        return this.result;
    }
    
    public double getX(){
        return this.x;
    }
    
    public int getResult(){
        return this.result;
    }
    
}
