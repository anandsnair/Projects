package com.anand.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i < 10 ; i++) {
			executorService.submit(new Processor(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}
	
	
}

 class Processor implements Runnable {
	CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println("Started Thread");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Stopped Thread");
	}
	
}