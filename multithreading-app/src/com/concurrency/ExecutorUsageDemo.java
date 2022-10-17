package com.concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TestOne implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("Executing task one");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TestTwo implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("Executing task two");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class ExecutorUsageDemo {

	private static ExecutorService executorService=null;
	private static volatile Future taskOneResults = null;
	private static volatile Future taskTwoResults=null;
	
	 private static void checkTasks() throws Exception {
	        if (taskOneResults == null
	                || taskOneResults.isDone()
	                || taskOneResults.isCancelled())
	        {
	            taskOneResults = executorService.submit(new TestOne());
	        }
	 
	        if (taskTwoResults == null
	                || taskTwoResults.isDone()
	                || taskTwoResults.isCancelled())
	        {
	            taskTwoResults = executorService.submit(new TestTwo());
	        }
	    }
	
	
	public static void main(String[] args) {
		 // creating thread pool of size
		executorService =Executors.newFixedThreadPool(2);
		
		// For whole life cycle of application 
		//while(true)
		 for(int i=0;i<10;i++)
	        {
	            try
	            {
	                checkTasks();
	                Thread.sleep(1000);
	            } catch (Exception e) {
	                System.err.println("Caught exception: " + e.getMessage());
	            }
	        }
	}

}
