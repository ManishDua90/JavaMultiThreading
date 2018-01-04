package DemoThread;

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
		for(int i =0 ; i<10 ; i++)
		{
			System.out.println("Hello Main " + i);
		}
		
		
		
		
		
	}

}
