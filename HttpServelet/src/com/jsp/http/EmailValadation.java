package com.jsp.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/EmailValadation")
public class EmailValadation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		String mail = req.getParameter("Email");
		
		HttpSession session = req.getSession();
		
		String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		 try { 
			 Class.forName("com.mysql.jdbc.Driver");
		Connection	con = DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement("select * from registrationform where EmailId=?");
		ps.setString(1, mail);
		ResultSet rs = ps.executeQuery();
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		if (rs.next()) {
			session.setMaxInactiveInterval(10);
			
			session.setAttribute("mail", mail);
			RequestDispatcher rd = req.getRequestDispatcher("Password.html");
			rd.include(req, resp);
			
		} else {

			RequestDispatcher rd = req.getRequestDispatcher("EmailId.html");
			rd.include(req, resp);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
