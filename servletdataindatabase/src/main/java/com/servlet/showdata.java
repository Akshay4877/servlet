package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/showdata")
public class showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyinfo","root","root");
			Statement st = (Statement) con.createStatement();
			ResultSet rs =st.executeQuery("select * from Companyinfo");

			while (rs.next()) {

			out.println(rs.getString(1));
			out.println(rs.getString(2));
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
	}

}
