package com.seven.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	//This is thread-safe
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
 	public static void main(String[] args) {
		App app = new App();
		app.threadGen();
	}
 	
 	private void threadGen() {
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
 	private void producer() throws InterruptedException {
 		Random random = new Random();
 		while(true) {
 	 		queue.put(random.nextInt(100));
 		}

	}
 	
 	private void consumer() throws InterruptedException {
 		while(true) {
 			Thread.sleep(100);
 			int integer = queue.take();
 			System.out.println("Value taken " + integer+ ".Size of queue is "+queue.size());
 		}
 	}
}
