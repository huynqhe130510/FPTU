class Main
 {public static void main(String args[]) throws Exception
   {String a=""; char ch; int x;
    System.out.print(" Enter integer number: ");
    while((ch = (char) System.in.read()) !='\n')
       a += ch;
    x = Integer.parseInt(a.trim());
    System.out.println(" An integer number entered is: " + x);
   }
 }
