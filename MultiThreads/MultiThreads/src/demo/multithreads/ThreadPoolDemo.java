package demo.multithreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo 
{
	public static void main(String [] args)
	{
		SimpleArray simpleArr = new SimpleArray(6);
		
		Runnable arrWrite1 = new ArrayWriter(1,simpleArr);
		Runnable arrWrite2 = new ArrayWriter(11,simpleArr);
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
        executor.execute(arrWrite1);
        executor.execute(arrWrite2);
		
        executor.shutdown(); 
        
        try
        {
        	ExecutorService executorService = Executors.newFixedThreadPool(10);
        	
        	//Wait for 1 minute for both writers to finish executing
        	boolean endFlag = executorService.awaitTermination(1, TimeUnit.MINUTES);
        	
        	if(endFlag)
        	{
        		//Print content of shared array
        		System.out.println("\nContent of Simple Array");
        		simpleArr.toString();
        	}
        	else
        	{
        		System.out.println("Time Out While Waiting Task To Finish.");
        	}
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        
        System.out.println("Finished all threads");
		
	}
}
