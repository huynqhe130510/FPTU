
public class VNMotor extends Motor{  
    String series;
    public VNMotor() {
     
    }

    public VNMotor(String brandName, String series, double price) {
       this.brandName=brandName;
       this.series=series;
       this.price=price;
        
    }
    
    /*Complete the below function for second test case*/
    public double getSalePrice() {
        double discount;
        if(price<3000) discount=price*5/100;
        else discount=price*10/100;
        return( price- discount);
    
    }  
    
    @Override
    public String toString(){
        String s= String.format("%s   %s  %.1f",brandName,series,price);
        return s;
    }

}
