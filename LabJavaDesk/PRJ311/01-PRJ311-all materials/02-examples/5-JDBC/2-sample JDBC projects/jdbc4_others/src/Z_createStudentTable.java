import java.sql.*;
import java.io.*;
public class Z_createStudentTable {
  public static void main(String[] args) {
    Connection con = null;
    Statement s;
    ResultSet rs = null;
    String xSql = null;
    String xTable = "Student";
    DBConnect t = new DBConnect(); 
    try {
      con = t.getConnection();
      s = con.createStatement();
      DatabaseMetaData dbm = con.getMetaData();
      // check if "Student" table is there
     rs = dbm.getTables(null, null, xTable, null);
     rs.next();
     if (rs.getRow() > 0) {
       // Table exists
       xSql = "drop table " + xTable;   
       s.execute(xSql);
     }
     rs.close();
     String fname = "sqlFiles\\Student.sql";     
     RandomAccessFile f = new RandomAccessFile(fname,"r");
     String u,v;
     while(true) {
      u = f.readLine();
      if(u==null || u.trim().equals("")) break;
      u = u.trim();
      s.execute(u);
     }
     f.close();
     rs = s.executeQuery("select * from Student");
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
