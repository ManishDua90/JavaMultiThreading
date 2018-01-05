package demoCountdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainClass
{
    public static void main(String args[]) throws InterruptedException
    {
        // Let us create task that is going to wait for four
        // threads before it starts
        CountDownLatch latch = new CountDownLatch(8);
 
        // Let us create four worker threads and start them.

        Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
 Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
 Thread t3 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	});
 Thread t4 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	});
 t1.start();
 t2.start();
 t3.start();
 t4.start();
 /*  Worker first = new Worker(1000, latch, "WORKER-1");
 Worker second = new Worker(1000, latch, "WORKER-2");
 Worker third = new Worker(1000, latch, "WORKER-3");
 Worker fourth = new Worker(1000, latch, "WORKER-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
 */
        // The main task waits for four threads
        latch.await(10000, TimeUnit.MILLISECONDS);
        //latch.await();
 
        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                           " has finished");
    }
}
 
// A class to represent threads for which the main thread
// waits.
class Worker extends Thread
{
    private int delay;
    private CountDownLatch latch;
 
    public Worker(int delay, CountDownLatch latch,
                                     String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }
 
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                               + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}