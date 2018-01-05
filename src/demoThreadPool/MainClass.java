package demoThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	public Processor(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Starting process " + id);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Completed process " + id);
	}
	
}
public class MainClass {
	public static void main(String[] args) {
	ExecutorService executor = Executors.newFixedThreadPool(4);
	for (int i =0 ;i<5 ;i++)
	{
		executor.submit(new Processor(i));
	}
	executor.shutdown();
	System.out.println("All tasks submitted");
	try {
		executor.awaitTermination(1, TimeUnit.DAYS);
	} catch (InterruptedException e) {
	}
	System.out.println("All tasks completed");
	}

}
