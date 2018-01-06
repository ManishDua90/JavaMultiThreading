package demoLockMethodsWaitAndNotify;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		final Processor proc = new Processor();
		Thread t1 = new Thread(new Runnable(){
			
			@Override
			public void run()
			{
				try {
					proc.producer();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					proc.Consumer();
				} catch (InterruptedException e) {
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
