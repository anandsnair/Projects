package com.nine.producer.consumer.low.level;

import java.util.LinkedList;

public class Processor {

	private LinkedList<Integer> integers = new LinkedList<Integer>();
	private int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized (lock) {
				while(integers.size() == LIMIT) {
					lock.wait();
				}
				integers.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (lock) {
				while(integers.size() == 0) {
					lock.wait();
				}
					System.out.println("Size is "+integers.size());
					int value = integers.removeFirst();
					System.out.println("Removed first element from queue "+ value);
					lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}
