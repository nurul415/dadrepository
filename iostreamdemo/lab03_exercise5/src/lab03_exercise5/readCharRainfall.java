package lab03_exercise5;

import java.io.Reader;
import java.io.FileReader;

public class readCharRainfall 
{
	public static void main (String args[]) 
	{
		
		// 1. Declaration of input source
		String fileName = "RainfallMelaka.dat";
		char[]array = new char[1000];
		
		System.out.println("Input from " + fileName + "\n");
		
		try {
			
			// 3. Create object
			Reader r_data = new FileReader(fileName);
			
			r_data.read();
			r_data.read(array);
			System.out.println(array);
			
			
			// 5. Close stream
			r_data.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");  
		
		
	}
}
