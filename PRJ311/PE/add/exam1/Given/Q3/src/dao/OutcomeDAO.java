package dao;

import Entity.Outcome;
import com.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OutcomeDAO {

    public List<Outcome> selectByShipname(String name) throws Exception {
        Connection conn = new DBContext().getConnection();
        String query = "select *\n"
                + "from Outcomes\n"
                + "where ship like '%" + name + "%'";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Outcome> outcomes = new ArrayList<>();
        while(rs.next()){
            name = rs.getString("ship");
            String Battle = rs.getString("battle");
            String result = rs.getString("result");
            outcomes.add(new Outcome(name, Battle, result));
        }
        rs.close();
        conn.close();
        return  outcomes;
    }

}
