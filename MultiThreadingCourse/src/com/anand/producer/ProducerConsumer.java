package com.anand.producer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
	
	private static void producer() throws InterruptedException {
		Random randomNumber = new Random();
		while(true) {
			blockingQueue.put(randomNumber.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random randomNumber = new Random();

		while(true) {
			Thread.sleep(100);
			if(randomNumber.nextInt(10) == 0) {
				Integer value = blockingQueue.take();
				System.out.println("Taken Value " + value + " Queue Size = " + blockingQueue.size());
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producer();
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
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
}
