package com.jsp.jdbc;

//import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		
		Bank bank = new  BankDaoImpl();
		//bank.checkTheBalence();
	bank.changePassword();
	}

}
