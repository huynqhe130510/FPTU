import java.sql.*;
public class F_create_table {
  public static void main(String[] args) {
    Connection con = null;
    Statement s;
    ResultSet rs;
    String xSql = null;
    DBConnect u = new DBConnect(); 
    try {
      con = u.getConnection();
      s = con.createStatement();
      DatabaseMetaData dbm = con.getMetaData();
      // check if "Student" table is there
      rs = dbm.getTables(null, null, "thu", null);
      rs.next();
      if (rs.getRow() > 0) {
        // Table exists
        xSql = "drop table thu";   
        s.execute(xSql);
       }
      rs.close();

      xSql = "create table thu (name char(30), age int)";
      s.execute(xSql);              

      xSql = "insert into thu values ('Nguyen Cuong', 19)";
      s.execute(xSql);              
      xSql = "insert into thu values ('Van Thang', 22)";
      s.execute(xSql);              
      xSql = "insert into thu values ('Ho Thu Ha', 20)";
      s.execute(xSql);              

      xSql = "select * from thu";
      rs = s.executeQuery(xSql);

      while(rs.next()) {
        System.out.print(rs.getString("name")+"\t");
        System.out.print(rs.getInt("age")+"\t");
        System.out.println();
       }
      rs.close();
      s.execute("drop table thu");
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
