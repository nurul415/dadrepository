package lab03_test_exercise03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WriteRainfall 
{
	public static void main(String[] args) 
	{
		
		String file = "dataDailyRainfallMelakaTengah.txt";
		
		String station = "Cheng(Taman Merdeka)";
				
		double rainfallDay[] = {3.0, 6.0, -9999.0, -9999.0, 145.0, 0.0 };
		
	
		try 
		{
			
			DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
			
			for(int index=0; index < rainfallDay.length;index++) 
			{
				
				output.writeUTF(station);
				output.writeDouble(rainfallDay[index]);
				
				
				output.flush();
			}
			
			output.close();
		
		}
		catch (Exception ex) 
		{
		
			ex.printStackTrace();
		}
		
		System.out.println("Data has been added succesfully. Checkout the file " + file);

	}
}
