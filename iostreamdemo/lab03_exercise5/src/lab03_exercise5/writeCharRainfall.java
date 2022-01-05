package lab03_exercise5;

import java.io.Writer;
import java.text.DecimalFormat;
import java.io.FileWriter;

public class writeCharRainfall 
{
	public static void main(String[] args) 
	{
		
		// 1. Declaration of target storage
		String targetStorage = "RainfallMelaka.dat";
		
		// Data declaration
		String stationId1 = "2222005";
		String stationId2 = "2221008";
		String station1   = "Klebang";
		String station2   = "Sg.Udang";
		String district   = "Melaka Tengah";
		int rainfallStation1[] = {1, 7, 1, 4, 2, 6};
		int rainfallStation2[] = {0, 35, 2, 0, 1, 12};
		
		double sum = 0;
		double sum1 = 0;
		int days = 6;
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		try 
		{
			// 2. Create an output stream between this program and the target storage
			Writer w_data = new FileWriter(targetStorage);

			// 3. Create write data into stream
			
			w_data.write("\nData Rainfall for Station 1");
			w_data.write("\nStation ID\tStation\t\tDistrict\tDay\tRainfall\n");
			
			for (int i = 0; i < 6; i++)
			{
				w_data.write(stationId1 + "\t\t" + station1 + "\t\t" + district + "\t" + (i+1) + "\t" + rainfallStation1[i] + "\n");
				sum += rainfallStation1[i];
			}
			
			w_data.write("\nTotal Rainfall Station 1   : " + sum);
			w_data.write("\nAverage Rainfall Station 1 : " + df.format(sum / days));
			
			w_data.write("\n\nData Rainfall for Station 2");
			w_data.write("\nStation ID\tStation\t\tDistrict\tDay\tRainfall\n");
			
			for (int j = 0; j < 6; j++)
			{
				w_data.write(stationId2 + "\t\t" + station2 + "\t" + district + "\t" + (j+1) + "\t" + rainfallStation2[j] + "\n");
				sum1 += rainfallStation2[j];
				sum += rainfallStation2[j];
			}
			
			w_data.write("\nTotal Rainfall Station 2   : " + sum1);
			w_data.write("\nAverage Rainfall Station 2 : " + df.format(sum1 / days));
			
			w_data.write("\n\nTotal Rainfall For 2 Stations        : " + sum);
			w_data.write("\nAverage Total Rainfal for 2 Stations : " + df.format(sum / days));
			
			
			// 4. Clear the stream
			w_data.flush();

			// 5. Close the stream
			w_data.close();  

		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcess
		System.out.println("End of program.  Check out " + targetStorage + ".");   
	}
}
