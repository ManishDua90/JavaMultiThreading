package demoRe_entrantLocks;


public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		final Runner proc = new Runner();
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
					proc.consumer();
				} catch (InterruptedException e) {
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		proc.getCount();
	}

}