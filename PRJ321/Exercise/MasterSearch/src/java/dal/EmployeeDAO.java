/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;

/**
 *
 * @author Asus
 */
public class EmployeeDAO extends DBContext {

    public ArrayList<Employee> getEmpsByDeptID(int did, int id, String name, int gender, String dateFrom, String dateTo) {
        ArrayList<Employee> emps = new ArrayList<>();
        String sql;
        try {
            sql = "SELECT e.id,e.name,e.dob,e.gender,e.did,d.name as dname "
                    + "FROM Employee_1 e INNER JOIN Department d ON e.did = d.id "
                    + "where e.did = d.id\n";
            if (id != 0) {
                sql += "and e.id = " + id + "\n";
            }
            if (!name.equals("")) {
                sql += "and e.name like '%" + name + "%'\n";
            }
            if (gender != 2) {
                sql += "and e.gender = " + gender + "\n";
            }
            if (!dateFrom.equals("")) {
                sql += "and e.dob >= '" + dateFrom + "'\n";
            }
            if (!dateTo.equals("")) {
                sql += "and e.dob <= '" + dateTo + "'";
            }

            if (did != 0) {
                sql += "and d.id = " + did + "";
            }

            PreparedStatement statement = connection.prepareStatement(sql);
           
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));

                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));

                e.setDepartment(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }
}
