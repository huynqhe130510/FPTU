import java.util.*;
import java.io.*;
import javax.swing.*;
class MyList {
  ArrayList<Emp> t;
  MyList() {t = new ArrayList<Emp>();}
  boolean isEmpty() {return(t.isEmpty());}
  void clear() {t.clear();}
  void add(Emp x) {
    int k = searchByCode(x.code);
    if(k>=0) {
     JOptionPane.showMessageDialog(null,"The code " + x.code + " already exists!");
     return;   
    }   
    t.add(x);
   }
  void traverse() {
    int n,i;
    n = t.size();
    for(i=0;i<n;i++)
     System.out.println(t.get(i));
   }
  void addMany(String [] a, String [] b, int [] c, int [] d) {
    int n,i; n = a.length;
    Emp x;
    for(i=0;i<n;i++)
     {x = new Emp(a[i],b[i],c[i],d[i]);
      t.add(x);
     }
   }
 void loadFile(String fname) {
  try {
   RandomAccessFile f = new RandomAccessFile(fname,"rw");
   if(f==null) return;
   String s; String [] a;
   String xCode, xName; int xSal, xBonus;
   while(true) {
     s = f.readLine();
     if(s==null || s.trim().length()<3) break;
     a = s.split("[|]");
     xCode = a[0].trim();
     xName = a[1].trim();
     xSal = Integer.parseInt(a[2].trim());
     xBonus = Integer.parseInt(a[3].trim());
     add(new Emp(xCode,xName,xSal,xBonus));
   }
   f.close();
      
  }
  catch(Exception e) { }
 }
  int searchByCode(String xCode) {
    int n,i; Emp x;
    n = t.size();
    for(i=0;i<n;i++) {
      x = t.get(i);
      if(x.code.equals(xCode)) return(i);
     }
    return(-1);
   }
  int searchByName(String xName) {
    int n,i; Emp x;
    n = t.size();
    for(i=0;i<n;i++) {
      x = t.get(i);
      if(x.name.equals(xName)) return(i);
     }
    return(-1);
   }
  void searchByName(MyList h, String xName) {
    int n,i; Emp x;
    n = t.size();
    for(i=0;i<n;i++) {
      x = t.get(i);
      if(x.name.equals(xName)) {
         h.add(new Emp(x.code,x.name,x.sal,x.bonus));
        }
     }
   }

  void searchByNameRel(MyList h, String xName) {
    int n,i; Emp x;
    n = t.size();
    for(i=0;i<n;i++) {
      x = t.get(i);
      if(x.name.indexOf(xName)>=0) {
          h.add(new Emp(x.code,x.name,x.sal,x.bonus));
        }
     }
   }

  int size() {return(t.size());}

  Emp get(int i) {
   int n = size();
   if(i<0 || i>=n) return(null);
   Emp x = (Emp) t.get(i);
   return(x);
      
  }
  void dele(int i) {
    int n = size();
    if(i<0 || i>=n-1) return; 
    t.remove(i);
   }

  void dele(String xName) {
    int k = searchByName(xName);
    dele(k);
   }

  void sortByName() {
    Collections.sort(t);
   }  

 }

