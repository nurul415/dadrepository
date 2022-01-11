package demo.multithreads;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ArrayWriter implements Runnable
{
	private int startValue;
	private SimpleArray sharedSimpleArray;
	
	public ArrayWriter(int value, SimpleArray simpleArray)
	{
		this.startValue = value;
		this.sharedSimpleArray = simpleArray;
	}
	
	@Override
	public void run() 
	{
		for(int i = 0; i < 3; i++)
		{
			sharedSimpleArray.add(startValue);
			startValue++;
		}
	}

}
