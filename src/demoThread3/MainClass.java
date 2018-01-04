package demoThread3;

//Another way to create Thread by using anonymous class.
//This is used when we don't want to write the entire class and use just a function to run thread.

public class MainClass {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i<10 ; i++){
					System.out.println("Hello " + i);
				}
			}
		});
		t1.start();
		for(int i = 0 ; i<10 ; i++){
			System.out.println("Hello Main" + i);
		}
	}

}
