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
import model.DepartmentModel;
import model.StudentModel;

/**
 *
 * @author sonnt
 */
public class DepartmentDAO extends BaseDAO<DepartmentModel> {

    @Override
    public ArrayList<DepartmentModel> all() {
        try {
            ArrayList<DepartmentModel> departments = new ArrayList<>();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [Department]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DepartmentModel d = new DepartmentModel();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                departments.add(d);
            }
            return departments;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DepartmentModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(DepartmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
