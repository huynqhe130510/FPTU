
public class VNMotor extends Motor{  
    
    String series;
    public VNMotor() {
       
    }

    public VNMotor(String brandName, String series, double price) {
       this.brandName=brandName;
       this.series=series;
       this.price= price;
        
    }
    
    /*Complete the below function for second test case*/
    public double getSalePrice() {
       if(this.price<3000){
           return this.price*0.95;
       }
       return this.price*0.9;
    }  
    
    //add and complete your other methods here (if needed)
    
    @Override
    public String toString() {
         String s= String.format("%s  %s %.1f",brandName,series, price);
        return  s ;
    }

}
