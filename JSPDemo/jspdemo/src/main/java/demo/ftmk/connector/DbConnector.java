package demo.ftmk.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	
	
	
	public Connection getConnection () throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/mcdonaldsdb", "root", "");
		
		System.out.println("Connected"); 
		
		return conn;
		
	}

}
