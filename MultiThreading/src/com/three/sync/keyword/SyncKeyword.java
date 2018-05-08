package com.three.sync.keyword;

/*
 * Every object in java has an intrinsic lock. When we use the keyword synchronized, we make sure that only one thread
 * can access the intrinsic lock of the object and rest of the threads needs to wait.
 */

public class SyncKeyword {


	int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	public static void main(String[] args) {
		SyncKeyword app = new SyncKeyword();
		app.doWork();
	}

	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 10000 ; i++) {
					increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 10000 ; i++) {
					increment();
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
		
		System.out.println("Count is " + count);
	}
}
