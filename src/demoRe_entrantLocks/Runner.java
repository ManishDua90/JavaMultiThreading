package demoRe_entrantLocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	private void increement(String abc){
		for(int i = 1 ; i<=10 ; i++)
		{
			count++;
			System.out.println("Count for "+abc+ " is : "+ i);
		}
		
	}
	public void producer() throws InterruptedException{
		System.out.println("Producer started");
		lock.lock();
		System.out.println("Giving control to consumer");
		con.await();
		try{
		System.out.println("Control given back to Producer");
		increement("producer");
		}finally{
			lock.unlock();
			System.out.println("Finished execution for producer");
		}
	}
	public void consumer()throws InterruptedException{
		Thread.sleep(1000);
		lock.lock();
		con.signal();
		
		try{
		increement("consumer");
		}finally{
			lock.unlock();
			System.out.println("Finished execution for consumer");
		}
	}
	public void getCount(){
		System.out.println("Count is : " + count);
	}


}
