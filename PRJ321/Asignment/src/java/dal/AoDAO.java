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
import model.Ao;
import model.Chat_Lieu;

/**
 *
 * @author huyNguyen
 */
public class AoDAO extends DBContext {

    public ArrayList<Ao> getAos(String s) {
        ArrayList<Ao> aos = new ArrayList<>();
        String sql;
        try {
            if (s != null) {
                sql = "SELECT   [Ma_Ao]\n"
                        + "      ,[Ten_Ao]\n"
                        + "      ,[Gia]\n"
                        + "      ,[So_Luong]\n"
                        + ",c.Ten\n"
                        + "  FROM [AsignmentJavaWeb].[dbo].[Ao] a, Chat_Lieu c\n"
                        + "  where a.Ma_Chat_Lieu = c.Ma and Ten_Ao like '%" + s + "%'";

            } else {
                sql = "SELECT TOP 1000 [Ma_Ao]\n"
                        + "      ,[Ten_Ao]\n"
                        + "      ,[Gia]\n"
                        + "      ,[So_Luong]\n"
                        + "      ,c.Ten\n"
                        + "  FROM [AsignmentJavaWeb].[dbo].[Ao] a, Chat_Lieu c\n"
                        + "  Where a.Ma_Chat_Lieu = c.Ma";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ao ao = new Ao();

                ao.setMa_ao(rs.getString("Ma_Ao"));
                ao.setTen_ao(rs.getString("Ten_Ao"));
                ao.setGia(rs.getInt("Gia"));
                ao.setSo_luong(rs.getInt("So_Luong"));
                ao.setChat_lieu(rs.getString("Ten"));

                aos.add(ao);
            }

        } catch (SQLException e) {
        }

        return aos;
    }

    public Ao getAo(String Ma_Ao) {

        try {
            String sql = "SELECT [Ma_Ao]\n"
                    + "      ,[Ten_Ao]\n"
                    + "      ,[Gia]\n"
                    + "      ,[So_Luong]\n"
                    + "  FROM [AsignmentJavaWeb].[dbo].[Ao]"
                    + "  Where Ma_Ao = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Ma_Ao);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ao ao = new Ao();

                ao.setMa_ao(rs.getString("Ma_Ao"));
                ao.setTen_ao(rs.getString("Ten_Ao"));
                ao.setGia(rs.getInt("Gia"));
                ao.setSo_luong(rs.getInt("So_Luong"));

                return ao;
            }

        } catch (NumberFormatException | SQLException e) {
        }

        return null;
    }

}
