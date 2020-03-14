public class ReservationCode {
    
    String code, customerName;
    
    public ReservationCode(String code, String customerName) {
        this.code = code;
        this.customerName = customerName;
    }
    
     
    String getCode() {
        String out = "";
        for (int i = 0; i < code.length(); i+= 3) {
            out = out + code.charAt(i)  + code.charAt(i + 1)
                    + code.charAt(i + 2) + "-";
        }
        return out.substring(0, out.length()-1);
    }

    @Override
    public String toString() {
        return customerName+"   "+code;
    }
    
    
    
}
