package parcel;

import java.sql.*;

public class ParcelManager 
{
	/*public static void main (String args []) throws Exception
	{
		
		ParcelFrame parcelFrame = new ParcelFrame();
		parcelFrame.setVisible(true);
		
		  /*Class.forName("com.mysql.jdbc.Driver");
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testdata", "root", "");
		
		  Statement stmt = conn.createStatement();
		  ResultSet res = stmt.executeQuery("select * from user");
		  
		  //for single result data (where needed)
		  //res.next();
		  //int id = res.getInt("user_id");
		  //String name = res.getString("user_name");
		  //String mykad = res.getString("user_mykad");
		  //System.out.println(id + "\t" + mykad + "\t" + name);
		  
		  //for multiple result data
		  while(res.next())
		  {
			  int id = res.getInt("user_id");
			  String name = res.getString("user_name");
			  String mykad = res.getString("user_mykad");
			  System.out.println(id + "\t" + mykad + "\t" + name);
		  }
		  
		  stmt.close();
		  conn.close(); 
		
	}*/
	
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
