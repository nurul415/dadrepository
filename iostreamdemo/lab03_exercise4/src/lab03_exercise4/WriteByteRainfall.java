package lab03_exercise4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WriteByteRainfall 
{
	public static void main(String[] args) {
		
		// 1. Declare output file 
		String outFile = "RainfallMelaka.txt";
		
		// Data declaration
		String stationId1 = "2222005";
		String stationId2 = "2221008";
		String station1   = "Klebang";
		String station2   = "Sg.Udang";
		String district   = "Melaka Tengah";
		int rainfallStation1[] = {1, 7, 1, 4, 2, 6};
		int rainfallStation2[] = {0, 35, 2, 0, 1, 12};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			dos.writeUTF(stationId1);
			dos.writeUTF(stationId2);
			dos.writeUTF(station1);
			dos.writeUTF(station2);
			dos.writeUTF(district);
			// Process data
			for (int index = 0; index < 6; index++) 
			{
				// 3. Write data into data stream
				dos.writeInt(rainfallStation1[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			for (int index1 = 0; index1 < 6; index1++) 
			{
				// 3. Write data into data stream
				dos.writeInt(rainfallStation2[index1]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
			}
}