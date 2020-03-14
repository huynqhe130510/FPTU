package Q3;
public class ReservationCode {
    String code;
    String customerName;
    

    public ReservationCode() {
    }
    public ReservationCode(String code, String customerName) {
        this.code = code;
        this.customerName = customerName;
    }

    public String getCode() {
        StringBuilder str = new StringBuilder(code);
        for(int i = 0; i < str.length()-2; i+=3){
            str.insert(i+2, "-");
        }  
         return new String(str);
    }
     
   
    
    /*add and complete your other methods here (if needed)*/

    @Override
    public String toString() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }
    
}
