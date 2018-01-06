package demoProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {
	static Random random = new Random();
	private static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
	//Thread safe. No need of thread synchronization
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	private static void producer() throws InterruptedException{
		while(true)
		{
			q.put(random.nextInt(100));
		}
	}
	private static void consumer() throws InterruptedException{
		while(true){
			//Thread.sleep(1);
			if(random.nextInt(1)==0)
			{
				int a = q.take();
				System.out.println("Value taken is " + a +" & queqe size is " + q.size());
			}
		}
	}
}
