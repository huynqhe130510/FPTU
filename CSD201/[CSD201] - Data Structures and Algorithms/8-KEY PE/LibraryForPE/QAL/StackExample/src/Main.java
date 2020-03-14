
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
//        String s = "1+(2+3)*(8-10))(";
        int n = 27;
        MyStack m = new MyStack();
//        boolean isValid = true;
//        for (char c : s.toCharArray()) {
//            if(c == '(') m.push(c);
//            if(c == ')') {
//                if(m.isEmpty()) {
//                    isValid = false;
//                    break;
//                }
//                else{
//                    m.pop();
//                }
//            }
//        }
//        if(!isValid || !m.isEmpty()){
//            System.out.println("Invalid....");
//        }
//        else {
//            System.out.println("Valid");
//        }

        while (n != 0) {
            int r = n % 2;
            m.push(r);
            n = n / 2;
        }
        while (!m.isEmpty()) {
            System.out.print(m.pop());
        }
        System.out.println();
        
        Stack k = new Stack();
        
                

    }
}
