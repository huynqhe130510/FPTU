/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Outcomes;

/**
 *
 * @author TOM
 */
public class OutcomesDAO {

    public List<Outcomes> searchByShip(String ship) throws Exception {
        Connection connect = new DBContext().getConnection();
        String query = "select * from outcomes  where ship like '%" + ship + "%'";
        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        //Create an empty list of group
        List<Outcomes> out = new ArrayList<>();
        while (rs.next()) {
            ship = rs.getString("ship");
            String battle = rs.getString("battle");
            String result = rs.getString("result");
            out.add(new Outcomes(ship, battle, result));
        }
        rs.close();
        connect.close();
        return out;
    }

    public List<Outcomes> searchByBattle(String battle) throws Exception {
        Connection connect = new DBContext().getConnection();
        String query = "select *\n"
                + " from Outcomes o , Battles b \n"
                + " where o.battle = b.name and o.ship like '%"+battle+"%'";
        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        //Create an empty list of group
        List<Outcomes> out = new ArrayList<>();
        while (rs.next()) {
            String ship = rs.getString("ship");
             battle = rs.getString("battle");
            String result = rs.getString("result");
            out.add(new Outcomes(ship, battle, result));
        }
        rs.close();
        connect.close();
        return out;
    }
}
