package regestration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/LogIn")
public class LogIn extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String pass = req.getParameter("password");
		System.out.println(name);
		System.out.println(pass);
		PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html");
		
		 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String select = "select * from registrationform where Name=? and Password=?";
		String select1 = "select * from registrationform where Name=? and Password=?";
		String select2 = "select * from registrationform where Name=? and Password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection	con	= DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement(select);
		PreparedStatement ps1 = con.prepareStatement(select1);
		PreparedStatement ps2 = con.prepareStatement(select2);
		ps.setString(1, name);
		ps.setString(2, pass);
		ps1.setString(1, name);
		ps1.setString(2, pass);
		ps2.setString(1, name);
		ps2.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		
		if (rs.next()) {
			
		 if (rs1.next()) {
			if(rs2.next()) {
				Random r = new Random();
				int otp = r.nextInt(10000);
				if(otp<1000) {
					otp+=1000;
				}
				
				write.println("<center><h1>Your otp Is:"+otp+"</h1></center>");
				write.println("<center><h1>login Success fully </h1></center>");
 			}
			else {
				write.println("<center><h1>enter  valied password </h1></center>");
			}
		} else {
			write.println("<center><h1>enter valied email</h1></center>");
                  
		}
		    
		} 
		else {
			write.println("<center><h1>login inValied </h1></center>");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
