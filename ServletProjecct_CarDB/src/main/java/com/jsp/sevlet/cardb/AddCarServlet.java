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


public class AddCarServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//Extracting all the values from the UI
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carName = req.getParameter("carName");
		String carBrand = req.getParameter("carBrand");
		String carModel = req.getParameter("carModel");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "DHIraj@2002");
			PreparedStatement ps = con.prepareStatement("INSERT INTO car VALUES(?, ?, ?, ?, ?)");
			ps.setInt(1, carId);
			ps.setString(2, carName);
			ps.setString(3, carBrand);
			ps.setString(4, carModel);
			ps.setInt(5, carPrice);
			
			int rowsInserted = ps.executeUpdate();
			PrintWriter out = res.getWriter();
			if(rowsInserted > 0) {
				out.print("<h1>Data inserted successfully!</h1>");
			}
			else {
				out.print("Data not inserted!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}	
	}
}
