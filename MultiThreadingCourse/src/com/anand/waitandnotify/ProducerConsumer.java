package com.anand.waitandnotify;

import java.util.Scanner;

public class ProducerConsumer {

	
	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer is running .. ");
			wait();
			System.out.println("Resume .. ");

		}
	}
	
	public void consumer() throws InterruptedException {
		Thread.sleep(2000);
		Scanner scan = new Scanner(System.in);
		
		synchronized (this) {
			System.out.println("Waiting for return key");
			scan.nextLine();
			System.out.println("Returned key pressed");
			notify();
		}
	}
	
}
