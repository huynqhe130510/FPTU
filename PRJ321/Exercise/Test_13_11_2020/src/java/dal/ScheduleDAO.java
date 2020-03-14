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
import model.Room;
import model.Schedule;

/**
 *
 * @author huyNguyen
 */
public class ScheduleDAO extends DBContext {

    public ArrayList<Schedule> getSchedules(String from, String to) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String sql = "select r.id as rid, r.name, s.id as sid, s.room_id, s.[from], s.[to]\n"
                    + "from Room r, Schedule s\n"
                    + "where r.id = s.room_id\n"
                    + "	and s.[from] >= '" + from + "'\n"
                    + "	and s.[to] <= '" + to + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("name"));

                Schedule s = new Schedule();
                s.setId(rs.getInt("sid"));
                s.setRoom(r);
                s.setFrom(rs.getString("from"));
                s.setTo(rs.getString("to"));

                schedules.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedules;
    }

    public ArrayList<Schedule> getSchedules_1() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String sql = "select r.name\n"
                    + "from Room r, Schedule s\n"
                    + "where r.id = s.room_id\n"
                    + "	and s.[from] is null \n"
                    + "	and s.[to] is null";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setName(rs.getString("name"));

                Schedule s = new Schedule();
                s.setRoom(r);
                schedules.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedules;
    }
}
