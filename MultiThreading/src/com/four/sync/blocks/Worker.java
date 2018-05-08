package com.four.sync.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void stageOne() throws InterruptedException {
		Thread.sleep(1);
		synchronized (lock1) {
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() throws InterruptedException {
		Thread.sleep(1);
		synchronized (lock2) {
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() throws InterruptedException {
		for(int i = 0 ; i < 1000 ; i++) {
			stageOne();
			stageTwo();
		}
	}
	public void main() throws InterruptedException {
		System.out.println("Hello");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		System.out.println("List1 = "+list1.size());
		System.out.println("List2 = "+list2.size());
		System.out.println("Time Taken = " + (end -start));
	}
}
