/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tienpro
 */
public class DBContext {
    //Khai bao doi tuong ket noi va xu ly CSDL
    static Connection cnn;     //Ket noi CSDL
    static Statement stm;      //Thuc thi cau lenh SQl
    /*
    * Ham ket noi CSDL
    */
    static public Connection getConnection(){
        try {
            //Chua cac cau lenh ket noi
            String url = "jdbc:sqlserver://localhost:1433;databasename=StudentDB";
            cnn = DriverManager.getConnection(url,"sa","sa");
        } catch (Exception e) {
            //neu loi trong luc ket noi
            System.out.println(e.getMessage());
        }
        
        return cnn;
    }
    
    static public Statement connectDB(){
        try {
            //Chua cac cau lenh ket noi
            cnn = DBContext.getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            //neu loi trong luc ket noi
            System.out.println(e.getMessage());
        }
        return stm;
    }
}
