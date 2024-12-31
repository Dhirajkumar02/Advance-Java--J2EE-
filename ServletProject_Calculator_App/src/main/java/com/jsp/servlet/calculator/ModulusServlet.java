package com.jsp.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ModulusServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n1 = req.getParameter("num1");
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int rem = num1 % num2;
		
		PrintWriter out = res.getWriter();
		out.print("<h1>The modulus of "+num1+ " and "+ num2+ " is " + rem + "</h1>");
		
	}

}
