package com.jsp.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Otp")
public class Otp extends HttpServlet {
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	                     String tOtp = req.getParameter("Otp");
	                     Integer uotp = Integer.parseInt(tOtp);
	                     PrintWriter writer = resp.getWriter();
	                 	resp.setContentType("text/html");
	                 	HttpSession session = req.getSession();
	                 	String email= (String)session.getAttribute("email");
	                 	int otp = (Integer)session.getAttribute("otp");
	                 	if (uotp!=null) {
							if (uotp==otp) {
								writer.println("<center><h1>Loh-In Sucessfully</h1></center>");
							} else {
								RequestDispatcher rd = req.getRequestDispatcher("UserLogIn.html");
								rd.include(req, resp);
							}
						} else {
							writer.println("<center><h1>Section Time-Out</h1></center>");
						}
	                 	
	}

}
