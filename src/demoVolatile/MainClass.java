package demoVolatile;

import java.util.Scanner;

//We use volatile keyword to prevent Threads from using Cache values of the variables instead of the current value.

class Runner extends Thread{
	private boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning)
			System.out.println("Hello ");
	}	
	public void shutdown()
	{
		isRunning = false;
	}
}
public class MainClass {
	public static void main(String[] args) {
		Runner r1 = new Runner();
		r1.start();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		r1.shutdown();
	}

}
