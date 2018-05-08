package com.anand.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ThreadProcessor {

	List<Integer> list = new ArrayList<>();
	Random random = new Random();
	private final int LIMIT = 5;
	private final int BOTTOM = 0;
	Object lock = new Object();
	public void produce() throws InterruptedException {
		synchronized (lock) {
			while(true) {
				if(LIMIT == list.size()) {
					System.out.println("Waiting for removing items from list");
					lock.wait();
				} else {
					int value = random.nextInt();
					System.out.println("Produced Integer "+value);
					list.add(value);
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
		
	}
	
	public void consume() throws InterruptedException {
		synchronized (lock) {
			while(true) {
				if(BOTTOM == list.size()) {
					System.out.println("Waiting for adding items to list");
					lock.wait();
				} else {
					System.out.println("Consumed from list" + list.remove(list.size()-1));
					lock.notify();
				}
				Thread.sleep(500);

			}
		}
		
	}

	
}
public class ProducerConsumer {

	
	public static void main(String[] args) {
		ThreadProcessor processor = new ThreadProcessor();
		Thread prodThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consumerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		prodThread.start();
		consumerThread.start();
		
		try {
			prodThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished all");
	}
}
