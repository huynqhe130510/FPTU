class Main
 {public static void main(String args[]) throws Exception
   {String a=""; char ch; float x;double y;
    System.out.print(" Enter float number: ");
    while((ch = (char) System.in.read()) !='\n')
       a += ch;
    x = Float.parseFloat(a.trim());
    y = Double.parseDouble(a.trim());
    System.out.println(" A string entered is: " + a);
    System.out.println(" A float number entered is: " + x);
    System.out.println(" A double number entered is: " + y);
   }
 }
