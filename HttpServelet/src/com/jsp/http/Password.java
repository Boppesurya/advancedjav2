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
@WebServlet("/Password")
public class Password extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pass = req.getParameter("password");
		
		PrintWriter write = resp.getWriter();
		resp.setContentType("text/html"); 
		
		HttpSession session = req.getSession();
		String mail = (String)session.getAttribute("mail");
		if (mail!=null) {
			
		
		String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection	con= DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from registrationform where EmailId=? and Password=?");
			ps.setString(1, mail);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				write.println("<center><h1>Log-In is Sussfully </h1></center>");
				
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("EmailId.html");
				rd.include(req, resp);
				write.println("<center><h1>in Valied Password</h1></center>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			
			RequestDispatcher rd = req.getRequestDispatcher("EmailId.html");
			rd.include(req, resp);
			write.println("<center><h1>Section tome oute </h1></center>");
		}
	}
    
	
}
