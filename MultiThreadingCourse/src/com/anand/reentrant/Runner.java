package com.anand.reentrant;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	int count = 0;
	Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	private void increment() {
		for(int i = 0 ; i < 10000 ; i++) {
			count++;
		}
	}
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting .. ");
		condition.await();
		System.out.println("Wait Over .. Starting");
		try {
			increment();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Please start by pressing return key");
		condition.signal();
		new Scanner(System.in).nextLine();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Finished "+count);
	}
}
