package com.eight.wait.notify;

import java.util.Scanner;

public class Processor {

	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running .. ");
			wait();
			System.out.println("Resumed");
		}
 		

	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		Scanner scan = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Press Return ..");
			scan.nextLine();
			System.out.println("Returned Key Pressed..");
			notify();
			
		}
	}
}
