import java.sql.*;
public class DBConnect {
  public Connection getConnection() throws Exception {
    Connection con = null;  
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String xUrl = "jdbc:sqlserver://" + xServer + ":" + xPort + ";databaseName=" + xDBName; 
    con = DriverManager.getConnection(xUrl,xUser,xPW);
    return(con);   
  }
  //private String xServer = "10.22.114.150";
  private String xServer = "localhost";
  private String xPort = "1433";
  private String xDBName = "StudentDB";
  private String xUser = "sa";
  private String xPW = "sa"; 
}
