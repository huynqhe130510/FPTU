public class ReservationCode {
    String code;
    String customerName;

    public ReservationCode() {
    }
    
    public ReservationCode(String code, String customerName) {
        this.code=code;
        this.customerName=customerName;
    }
    
     
    String getCode() {
     int n,i;
        n=code.length();
        String s=code.substring(0, 2);
        for(i=2;i<n;i+=2){
            s+="-" +code.substring(i, i+2);
        }
        return s;
    }
    
    @Override
   public String toString(){
       String s= String.format("%s   %s",code,customerName);
       return s;
   }
    
}
