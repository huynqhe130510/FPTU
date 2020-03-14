import java.sql.*;
public class E_search2 { 
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
      /* The cursor on the rs after this statement is in the BOF area, i.e. it is before the first record.
         Thus the first rs.next() statement moves the cursor to the first record
      */
      rs.next();
      if(rs.getRow()==0) { // The current row (0 if no current row)
       javax.swing.JOptionPane.showMessageDialog(null,"The student with rollno " + xRollNo + " is not found");
      }
      else {
       System.out.print(rs.getString("rollNo")+"\t");
       System.out.print(rs.getString("name")+"\t");
       System.out.print(rs.getInt("mark")+"\t");
       System.out.println();
       while(rs.next()) {
         System.out.print(rs.getString("rollNo")+"\t");
         System.out.print(rs.getString("name")+"\t");
         System.out.print(rs.getInt("mark")+"\t");
         System.out.println();
        }
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
