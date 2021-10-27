package lab03_exercise4;

import java.io.FileInputStream;

public class ReadByteRainfall 
{
	public static void main (String args[]) 
	{
		
		//Declaration of input source
		String fileName = "outByteRainfall.dat";
		
		//Declaration of input stream object
		FileInputStream fisObject;
		
		System.out.println("Input from " + fileName + "\n");
		System.out.println("Daily Rainfall Data A Station 2021\n");
		
		try {
			
			//Create object
			fisObject = new FileInputStream(fileName);
			
			//Read values from the stream
			// -1: read until end of file/stream
			int i=0; 
			
            while((i=fisObject.read())!=-1)
            {    
            	System.out.print((char)i);
            }  
            
			//Close stream
            fisObject.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		System.out.println("\n*Convective rain more than 60 mm in 2 to 4 hours duration (typical) "
				+ "may cause flash floods. However, monsoon rains are \ntypically of long duration "
				+ "with intermittent heavy bursts and the intensity can occasionally exceed several "
				+ "hundred mm in 24 hours.");
		
		//Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");  
		
		
	}

}
