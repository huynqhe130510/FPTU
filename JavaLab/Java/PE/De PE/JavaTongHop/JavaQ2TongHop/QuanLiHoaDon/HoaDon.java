/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2;

/**
 *
 * @author Kudo
 */
public class HoaDon {
    String name;
    double money;

    public HoaDon() {
    }

    public HoaDon(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return this.name+" "+this.money; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    

}
