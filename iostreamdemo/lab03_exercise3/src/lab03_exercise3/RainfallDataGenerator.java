package lab03_exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallDataGenerator 
{
	public static void main(String[] args)
	{
		//Declare output file
		String outFile = "RainfallMelaka.txt";
		
		 int no[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		//Data declaration
		String stationID[] = {"2421003", "2421003", "2322006", "2321006", "2222002", "", 
				"2324033","2225044", "2125002", "2222006", "2222007", "2222033", "2222003", 
				"2222005", "2221008"};
		
		String station[] = {"Ladang Tebolang Tebong\t\t", "Jam. Sg. Simpang Ampat di Jln. Empat", "Melaka Pindah\t\t\t", "Ladang Lendu\t\t\t", "Durian Tunggal\t\t\t", "Durian Tunggal D/S\t\t", 
				"Hospital Jasin\t\t\t","Sg. Chohong\t\t\t", "Telok Rimba\t\t\t", "Cheng (Taman Merdeka)\t\t", "Cheng D/S\t\t\t", "Batu Hampar\t\t\t", "Klebang Besar\t\t\t", 
				"Klebang Besar D/\t\t", "Pusat Pertanian Sg. Udang\t"};
		
		String district[] = {"Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", 
				"Jasin\t","Jasin\t", "Jasin\t", "Melaka Tengah", "Melaka Tengah", "Melaka Tengah", "Melaka Tengah", 
				"Melaka Tengah", "Melaka Tengah"};
		
		 int day1[] = {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		 int day2[] = {0, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		 int day3[] = {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
		 int day4[] = {0, 1, 0, 1, 0, 0, 7, 0, 2, 0, 0, 0, 0, 0, 1};
		 int day5[] = {0, 1, 0, 0, 0, 0, 8, 5, 0, 0, 0, 0, 0, 0, 0};
		 int day6[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0};
		 int sum[]  = {0, 2, 0, 5, 4, 4, 15, 6, 2, 0, 0, 0, 1, 1, 2};
		 
		 try
		 {
			 //Create stream to read data
			 DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			 
			 //Process Data
			 for (int index = 0; index < no.length; index++) 
			 {
					//Write data into data stream
				 	dos.writeInt(no[index]);
					dos.writeUTF(stationID[index]);
					dos.writeUTF(station[index]);
					dos.writeUTF(district[index]);
					dos.writeInt(day1[index]);
					dos.writeInt(day2[index]);
					dos.writeInt(day3[index]);
					dos.writeInt(day4[index]);
					dos.writeInt(day5[index]);
					dos.writeInt(day6[index]);
					dos.writeInt(sum[index]);
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
