package st3_solution;

// ======= DO NOT EDIT THIS FILE ============
import java.io.*;
import java.util.*;
class Main
 {public static void main(String args[]) throws Exception
   {char choice;
    Scanner r = new Scanner(System.in);
    int nTestCases = 6;
    Marking w = new Marking(nTestCases);
    Graph t = new Graph();
    while(true)
     {System.out.println();
      System.out.println(" 1. Test f1 (1 mark)");
      System.out.println(" 2. Test f2 (1 mark)");
      System.out.println(" 3. Test f3 (1 mark)");
      System.out.println(" 4. Test f4 (1 mark)");
      System.out.println(" 5. Test f5 (1 mark)");
      System.out.println(" 6. Test f6 (1 mark)");
      System.out.println(" a. Test all cases & view marks");
      System.out.println(" 0. Exit ");
      System.out.print("    Your selection (0 -> a): ");
      choice = r.nextLine().trim().charAt(0);
      choice = Character.toUpperCase(choice);
      if(choice=='0') break;
      switch(choice)
       {
        case '1': System.out.println("\n 1. Test f1:");
                    t.f1();
                    System.out.println("Your output:");
                    Lib.viewFile("f1.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f1.txt");
                    if(w.isEqual("f1.txt","R_f1.txt"))
                      System.out.println("Mark = " + w.mark[1]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case '2': System.out.println("\n 2. Test f2:");
                    t.f2();
                    System.out.println("Your output:");
                    Lib.viewFile("f2.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f2.txt");
                    if(w.isEqual("f2.txt","R_f2.txt"))
                      System.out.println("Mark = " + w.mark[2]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case '3': System.out.println("\n 3. Test f3:");
                    t.f3();
                    System.out.println("Your output:");
                    Lib.viewFile("f3.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f3.txt");
                    if(w.isEqual("f3.txt","R_f3.txt"))
                      System.out.println("Mark = " + w.mark[3]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case '4': System.out.println("\n 4. Test f4:");
                    t.f4();
                    System.out.println("Your output:");
                    Lib.viewFile("f4.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f4.txt");
                    if(w.isEqual("f4.txt","R_f4.txt"))
                      System.out.println("Mark = " + w.mark[4]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case '5': System.out.println("\n 5. Test f5:");
                    t.f5();
                    System.out.println("Your output:");
                    Lib.viewFile("f5.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f5.txt");
                    if(w.isEqual("f5.txt","R_f5.txt"))
                      System.out.println("Mark = " + w.mark[5]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case '6': System.out.println("\n 6. Test f6:");
                    t.f6();
                    System.out.println("Your output:");
                    Lib.viewFile("f6.txt");
                    System.out.println("Correct output:");
                    Lib.viewFile("R_f6.txt");
                    if(w.isEqual("f6.txt","R_f6.txt"))
                      System.out.println("Mark = " + w.mark[6]);
                        else
                          System.out.println("Mark = 0");
                    break;

        case 'A': 
                    t.f1();
                    t.f2();
                    t.f3();
                    t.f4();
                    t.f5();
                    t.f6();
                    w.marking();
                    break;
       }
     }      
    System.out.println();
   }
 }
