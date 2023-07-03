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
@WebServlet("/Registration")
public class Registration extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String email= req.getParameter("Email");
		String mb= req.getParameter("Mobaialnumber");
		String pss = req.getParameter("Password");
		String ged= req.getParameter("Gender");
		String sel= req.getParameter("SelectCourse");
		System.out.println(name);
		System.out.println(email);
		System.out.println(mb);
		System.out.println(pss);
		System.out.println(ged);
		System.out.println(sel);
		System.out.println("----------------------------------------------------------------------------------");
		PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html");
//		 write.println("<center><h1>Enter the name:"+name+ "</h1></center>");
//		 write.println("<center><h1>Enter the email:"+email+ "</h1></center>");
//		 write.println("<center><h1>Enter the mobailnumber:"+mb+ "</h1></center>");
//		 write.println("<center><h1>Enter the password:"+pss+ "</h1></center>");
//		 write.println("<center><h1>Enter the gender:"+ged+ "</h1></center>");
//		 write.println("<center><h1>Enter the selection:"+sel+ "</h1></center>");
		 
		 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		 String insert = "insert into registrationform ( Name, EmailId, MobialNumber, Password, Gender, SelectCourse)"+" values(?,?,?,?,?,?)";
		                        try {
		                        	Class.forName("com.mysql.jdbc.Driver");
							Connection	con	= DriverManager.getConnection(url);
							PreparedStatement ps = con.prepareStatement(insert);
							ps.setString(1,name);
							ps.setString(2, email);
							ps.setString(3, mb);
							ps.setString(4, pss);
							ps.setString(5, ged);
							ps.setString(6, sel);
							int num = ps.executeUpdate();
							if (num!=0) {
								//write.println("<center><h1>Rigestaration Success fully </h1></center>");
								RequestDispatcher rd = req.getRequestDispatcher("UserLogIn.html");
								rd.include(req, resp);
							} 
							else {
							
								write.println("<center><h1>Data not Inserted </h1></center>");
								RequestDispatcher rd = req.getRequestDispatcher("Registration.html");
								rd.include(req, resp);
								
							}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	}

}
