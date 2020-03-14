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
import model.Skill;

/**
 *
 * @author huyNguyen
 */
public class CharacterDAO extends DBContext {

    public ArrayList<model.Character> getChracters() {
        ArrayList<model.Character> characters = new ArrayList<>();
        try {
            String sql = "select c.cid, c.name, c.created_date, c.gender,s.sid, s.name as sname\n"
                    + "from Character_Skill ck, Characters c, Skills s\n"
                    + "where ck.cid = c.cid\n"
                    + "	and ck.sid = s.sid\n";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                model.Character c = new model.Character();
                c.setId(rs.getString("cid"));
                c.setName(rs.getString("name"));
                c.setDate(rs.getString("created_date"));
                c.setGender(rs.getBoolean("gender"));

                ArrayList<Skill> skills = new ArrayList<>();
                Skill s = new Skill();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                skills.add(s);
                c.setS(skills);

                characters.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CharacterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CharacterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;
    }

    public ArrayList<model.Skill> getSkills(String cid) {
        ArrayList<model.Skill> skills = new ArrayList<>();
        try {
            String sql = "select s.name\n"
                    + "from Character_Skill ck join Skills s\n"
                    + "on ck.sid = s.sid\n"
                    + "	and ck.cid = '" + cid + "'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                model.Skill s = new model.Skill();
                skills.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CharacterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CharacterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return skills;
    }

}
