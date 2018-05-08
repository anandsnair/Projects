package com.five.thread.pools;

public class Processor implements Runnable {
	int id;
	Processor(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Starting : " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : " + id);

	}

}
