package com.jsp.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankDaoImpl implements Bank {
	//Bank Data access object Implementation
	String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
	private Connection connection;
	String select = "select * from bank where mobailnumber=? and password=?";
	
	public void credit() 
		{
		Scanner dc = new Scanner(System.in);
		System.out.println("Enterb your mobail:");
		String mb = dc.next();
		System.out.println("Enter the passwoed");
		String pass = dc.next();
		
		//String select = "select * from bank where mobailnumber=? and password=?";
		try {
		 connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, mb);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
             if (rs.next()) {
            	 System.out.println("Enter Amount");
		         double amount = dc.nextDouble();
				
			} else {

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public void debit() {
		// TODO Auto-generated method stub
		Scanner dc = new Scanner(System.in);
		System.out.println("Enterb your mobail:");
		String mb = dc.next();
		System.out.println("Enter the passwoed");
		String pass = dc.next();
		try {
		     connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, mb);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
		         System.out.println("Enter Amount");
		         double amount = dc.nextDouble();
		         if (amount>0) {
					double damount = rs.getDouble(3);
					if (damount>=amount) {
						double sub = damount-amount;
						String update = "update bank set amount=? where mobilenumber=?";
						PreparedStatement ps1 = connection.prepareStatement(update);
						ps.setDouble(1, sub);
						ps.setString(2,mb);
						int num = ps1.executeUpdate();
						if (num!=0) {
							System.out.println("Amounte Debite Successfully");
						} else {
							System.out.println("404 error");
						}
						
					} else {
						System.out.println("Insufficent amount");
 
					}
				}
			}
			else {
				System.out.println(" valied amounte");
			
			}
			
		} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
 					e.printStackTrace();
			}
	}

	public void changePassword() {
		// TODO Auto-generated method stub
		Scanner dc = new Scanner(System.in);
		System.out.println("Enterb your mobail:");
		String mb = dc.next();
		System.out.println("Enter the passwoed");
		String pass = dc.next();
		try {
		    connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, mb);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String dpasswoed = rs.getString(5);
				System.out.println(dpasswoed);
				if (dpasswoed.equals(pass)) {
					System.out.println("Enter your new password");
					String npass = dc.next();
					String update = "update bank set password=? where mobailnumber=?";
					PreparedStatement ps1 = connection.prepareStatement(update);
					ps1.setString(1, npass);
					ps1.setString(2,mb);
					int num = ps1.executeUpdate();
					if (num>0) {
						System.out.println("Ypor Password is changed");
					} else {
                          System.out.println("your passworde is not changed");
					}
				}
				
			} 
			else {
              System.out.println("connection properaly");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void mobileTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkTheBalence() {
		// TODO Auto-generated method stub
		Scanner dc = new Scanner(System.in);
		System.out.println("Enterb your mobail:");
		String mb = dc.next();
		System.out.println("Enter the passwoed");
		String pass = dc.next();
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, mb);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Id :TECA41"+rs.getInt(1));
				System.out.println("Amount: "+rs.getDouble(4));
				String a=rs.getString(3);
				for (int j = 0; j < a.length(); j++) {
					if (j<=2 ||j>=8) {
						System.out.print(a.charAt(j));
					}
					else {
						System.out.print("*");
					}
					
				}
			} else {
                     System.out.println("No data found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
