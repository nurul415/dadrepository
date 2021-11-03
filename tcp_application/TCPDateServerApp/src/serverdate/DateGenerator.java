package serverdate;

import java.util.Date;

public class DateGenerator 
{
	public String getCurrentDate( ) 
	{
		String currentDate = new Date().toString();
		
		return currentDate;
	}

}
