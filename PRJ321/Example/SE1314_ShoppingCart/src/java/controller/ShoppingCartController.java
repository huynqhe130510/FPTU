/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;

/**
 *
 * @author sonnt
 */
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDAO customerDB = new CustomerDAO();
        ArrayList<Customer> customers = customerDB.getCustomers();
        request.getSession().setAttribute("customers", customers);
        response.sendRedirect("cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("cart");
        if (order == null) {
            order = new Order();
        }
        int pid = Integer.parseInt(request.getParameter("pid"));
        ProductDAO productDB = new ProductDAO();
        Product product = productDB.getProduct(pid);
        int indexOfExistingProduct = -1;
        for (int i = 0; i < order.getLines().size(); i++) {
            OrderLine line = order.getLines().get(i);
            if (line.getProduct().getId() == pid) {
                indexOfExistingProduct = i;
                break;
            }
        }
        if (indexOfExistingProduct != -1) {
            OrderLine line = order.getLines().get(indexOfExistingProduct);
            line.setQuantity(line.getQuantity() + 1);
        } else {
            OrderLine line = new OrderLine();
            line.setProduct(product);
            line.setOrder(order);
            line.setPrice(product.getPrice());
            line.setQuantity(1);
            order.getLines().add(line);
        }
        request.getSession().setAttribute("cart", order);
        response.sendRedirect("products");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
