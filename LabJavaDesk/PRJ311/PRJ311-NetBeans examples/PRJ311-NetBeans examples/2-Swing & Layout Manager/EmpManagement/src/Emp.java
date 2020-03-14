import java.util.*;
class Emp implements Comparable
 {String code,name; int sal,bonus;
  Emp() {}
  Emp(String xCode, String xName, int xSal, int xBonus)
   {code=xCode;name=xName;sal=xSal;bonus=xBonus;
   } 
  void setData(String xCode, String xName, int xSal, int xBonus)
   {code=xCode;name=xName;sal=xSal;bonus=xBonus;
   }
  public String toString()
   {return(code+", "+name +", "+sal + ", " + bonus);
   }
  public int compareTo(Object x)
   {Emp y = (Emp) x;
    return(name.compareTo(y.name));
   }  

 }
