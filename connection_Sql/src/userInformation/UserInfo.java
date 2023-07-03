package userInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInfo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String insert = "insert into userinformation( name, emailId, mobileNumber, password)values(?,?,?,?)";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			@SuppressWarnings("resource")
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter the name:");
			String name = scr.next();
			System.out.println("Enter the EmailId:");
			String email= scr.next();
			System.out.println("Enter the Modaile number :");
			String mb= scr.next();
			System.out.println("Enter the password:");
			String password = scr.next();
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mb);
			ps.setString(4, password);
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("Registration Successfull!");
			}
			else {
				System.out.println("Enter Valid Details");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
