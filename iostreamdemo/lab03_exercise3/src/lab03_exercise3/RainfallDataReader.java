package lab03_exercise3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.text.DecimalFormat;

public class RainfallDataReader 
{
	public static void main(String[] args) {

		//Declare output file 
		String sourceFile = "RainfallMelaka.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			//Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			//Variables for processing byte-based data
			String station = "";
			String stationId = "";
			String district = "";
			int rainfall = 0;
			double total = 0;
			double average = 0;
			double day = 6;
			
			System.out.println("Daily Rainfall Data A Station 2021\n");
			System.out.println("Day\tSID\tStation\t\t\tDistrict\tRainfall");
			
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
			DecimalFormat dInt = new DecimalFormat();
			dInt.setMaximumFractionDigits(0);
			
			//Process data until end-of-file
			while(dis.available() > 0) 
			{
				
				for(int i = 1; i < 7; i++)
				{
					// Read data
					stationId = dis.readUTF();
					station = dis.readUTF();
					district = dis.readUTF();
					rainfall = dis.readInt();
					
					System.out.println(  i + "\t"+ stationId + "\t"+ station + "\t"+ district +"\t" + rainfall );
					total += rainfall;
				}
				
				average = total / day;
				System.out.println("\nTotal Rainfall of 6 days : " + dInt.format(total));
				System.out.println("The average of 6 days of rainfall : " + df.format(average));
				
			}
			
			//Close stream
			dis.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}
	
}
