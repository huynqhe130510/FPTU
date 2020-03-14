import java.io.*;
import java.util.*;
public class Main
 { public static void main(String [] args) throws Exception
   {
    File f =new File("report.txt"); //File f =new File("c:\\myFile.txt");
    if(f.exists()) f.delete();
    
    RandomAccessFile f1 = new RandomAccessFile("persons.txt","r");
    RandomAccessFile f2 = new RandomAccessFile("report.txt","rw");
    String a, g;
    StringTokenizer t;
    int i=1;
    while((a = f1.readLine()) != null)
     {a = a.trim();
      if(a.length() == 0) continue;
      System.out.println(" Line " + i + ":");
      System.out.println(" " + a);
      t = new StringTokenizer(a,"|");
      while(t.hasMoreTokens())
        {g = t.nextToken();
         g = g.trim();
         f2.writeBytes(" * " + g);
        }
      f2.writeBytes("\n");
      i++;
     } 
    System.out.println();
   }
 }
