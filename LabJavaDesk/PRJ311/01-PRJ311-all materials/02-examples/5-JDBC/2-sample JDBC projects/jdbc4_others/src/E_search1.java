import java.sql.*;
public class E_search1 { 
  public static void main(String[] args) {
    Connection con;  
    Statement s;
    ResultSet rs;
    String xSql = null;
    DBConnect u = new DBConnect(); 
    try {
      con = u.getConnection();
      s = con.createStatement();
      rs = s.executeQuery("select * from Student");
      while(rs.next()) {
        System.out.print(rs.getString("rollNo")+"\t");
        System.out.print(rs.getString("name")+"\t");
        System.out.print(rs.getInt("mark")+"\t");
        System.out.println();
       }
      rs.close();
      System.out.println(" Searching:");
      String xRollNo;
     xRollNo = javax.swing.JOptionPane.showInputDialog(null,"Enter rollno to be searched:");;
     xRollNo = xRollNo.trim();
     int r = xRollNo.length();
     xSql = "select * from Student where left(rollno," + r + ") = '" + xRollNo + "'";
           
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
