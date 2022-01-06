package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject 
	implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	@Override
	public HashMap<String, Integer> getWeekTemperature() throws RemoteException 
	{
		HashMap<String, Integer> week = new HashMap<>();
		week.put("Monday", 32);
		week.put("Tuesday", 31);
		week.put("Wednesday", 33);
		week.put("Thursday", 35);
		week.put("Friday", 36);
		week.put("Saturday", 33);
		week.put("Sunday", 33);
		
		return week;
	}
	
	@Override
	public double getAverageTemperature() throws RemoteException 
	{
		HashMap<String, Integer> week = new HashMap<>();
		week.put("Monday", 32);
		week.put("Tuesday", 31);
		week.put("Wednesday", 33);
		week.put("Thursday", 35);
		week.put("Friday", 36);
		week.put("Saturday", 33);
		week.put("Sunday", 33);
		
		double sum = 0;
		for (int i : week.values()) 
		{
		    sum += i;
		}
		
		double average = sum / 7;
		
		return average;
	}

}
