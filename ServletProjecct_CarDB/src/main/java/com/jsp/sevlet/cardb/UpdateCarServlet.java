package com.jsp.sevlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateCarServlet extends GenericServlet 
  {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));
        String carModel = req.getParameter("carModel");
        int carPrice = Integer.parseInt(req.getParameter("carPrice"));      
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "DHIraj@2002");
            ps = con.prepareStatement("UPDATE car SET carModel=?, carPrice=? WHERE carId=?");
            ps.setString(1, carModel);
            ps.setInt(2, carPrice);
            ps.setInt(3, carId);
            
            int rowsUpdated = ps.executeUpdate();
            PrintWriter out = res.getWriter();
            if (rowsUpdated > 0) {
                out.print("<h1>Data Updated successfully!</h1>");
            } else {
                out.print("<h1>Data not updated!</h1>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null && ps != null)
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
