package com.jsp.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MobailTransaction")
public class MobailTransaction extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String	mb= req.getParameter("number");
	String pass= req.getParameter("password");
	 PrintWriter writer= resp.getWriter();
	 resp.setContentType("text/html");
	 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String select ="select * from bank where mobailnumber=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(select);
		ps.setString(1, mb);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			RequestDispatcher rd= req.getRequestDispatcher("Mobaile.html");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("Mobailetransaction.html");
			rd.forward(req, resp);
			writer.println("<center><h1>In valied  details</center></h1>");
			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
