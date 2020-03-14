import java.io.*;
class Emp implements Serializable
 {String name; int salary,bonus;
  Emp(String xName, int xSalary, int xBonus)
   {name=xName;salary=xSalary;bonus=xBonus;
   }
  public String toString()
   {return("("+name + "," + salary + "," + bonus + ") ");
   }
  void setData(String xName, int xSalary, int xBonus)
   {name=xName;salary=xSalary;bonus=xBonus;
   }
  int calcIncome()
   {return(salary + bonus);
   }
 }