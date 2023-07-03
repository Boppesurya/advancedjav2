package userInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String insert = "insert into registration( Phonenumber, password)values(?,?)";
		try {
			Connection connection	= DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter the phone number:");
			String pn = scr.next();
			System.out.println("Enter the Passworde");
			String pass = scr.next();
			if(pn.length()==10) {
			ps.setString(1, pn);
			}
			else {
				System.out.println("Please enter 10 digets number");
			}
			if (pass.length()==4) {
			ps.setString(2, pass);
			}
			else {
				System.out.println("Enter the valied password");
			}
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("registration is valeade");
			}
			else {
				System.out.println("Please enter valied information");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
