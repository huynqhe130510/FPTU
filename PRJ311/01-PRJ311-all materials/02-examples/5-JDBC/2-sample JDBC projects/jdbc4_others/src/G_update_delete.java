import java.sql.*;
public class G_update_delete {
  public static void main(String[] args) {
    Connection con;
    Statement s;
    ResultSet rs;
    String xSql = null;
    DBConnect u = new DBConnect(); 
    try {
      con = u.getConnection();  
      s = con.createStatement();
      // s.execute("drop table thu");
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

      xSql = "update thu set name = 'Tran Phung' where name = 'Van Thang'";
      s.execute(xSql);

      xSql = "select * from thu";
      rs = s.executeQuery(xSql);

      System.out.println("\nAfter updating");
      while(rs.next()) {
        System.out.print(rs.getString("name")+"\t");
        System.out.print(rs.getInt("age")+"\t");
        System.out.println();
       }
      rs.close();
             
      System.out.println("\nDelete Ho Thu Ha");

      xSql = "delete from thu where name = 'Ho Thu Ha'";
      s.execute(xSql);              
      xSql = "select * from thu";
      rs = s.executeQuery(xSql);

      System.out.println("\nAfter deleting");
      while(rs.next()) {
        System.out.print(rs.getString("name")+"\t");
        System.out.print(rs.getInt("age")+"\t");
        System.out.println();
       }
      rs.close();
      s.execute("drop table thu");
      s.close();
      con.close();
     }
     catch(Exception e) {
       System.out.println(e);
      }   
     System.out.println();
   }
    
}


