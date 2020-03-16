/*
* DBContext.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBContext.<br>
 *
 * <pre>
 * Class mở và đóng kết nối đến sqlServer
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * .getConnection
 * .closeConnection
 *
 * </pre>
 *
 * @author FU HuyNQ130510
 * @version 1.0
 */
public class DBContext {

    /**
     * getConnection <br>
     * 
     * Mở kết nối tới SQLServer
     * Trường hợp gặp lỗi thực hiện exception.
     * 
     * @return connection
     * @throws Exception 
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "localhost";
    private final String dbName = "photographer";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    
    /**
     * closeConnection <br>
     * 
     * Thực hiện việc đóng kết nối nếu bị lỗi thực hiện exception
     * 
     * @param rs
     * @param ps
     * @param con
     * @throws SQLException 
     */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
