package regestration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/CreationgNewPassword")
public class CreationgNewPassword extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String Email = req.getParameter("email");
		String pss = req.getParameter("pass");
		String rpss = req.getParameter("pass1");
		PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html"); 
		 if (pss.equals(rpss)) {
			 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
			 String update = "update registrationform set Password=? where EmailId=?";
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			Connection	con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1,Email);
			ps.setString(2, pss);
			int num = ps.executeUpdate();
			if (num !=0) {
				write.println("<center><h1>Password change sussfully </h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogIn.html");
				rd.include(req, resp);
			} else {
				write.println("<center><h1>Password not-change </h1></center>");

				RequestDispatcher rd = req.getRequestDispatcher("Regestration.html");
				rd.include(req, resp);

			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 else {
			 write.println("<center><h1>Password not-change </h1></center>");
			 RequestDispatcher rd = req.getRequestDispatcher("ForgetPass.html");
				rd.include(req, resp);
				
		 }
		
	}

}
