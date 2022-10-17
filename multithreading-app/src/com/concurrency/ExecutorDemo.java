package com.concurrency;
/**
 * https://www.geeksforgeeks.org/what-is-java-executor-framework/
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String[] args) {
		
	ExecutorService  executorService=  Executors.newFixedThreadPool(2);
		
		TaskOne task = new TaskOne("Devendra");
		
		Future<String>  futureResult = executorService.submit(task);
		
            try {
            	 System.out.print(futureResult.isDone());
            	 System.out.print(futureResult.isCancelled());
            	 System.out.print(futureResult.get());
            }catch(InterruptedException | ExecutionException ex) {
            	 System.err.print("Error "+ex);
            }
            executorService.shutdown();
	}

}

class TaskOne implements Callable<String> {
	private String message ;
	
	public TaskOne(String msg) {
		this.message=msg;
	}
	@Override
	public String call() throws Exception {
		
		return "Hi ==="+message+"=== !";
	}
}
