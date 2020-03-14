
public class Main {

 public static boolean isValidEmail(String email) {
   String s = "^.+@.+\\..+$";
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
  
    }
 }
