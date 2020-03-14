import java.sql.*;
import java.io.*;
public class X_execute_Sql_file {
 public static void runSQL(String fname) throws Exception {
   RandomAccessFile f = new RandomAccessFile(fname,"r");
   String u,v;
   Connection con;
   Statement s;
   ResultSet rs;
   String xSql = null;
   String xTable = "Employee";
   DBConnect t = new DBConnect(); 
   try {
     con = t.getConnection();  
     s = con.createStatement();
     DatabaseMetaData dbm = con.getMetaData();
      // check if "Student" table is there
     rs = dbm.getTables(null, null, xTable, null);
     if (rs.next()) {
       // Table exists
       xSql = "drop table '" + xTable + "'";
       s.execute(xSql);
     }
     rs.close();
  
     //s.execute("drop table Employee");
     while(true) {
      u = f.readLine();
      if(u==null || u.trim().equals("")) break;
      u = u.trim();
      s.execute(u);
     }
     f.close();
     rs = s.executeQuery("select * from Employee");
     while(rs.next()) {
       System.out.print(rs.getString("id")+"\t");
       System.out.print(rs.getString("name")+"\t");
       System.out.print(rs.getFloat("salary")+"\t");
       System.out.println();
      }
      rs.close();
      s.execute("drop table Employee");
      s.close();
      con.close();
     } 
    catch(Exception e) {
      System.out.println(e);
     }   
    }
  public static void main(String[] args) throws Exception {
      runSQL("sqlFiles\\Employee.sql");
    }

}


