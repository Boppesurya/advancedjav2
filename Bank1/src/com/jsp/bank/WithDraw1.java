package com.jsp.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/WithDraw1")
public class WithDraw1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tamounte = req.getParameter("Amounte");
		double amounte  = Double.parseDouble(tamounte);
		PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			HttpSession session = req.getSession();
			Double damounte =(Double) session.getAttribute("damounte");
			String mb = (String) session.getAttribute("mb");
		 String pass = (String)session.getAttribute("pass");
		 if (damounte!=null) {
		
		 if (amounte>0) {
			double sub = damounte - amounte;
			String update ="update bank set amount=? where mobailnumber=? and password=?";
			String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		        try {
		        	Class.forName("com.mysql.jdbc.Driver");
				Connection	conn =DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(update);
				ps.setDouble(1, sub);
				ps.setString(2, mb);
				ps.setString(3, pass);
				int num = ps.executeUpdate();
				if (num!=0) {
					RequestDispatcher rd = req.getRequestDispatcher("BankHomePage.html");
					writer.println("<center><h1>Amounte Withdraw</h1></center>");
					rd.include(req, resp);
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("BankHomePage.html");
					writer.println("<center><h1>404</h1></center>");
					rd.include(req, resp);

				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		 }	
		} 
		 else {
			 RequestDispatcher rd = req.getRequestDispatcher("BankHomePage.html");
				writer.println("<center><h1>Seccion time out</h1></center>");
				rd.include(req, resp);
			 
			 
		 }
	}

}
