package com.two.basic.thread.sync;

import java.util.Scanner;

/*
 * Basic Thread Sync. The main problems
 * 1. Data being cached
 * 2. Thread interleaving.
 */


class Processor extends Thread {
	//The volatile keyword ensures that this thread always reads the "running" variable from the memory instead of from the cache.
	private volatile boolean running = true;
	public void run() {
		
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown() { 
		running = false;
	}
}
public class App {

	public static void main(String[] args) {
		Processor proc1  = new Processor();
		proc1.start();
		System.out.println("Press return to stop");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		proc1.shutdown();
	}
}
