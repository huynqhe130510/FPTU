
public class MyString implements IString{

    @Override
    public int sum(String string) {
        int sum =0, a=0, b=0,count=0;
        for (int i = 0; i < string.length(); i++) {
            if(Character.isDigit(i)){
                a =(int) string.charAt(i);
                count++;
                        if(count==1)
                break;
            }
        }
        for (int i = 0; i < string.length(); i++) {
            if(Character.isDigit(i)){
                b =(int) string.charAt(i);
                count++;
                        if(count==1)
                break;
            }
        }
        sum = a+b;
        
        return sum;
    }

    @Override
    public String getCode(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
