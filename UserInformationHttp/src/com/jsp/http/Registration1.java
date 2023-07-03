package com.jsp.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Registration1")
public class Registration1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email1= req.getParameter("email");
		String name = req.getParameter("Name");
		String mb = req.getParameter("Mobaialnumber");
		String gender= req.getParameter("Gender");
		String course =req.getParameter("SelectCourse");
		
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html"); 
		
		String url="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String update= "update regstrations set name=?,mobaileNumber=?,gender=?,course=? where email=?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1,name);
			ps.setString(2,mb);
			ps.setString(3,gender);
			ps.setString(4,course);
			ps.setString(5,email1);
			
			int num = ps.executeUpdate();
			if (num>0) {
				write.println("<center><h1>Successfully updated</h1></center>");
				 
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("Rege.html");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
