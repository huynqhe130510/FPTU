import java.sql.*;
public class Y_check_TableExist {
  public static void main(String[] args) {
    Connection con = null;
    Statement s;
    ResultSet rs = null;
    String xSql = null;
    String xTable = "Student";
    DBConnect u = new DBConnect(); 
    try {

     con = u.getConnection();
     DatabaseMetaData dbm = con.getMetaData();
      // check if "Student" table is there
     rs = dbm.getTables(null, null, xTable, null);
     s = con.createStatement();
     rs.next();
     if (rs.getRow() > 0) {
       // Table exists
       javax.swing.JOptionPane.showMessageDialog(null,"The table " + xTable + " exists");
       xSql = "drop table " + xTable;   
       s.execute(xSql);
     }
      else {
       // Table does not exist
       javax.swing.JOptionPane.showMessageDialog(null,"The table " + xTable + " does not exists");
       xSql = "Create Table Student (RollNo varchar(10),Name varchar(30),mark int, PRIMARY KEY (RollNo))";
       s.execute(xSql);
     }
      rs.close();
      con.close();
     }
     catch(Exception e) {
       System.out.println(e);
      }   
     System.out.println();
  }
    
}
