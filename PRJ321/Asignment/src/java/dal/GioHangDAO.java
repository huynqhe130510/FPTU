/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Chi_Tiet_Don_Hang;
import model.Don_Hang;

/**
 *
 * @author huyNguyen
 */
public class GioHangDAO extends DBContext {

    public void insert(Chi_Tiet_Don_Hang chi_Tiet_Don_Hang) {
        try {
            connection.setAutoCommit(false);
            String insert_chi_tiet_don_hang
                    = "INSERT INTO [AsignmentJavaWeb].[dbo].[Chi_Tiet_Don_Hang]\n"
                    + "           ([Ngay_Ban]\n"
                    + "           ,[Ten_Khach_Hang]\n"
                    + "           ,[Sdt]\n"
                    + "           ,[Dia_Chi])\n"
                    + "     VALUES\n"
                    + "           (GETDATE()\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement insertPreparedStatement
                    = connection.prepareStatement(insert_chi_tiet_don_hang);
            insertPreparedStatement.setString(1, chi_Tiet_Don_Hang.getTen());
            insertPreparedStatement.setString(2, chi_Tiet_Don_Hang.getSdt());
            insertPreparedStatement.setString(3, chi_Tiet_Don_Hang.getDia_chi());
            insertPreparedStatement.executeUpdate();

            String select_ma_chi_tiet_don_hang = "SELECT @@IDENTITY as oid";
            PreparedStatement ps_select_ma_chi_tiet_don_hang
                    = connection.prepareStatement(select_ma_chi_tiet_don_hang);
            ResultSet rs = ps_select_ma_chi_tiet_don_hang.executeQuery();
            if (rs.next()) {
                chi_Tiet_Don_Hang.setMa(rs.getInt("oid"));
            }

            String insert_don_hang
                    = "INSERT INTO [AsignmentJavaWeb].[dbo].[Don_Hang]\n"
                    + "           ([Ma_Chi_Tiet_Don_Hang]\n"
                    + "           ,[Ma_Ao]\n"
                    + "           ,[So_Luong]\n"
                    + "           ,[Don_Gia]\n"
                    + "           ,[Tong])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            for (Don_Hang don_Hang : chi_Tiet_Don_Hang.getDon_Hangs()) {
                PreparedStatement ps_insert_don_hang
                        = connection.prepareStatement(insert_don_hang);
                ps_insert_don_hang.setInt(1, chi_Tiet_Don_Hang.getMa());
                ps_insert_don_hang.setString(2, don_Hang.getAo().getMa_ao());
                ps_insert_don_hang.setInt(3, don_Hang.getSo_luong());
                ps_insert_don_hang.setFloat(4, don_Hang.getDon_gia());
                ps_insert_don_hang.setFloat(5, don_Hang.getTotal());
                ps_insert_don_hang.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
        }
    }
}
