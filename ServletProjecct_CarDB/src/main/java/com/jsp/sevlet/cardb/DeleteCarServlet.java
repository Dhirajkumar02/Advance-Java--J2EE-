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

public class DeleteCarServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));

        Connection conn = null;

        try {
            // Step 1: Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "DHIraj@2002");

            // Step 3: Create Statement
            PreparedStatement ps = conn.prepareStatement("DELETE FROM car WHERE carId=?");
            ps.setInt(1, carId);

            // Step 4: Execute the query
            int rowsDeleted = ps.executeUpdate();

            // Step 5: Display results
            PrintWriter out = res.getWriter();
            if (rowsDeleted > 0) {
                out.print("<h1>Data deleted successfully!</h1>");
            } else {
                out.print("<h1>Data not deleted! Car ID not found.</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
