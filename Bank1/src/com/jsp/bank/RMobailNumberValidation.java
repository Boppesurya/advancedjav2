package com.jsp.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RMobailNumberValidation  extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String rmb = req.getParameter("number");
	PrintWriter writer= resp.getWriter();
	 resp.setContentType("text/html");

	 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String select ="select * from bank where mobailnumber=?";
		 try {
		Connection conn	= DriverManager.getConnection(select);
		PreparedStatement ps = conn.prepareStatement(select);
		ps.setString(1, rmb);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			
			
		} else {

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
