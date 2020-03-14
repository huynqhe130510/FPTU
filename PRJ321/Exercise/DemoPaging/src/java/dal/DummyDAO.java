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
import model.Dummy;

/**
 *
 * @author sonnt
 */
public class DummyDAO extends DBContext {

    public ArrayList<Dummy> paging(int pageindex, int pagesize, String search) {
        ArrayList<Dummy> dummies = new ArrayList<>();
        String sql;

        try {
            if (search == null) {
                sql = "SELECT id,name FROM\n"
                        + "	(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM  Dummy) tblDummy\n"
                        + "WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            } else {
                sql = "SELECT id,name FROM \n"
                        + "(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM  Dummy where name like '%" + search + "%') tblDummy\n"
                        + "WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dummy d = new Dummy();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                dummies.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DummyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dummies;
    }

    public int count(String search) {
        String sql;

        try {
            if (search != null) {
                sql = "SELECT COUNT(*) as rownum FROM \n"
                        + "(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM  Dummy where name like '%" + search + "%') tblDummy";
            } else {
                sql = "SELECT COUNT(*) as rownum FROM Dummy";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("rownum");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DummyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }
}
