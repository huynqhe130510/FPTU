/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.OrderLine;

/**
 *
 * @author sonnt
 */
public class OrderDAO extends DBContext {
    public void insert(Order order)
    {
        try {
            connection.setAutoCommit(false);
            //insert into Order
            String sql_insert_order = "INSERT INTO [Order]\n" +
            "           ([date]\n" +
            "           ,[cid])\n" +
            "     VALUES\n" +
            "           (GETDATE()\n" +
            "           ,?)";
            PreparedStatement ps_insert_order = 
                    connection.prepareStatement(sql_insert_order);
            ps_insert_order.setInt(1,order.getCustomer().getId());
            ps_insert_order.executeUpdate();
            //select orderid (IDENTITY)
            String sql_select_orderid = "SELECT @@IDENTITY as oid";
            PreparedStatement ps_select_orderid = 
                    connection.prepareStatement(sql_select_orderid);
            ResultSet rs = ps_select_orderid.executeQuery();
            if(rs.next())
                order.setId(rs.getInt("oid"));
            //insert order lines
            String sql_insert_line = "INSERT INTO [OrderLine]\n" +
            "           ([oid]\n" +
            "           ,[pid]\n" +
            "           ,[quantity]\n" +
            "           ,[price])\n" +
            "     VALUES\n" +
            "           (?\n" +
            "           ,?\n" +
            "           ,?\n" +
            "           ,?)";
            for (OrderLine line : order.getLines()) {
                PreparedStatement ps_insert_line = 
                    connection.prepareStatement(sql_insert_line);
                ps_insert_line.setInt(1, order.getId());
                ps_insert_line.setInt(2, line.getProduct().getId());
                ps_insert_line.setFloat(3, line.getQuantity());
                ps_insert_line.setFloat(4, line.getPrice());
                ps_insert_line.executeUpdate();
            }
            
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
