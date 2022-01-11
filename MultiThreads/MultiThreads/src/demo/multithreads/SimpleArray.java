package demo.multithreads;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class SimpleArray
{
	private int sharedData[];
	private int currentIndex;
	private SecureRandom generator;
	
	public SimpleArray(int size)
	{
		sharedData = new int[size];
	}
	
	public synchronized void add(int value)
	{
		sharedData[currentIndex] = value;
		 
		try 
		{
			// Suspend the current thread for 3 milliseconds
			Thread.sleep(3000);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		
		SecureRandom rand = new SecureRandom();
		int randomNumber = rand.nextInt();
		
		Thread currentThread = Thread.currentThread();
		
		System.out.println(Thread.currentThread().getName()+" wrote " + value 
				+ " to element " + currentIndex + "\nNext Index To Write is " + (currentIndex++ + 1));
		
	}
	
	public String toString()
	{
		return String.valueOf(sharedData);
	}
}
