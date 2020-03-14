
package dao;

import context.DBContext;
import entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AddDAO {
     private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public void insertID(String cid, int sid) throws SQLException {
        try {
            String query = "insert into Character_skill(cid,sid) values(?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            ps.setInt(2, sid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }
    }
    public void insertCharacter(String id, String name, int gender) throws SQLException {
        try {
            String query = "insert into Characters(cid,name,gender,created_date) values(?,?,?,getdate())";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, gender);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }
    }
    public List<Skill> getAllSkill() throws SQLException {
        List<Skill> list = new ArrayList<>();
        try {
            String query = "select * from skills";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Skill k = new Skill(rs.getInt("sid"),
                        rs.getString("name"));
                list.add(k);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }
}
