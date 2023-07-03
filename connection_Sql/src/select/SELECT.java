
package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SELECT {
	  public static void main(String[] args)
	  { 
	    String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	     String select="select*from teca41.employee ";
	     try {
	    	 Connection connection=DriverManager.getConnection(url);
	    	 Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(select);
				if (rs.last()) {
					rs.beforeFirst();
                  while(rs.next()) {			
	         int ld=0;
	         int rev=0;
	         int id=rs.getInt(1);
	         int temp=id;
	         while(temp!=0)
	         {
	          ld=temp%10;
	           rev=rev*10+ld;  
	           temp/=10;
	         }
	        if(rev==id)
	        { 
	          System.out.println("ID of the employee:"+rs.getInt(1));
	 	 System.out.println("Name of the Employee:"+rs.getString(2));
	 	 System.out.println("Salary of the Employee:"+rs.getDouble(3));
	 	 System.out.println("Deptno of the Employee:"+rs.getInt(4));
	 	 System.out.println("__________*");
	        }
                  }
				}
	        else
	        {
	          System.out.println("Given number is not a palindrome");
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	  }
}
