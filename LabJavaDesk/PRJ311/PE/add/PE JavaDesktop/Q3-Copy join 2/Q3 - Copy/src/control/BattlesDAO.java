/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Battles;
import model.Outcomes;

/**
 *
 * @author TOM
 */
public class BattlesDAO {
    public Battles searchAll(String battle) throws Exception {
        Connection connect = new DBContext().getConnection();
        String query = "select * from battles where name like '%"+battle+"%'";
        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        //Create an empty list of group
        Battles b = new Battles();
        while (rs.next()) {
           
            battle = rs.getString("name");
            Date date= rs.getDate("date");
            b = new Battles(battle, date);
        }
        rs.close();
        connect.close();
        return b;
    }
}
