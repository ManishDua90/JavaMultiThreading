package demoLockMethodsWaitAndNotify;

public class Processor {
	
	public void producer() throws InterruptedException{
		synchronized (this) {
		System.out.println("Producer thread started..");
		wait();
		System.out.println("Producer thread resumed..");
		Thread.sleep(2000);
		System.out.println("Producer Thread Finished");
	}
	}
	public void Consumer() throws InterruptedException{
		synchronized (this) {
		Thread.sleep(200);
		System.out.println("Consumer thread started..");
		notify();
		Thread.sleep(5000);
		System.out.println("Consumer Thread Finished");
		System.out.println("Returning the control");
		}
	}
}
