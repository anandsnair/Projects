package com.anand.syncblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	List<Integer> intList1 = new ArrayList<Integer>();
	List<Integer> intList2 = new ArrayList<Integer>();

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In Thread 1");
		synchronized (lock1) {
			System.out.println("In Thread 1 Lock");
			intList1.add(new Random().nextInt(100));
		}
	}
	
	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In Thread 2");
		synchronized (lock2) {
			System.out.println("In Thread 2 Lock");
			intList2.add(new Random().nextInt(100));
		}
	}
	public void process() {
		for(int i = 0 ; i < 1000 ;i++) {
			stageOne();
			stageTwo();
		}
	}
	public void work() {
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		t2.start();		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("Total Time taken = "+ String.valueOf(end-start));
		System.out.println("List 1 = "+intList1.size());
		System.out.println("List 2 = "+intList2.size());

	}

}
