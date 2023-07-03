package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Quary {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String select = "select * from teca41.employee";
		try {
			Connection connection= DriverManager.getConnection(url);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println("Id of the employee :" + rs.getInt(1));
				System.out.println("Name of the Employee : " + rs.getString(2));
				System.out.println("Salary of the Employee :"+ rs.getDouble(3));
				System.out.println("Deptno of the Employee :"+ rs.getInt(4));
				System.out.println("-----------------------------------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
