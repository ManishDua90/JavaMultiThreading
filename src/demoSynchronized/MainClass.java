package demoSynchronized;

public class MainClass {

	private int count = 0;
	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.startCounting();
		System.out.println("Count is " + mc.count);

	}
	//Every object in java has an intrinsic lock (Mutex), if we call sync on the object, only one thread will acquire the lock 
	//and other thread won't be able to acquire until the first finishes.
	public synchronized void increement ()
	{
		count++;
	}
	private void startCounting() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1 ; i<=1000 ;i++)
				{
					increement();
				}
			}

		
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1 ; i<=1000 ;i++)
				{
					increement();
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			//join() method allows one thread to wait until another thread completes its execution.
			//join(): It will put the current thread on wait until the thread on which it is called is dead. 
			//If thread is interrupted then it will throw InterruptedException.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
