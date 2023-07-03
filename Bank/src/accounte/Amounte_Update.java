package accounte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Amounte_Update {

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/teca41?user=root&password=12345";
		String update ="update bank set amount=7000 where amount is null";
		try {
			Connection con 	 = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			int results = st.executeUpdate(update);
			if (results!=0) {
				System.out.println("Data is Update");
			}
			else {
				System.out.println("Data is not Update");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
