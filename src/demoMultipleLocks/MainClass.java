package demoMultipleLocks;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class MainClass {
	
	private Random r = new Random();
	ArrayList<Integer> one;
	ArrayList<Integer> two;
	
	Object lock1;
	Object lock2;
	 public MainClass() {
		 one  = new ArrayList<Integer>();
		 two = new ArrayList<Integer>();
		 lock1 = new Object();
		 lock2 = new Object();
	}
	
	public void startProcess()
	{
		stepOne();
		stepTwo();
		
	}
	public void stepOne()
	{
		synchronized (lock1) {
			
		
		for(int i=1 ;i <=1000;i++)
			{one.add(r.nextInt(10));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	}}
	
	public void stepTwo()
	{
		synchronized (lock2) {
			
		
		for(int i=1 ;i <=1000;i++)
			{two.add(r.nextInt(10));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	}}
	public void main()
	{
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				startProcess();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				startProcess();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Total Time taken : " + (end-start));
		System.out.println(one.size()+two.size());
		
	}
}
