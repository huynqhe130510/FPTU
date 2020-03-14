import java.sql.*;
public class A_testConnection {
  public static void main(String [] args) {
     DBConnect u = new DBConnect(); 
     try {
       Connection con = u.getConnection();
       System.out.println("The connection is successful");
     }
     catch(Exception e) {
       e.printStackTrace();
     }
  }  
}
