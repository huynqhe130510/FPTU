import java.sql.*;
public class C_connect_outside {

  public static void main(String[] args) {
    Connection con;
    Statement s;
    ResultSet rs;
    DBConnect u = new DBConnect(); 
    try { 
      con = u.getConnection();
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
     catch(Exception e) {
       e.printStackTrace();
      }   
     System.out.println();
    }
  }
