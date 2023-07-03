package com.jsp.bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/OtpValide2")
public class OtpValide2 extends HttpServlet {
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String totp = req.getParameter("Otp");
		int uotp = Integer.parseInt(totp);
		 HttpSession session= req.getSession();
		 Integer otp =(Integer)session.getAttribute("otp");
		 PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html"); 
		 
		 if (otp!=null) {
			 
			 if (otp==uotp) {
				 
				// writer.println("<center><h1>"+otp+"</h1></center>");
					RequestDispatcher rd = req.getRequestDispatcher("Withdraw.html");
					rd.include(req, resp);
			} else {
				write.println("<center><h1>"+otp+"</h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("Otp.html");
				rd.include(req, resp);
			}
		} else {
			write.println("<center><h1>otp Time_out</h1></center>");

		}
	}

}
