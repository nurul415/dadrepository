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
			int no = 0;
			String stationID = "";
			String station = "";
			String district = "";
			int day1 = 0;
			int day2 = 0;
			int day3 = 0;
			int day4 = 0;
			int day5 = 0;
			int day6 = 0;
			
			System.out.println("Daily Rainfall Data A Station 2021\n");
			
			System.out.println(  "No\t" + "SID\t"+ "Station\t\t\t\t\t"+ "District\t" + 
					"21/10\t"+ "22/10\t"+ "23/10\t"+ "24/10\t"+ "25/10\t"+ "26/10\t" + "Area");
			
			double area = 0;
			double day = 6;
			
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
			//Process data until end-of-file
			while(dis.available() > 0) 
			{
				// Read data
				no = dis.readInt();
				stationID = dis.readUTF();
				station = dis.readUTF();
				district = dis.readUTF();
				day1 = dis.readInt();
				day2 = dis.readInt();
				day3 = dis.readInt();
				day4 = dis.readInt();
				day5 = dis.readInt();
				day6 = dis.readInt();
				area = dis.readInt()/day;
				
				
				System.out.println(  no + "\t" + stationID + "\t"+ station + "\t"+ district + "\t" + 
				day1 + "\t"+ day2 +"\t"+ day3 +"\t"+ day4 +"\t"+ day5 +"\t"+ day6 + "\t" + df.format(area));
			}
			
			//Close stream
			dis.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\n*Convective rain more than 60 mm in 2 to 4 hours duration (typical) "
				+ "may cause flash floods. However, monsoon rains are \ntypically of long duration "
				+ "with intermittent heavy bursts and the intensity can occasionally exceed several "
				+ "hundred mm in 24 hours.");
		System.out.println("\nEnd of program.");
		

	}
	
}
