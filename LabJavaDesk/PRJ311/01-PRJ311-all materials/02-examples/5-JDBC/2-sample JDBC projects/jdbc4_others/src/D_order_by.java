import java.sql.*;
public class D_order_by {
  public static void main(String[] args) {
    Connection con;
    Statement s;
    ResultSet rs;
    String xSql = null;
    DBConnect u = new DBConnect(); 
    try {
      con = u.getConnection();
      s = con.createStatement();
      xSql = "select * from Student order by mark, name";
      rs = s.executeQuery(xSql);
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
