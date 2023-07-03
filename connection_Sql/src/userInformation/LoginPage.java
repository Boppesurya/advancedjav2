package userInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class LoginPage {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
	String select ="select * from userinformation where emailId=? and password=?";
	 try {
		Connection connection= DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(select);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your MailId:");
		String mail = scn.next();
		System.out.println("Enter your Password:");
		String password = scn.next();
		ps.setString(1, mail);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Random r = new Random();
			int otp = r.nextInt(100000);
			if (otp<10000) {
				otp+=10000;
			}
			else {
				System.out.println("Enter the valied passworde");
			}
			System.out.println("your otp is :"+otp);
			System.out.println("Login Success fully");
		}
		else {
			System.out.println("Invalide Details");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
