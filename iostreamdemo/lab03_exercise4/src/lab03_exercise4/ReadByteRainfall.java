package lab03_exercise4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.text.DecimalFormat;

public class ReadByteRainfall 
{
	public static void main (String args[]) 
	{
		
		// 1. Declare output file 
				String sourceFile = "RainfallMelaka.txt";
				System.out.println("Reading data from " + sourceFile + "\n");

				try 
				{
					// 2. Create stream to read data
					DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

					// Variables for processing byte-based data
					String stationId1 = "";
					String stationId2 = "";
					String station1   = "";
					String station2   = "";
					String district   = "";
					double sum = 0;
					double sum1 = 0;
					int days = 6;
					
					int r_station1 = 0;
					int r_station2 = 0;
					
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					
					// 3. Process data until end-of-file
					while(dis.available() > 0) 
					{
						// Read data
						stationId1 = dis.readUTF();
						stationId2 = dis.readUTF();
						station1 = dis.readUTF();
						station2 = dis.readUTF();
						district = dis.readUTF();
						
						System.out.println("Data Rainfall for Station 1");
						System.out.println("Station ID\tStation\t\tDistrict\tDay\tRainfall");
						
						for (int i = 1; i < 7; i++)
						{
							r_station1 = dis.readInt();
							System.out.println(stationId1 + "\t\t" + station1 + "\t\t" + district + "\t" + i + "\t" + r_station1);
							sum += r_station1;
						}
						
						System.out.println("\nTotal Rainfall Station 1   : " + sum);
						System.out.println("Average Rainfall Station 1 : " + df.format(sum / days));
						
						System.out.println("\n\nData Rainfall for Station 2");
						System.out.println("Station ID\tStation\t\tDistrict\tDay\tRainfall");
						for (int j = 1; j < 7; j++)
						{
							r_station2 = dis.readInt();
							System.out.println(stationId2 + "\t\t" + station2 + "\t" + district + "\t" + j + "\t" + r_station2);
							sum1 += r_station2;
							sum += r_station2;
						}
						
						System.out.println("\nTotal Rainfall Station 2   : " + sum1);
						System.out.println("Average Rainfall Station 2 :  " + df.format(sum1 / days));
						
						System.out.println("\nTotal Rainfall For 2 Stations        : " + sum);
						System.out.println("Average Total Rainfal for 2 Stations : " + df.format(sum / days));
						
						
						
						// Calculate total utilization
						
					}
					
					// 4. Close stream
					dis.close();
					
					
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}

				// Indicate end of program - Could be successful
				System.out.println("\nEnd of program."); 
		
		
	}

}
