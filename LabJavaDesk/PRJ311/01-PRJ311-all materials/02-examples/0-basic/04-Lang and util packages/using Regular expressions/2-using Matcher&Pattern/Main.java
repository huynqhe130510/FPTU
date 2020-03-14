import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

 public static boolean isValidEmail(String email) {
   String s = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
   boolean t = Pattern.matches(s,email);
   return(t);
  }

 public static boolean isValidEmail2(String email) {
   String s = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
   Pattern p = Pattern.compile(s);
   Matcher m = p.matcher(email);
   return(m.matches());
  }

 public static void checkEmail(String email) {
   boolean t = isValidEmail(email);
   if (t)
    System.out.println("The email is valid");
     else
      System.out.println("The email is not valid");
  }

   
   public static void main( String args[] ) {

    String email = "HoaLa@fpt.edu.vn";
    checkEmail(email);
    email = "@HoaLa.fpt.edu.vn";
    checkEmail(email);
  
    }
 }
