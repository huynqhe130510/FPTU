//Suppose that the database named qldiem already created in SQL Server
import java.sql.*;
import java.util.*;

public class B_connect_inside {
  public static void main(String[] args) {
    //String xUrl = "jdbc:sqlserver://CAU-PD:1433;databaseName=StudentDB"; 
    String xUrl = "jdbc:sqlserver://localhost:1433;databaseName=StudentDB"; 
    String xUser = "sa";
    String xPW = "sa";
    Connection con;
    Statement s;
    ResultSet rs;
    try {
      /*Load the driver. The following statement checks whether the class com.mysql.jdbc.Driver
        is available or not. If it is available, the statement below may be absent. */ 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       }
       catch(ClassNotFoundException e) {
         e.printStackTrace();
        }     
  
    try {
      // The class DriverManager has private constructor. Its' members are static
      con = DriverManager.getConnection(xUrl,xUser,xPW);

      s = con.createStatement();
      rs = s.executeQuery("select * from Student");
      /* The cursor on the rs after this statement is in the BOF area, i.e. it is before the first record.
         Thus the first rs.next() statement moves the cursor to the first record
      */
      while(rs.next()) {
        System.out.print(rs.getString("rollNo")+"\t");
        System.out.print(rs.getString("name")+"\t");
        System.out.print(rs.getInt("mark")+"\t");
        System.out.println();
       }
       rs.close();
       s.close();
       con.close();
      }
     catch(SQLException e) {
       e.printStackTrace();
      }   
     System.out.println();
    }
  }
