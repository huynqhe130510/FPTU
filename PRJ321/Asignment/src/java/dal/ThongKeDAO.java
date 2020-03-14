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
import model.Thong_Ke;

/**
 *
 * @author huyNguyen
 */
public class ThongKeDAO extends DBContext {

    public ArrayList<Thong_Ke> thongKe(String from, String to) {
        ArrayList<Thong_Ke> list = new ArrayList<>();
        try {
            String sql = " select cdh.Ten_Khach_Hang, cdh.Sdt, cdh.Dia_Chi,a.Ten_Ao,cl.Ten as chatlieu, dh.So_Luong,dh.Don_Gia, dh.Tong \n"
                    + "  from Chi_Tiet_Don_Hang cdh, Don_Hang dh, Ao a, Chat_Lieu cl\n"
                    + "  where cdh.Ma = dh.Ma_Chi_Tiet_Don_Hang\n"
                    + "	and a.Ma_Ao = dh.Ma_Ao\n"
                    + "	and cl.Ma = a.Ma_Chat_Lieu\n"
                    + "	and cdh.Ngay_Ban >= '" + from + "'\n"
                    + "	and cdh.Ngay_Ban <= '" + to + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Thong_Ke thong_Ke = new Thong_Ke();
                thong_Ke.setTen(rs.getString("Ten_Khach_Hang"));
                thong_Ke.setSdt(rs.getString("Sdt"));
                thong_Ke.setDia_chi(rs.getString("Dia_Chi"));
                thong_Ke.setTen_ao(rs.getString("Ten_Ao"));
                thong_Ke.setChat_lieu(rs.getString("chatlieu"));
                thong_Ke.setSo_luong(rs.getInt("So_Luong"));
                thong_Ke.setDon_gia(rs.getFloat("Don_Gia"));
                thong_Ke.setTong(rs.getInt("Tong"));
                list.add(thong_Ke);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getTong(String from, String to) {
        String sum = null;
        try {
            String sql = "  select SUM(dh.Tong) as Tong\n"
                    + "  from Chi_Tiet_Don_Hang cdh, Don_Hang dh\n"
                    + "  where cdh.Ma = dh.Ma_Chi_Tiet_Don_Hang\n"
                    + "	and cdh.Ngay_Ban >= '" + from + "'\n"
                    + "	and cdh.Ngay_Ban <= '" + to + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                sum = rs.getString("Tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
    public String getTongSoLuong(String from, String to) {
        String sum = null;
        try {
            String sql = "  select SUM(So_Luong) as Tong\n"
                    + "  from Chi_Tiet_Don_Hang cdh, Don_Hang dh\n"
                    + "  where cdh.Ma = dh.Ma_Chi_Tiet_Don_Hang\n"
                    + "	and cdh.Ngay_Ban >= '" + from + "'\n"
                    + "	and cdh.Ngay_Ban <= '" + to + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                sum = rs.getString("Tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
}
