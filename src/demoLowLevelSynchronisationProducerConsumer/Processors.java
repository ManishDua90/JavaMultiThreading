package demoLowLevelSynchronisationProducerConsumer;

import java.util.LinkedList;
import java.util.Random;

public class Processors {
	LinkedList<Integer> list = new LinkedList<Integer>();
	final int LIMIT = 10;
	int value = 0;
	Object lock = new Object();
	public void producer() throws InterruptedException{
		System.out.println("-------Producer Thread Started-------");
		while(true)
		{
			synchronized (lock) {
			while(list.size()==10)
			{
				System.out.println("-------List full waiting for a value to get removed -------");
				lock.wait();
			}
			list.add(value++);
			System.out.println("--Value added is : --" + (value-1) + " & list size is : " + list.size());
			lock.notify();
		}
			Thread.sleep(new Random().nextInt(100));
		}
	}
	public void consumer()throws InterruptedException{
		System.out.println("********Consumer Thread Stared*********");
		while(true)
		{
			synchronized (lock) {
				while(list.size()==0)
				{
					System.out.println("********List Empty waiting for a value to get added*********");
					lock.wait();
				}
			int removedValue = list.remove();
			System.out.println("**Removed value is : **" + removedValue + " & list size is : " + list.size());
			lock.notify();
			}
			Thread.sleep(new Random().nextInt(10));
		}
	}

}
