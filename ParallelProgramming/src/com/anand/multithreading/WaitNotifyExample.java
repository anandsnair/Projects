package com.anand.multithreading;


class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("In Produce");
			System.out.println("Start to wait");
			wait();
			System.out.println("Returned back to produce");
		}
	}
	
	public void consume() {
		synchronized (this) {
			System.out.println("In Consume");
			notify();
			System.out.println("Finished consuming");
		}
	}

	
}
public class WaitNotifyExample {

	
	public static void main(String[] args) {
		Processor processor = new Processor();
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
				processor.consume();
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
