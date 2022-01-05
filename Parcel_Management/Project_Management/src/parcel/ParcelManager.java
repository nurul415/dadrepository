package parcel;

import java.sql.*;

import payment.PaymentFrame;

public class ParcelManager 
{
	private double price;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcel_management", "root", "");
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		return null;
	}
}
