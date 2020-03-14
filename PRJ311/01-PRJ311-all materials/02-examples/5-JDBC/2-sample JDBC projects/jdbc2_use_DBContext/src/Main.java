import java.sql.*;
import com.context.*;
public class Main {

    public static void main(String[] args) {
       Connection con = null; 
       Statement s;
       ResultSet rs;
       DBContext t = new DBContext();
       try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = t.getConnection();
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
