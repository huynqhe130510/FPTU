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
        for(int i = 0; i < str.length()-3; i+=4){
            str.insert(i+3, "-");
        }  
         return new String(str);
    }
    
     
    
    
    /*add and complete your other methods here (if needed)*/

    @Override
    public String toString() {
        return this.code; //To change body of generated methods, choose Tools | Templates.
    }
//     String getCode() {
//        String out = "";
//        for (int i = 0; i < code.length(); i+= 3) {
//            out = out + code.charAt(i)  + code.charAt(i + 1)
//                    + code.charAt(i + 2) + "-";
//        }
//        return out.substring(0, out.length()-1);
//    }
}
