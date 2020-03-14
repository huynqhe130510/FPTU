/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author huyNguyen
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProduct() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "select * from Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                products.add(product);
            }

        } catch (Exception e) {
        }
        return products;

    }
}
