package com.jsp.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		PrintWriter writer = resp.getWriter();
     	resp.setContentType("text/html");
		HttpSession session = req.getSession();
		
		
		 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
	Connection	con	= DriverManager.getConnection(url);
	
	PreparedStatement ps = con.prepareStatement("select * from registrationform where EmailId=? and Password=?");
	ps.setString(1, email);
	ps.setString(2, pass);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
		 Random r = new Random();
         int otp = r.nextInt(10000);
         if (otp<1000) {
				otp+=1000;
			}
         writer.println("<center><h1>Otp is generated"+otp+"</h1></center>");
         session.setMaxInactiveInterval(10);
         session.setAttribute("otp", otp);
	 session.setAttribute("email", email); 
	 RequestDispatcher rd = req.getRequestDispatcher("OTP.html");
		rd.include(req, resp);
	}
	else {
		RequestDispatcher rd = req.getRequestDispatcher("UserLogIn.html");
		rd.include(req, resp);
		
	}
	  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
