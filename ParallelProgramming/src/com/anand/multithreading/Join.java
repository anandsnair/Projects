package com.anand.multithreading;

public class Join {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed");
	}
}
