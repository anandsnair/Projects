package com.anand.lowlevel.producer.consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Processor {

	
	public LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
	
	public final int LIMIT = 10;
	Object lock = new Object();
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized (lock) {
				while(listOfIntegers.size() == LIMIT) {
					lock.wait();
				}
				listOfIntegers.add(value);
				notify();
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		while(true) {
			synchronized (lock) {
				System.out.println("Size of list "+listOfIntegers.size());
				while(listOfIntegers.size() == 0) {
					wait();
				}
				int value = listOfIntegers.removeFirst();
				System.out.println("Value = "+value);
				notify();
			}
			
		}
	}
}
