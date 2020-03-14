public class Main {
 public static boolean isValidName(String name) {
    String s = "[A-Z][a-zA-Z ]*";
    return(name.matches(s));
  }

 public static void checkName(String name) {
   boolean t = isValidName(name);
   if (t)
    System.out.println("The name is valid");
     else
      System.out.println("The name is not valid");
  }

  public static void main(String[] args) {
    String name;
    name = "Hoa La Canh";
    checkName(name);
    name = "Hoa 12 La";
    checkName(name);
    name = "";
    checkName(name);
    name = " ";
    checkName(name);
  }
    
}
