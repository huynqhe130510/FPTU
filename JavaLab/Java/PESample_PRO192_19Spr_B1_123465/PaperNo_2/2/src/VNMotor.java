/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NQH
 */
public class VNMotor extends Motor{
    String series;
    public VNMotor() {
    }

    public VNMotor(String brandName, String series,  double price) {
        super(brandName, price);
        this.series = series;
    }
    
    double getSalePrice(){
       if(price < 3000){
            return price = price - price*5/100;
       }
       else{
           return price = price - price*10/100;
       }
    }

    @Override
    public String toString() {
        return brandName + " " + series + " " + price ;
    }

    
    
    
}
