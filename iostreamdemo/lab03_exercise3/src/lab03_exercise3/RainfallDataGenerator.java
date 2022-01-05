package lab03_exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallDataGenerator 
{
	public static void main(String[] args)
	{
		//Declare output file
		String outFile = "RainfallMelaka.txt";
		
		//Data declaration
		String stationId = "2222006";
		String station = "Cheng (Taman Merdeka)";
		String district = "Melaka Tengah";
		
		 int rainfall[] = {0, 0, 8, 0, 10, 2};
		 
		 try
		 {
			 //Create stream to read data
			 DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			 
			 for (int index = 0; index < rainfall.length; index++) 
			 {
					//Write data into data stream
				 	dos.writeUTF(stationId);
				 	dos.writeUTF(station);
				 	dos.writeUTF(district);
				 	dos.writeInt(rainfall[index]);
				 	
					//Flush for each writing
					dos.flush();
			 }
			 
			 //Close Stream
			 dos.close();
			 
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}
}
