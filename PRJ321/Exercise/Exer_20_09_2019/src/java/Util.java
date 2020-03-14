package DBContext;


import DBContext.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author huyNguyen
 */
public class Util {

    public static List<Employee> Connect() {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        Statement s;
        ResultSet rs;
        ConnectDB t = new ConnectDB();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = t.getConnection();
            System.out.println("Connection is successful.");
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
        try {
            s = con.createStatement();
            rs = s.executeQuery("select * from Employee");

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDate(rs.getDate("dob"));
                employee.setBit(rs.getBoolean("gender"));
                employees.add(employee);
            }
        } catch (Exception e) {
        }
        return employees;
    }
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list = Connect();
        System.out.println(list.size());
    }
}
