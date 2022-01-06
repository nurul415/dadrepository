import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin 
				= (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			TemperatureSensor remoteSensorAyerKeroh 
			= (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int jasinCurrentTemperature = remoteSensorJasin.getTemperature();
			HashMap<String, Integer> ayerKerohCurrentTemperature = remoteSensorAyerKeroh.getWeekTemperature();
			double ayerKerohTemperatureAverage = remoteSensorAyerKeroh.getAverageTemperature();
			
			System.out.println("\nCurrent temperature in Jasin is " 
					+ jasinCurrentTemperature + " Celcius");
			
			System.out.println("\n\nCurrent temperature in Ayer Keroh is " 
					+ ayerKerohCurrentTemperature + " Celcius");
			
			System.out.println("\nAverage temperature in Ayer Keroh for a week is " 
					+ ayerKerohTemperatureAverage + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
