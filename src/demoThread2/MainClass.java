package demoThread2;

//Another way to create Thread by implementing Runnable Interface.

class Runner implements Runnable{
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
		Thread t1 = new Thread(new Runner());
		t1.start();
		
		for(int i =0 ; i<10 ; i++)
		{
			System.out.println("Hello Main " + i);
		}
	}

}
