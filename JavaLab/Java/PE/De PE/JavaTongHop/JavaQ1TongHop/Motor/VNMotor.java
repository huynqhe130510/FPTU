package sampletest;
public class VNMotor extends Motor{  
    String series;
    public VNMotor() {
    }

    public VNMotor(String brandName, String series, double price) {
        super(brandName, price);
        this.series = series;
    }
    
    /*Complete the below function for second test case*/
    public double getSalePrice() {
        double salePrice;
        if(this.price < 3000){
            salePrice = price - price *0.05;
        }
        else salePrice = price-price * 0.1;
        return salePrice;
    }  
    
    //add and complete your other methods here (if needed)

    @Override
    public String toString() {
        return this.brandName + " "+ this.series+" "+this.price; //To change body of generated methods, choose Tools | Templates.
    }

}
