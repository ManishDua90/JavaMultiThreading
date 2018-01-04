package demoThread1;

 class Runner extends Thread{
	@Override
	public void run() {
		for(int i =0 ; i<10 ; i++)
		{
			System.out.println("Hello " + i);
		}
	}	
}
public class MainClass {

	public static void main(String[] args) {
		Runner r1 = new Runner();
		r1.start();
		
		//We call start method here so that a separate thread can be started and does not interrupt the main method
		//We should not call run here. If we call run, separate thread wont start and run method will be called in the main thread only.
		//This is one method to start the thread. Another is implementing Runnable
		
		for(int i =0 ; i<10 ; i++)
		{
			System.out.println("Hello Main " + i);
		}
	}

}
