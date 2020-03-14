
public class Main {

 public static boolean isValidEmail(String email) {
   String s = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
   return(email.matches(s));
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
    email = "HoaLa@fpt@edu.vn";
    checkEmail(email);
  
    }
 }
