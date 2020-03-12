package TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl ="jdbc:mysql://localhost:3306/pension_scheme?useSSL=false";
		String user = "root";
		String pass = "root";
		try {
			System.out.println("Connecting to database" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection succesfull");
		}
		
		catch(Exception exc) {
			
			exc.printStackTrace();
		}
	}

}
