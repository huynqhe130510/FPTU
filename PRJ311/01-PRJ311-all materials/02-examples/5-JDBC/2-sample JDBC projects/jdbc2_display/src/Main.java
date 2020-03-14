import java.sql.*;
public class Main {

    public static void main(String[] args) {
       Connection con = null; 
       Statement s;
       ResultSet rs;
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
       try {
        s = con.createStatement();
        rs = s.executeQuery("select * from student");
        String xRollNo, xName; int xMark;
        while(rs.next()) {
           xRollNo = rs.getString("RollNo");
           xName = rs.getString("name");
           xMark = rs.getInt("mark");
           System.out.println(xRollNo + ", " + xName + ", " + xMark);
        }
        rs.close();        
       }
       catch(Exception e) {
       }
       
    }
    
}
