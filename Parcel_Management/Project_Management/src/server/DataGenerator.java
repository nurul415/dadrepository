package server;

import java.sql.*;
import parcel.ParcelManager;

public class DataGenerator 
{
	private int parcel_ID = 0;
	private int sender_ID = 0;
	private int receiver_ID = 0;
	private String sName = "";
	
	
	ParcelManager pm = new ParcelManager();
	Connection conn = pm.getConnection();
	
	public int getParcelID()
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT MAX(parcel_id) FROM parcel");
			
			res.next();
			int id = res.getInt("MAX(parcel_id)");
			parcel_ID = id;
			
		}
		catch(Exception ae)
		{
			System.out.println(ae.getMessage());
		}
		
		return parcel_ID;
	}
	
}
