package com.jsp.sevlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayCarServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "DHIraj@2002");
			ps = con.prepareStatement("SELECT * FROM car WHERE carId=? ");
			ps.setInt(1, carId);
			ResultSet rs = ps.executeQuery();
			
			PrintWriter out = res.getWriter();
			
			out.print("<html>");
            out.print("<head><title>Car Details</title></head>");
            out.print("<body>");
            out.print("<h1>Car Details:</h1>");
            out.print("<table border='1' cellspacing='0' cellpadding='10'>");
            out.print("<tr>");
            out.print("<th>carId</th>");
            out.print("<th>carName</th>");
            out.print("<th>carBrand</th>");
            out.print("<th>carModel</th>");
            out.print("<th>carPrice</th>");
            out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
                out.print("<td>" + rs.getInt("carId") + "</td>");
                out.print("<td>" + rs.getString("carName") + "</td>");
                out.print("<td>" + rs.getString("carBrand") + "</td>");
                out.print("<td>" + rs.getString("carModel") + "</td>");
                out.print("<td>" + rs.getInt("carPrice") + "</td>");
                out.print("</tr>");
				
			}
			out.print("</table>");
            out.print("</body></html>");
            
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(con != null && ps != null)
				try {
					con.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		}
		
	}
	

}
