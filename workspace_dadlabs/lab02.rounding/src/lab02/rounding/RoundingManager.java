package lab02.rounding;

import java.text.DecimalFormat;

public class RoundingManager 
{
	public double calculatePercentage(int divident, int divisor)
	{
		double percentage = ((double)divident/(double)divisor)*100;
		
		return percentage;
	}
	
	public String roundValue(double value, int decimalPoints)
	{
		String decimalPlaces = ".";
		
		for (int counter = 0; counter < decimalPoints; counter++)
			decimalPlaces += "0";
		
		if (decimalPoints == 0)
			decimalPlaces = "";
		
		DecimalFormat formatter = new DecimalFormat("###" + decimalPlaces);
		String result = formatter.format(value);
		
		return result;
			
	}
}
