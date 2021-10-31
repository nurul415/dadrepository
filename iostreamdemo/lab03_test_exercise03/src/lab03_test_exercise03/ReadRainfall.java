package lab03_test_exercise03;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadRainfall 
{
	public static void main(String[] args) 
	{

		// 1. Declare output file 
		String sourceFile = "dataDailyRainfallMelakaTengah.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try 
		{

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double rainfall = 0;
			double totalRainfall = 0;
			int noOfRecords = 6;
			String station = "";
			
			
				System.out.println("6 Days Of Data Rainfall From Selected Station\n");
				
			
				while(dis.available() > 0) 
				{
					for(int i =1 ; i < 7; i++) 
					{	// 3. Process 6 days data rainfall
						// Read data
						station = dis.readUTF();
						rainfall = dis.readDouble();
					
						System.out.println( "Day " + i + " " + station + "\t" + rainfall );
						totalRainfall +=rainfall;
					}
					
					//Formula to calculate average
					double averageRainfall = totalRainfall/ noOfRecords;
					// Convert double to string before print out
					String formattedAverage = String.format("%.1f", averageRainfall); 
					System.out.println("\nAverage of " + noOfRecords + " days from selected station is " + formattedAverage + "%");
				}
			
			// 4. Close stream
			dis.close();
			
		} 
		catch (Exception ex) 
		{
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");

	}
}
