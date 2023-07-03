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
@WebServlet("/Regestration")
public class Regestration extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		HttpSession session = req.getSession();
		
		PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html");
		String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String insert ="insert into regstrations(password,email)value(?,?)";
                 try {
                	 Class.forName("com.mysql.jdbc.Driver");
					Connection conn= DriverManager.getConnection(url);
					PreparedStatement ps = conn.prepareStatement(insert);
					ps.setString(1,email);
					ps.setString(2, pass);
					int num = ps.executeUpdate();
					if (num!=0) {
					session.setAttribute("email", email);
						 RequestDispatcher rd = req.getRequestDispatcher("Rege.html");
							rd.include(req, resp);
						
					} else {
						 RequestDispatcher rd = req.getRequestDispatcher("Registration.html");
							rd.include(req, resp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
