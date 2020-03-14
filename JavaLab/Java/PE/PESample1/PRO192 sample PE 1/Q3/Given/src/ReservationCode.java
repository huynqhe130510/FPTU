public class ReservationCode {
    String code;
    String customerName;
    public ReservationCode(String code, String customerName) {
        this.code=code;
        this.customerName= customerName;
    }
    
     
    String getCode() {
        StringBuilder t =new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            t.append(code.charAt(i));
            if((i%2==1)&&(i<code.length()-1)) t.append('-');
        }
        return t.toString();
    }
    
    String getCode2(){
        int n,i;
        n=code.length();
        String s=code.substring(0, 2);
        for(i=2;i<n;i+=2){
            s+="-" +code.substring(i, i+2);
        }
        return s;
    }

    @Override
    public String toString() {
        return customerName + "  " +code  ;
    }
    
    
}
