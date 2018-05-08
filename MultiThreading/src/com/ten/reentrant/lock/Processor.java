package com.ten.reentrant.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {

	int count;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	
	public void increment() {
		for(int i = 0 ; i < 10000 ; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ...");
		condition.await();
		System.out.println("Woken up");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press return");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		System.out.println("Got Return Key");
		condition.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finish() {
		System.out.println("finished. count :" +count);
	}

	public static void main(String[] args) throws InterruptedException {
		Processor p = new Processor();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					p.firstThread();
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
					p.secondThread();
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
		
		p.finish();
	}
	
}
