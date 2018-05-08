package com.anand.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantWorker {
	
	Lock lock = new ReentrantLock();
	Condition condidion = lock.newCondition();
	
	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("In Producer...");
		condidion.await();
		System.out.println("Back to producer ..");
		lock.unlock();
	}
	
	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("In Consumer...");
		condidion.signal();
		System.out.println("Executed Consumer ...");
		lock.unlock();
	}
}
public class ProducerConsumerWithReentrantLock {

	public static void main(String[] args) {
		ReentrantWorker worker = new ReentrantWorker();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.producer();
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
					worker.consumer();
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
		}	}
}
