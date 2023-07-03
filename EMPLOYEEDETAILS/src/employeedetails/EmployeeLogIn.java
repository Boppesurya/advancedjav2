package employeedetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/EmployeeLogIn")
public class EmployeeLogIn extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String tid = req.getParameter("Id");
		int id = Integer.parseInt(tid);
		String name = req.getParameter("name");
		String salary = req.getParameter("Salary");
		double sal = Double.parseDouble(salary);
		String deptno = req.getParameter("Deptno");
		int dept = Integer.parseInt(deptno);
		
		
		System.out.println("Id of the employee :"+id);
		System.out.println("Name of the Employee:"+name);
		System.out.println("salary of the Employee:"+salary);
		System.out.println("Edeptno of the employee:"+deptno);
		 PrintWriter write = resp.getWriter();
		 resp.setContentType("text/html");
		 write.println("<center><h1 style=color:green> Id od the employee :"+id+ "</h1></center>");
		 write.println("<center><h1>name of the employee :"+name+ "</h1></center>");
		 write.println("<center><h1>Salary of the employee :"+salary+ "</h1></center>");
		 write.println("<center><h1>Deptno of  the employee :"+deptno+ "</h1></center>");
		 
		 String url = "jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		 String insert = "insert into employee values(?,?,?,?)";
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
				Connection con 	 = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setDouble(3,sal);
				ps.setInt(4,dept);
				int num = ps.executeUpdate();
				if (num!=0) {
					write.println("<center><h1>Data Inserted </h1></center>");
					
				} 
				else {
				
					write.println("<center><h1>Data not Inserted </h1></center>");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
}
