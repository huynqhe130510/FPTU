import java.sql.*;
public class Main {

    public static void main(String[] args) {
       Connection con; 
       String xUrl = "jdbc:sqlserver://localhost:1433;databaseName = StudentDB";
       String xUser = "sa";
       String xPW = "sa";
       try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(xUrl,xUser,xPW);
         System.out.println("Connection is successful.");
       }
       catch(Exception e) {
         System.out.println("Connection failed.");
       }
    }
    
}
