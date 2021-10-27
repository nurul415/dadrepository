package lab03_exercise4;

import java.io.*;
import java.text.DecimalFormat;

public class WriteByteRainfall 
{
	public static void main(String[] args) {
		
		//Declaration of target storage
		String targetStorage = "outByteRainfall.dat";
		double sum[]  = {0, 2, 0, 5, 4, 4, 15, 6, 2, 0, 0, 0, 1, 1, 2};
		int day = 6;
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		try {

			// 2. Create an output stream between this program and the target storage
			FileOutputStream fosObject = new FileOutputStream(targetStorage); 
			
			String title = "No\t SID\t\t Station\t\t\t\t District\t 21/10\t22/10\t23/10\t24/10\t25/10\t26/10\tArea\n";
			String station1 = "1.\t 2421003\t Ladang Tebolang Tebong\t\t\t Alor Gajah\t 0\t0\t0\t0\t0\t0\t"+ df.format(0/day) +"\n";
			String station2 = "2.\t 2421003\t Jam. Sg. Simpang Ampat di Jln. Empat\t Alor Gajah\t 0\t0\t0\t1\t1\t0\t"+ df.format(sum[1]/day) +"\n";
			String station3 = "3.\t 2322006\t Melaka Pindah\t\t\t\t Alor Gajah\t 0\t0\t0\t0\t0\t0\t"+ df.format(sum[2]/day) +"\n";
			String station4 = "4.\t 2321006\t Ladang Lendu\t\t\t\t Alor Gajah\t 1\t2\t1\t1\t0\t0\t"+ df.format(sum[3]/day) +"\n";
			String station5 = "5.\t 2222002\t Durian Tunggal\t\t\t\t Alor Gajah\t 1\t3\t0\t0\t0\t0\t"+ df.format(sum[4]/day) +"\n";
			String station6 = "6.\t        \t Durian Tunggal D/S\t\t\t Alor Gajah\t 1\t3\t0\t0\t0\t0\t"+ df.format(sum[5]/day) +"\n";
			String station7 = "7.\t 2324033\t Hospital Jasin\t\t\t\t Jasin\t\t 0\t0\t0\t7\t8\t0\t"+ df.format(sum[6]/day) + "\n";
			String station8 = "8.\t 2225044\t Sg. Chohong\t\t\t\t Jasin\t\t 0\t0\t1\t0\t5\t0\t" + df.format(sum[7]/day) + "\n";
			String station9 = "9.\t 2125002\t Telok Rimba\t\t\t\t Jasin\t\t 0\t0\t0\t2\t0\t0\t" + df.format(sum[8]/day) + "\n";
			String station10 = "10.\t 2222006\t Cheng (Taman Merdeka)\t\t\t Melaka Tengah\t 0\t0\t0\t0\t0\t0\t" + df.format(sum[9]/day) + "\n";
			String station11 = "11.\t 2222007\t Cheng D/S\t\t\t\t Melaka Tengah\t 0\t0\t0\t0\t0\t0\t" + df.format(sum[10]/day) + "\n";
			String station12 = "12.\t 2222033\t Batu Hampar\t\t\t\t Melaka Tengah\t 0\t0\t0\t0\t0\t0\t" + df.format(sum[11]/day) + "\n";
			String station13 = "13.\t 2222003\t Klebang Besar\t\t\t\t Melaka Tengah\t 0\t0\t0\t0\t0\t1\t" + df.format(sum[12]/day) + "\n";
			String station14 = "14.\t 2222005\t Klebang Besar D/S\t\t\t Melaka Tengah\t 0\t0\t0\t0\t0\t1\t" + df.format(sum[13]/day) + "\n";
			String station15 = "15.\t 2221008\t Pusat Pertanian Sg. Udang\t\t Melaka Tengah\t 0\t1\t0\t1\t0\t0\t" + df.format(sum[14]/day) + "\n";
			
			
			// 3. Create write data into stream 
			byte[] Title = title.getBytes();
			byte[] myStation1 = station1.getBytes();
			byte[] myStation2 = station2.getBytes();
			byte[] myStation3 = station3.getBytes();
			byte[] myStation4 = station4.getBytes();
			byte[] myStation5 = station5.getBytes();
			byte[] myStation6 = station6.getBytes();
			byte[] myStation7 = station7.getBytes();
			byte[] myStation8 = station8.getBytes();
			byte[] myStation9 = station9.getBytes();
			byte[] myStation10 = station10.getBytes();
			byte[] myStation11 = station11.getBytes();
			byte[] myStation12 = station12.getBytes();
			byte[] myStation13 = station13.getBytes();
			byte[] myStation14 = station14.getBytes();
			byte[] myStation15 = station15.getBytes();
			fosObject.write(Title);
			fosObject.write(myStation1);
			fosObject.write(myStation2);
			fosObject.write(myStation3);
			fosObject.write(myStation4);
			fosObject.write(myStation5);
			fosObject.write(myStation6);
			fosObject.write(myStation7);
			fosObject.write(myStation8);
			fosObject.write(myStation9);
			fosObject.write(myStation10);
			fosObject.write(myStation11);
			fosObject.write(myStation12);
			fosObject.write(myStation13);
			fosObject.write(myStation14);
			fosObject.write(myStation15);
			// 4. Clear the stream
			fosObject.flush();
			

			// 5. Close the stream
			fosObject.close();     

		} catch (IOException e) {
			
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.  Check out " + targetStorage + ".");   
	}
}
